package my_package;

import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
;

public class Main extends Application {
	
	private final static int WIDTH = 800;
	private final static int HEIGHT = 800;
	private final static int PLANETSNUM = 1;
	private final static int PLANETMINRAD = 30;
	private final static int PLANETMAXRAD = 100;

	
    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
    
    public static String getRessourcePathByName(String name) {
		return Main.class.getResource('/' + name).toString();
	}
    
    public int my_random(int min, int max)
    {
    	int result = (int)( Math.random()*( max - min + 1 ) ) + min;
    	
    	return result;
    	
    }
    
    @Override
    public void start(Stage primaryStage) {
    	
    	primaryStage.setTitle("SpaceGame");
    	Group root = new Group();
    	Scene scene = new Scene(root, WIDTH,HEIGHT, Color.WHITE);
    	primaryStage.setScene(scene);
    	
    	Image space = new Image(getRessourcePathByName("images/space_background.jpg"), WIDTH, HEIGHT, false, false);
    	ImageView space_view = new ImageView(space);
    	root.getChildren().add(space_view);
    	
    	ArrayList<Planetes> PlanetList= new ArrayList<Planetes>();
    	
    	//Planets generation
    	for(int i = 0; i < PLANETSNUM; i++  )
    	{
    		int a = 0;
    		for(int l = 0; l < 300 && a == 0; l++)
    		{
    			int r = my_random(PLANETMINRAD, PLANETMAXRAD);
        		Color c = Color.CHOCOLATE;
        		int x = my_random(r, WIDTH -r);
        		int y = my_random(r, HEIGHT -r);
        		int t = 0;
        		int index = i;
        		Circle shape = new Circle(); 
                shape.setCenterX(x);//réglage de la position, de la taille et de la couleur du cercle
                shape.setCenterY(y);
                shape.setRadius(r);
                shape.setFill(c);
        		Planetes planets = new Planetes(r,c,x,y,t,index,shape);	
  
        		if(planets.check(PlanetList) == true)
        		{
        			a = 1;
        			PlanetList.add(planets);
            		root.getChildren().add(planets.Pshape);
        		}	
    		}
    	}
    	// End of Planets generations 
    	
    	
    	// Starts of Vessels generation
    	
    	//boucle avec nbr vaisseau qui renvoit le vaisseau puis afficheage chaque tour
 
		
    	for(int i = 0; i < 15; i++)
    	{
    	Planetes b = PlanetList.get(0);
    	SpaceShip ship = b.generateSpaceShip();
    	root.getChildren().add(ship.Tshape);

    	}
    	
    	//End of Vessels generations
    	
    	primaryStage.show();
    }

}
