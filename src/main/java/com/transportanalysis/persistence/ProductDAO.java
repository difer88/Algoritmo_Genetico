package main.java.com.transportanalysis.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import main.java.com.transportanalysis.models.ProductVO;

public class ProductDAO extends ConnectionDAO {
	
	private final static Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());

	public void insertProduct(ProductVO productVO) {
		
		try {
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("INSERT INTO ")
			   .append("	products")
			   .append("		(product_name,")
			   .append("		used_space,")
			   .append("		product_value,")
			   .append("		quantity)")
			   .append("VALUES")
			   .append("	(?, ?, ?, ?)");
			
			openConnection();
			
			int aux = 1;
			
			stmt = con.prepareStatement(sql.toString());
			
			stmt.setString(aux++, productVO.getName());
			stmt.setDouble(aux++, productVO.getSpace());
			stmt.setDouble(aux++, productVO.getValue());
			stmt.setInt(aux++, productVO.getQuantity());
			
			stmt.execute();
			
			stmt.close();
			
			closeConnection();
			
		} catch (Exception e) {
			LOGGER.info("Erro: " + e.getMessage());
		}
	}
	
	public List<ProductVO> selectAllProducts() {
		
		List<ProductVO> productVOList = new ArrayList();
		
		try {
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("SELECT * ")
			   .append("FROM ")
			   .append("	products ")
			   .append("ORDER BY ")
			   .append("	product_id ")
			   .append("ASC ");
			
			openConnection();
			
			stmt = con.prepareStatement(sql.toString());
			
			rs = stmt.executeQuery();
			
			ProductVO productVO;
			
			while(rs.next()) {
				
				productVO = new ProductVO();
				
				productVO.setName(rs.getString("product_name"));
				productVO.setSpace(rs.getDouble("used_space"));
				productVO.setValue(rs.getDouble("product_value"));
				productVO.setQuantity(rs.getInt("quantity"));
				
				productVOList.add(productVO);
				
			}
			
			return productVOList;
			
		} catch (Exception e) {
			LOGGER.info("Erro: " + e.getMessage());
			return productVOList;
		}
	}
}
