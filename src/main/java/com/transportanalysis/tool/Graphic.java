package main.java.com.transportanalysis.tool;

import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import main.java.com.transportanalysis.models.IndividualVO;

public class Graphic extends ApplicationFrame {

	private List<IndividualVO> bestChromossomes = new ArrayList();
	
	public Graphic(String windowTitle, String graphicTitle, List bestChromossomes) {
		super(windowTitle);
		this.bestChromossomes = bestChromossomes;
		JFreeChart lineGraphic = ChartFactory.createLineChart(
				graphicTitle, "Generation", "Value", loadData(), PlotOrientation.VERTICAL, true, true, false);
		ChartPanel graphicWindow = new ChartPanel(lineGraphic);
		graphicWindow.setPreferredSize(new java.awt.Dimension(800, 600));
		setContentPane(graphicWindow);
	}
	
	private DefaultCategoryDataset loadData() {
		
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		
		for(int i = 0; i < bestChromossomes.size(); i++) {
			data.addValue(bestChromossomes.get(i).getEvaluationNote(), "Best solution", "" + i);
		}
		
		return data;
	}
	
}
