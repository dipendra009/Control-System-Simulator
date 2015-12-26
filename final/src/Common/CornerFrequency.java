package Common;
public class CornerFrequency
{
	public double value;
	public double img;
	public int order;
	
	public CornerFrequency(double value,int order)
	{
		
		this.value = value;
		this.order = order;
	
	}
	public  CornerFrequency(double value, double img,int order)
	{
		this.value = Math.sqrt(value);
		this.order = order;
		this.img = img/value;
	}
	
	public static double getMaximum(CornerFrequency[] corners)
	{
		double max=.00001;
		for(CornerFrequency corner : corners)
		{
			if((corner.value > max)&&(corner.order!=0))
				max = corner.value;
			
		}
		return max;
		
	}
	public static  double getMinimum(CornerFrequency[] corners)
	{
		double min = 1000;
		for(int i =0; i< corners.length; i++)
		{
			if((corners[i].order !=0)&&(corners[i].value!=0))
			{
				if(corners[i].value< min)
				min = corners[i].value;
			}
		}
		return min;
		
	}
	public static double getStartingPoint(CornerFrequency[] corners)
	{
		double  min = getMinimum(corners);
		
		double start = Math.log10(min);

		
		if(start >0)
		start = (int)start -1.0;
		else
			start = (int)start - 2.0;
		
		
		start = Math.pow(10, start);
		
		
		return start;
		
	}
	public static void arrange(CornerFrequency[] corners)
	{
		
		CornerFrequency temp;
		for(int i =0;i < corners.length-1; i++)
		{
			
		
			if((corners[i].order!=0)&&(corners[i].value!=0))
			for(int j=i+1;j< corners.length; j++)
			{
					temp = corners[j];
					if(corners[j].order == 0)
					{
						
						
						corners[j] = corners[i];
						corners[i]= temp;
						
						
					}
					else if(corners[j].value == 0)
					{
						
						
						corners[j] = corners[i];
						corners[i]= temp;
						
					}
					
					
					else	if(corners[j].value<corners[i].value)
						{
							corners[j] = corners[i];
							corners[i]= temp;
						
						}
					}
					

					
		 	}
		}
	
	public static  double  getPhase(CornerFrequency corner, double w)
	{
		
		if(corner.order == 0)
			return 0;
		else if(corner.value ==0)
			return ((Math.PI/2)*corner.order);
		else if(corner.order == 1)
			return (Math.atan(w/corner.value));
		else if(corner.order == -1)
			return (-(Math.atan(w/corner.value)));
		else if(corner.order == 2)
		{
			
			double denum = (1-(w/corner.value)*(w/corner.value));
			if(denum==0)
					return ((Math.PI/2)*corner.order);
			else if(denum < 0 )
			{
				denum *= -1.0;
				return(Math.PI-(Math.atan((corner.img*w)/denum)));
			}
				
			return(Math.atan((corner.img*w)/denum));
		}
		else if(corner.order == -2)
		{
			
			double denum = (1-(w/corner.value)*(w/corner.value));
			if(denum==0)
					return ((Math.PI/2)*corner.order);
			else if(denum < 0 )
			{
				denum *= -1.0;
				return(-(Math.PI-(Math.atan((corner.img*w)/denum))));
			}
				
			return(-(Math.atan((corner.img*w)/denum)));
		}
		
		else
			System.exit(1);
		return 0;
		
				
		
	}
	public static  double  getMagnitude(CornerFrequency corner, double w)
	{
		
		double mag=0;
		if(corner.order == 0)
			mag= corner.value;
		else if(corner.value ==0)
			mag = Math.pow(w, corner.order);
		else if(corner.order == 1)
			mag = Math.sqrt(w*w+corner.value*corner.value);
		else if(corner.order == -1)
				mag = 1/(Math.sqrt(w*w+corner.value*corner.value));
		else if(corner.order == 2)
		{
			
			double imagin = corner.img*corner.value*corner.value;
			double real = corner.value* corner.value - w*w;
			mag = Math.sqrt(imagin*imagin + real*real);
		}
		else if(corner.order == -2)
		{
			
			double imagin = corner.img*corner.value*corner.value;
			double real = corner.value* corner.value - w*w;
			mag = 1/(Math.sqrt(imagin*imagin + real*real));
		}
		
		else
			System.exit(1);
		
	
		return mag;
				
		
	}
	public static double  getStartMagnitudePoint(CornerFrequency[] corners)
	{
		double startMagnitudePoint=1;
		
		for(CornerFrequency corner : corners)
		{
			if(corner.value != 0)
			{
				if(corner.order==0)
			
					startMagnitudePoint *= (corner.value);
				else if(corner.order==1)
					startMagnitudePoint *=(corner.value);
				else if(corner.order==2)
					startMagnitudePoint *=((corner.value)*(corner.value));
				else if(corner.order==-1)
					startMagnitudePoint *=(1/(corner.value));
				else if(corner.order==-2)
					startMagnitudePoint *=(1/(corner.value*corner.value));
			}
			
		}

		for(CornerFrequency corner : corners)
		{
			double startX = getStartingPoint(corners);
			if(corner.value == 0)
			startMagnitudePoint = startMagnitudePoint * (Math.pow(startX, corner.order));
		}
		startMagnitudePoint = 20 * (Math.log10(startMagnitudePoint));
		
		
		return startMagnitudePoint;
	}
	
	

	
	public static void display(CornerFrequency[] corners)
	{
		System.out.println("The given CornerFrequencies are :");
		for(CornerFrequency corner : corners)
			System.out.println("Value is : "+corner.value + "Order is : "+corner.order);
	}
	public static double getPhaseSum(CornerFrequency []corners, double w)
	{
		double phase = 0;
		for(CornerFrequency corner : corners)
			phase += CornerFrequency.getPhase(corner,w);
		return phase;

	}
	public static double getMagnitudeSum(CornerFrequency []corners, double w)
	{
		double mag = 1;
		for(CornerFrequency corner : corners)
			mag *= CornerFrequency.getMagnitude(corner,w);
			
	return mag;
	}
	


	
	

	

	
}
