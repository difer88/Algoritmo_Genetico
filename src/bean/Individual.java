package bean;

import java.util.ArrayList;
import java.util.List;

/**
* 
*
* @author  Diego Hortolani Fernandes <diegofernandes88@hotmail.com>
* @version 1.0
* @since   2018-08-09 
*/
public class Individual implements Comparable<Individual>{
	
	private List spaces = new ArrayList<>();
	private List values = new ArrayList<>();
	private Double spaceLimit;
	private Double usedSpace;
	private Double evaluationNote;
	private int generation;
	private List chromosome = new ArrayList<>();
	
	/**
	 * Constructor of the Individual class and initialization of its chromosome
	 * 
	 * @param spaces list containing the spaces used by the items
	 * @param values list containing the values of the items
	 * @param spaceLimit limit of space used by the cargo
	 */
	public Individual(List spaces, List values, Double spaceLimit) {
		this.spaces = spaces;
		this.values = values;
		this.spaceLimit = spaceLimit;
		this.evaluationNote = 0.0;
		this.usedSpace = 0.0;
		this.generation = 0;
		
		for(int i = 0; i < spaces.size(); i++) {
			if(Math.random() < 0.5) {
				this.chromosome.add("0");
			} else {
				this.chromosome.add("1");
			}
		}
	}
	
	/**
	 * Method responsible for evaluating the sum of values of the objects 
	 * attached to the chromosome, returning its value in R$
	 */
	public void evaluation() {
		Double grade = 0.0;
		Double sumOfSpaces = 0.0;
		
		for(int i = 0; i < this.chromosome.size(); i++) {
			if(this.chromosome.get(i).equals("1")) {
				grade += (Double) this.values.get(i);
				sumOfSpaces += (Double) this.spaces.get(i);
			}
		}
		
		if(sumOfSpaces > this.spaceLimit) {
			grade = 1.0;
		}
		
		this.evaluationNote = grade;
		this.usedSpace = sumOfSpaces;
	}
	
	/**
	 * Method responsible for creating the crossover between two chromosomes
	 * 
	 * @param anotherIndividual second individual used to perform the crossover
	 * @return a list of children generated through the crossover method
	 */
	public List crossover(Individual anotherIndividual) {
		
		int cut = (int) Math.round(Math.random() * this.chromosome.size());
		
		List child_01 = new ArrayList<>();
		
		child_01.addAll(anotherIndividual.getChromosome().subList(0, cut));
		child_01.addAll(this.chromosome.subList(cut, this.chromosome.size()));
		
		List child_02 = new ArrayList<>();
		
		child_02.addAll(this.chromosome.subList(0, cut));
		child_02.addAll(anotherIndividual.getChromosome().subList(cut, this.chromosome.size()));
		
		List<Individual> children = new ArrayList();
		
		children.add(new Individual(this.spaces, this.values, this.spaceLimit));
		children.add(new Individual(this.spaces, this.values, this.spaceLimit));
		
		children.get(0).setChromosome(child_01);
		children.get(0).setGeneration(this.generation + 1);
		
		children.get(1).setChromosome(child_02);
		children.get(1).setGeneration(this.generation + 1);
		
		return children;
		
	}
	
	public Individual mutation(Double mutationRate) {
		
		System.out.println("Before mutation: " + this.chromosome);
		
		for(int i = 0; i < this.chromosome.size(); i++) {
			if(Math.random() < mutationRate) {
				if(this.chromosome.get(i).equals("1")) {
					this.chromosome.set(i, "0");
				} else {
					this.chromosome.set(i, "1");
				}
			}
		}
		
		System.out.println("After mutation:  " + this.chromosome);
		
		return this;
		
	}
	
	public Double getUsedSpace() {
		return usedSpace;
	}

	public void setUsedSpace(Double usedSpace) {
		this.usedSpace = usedSpace;
	}

	public List getSpaces() {
		return spaces;
	}

	public void setSpaces(List spaces) {
		this.spaces = spaces;
	}

	public List getValues() {
		return values;
	}

	public void setValues(List values) {
		this.values = values;
	}

	public Double getSpaceLimit() {
		return spaceLimit;
	}

	public void setSpaceLimit(Double spaceLimit) {
		this.spaceLimit = spaceLimit;
	}

	public Double getEvaluationNote() {
		return evaluationNote;
	}

	public void setEvaluationNote(Double evaluationNote) {
		this.evaluationNote = evaluationNote;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public List getChromosome() {
		return chromosome;
	}

	public void setChromosome(List chromosome) {
		this.chromosome = chromosome;
	}

	@Override
	public int compareTo(Individual ind) {
		if(this.evaluationNote > ind.getEvaluationNote()) {
			return -1;
		} else if(this.evaluationNote < ind.getEvaluationNote()) {
			return 1;
		} return 0;
	}
	
}
