package my_package;

public abstract class Object2D {
	protected double x;
	protected double y;
	public Object2D(double x, double y)
	{
		this.x = x;
		this.y = y; 
	}
	public void translate(double x, double y)
	{
		this.x += x;
		this.y +=y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
}
