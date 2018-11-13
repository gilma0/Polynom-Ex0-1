package myMath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
public class plot_poly {
	
	
	
	
	public static void main(String[] args) throws IOException { 
		Polynom test = new Polynom ("0.2*X^4-1.5*X^3+3.0*X^2-1*X^1-5");
		double eps = 0.1;
		double start = -2;
		double end = 6;
		ArrayList<Double> xxdata = new ArrayList<Double>();
		ArrayList<Double> yydata = new ArrayList<Double>();
		while (start <= end) {
			xxdata.add(start);
			yydata.add(test.f(start));
			start = start + eps;
		}
		System.out.println(xxdata);
		System.out.println(yydata);
 		double[] xData = new double[xxdata.size()];
		double[] yData = new double[xxdata.size()];
		Iterator<Double> iterX = xxdata.iterator();
		Iterator<Double> iterY = yydata.iterator();
		for (int i = 0; i<xxdata.size(); i++) {
			xData[i] = iterX.next();
			yData[i] = iterY.next();
		}

		// Create Chart
		XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);

		// Show it
		new SwingWrapper(chart).displayChart();

		// Save it
		BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapFormat.PNG);

		// or save it in high-res
		BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapFormat.PNG, 300);
	}
	}