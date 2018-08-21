package function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bean.Individual;

public class GeneticAlgorithm {
	
	private int populationSize;
	private List<Individual> population = new ArrayList<>();
	private int generation;
	private Individual bestSolution;
	
	public GeneticAlgorithm(int populationSize) {
		this.populationSize = populationSize;
	}
	
	public void initializesPopulation(List spaces, List values, Double spaceLimit) {
		
		for(int i = 0; i < this.populationSize; i++) {
			this.population.add(new Individual(spaces, values, spaceLimit));
		}
		
		this.bestSolution = this.population.get(0);
		
	}
	
	public void bestIndividual(Individual ind) {
		if(ind.getEvaluationNote() > this.getBestSolution().getEvaluationNote()) {
			this.bestSolution = ind;
		}
	}
	
	public void ordenatePopulation() {
		Collections.sort(this.population);
	}

	public int getPopulationSize() {
		return populationSize;
	}

	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}

	public List<Individual> getPopulation() {
		return population;
	}

	public void setPopulation(List<Individual> population) {
		this.population = population;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public Individual getBestSolution() {
		return bestSolution;
	}

	public void setBestSolution(Individual bestSolution) {
		this.bestSolution = bestSolution;
	}
	
}
