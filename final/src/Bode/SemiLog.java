package Bode;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

import Common.CornerFrequency;


public class SemiLog extends JPanel
{
	CornerFrequency[] corners;
    double scaleM, scaleP;
    private int x;
	private int maxX, maxY, startX, startY;
	private int divY, divX;
	private double k,factor,initX,lastC,xm,xm1,xm2,ym1,ym2,scale;
   
    
    Color graphColor = Color.RED;
    Color backGroundColor = Color.WHITE;
   
    Color plotColor = Color.black;
   
       
	public SemiLog(CornerFrequency[] points)
	{
		
		this.corners = points;
		CornerFrequency.arrange(points);
		CornerFrequency.display(points);
		

		
	}
    
	public void paintComponent(Graphics g)
    {
		 maxX=getWidth();
    	 maxY=getHeight();
    	 startX = (int)(0.05*maxX);
    	 startY = (int)(0.05*maxY);
    	 maxX = (int)(0.93*maxX);
         maxY = (int)(maxY*.85);
         initX = CornerFrequency.getStartingPoint(corners);
		
         factor=((maxX-startX)/4);
         divY=(int)((maxY-startY)/200);
        
         maxY=maxY-(maxY)%(divY*10)+startY;
      
         super.paintComponent(g);
         this.setBackground(backGroundColor); 

         SemilogGraphPlot(g);
         MagnitudePlot(g);
         PhasePlot(g);
    }
	
	public void SemilogGraphPlot(Graphics g)
	{
		
		double k;;
		int i=1;
		 int l=0;
		double tempi=0;
		do
		{
					g.setColor(graphColor);
					k = Math.log10(i)*factor;
					x = (int)(startX+k);
					g.fillRect(x,startY, 2, maxY-startY );
					divX = (int)Math.pow(10,(int)(Math.log10(i)));
					g.setColor(Color.BLUE);
				
					
					if(tempi != divX)
					{	
						l=1;
						tempi = divX;
						String d = String.format("%d E%d",l,(int)(Math.log10(i*initX)));
						g.drawString(d,x,startY-10);
						g.drawString(d,x,maxY+20);
					}
					else
					{
						l++;
						String d = String.format("%d",l);
						g.drawString(d,x,startY-10);
						g.drawString(d,x,maxY+20);
					}
					
					double tempK=i;
					int j=0;
					g.setColor(Color.PINK);
					if(i==10000)
						break;
					do
					{
						j++;
						tempK += divX/10.0;
						k = (Math.log10(tempK))*factor;
						x = (int)(startX+k);
						g.fillRect(x,startY, 1, maxY-startY );
						
						
				    }	while(j<10);
					i+= divX;
					
					
		}	while(i<=10000);
		maxX= x;
		
       for(i = startY;i<=maxY-divY*10; i+=divY*10)
        {
			 g.setColor(graphColor);
			
			 g.fillRect(startX,i, maxX-startX, 2);
		   
			 g.setColor(Color.PINK);
			
			 for(int j = 1; j < 10;j++)
			 {
				g.fillRect(startX,i+divY*j, maxX-startX, 1);
		   	
			 }
        }
       
	g.setColor(graphColor);
	g.fillRect(startX,maxY, maxX-startX, 2);
	}
	
	public void MagnitudePlot(Graphics g)
	{
		double mag, x2;
		xm =CornerFrequency.getStartingPoint(corners);
		double x1 =CornerFrequency.getStartingPoint(corners);
		mag = CornerFrequency.getStartMagnitudePoint(corners);
		double slope = 0;
		
		for(CornerFrequency corner : corners)
		{
		if(corner.value == 0)
			slope += 20 * corner.order;
		}
		
		double maxM = mag;
		double minM = mag;
		
		int i;	
		
		for( i=0; i< corners.length; i++)
		{
			if((corners[i].order!=0)&&(corners[i].value !=0) )
			{
				
				x2 = corners[i].value;
				mag +=(slope*Math.log10(x2/x1));
				if(mag< minM)
						minM = mag;
				if(mag> maxM)
						maxM = mag;

			
				slope += 20 * corners[i].order;  
				x1=x2;
			}
		
		}
		x2 = x1 + 50* Math.pow(10,(int)(Math.log10(x1)));
		if(x2>10000*xm)
			x2 = 10000*xm;

		mag +=(slope*Math.log10(x2/x1));
				if(mag< minM)
						minM = mag;
				if(mag> maxM)
						maxM = mag;
			
				
		
		//End
		
		scaleM = (maxM-minM)/10;
		scaleM = (scaleM - (scaleM)%10 + 10);
		
		
		double startM = startY +20*divY+(maxM/scaleM)*10*divY;
		startM -= (startM-startY)%(divY*10);
		
		g.setColor(plotColor);
		g.fillRect(startX, (int)(startM), maxX-startX, 2);
		
		
		mag = CornerFrequency.getStartMagnitudePoint(corners);
		slope = 0;
		for( i =0; i< corners.length; i++)
		{
			if(corners[i].value == 0)
			slope += 20 * corners[i].order;
			else if(corners[i].order == 0)
				continue;
			else
				break;
		}
		
		x1=xm;
		
		 xm1 = startX;
		ym1 = startM -((mag )/scaleM)*divY * 10;
		
		for( ; i< corners.length; i++)
		{
			if((corners[i].order!=0)&&(corners[i].value !=0) )
			{
				x2 = corners[i].value;
				mag +=(slope*Math.log10(x2/x1));
				slope += 20 * corners[i].order;  
				x1=x2;
				xm2 =startX + Math.log10(x2/xm)*factor;
				ym2 = startM - ((mag )/scaleM)*divY * 10;
				g.drawLine((int)xm1, (int)ym1, (int)xm2, (int)ym2);
				xm1 = xm2;
				ym1 = ym2;
			
			}
		}
		x2 = x1 + 50* Math.pow(10,(int)(Math.log10(x1)));
		
		if(x2>10000*xm)		x2 = 10000*xm;
		
		mag +=(slope*Math.log10(x2/x1));
		xm2 = startX+Math.log10(x2/xm)*factor;
		ym2 = startM - ((mag )/scaleM)*divY * 10;
		lastC = x2;
		
		System.out.println(" X 2 is "+lastC);
		
		g.drawLine((int)xm1, (int)ym1, (int)xm2, (int)ym2);
		g.setColor(Color.BLUE);
		scale =(minM-2*scaleM);
		scale = (scale-scale%scaleM+scaleM);
		
		for(;(scale<maxM+scaleM);scale+=scaleM)
		{
			
			String d = String.format("%.2f", scale);
			g.drawString(d,(int)(startX-40),(int)(startM-scale*divY*10/scaleM));
			
		}	
		
	}
	
	public void PhasePlot(Graphics g)
	{
		double mag;
		double maxP =-500;
		double minP =1000;
		k =  CornerFrequency.getStartingPoint(corners);
		double w =k;
		int inc;
		int l;
		 l = corners.length; 
		 int i;
		for( i =0;; i++)
		{
			
			mag = 0;
			for(int j=0; j< corners.length; j++)
			mag+= CornerFrequency.getPhase(corners[j],w);	
			mag *= (180 / (Math.PI));
		
			inc = (int)(Math.log10(w))-1;
			w += Math.pow(10,inc);
			if(minP>mag) 
				minP=mag;
			if(maxP<mag)
				maxP=mag;
			mag = 0;
			for(int j=0; j< corners.length; j++)
			mag+= CornerFrequency.getPhase(corners[j],w);	
			mag *= (180 / (Math.PI));
		
			inc = (int)(Math.log10(w))-1;
			w += Math.pow(10,inc);
			if(minP>mag) 
				minP=mag;
			if(maxP<mag)
				maxP=mag;
			System.out.println("w  "+w+" mag "+mag);
			
			if(w>=lastC )
				break;
		}
		
			
		
		if(minP>-180)
			minP = -180;
		if(maxP<-180)
			maxP = -180;
		scaleP = (maxP-minP)/10;
		scaleP = scaleP - (scaleP)%10 + 10;
		double startP = maxY-divY*20-(-180-minP)/scaleP*divY*10;
		startP = startP -  ((startP-startY)%(divY*10));
	
		g.setColor(plotColor);
		g.fillRect(startX,(int)(startP), maxX-startX, 2);
		startP -= (180)/scaleP*divY*10;
		
		k =  CornerFrequency.getStartingPoint(corners);
		w =k;
		mag=0;
		xm1 = startX;
		for(int j=0; j< corners.length; j++)
		mag+= CornerFrequency.getPhase(corners[j],w);
		ym1 = startP - ((mag )/scaleP)*divY * 10;
		do
		{
			
			mag = 0;
			for(int j=0; j< corners.length; j++)
			mag+= CornerFrequency.getPhase(corners[j],w);	
			mag *= (180 / (Math.PI));
			
			xm2 =startX + Math.log10(w/xm)*factor;
			ym2 = startP - ((mag )/scaleP)*divY * 10;
			g.drawLine((int)xm1, (int)ym1, (int)xm2, (int)ym2);
			xm1 = xm2;
			ym1 = ym2;
		
			inc = (int)(Math.log10(w))-1;
			w += Math.pow(10,inc);
			
			mag = 0;
			for(int j=0; j< corners.length; j++)
			mag+= CornerFrequency.getPhase(corners[j],w);	
			mag *= (180 / (Math.PI));
		
			xm2 =startX + Math.log10(w/xm)*factor;
			ym2 = startP - ((mag )/scaleP)*divY * 10;
			g.drawLine((int)xm1, (int)ym1, (int)xm2, (int)ym2);
			xm1 = xm2;
			ym1 = ym2;
		
			inc = (int)(Math.log10(w))-1;
			w += Math.pow(10,inc);
			
			
		}while(w < lastC);
		
		g.setColor(Color.BLUE);
		scale=(minP-2*scaleP);
		scale = (scale-scale%scaleP+scaleP);
		for(;(scale<maxP+scaleP);scale+=scaleP)
		{
			
			String d = String.format("%.2f", scale);
			g.drawString(d,(int)(startX-40),(int)(startP-scale*divY*10/scaleP));
			
		}	
		
		Font f12 = new Font("Times New Roman", Font.BOLD + Font.ITALIC, 24);
		
		int x= (int)(3*maxX/4);
		int y = (int)(maxY/7);

        String mg = "Magnitude Plot";
		g.setFont(f12);
		g.setColor(Color.black);
		g.drawString(mg, x, y-10);
		
		y = (int)(5*maxY/7);
		String ph = "Phase Plot";
		g.drawString(ph, x, y-10);

	}
	




}


