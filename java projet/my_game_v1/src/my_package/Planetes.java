package my_package;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;



public class Planetes 
{
	private final static int PLANETDIST= 75;
	private final static int SPACESHIPSCALE= 20;
	

	protected double radius; 
	private int index; //
	public Shape Pshape; 
	 private Color my_color;
	 protected double Xcenter;
	 protected double Ycenter; 
	 private int spaceships_type; // set 0 classic vessels, 1 to 5 is worth to best 
	 private int owner; // 0 is the human player, 1 is the bot 
	 protected Coordinates center; 
	 protected Coordinates top;
	 protected int spaceShipsOut;
	 protected double perimeter;
	 protected int maxSpaceShips;
	 protected double angle; 
	 
	 public Planetes(int radius, Color my_color, int xcenter, int ycenter, int spaceships_type, int index, Shape shape) {
		super();
		this.radius = radius;
		this.my_color = my_color;
		Xcenter = xcenter;
		Ycenter = ycenter;
		this.spaceships_type = spaceships_type;
		this.index = index;
		this.Pshape = shape;
		this.center = new Coordinates(xcenter,ycenter);
		this.top = new Coordinates(center.x,center.y);
		this.top.translate(0,-this.radius);
		this.perimeter = radius * 2 * Math.PI;
		this.maxSpaceShips = (int)(this.perimeter / SPACESHIPSCALE);
		this.spaceShipsOut = 0;
		this.angle = (360 / this.maxSpaceShips) ;
		
		
	}
	public boolean check(ArrayList<Planetes> planetList)
	{
		//go in the list to recup 1 planet and redoo for all.
		
		// WARNING add a check to make sure planet is above 20 of the top bottom and sides
		if(planetList.size() == 0)
		{ 
			//System.out.println("premier");
			return true;
		}		
		for(int i = 0 ; i < planetList.size() ; i++)
		{
			Planetes b = planetList.get(i);		
			double x = b.Xcenter  - this.Xcenter;
			double y = b.Ycenter - this.Ycenter;			
			double d = PLANETDIST + b.radius + this.radius;		
			if(Math.sqrt((x*x + y*y )) < d)   
			{
				System.out.println("false");
				return false;
			}		
		}	
		System.out.println("true");
		return true;		
	}
	
	public SpaceShip generateSpaceShip()
	{	
        Coordinates top = new Coordinates(this.top.x , this.top.y - 30);
        Coordinates left = new Coordinates(this.top.x - 10 , this.top.y );
        Coordinates right = new Coordinates(this.top.x + 10 , this.top.y );      
    	Polygon Tshape = new Polygon();
    	Tshape.setFill(Color.WHITE);
    	int j = this.spaceShipsOut /2 ;
    	if(this.spaceShipsOut == 0) {j = 1;}      
    	SpaceShip spaceShip = new SpaceShip(Color.BLACK,top,left,right,Tshape);			
		if(this.spaceShipsOut == 0)
		{
			this.spaceShipsOut++;	
			spaceShip.Tshape.getPoints().addAll(new Double[]{
    	    top.getX(), top.getY(),
    	    left.getX(), left.getY(),
    	    right.getX(), right.getY()});
			return spaceShip;			
    	} 
		else if (this.spaceShipsOut %2 == 1)
		{		
			top.rotation( j*this.angle + this.angle + 180 , this.center);
			right.rotation(j*this.angle + this.angle+  180 , this.center);
			left.rotation(j*this.angle + this.angle + 180 , this.center);
			spaceShip.Tshape.setFill(Color.RED);
			spaceShip.Tshape.getPoints().addAll(new Double[]{
			top.getX(),top.getY(),
			right.getX(),right.getY(),
			left.getX(),left.getY() });
			this.spaceShipsOut++;
			j++;
		
		}
		else
		{
			top.rotation(- ((j-1)*this.angle + this.angle + 180 ), this.center);
			right.rotation(-((j-1)*this.angle + this.angle +  180 ), this.center);
			left.rotation(-((j-1)*this.angle + this.angle + 180) , this.center);
			spaceShip.Tshape.setFill(Color.YELLOW);
			spaceShip.Tshape.getPoints().addAll(new Double[]{
			top.getX(),top.getY(),
			right.getX(),right.getY(),
			left.getX(),left.getY() });
			this.spaceShipsOut++;
			
		}
    	
		return spaceShip;
	}
	
}

