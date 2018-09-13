package persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import bean.Product;

public class ProductDAO extends ConnectionDAO {
	
	private final static Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());

	public void insertProduct(Product product) {
		
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
			
			stmt.setString(aux++, product.getName());
			stmt.setDouble(aux++, product.getSpace());
			stmt.setDouble(aux++, product.getValue());
			stmt.setInt(aux++, product.getQuantity());
			
			stmt.execute();
			
			stmt.close();
			
			closeConnection();
			
		} catch (Exception e) {
			LOGGER.info("Erro: " + e.getMessage());
		}
	}
	
	public List<Product> selectAllProducts() {
		
		List<Product> productList = new ArrayList<>();
		
		try {
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("SELECT * ")
			   .append("FROM ")
			   .append("	products")
			   .append("ORDER BY ")
			   .append("	product_id")
			   .append("ASC ");
			
			openConnection();
			
			stmt = con.prepareStatement(sql.toString());
			
			rs = stmt.executeQuery();
			
			Product product;
			
			while(rs.next()) {
				
				product = new Product();
				
				product.setName(rs.getString("product_name"));
				product.setSpace(rs.getDouble("used_space"));
				product.setValue(rs.getDouble("product_value"));
				product.setQuantity(rs.getInt("quantity"));
				
				productList.add(product);
				
			}
			
			return productList;
			
		} catch (Exception e) {
			LOGGER.info("Erro: " + e.getMessage());
			return productList;
		}
	}
}
