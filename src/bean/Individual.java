package bean;

import java.util.ArrayList;
import java.util.List;

public class Individual {
	
	private List spaces = new ArrayList<>();
	private List values = new ArrayList<>();
	private Double spaceLimit;
	private Double usedSpace;
	private Double evaluationNote;
	private int generation;
	private List chromosome = new ArrayList<>();
	
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
	
}
