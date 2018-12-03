package main.java.com.transportanalysis.executor;

import java.util.ArrayList;
import java.util.List;

import main.java.com.transportanalysis.models.ProductVO;
import org.jfree.ui.RefineryUtilities;

import main.java.com.transportanalysis.function.GeneticAlgorithm;
import main.java.com.transportanalysis.persistence.ProductDAO;
import main.java.com.transportanalysis.tool.Graphic;

/**
* 
*
* @author  Diego Hortolani Fernandes <diegofernandes88@hotmail.com>
* @version 1.0
* @since   2018-08-09 
*/
public class Execute {

	public static void main(String[] args) {

		List<ProductVO> productVOList = new ArrayList();
		
		ProductDAO pd = new ProductDAO();
		
		productVOList = pd.selectAllProducts();
		
        List spaces = new ArrayList();
        List values = new ArrayList();
        List names = new ArrayList();
        
        for(ProductVO productVO : productVOList) {
        	spaces.add(productVO.getSpace());
        	values.add(productVO.getValue());
        	names.add(productVO.getName());
        }
        
        Double spaceLimit = 3.0;
        int populationSize = 20;
        Double mutationRate = 0.01;
        int numberOfGenerations = 100;
        
        GeneticAlgorithm ga = new GeneticAlgorithm(populationSize);
        
        List result = ga.resolve(mutationRate, numberOfGenerations, spaces, values, spaceLimit);
        
        for(int i = 0; i < productVOList.size(); i++) {
        	if(result.get(i).equals("1")) {
        		System.out.println("Name: " + productVOList.get(i).getName());
        	}
        }
        
        Graphic graphic = new Graphic("Genetic Algorithm", "Solution Evolution", ga.getBestChromossomes());
        
        graphic.pack();
        
        RefineryUtilities.centerFrameOnScreen(graphic);
        
        graphic.setVisible(true);
        
	}

}
