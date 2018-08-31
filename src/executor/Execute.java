package executor;

import java.util.ArrayList;
import java.util.List;

import bean.Individual;
import bean.Product;
import function.GeneticAlgorithm;

/**
* 
*
* @author  Diego Hortolani Fernandes <diegofernandes88@hotmail.com>
* @version 1.0
* @since   2018-08-09 
*/
public class Execute {

	public static void main(String[] args) {

		List<Product> productList = new ArrayList<>();
		
        productList.add(new Product("Geladeira Electrolux", 0.751, 999.90));
        productList.add(new Product("Geladeira Brastemp", 0.635, 849.00));
        productList.add(new Product("Geladeira Consul", 0.870, 1199.89));
        productList.add(new Product("Notebook Lenovo", 0.498, 1999.90));
        productList.add(new Product("Notebook Asus", 0.527, 3999.00));
        productList.add(new Product("Notebook Dell", 0.00350, 2499.90));
        productList.add(new Product("Microondas Sanyo", 0.0424, 308.66));
        productList.add(new Product("Microondas LG", 0.0544, 429.90));
        productList.add(new Product("Microondas Panasonic", 0.0319, 299.29));
        productList.add(new Product("TV 55' ", 0.400, 4346.99));
        productList.add(new Product("TV 50' ", 0.290, 3999.90));
        productList.add(new Product("TV 42' ", 0.200, 2999.00));
        productList.add(new Product("Iphone 6", 0.000089, 2911.12));
        productList.add(new Product("Ventilador Ventisol", 0.496, 199.90));
        
        List spaces = new ArrayList<>();
        List values = new ArrayList<>();
        List names = new ArrayList<>();
        
        for(Product product : productList) {
        	spaces.add(product.getSpace());
        	values.add(product.getValue());
        	names.add(product.getName());
        }
        
        Double spaceLimit = 3.0;
        int populationSize = 20;
        Double mutationRate = 0.01;
        int numberOfGenerations = 100;
        
        GeneticAlgorithm ga = new GeneticAlgorithm(populationSize);
        
        List result = ga.resolve(mutationRate, numberOfGenerations, spaces, values, spaceLimit);
        
	}

}
