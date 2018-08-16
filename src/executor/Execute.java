package executor;

import java.util.ArrayList;
import java.util.List;

import bean.Individual;
import bean.Product;

/**
* Application built in Java and based on genetic algorithm and artificial intelligence 
* to calculate the maximum number of items to be loaded in a vehicle, according to its 
* value and volume.
*
* @author  Diego Fernandes
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
        
        /*
         * Print: 
         * - Espaço utilizado por produto
         * - Valores de todos os produtos
         * - Cromossomo gerado para a carga
         
        System.out.println("Spaces: " + spaces);
        System.out.println("Values: " + values);
        System.out.println("\nCargo components: \n");
        
        for(int i = 0; i < productList.size(); i++) {
            if(indiv_01.getChromosome().get(i) == "1") {
                System.out.println("Name: " + productList.get(i).getName() 
                                            + " R$ " + productList.get(i).getValue());
            }
        }*/

        Double limit = 3.0;
        
        Individual indiv_01 = new Individual(spaces, values, limit);

        indiv_01.evaluation();
        
        System.out.println("Indivíduo 1:");
        System.out.println("\nChromosome: " + indiv_01.getChromosome());
        System.out.println("\nEvaluation Note: " + indiv_01.getEvaluationNote());
        System.out.println("Used space: " + indiv_01.getUsedSpace());

        Individual indiv_02 = new Individual(spaces, values, limit);
        
        indiv_02.evaluation();

        System.out.println("\nIndivíduo 2:");
        System.out.println("\nChromosome: " + indiv_02.getChromosome());
        System.out.println("\nEvaluation Note: " + indiv_02.getEvaluationNote());
        System.out.println("Used space: " + indiv_02.getUsedSpace());

        indiv_01.crossover(indiv_02);
        
	}

}
