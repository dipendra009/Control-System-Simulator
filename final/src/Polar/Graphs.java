package Polar;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

import Common.Coordinate;

import java.awt.Graphics2D;

public class Graphs extends JPanel
{
   
     double div1;
	 boolean LINE ;
	 private int  div;
	 private int screenX = 1400;
	 private int screenY = 900;
	 private int maxX = screenX/2-30;
	 private int maxY = screenY/2 -70;
	
	  Coordinate[] points;
	  double scale1;
	  int  scale;
	  Color color;
	  

	 
	public Graphs(Coordinate[] points, boolean b)
	{
		LINE = b;
		this.points = points;
		this.color = Color.BLACK;
		
		double  divX= maxX/(10*Coordinate.getMaxX(points));
		
		double divY= maxY/(10*Coordinate.getMaxY(points));
		if(divX<divY)
		{
			if(divX<3)
				divX++;
			div1 = divX;
		}
		else
		{
			if(divY<3)
				divY++;
			div1 =divY;
		}
		if(div1<5)
			div1=5;
		if(div1>10)
			div1=10;

		div = 5;
		
		
		//System.out.printf("%f", div);
		maxX = maxX-maxX%(div*10);
		maxY = maxY-maxY%(div*10);
		double max = (maxX>maxY) ? maxY : maxX;
		
		double  scaleX = (Coordinate.getMaxX(points)/(max/(div*10)));
		double scaleY = (Coordinate.getMaxY(points)/(max/(div*10)));
		
		if(scaleX > scaleY)  
			scale1 = scaleX;
		else
			scale1 = scaleY;
		scale1 += Math.pow(5, (int)Math.log10(scale1))*3;
		if(scale1<0)
			scale1=1;
		if(scale1>1000)
		{
			javax.swing.JOptionPane.showMessageDialog(null,"data out of range");
			System.exit(1);
		}
			else scale1= (int) (scale1);
		 scale = (int)scale1;
		//System.out.println("1max "+max+"scale X "+scaleX+"Coordinate.getMaxX  "+Coordinate.getMaxX(points)+"scale Y "+scaleY+"Coordinate.getMaxY  "+Coordinate.getMaxY(points)+"scale"+scale);
		
		
		 if((scale>2)&&(scale<5))
			scale = 5;
		else if((scale<10)&&(scale>5))
			scale = 10;
		else if(((scale%10)!=0)&&(scale>10))
			scale = scale - (scale%10) + 10;
		
		//System.out.println("2max "+max+"scale X "+scaleX+"Coordinate.getMaxX  "+Coordinate.getMaxX(points)+"scale Y "+scaleY+"Coordinate.getMaxY  "+Coordinate.getMaxY(points)+"scale"+scale);
		//System.out.println("div  "+div);
		}
	  
	  
     public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        screenX = getWidth();
        screenY = getHeight();
		
        Graphics2D g2d = (Graphics2D ) g;
		g2d.translate(screenX/2, screenY/2);

        
        this.setBackground(Color.WHITE);
        g.setColor(new Color((255), (175),( 175) ));
        
		int j=0;
		
		for(int i = 0;i<=maxX; i+= div,j++)
        {
            g.setColor(new Color((255), (175),( 175) ));
            if((j%10==0))
            {
                g.fillRect(i, -maxY, 2,maxY*2 );
                g.fillRect(-i,-maxY, 2,maxY*2 );
            }
            
            else
            {
                g.fillRect(i, -maxY, 1,maxY*2 );
                g.fillRect(-i, -maxY, 1,maxY*2 );
            }
       }
		j = 0;
      
       for(int i = 0;i<=maxY;j++, i+=div)
        {
             g.setColor(new Color((255), (175),( 175) ));
            if((j%10==0))
            {
                g.fillRect( -maxX,-i, maxX*2,2 );
                g.fillRect(-maxX,i, maxX*2 ,2);
               
                if((j>0)&&(i+div*10<=maxY))
				{
					g.setColor(Color.BLUE);
					String d = String.format("%d",-(j*scale/10));
					g.drawString(d,0,i);
					d = String.format("%d",(j*scale/10));
					g.drawString(d,0,- i);
				}
             
            }
            else
            {
                g.fillRect( -maxX,i, maxX*2,1 );
                g.fillRect( -maxX, -i,maxX*2,1 );
             
            }
       }

		j=0;
		
       for(int i = 0;i<=maxX; i+= div,j++)
        {
            
            if((j%10==0))
            {
               
              if((i+div*10<=maxX))
				{
					g.setColor(Color.BLUE);
					
					 String d = String.format("%d",(j*scale/10));
					g.drawString(d,i+2,0);
					d = String.format("%d",-(j*scale/10));
					g.drawString(d,- i+2,0);
				}
				
             
            }
           
       }
	   g.setColor(color);
	  if(LINE == true)
		  this.line(g,points);
	  else
	  this.plot(g,points);

    	 
	}
			
     
     
     
     private  void plot(Graphics g,Coordinate []points)
		{
    	 //	System.out.println(scale);
			for(Coordinate point : points)
				plotPoint(g,point);
				
		}
     
     
	private  void plotPoint(Graphics g, Coordinate point)
		{
			int X= (int)((point.x*10*div)/(scale));
			int Y = (int)((point.y*10*div)/(scale));
			//System.out.printf("\n%d  %d ", X, -Y);
			g.fillRect(X, -Y, 2,2);
		}
				
	private   void line(Graphics g,Coordinate []points)
		{

				for(int i=0; i<points.length-1; i++)
				{
					int X1= (int)((points[i].x*10*div)/(scale));
					int Y1 = (int)((points[i].y*10*div)/(scale));
					int X2= (int)((points[i+1].x*10*div)/(scale));
					int Y2 = (int)((points[i+1].y*10*div)/(scale));	
					g.drawLine(X1, -Y1, X2, -Y2);
					
				}
			}
        
               
    
}