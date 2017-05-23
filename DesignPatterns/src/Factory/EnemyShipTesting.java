package Factory;

import java.util.Scanner;


//Factory se usa para que un metodo regrese UNA de varias clases posibles que comparten una superclase, por ejemplo
// se pueden tener enemigos que dependiendo de un numero aleatorio regrese el objeto de cierto tipo --> classes chosen @runtime

// Cuando se usa:
// - Cuando no se sabe que objeto se usará -> siempre y cuando sean subclases
public class EnemyShipTesting {

	public static void main(String[] args){
		
		// Create the factory object
		EnemyShipFactory shipFactory = new EnemyShipFactory();
		
		// Enemy ship object
		
		EnemyShip theEnemy = null;
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("What type of ship? (U / R / B)");
		
		if (userInput.hasNextLine()){
			
			String typeOfShip = userInput.nextLine();
		
			theEnemy = shipFactory.makeEnemyShip(typeOfShip);
			
			if(theEnemy != null){
				
				doStuffEnemy(theEnemy);
				
			} else System.out.print("Please enter U, R, or B next time");
		
		}
		
		/*
		EnemyShip theEnemy = null;
		
		// Old way of creating objects
		// When we use new we are not being dynamic
		
		EnemyShip ufoShip = new UFOEnemyShip();
		
		doStuffEnemy(ufoShip);
		
		System.out.print("\n");
		
		// -----------------------------------------
		
		// This allows me to make the program more dynamic
		// It doesn't close the code from being modified
		// and that is bad!
		
		// Defines an input stream to watch: keyboard
		Scanner userInput = new Scanner(System.in);
		
		String enemyShipOption = "";
		
		System.out.print("What type of ship? (U or R)");
		
		if (userInput.hasNextLine()){
			
			enemyShipOption = userInput.nextLine();
			
		}
		
		if (enemyShipOption == "U"){
			
			theEnemy = new UFOEnemyShip();

			
		} else 
		
		if (enemyShipOption == "R"){
			
			theEnemy = new RocketEnemyShip();
			
		} else {
			
			theEnemy = new BigUFOEnemyShip();
			
		}
		
		doStuffEnemy(theEnemy);
		
		// --------------------------------------------
		*/
		
	}
	
	// Executes methods of the super class
	
	public static void doStuffEnemy(EnemyShip anEnemyShip){
		
		anEnemyShip.displayEnemyShip();
		
		anEnemyShip.followHeroShip();
		
		anEnemyShip.enemyShipShoots();
		
	}
	
}
