package main.java.com.transportanalysis.function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.java.com.transportanalysis.models.IndividualVO;

/**
* Provides the information needed to solve this transportation case
*
* @author  Diego Hortolani Fernandes <diegofernandes88@hotmail.com>
* @version 1.0
* @since   2018-08-09
*/
public class GeneticAlgorithm {
	
	private int populationSize;
	private List<IndividualVO> population;
	private int generation;
	private IndividualVO bestSolution;
	private List<IndividualVO> bestChromossomes;
	
	public GeneticAlgorithm(int populationSize) {
		this.populationSize = populationSize;
		this.population = new ArrayList();
		this.bestChromossomes = new ArrayList();
	}
	
	/**
	 * Method responsible for initializes the population
	 * 
	 * @param spaces list containing the spaces used by the products in the cargo
	 * @param values list containing the values of the products in the cargo
	 * @param spaceLimit cargo limit
	 */
	public void initializesPopulation(List spaces, List values, Double spaceLimit) {
		
		for(int i = 0; i < this.populationSize; i++) {
			this.population.add(new IndividualVO(spaces, values, spaceLimit));
		}
		
		this.bestSolution = this.population.get(0);
	}
	
	/**
	 * Method responsible for analyzing the best solution between two individuals
	 * 
	 * @param anotherIndividualVO second individual used to perform the analysis
	 */
	public void bestIndividual(IndividualVO anotherIndividualVO) {
		if(anotherIndividualVO.getEvaluationNote() > this.getBestSolution().getEvaluationNote()) {
			this.bestSolution = anotherIndividualVO;
		}
	}
	
	/**
	 * Method responsible for adding up the grades of the evaluations of a given population
	 * 
	 * @return a double containing the sum of the evaluations
	 */
	public Double evaluationSum() {
		
		Double sum = 0.0;
		
		for(IndividualVO ind : this.population) {
			sum += ind.getEvaluationNote();
		}
		
		return sum;
	}
	
	public int selectParent(Double evaluationSum) {
		
		int parent = -1;
		
		Double sortValue = Math.random() * evaluationSum;
		Double sum = 0.0;
		
		int i = 0;
		
		while(i < this.population.size() && sum < sortValue) {
			sum += this.population.get(i).getEvaluationNote();
			parent += 1;
			i += 1;
		}
		
		return parent;
	}
	
	public void viewGeneration() {
		
		IndividualVO best = this.population.get(0);
		
		this.bestChromossomes.add(best);
		
		System.out.println("Generation: " + best.getGeneration() + 
							" Value: " + best.getEvaluationNote() + 
							" Space: " + best.getUsedSpace() + 
							" Chromossome: " + best.getChromosome());
		
	}
	
	public List resolve(Double mutationRate, int numberOfGenerations, List spaces, List values, Double spaceLimit) {
		
		this.initializesPopulation(spaces, values, spaceLimit);
		
		for(IndividualVO individualVO : this.population) {
			individualVO.evaluation();
		}
		
		this.ordenatePopulation();
		this.viewGeneration();
		
		for(int generation = 0; generation < numberOfGenerations; generation++) {
			
			Double evaluationSum = this.evaluationSum();
			
			List<IndividualVO> newPopulation = new ArrayList();
			
			for(int i = 0; i < this.population.size() / 2; i++) {
				
				int parent1 = this.selectParent(evaluationSum);
				int parent2 = this.selectParent(evaluationSum);
				
				List<IndividualVO> children = this.getPopulation().get(parent1).crossover(this.getPopulation().get(parent2));
				
				newPopulation.add(children.get(0).mutation(mutationRate));
				newPopulation.add(children.get(1).mutation(mutationRate));
				
			}
			
			this.setPopulation(newPopulation);
			
			for(IndividualVO individualVO : this.getPopulation()) {
				individualVO.evaluation();
			}
			
			IndividualVO bestIndividualVO = this.population.get(0);

			this.ordenatePopulation();
			this.viewGeneration();
			this.bestIndividual(bestIndividualVO);
			
		}
		
		System.out.println("Best solution G -> " + this.bestSolution.getGeneration() + 
						   " Value: " + this.bestSolution.getEvaluationNote() + 
						   " Space: " + this.bestSolution.getUsedSpace() + 
						   " Chromossome: " + this.bestSolution.getChromosome());
		
		return this.bestSolution.getChromosome();
		
	}
	
	/**
	 * Method responsible for ordenate a given population
	 */
	public void ordenatePopulation() {
		Collections.sort(this.population);
	}

	public int getPopulationSize() {
		return populationSize;
	}

	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}

	public List<IndividualVO> getPopulation() {
		return population;
	}

	public void setPopulation(List<IndividualVO> population) {
		this.population = population;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public IndividualVO getBestSolution() {
		return bestSolution;
	}

	public void setBestSolution(IndividualVO bestSolution) {
		this.bestSolution = bestSolution;
	}

	public List<IndividualVO> getBestChromossomes() {
		return bestChromossomes;
	}

	public void setBestChromossomes(List<IndividualVO> bestChromossomes) {
		this.bestChromossomes = bestChromossomes;
	}
	
}
