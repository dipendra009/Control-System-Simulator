package Nyquist;
import javax.swing.JFrame;

import Common.Coordinate;
import Common.CornerFrequency;

import java.util.ArrayList;
import java.awt.Color;
public class NyquistPlot extends JFrame
{
   
    
	
    CornerFrequency[] corners;
    
       
	public void displayNyquistPlot(CornerFrequency[] cor)
	{
		
		this.corners = cor;
		CornerFrequency.arrange(corners);
		//CornerFrequency.display(corners);
		double w0 = Math.pow(10, -10);
		double infinite = Math.pow(10, 4);
		double k = Math.pow(10, -2);
		double w = w0;
		Coordinate point;
		double mag;
		double phase;
		double real1, real2, imag1, imag2;
		real1 =0; 
		imag1 =0;
		double inc ;
		double diffx, diffy;
		ArrayList<Coordinate> points = new ArrayList<Coordinate>();
		boolean loop = true;
		int i =0; 
		inc = Math.pow(10, (int)(Math.log10(w)));
		//double dw= inc;
		do
		{
			inc = Math.pow(10, (int)(Math.log10(w))-2);
			i++;
			phase = CornerFrequency.getPhaseSum(corners, w);
			
			mag = CornerFrequency.getMagnitudeSum(corners, w);
			imag2 = mag* Math.sin(phase);
			real2 = mag*Math.cos(phase);
			diffx = Math.abs(real1-real2);
			diffy = Math.abs(imag1-imag2);
			real1 = real2; 
			imag1 = imag2;
			point = new Coordinate(real2, imag2);
				//dw= inc/10;
				points.add(point);
				//System.out.println("real2  "+real2+"imag  "+imag2+"  w  "+w);
			
			
			w += inc;
			
		}
		while(w*w0<1);
		Coordinate[] plotPoints = new Coordinate[points.size()];
		 points.toArray(plotPoints);
	
		double maxX = Coordinate.getMaxX(plotPoints);
		double maxY = Coordinate.getMaxY(plotPoints);
	
		if(maxX>maxY)
			maxX = 3*maxY;
		else
			maxY = 2*maxX;
		
		
		for(i =0; i<plotPoints.length; i++)
		{
			
			if(Math.abs(plotPoints[i].x )> maxX)
			{
				plotPoints[i].x=0;
				plotPoints[i].y=0;

			}
			if(Math.abs(plotPoints[i].y)> maxY)
			{
				plotPoints[i].x=0;
				plotPoints[i].y=0;
			}
			
		}
		ArrayList<Coordinate> finalPoints = new ArrayList<Coordinate>();
		for(i=0; i< plotPoints.length;i++)
		{
			if((plotPoints[i].x!=0)&&(plotPoints[i].y!=0))
				finalPoints.add(plotPoints[i]);
		}
		Coordinate[] finalPlotPoints = new Coordinate[finalPoints.size()];
		finalPoints.toArray(finalPlotPoints);
		Graphn polarPlot = new Graphn(finalPlotPoints, true);
		add(polarPlot);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1400, 900);
		setVisible(true);
		
		
	

	}
	




}




