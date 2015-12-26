package Common;
public class Coordinate 
{
	public double x;
	public double y;
	public  Coordinate(double x, double y )
	{
		this.x = x;
		this.y = y;
	}
	public static double getMaxX(Coordinate[] points)
	{
		double maxX=0;
		for(Coordinate point : points)
		{
		if(maxX < Math.abs(point.x))
			maxX= Math.abs(point.x);
	}
		return maxX;
	}
	public static double getMaxY(Coordinate []points)
	{
		double maxY=0;
		for(Coordinate point : points)
		{
			if(maxY < Math.abs(point.y))
			maxY= Math.abs(point.y);
		}
		return maxY;
	}
	public static void display(Coordinate point)
	{
		System.out.println(" x = "+point.x+"\ty = "+point.y);
	}
	public static void display(Coordinate[] points)
	{
		for(Coordinate point : points)
		System.out.println(" x = "+point.x+"\ty = "+point.y);
	}
	
	
}
