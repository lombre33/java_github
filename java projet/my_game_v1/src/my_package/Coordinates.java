package my_package;

public class Coordinates extends Object2D{
	
	public Coordinates(double x, double y)
	{
		super(x,y);
	}
	
	public void rotation(double angle, Coordinates center)
	{		
		double X = this.x - center.x;
		double Y = this.y - center.y;
		double x1 = center.x - X * Math.cos(Math.toRadians(angle)) + Y * Math.sin(Math.toRadians(angle));
		double y1 = center.y - X * Math.sin(Math.toRadians(angle)) - Y * Math.cos(Math.toRadians(angle));
		this.x = x1;
		this.y = y1;
		
	}
	public void ToString() 
	{
		System.out.println("test");
		System.out.println(this.x);
		System.out.println(this.y);
		
		
	}
	public void read()
	{
		System.out.print(this.x + " ");
		System.out.println(this.y);
	}
	

}
