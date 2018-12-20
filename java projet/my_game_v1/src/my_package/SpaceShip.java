package my_package;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class SpaceShip {
	
	private Color myColor;
	private int lifePoint;
	private double speed; 
	//private int buildTime; useless
	//private int power;
	Coordinates top;
	Coordinates left;
	Coordinates right;
	Polygon Tshape;

	public SpaceShip(Color myColor, Coordinates top, Coordinates left,Coordinates right, Polygon Tshape) 
	{
		this.myColor = myColor;
		this.top = top;
		this.left = left;
		this.right = right;
		this.Tshape = Tshape;
	}
	

}
