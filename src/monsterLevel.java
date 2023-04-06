import java.io.BufferedReader;
 import java.io.FileNotFoundException;
 import java.io.FileReader;
 import java.io.IOException;
 import java.util.Random;
 import java.util.Scanner;

 /**
  * A subclass of Room that represents a room with a chance of spawning an enemy.
  */
 public class monsterLevel extends Room {
 	/**
 	 * Creates a new instance of MonsterLevel.
 	 */
 	public monsterLevel() {
         	super();
    }
	
         /**
          * The chance of an enemy spawning in this room.
          */
    enemySpawnChance = 1;
	
 	/**
 	 * Runs the engine for this room, prompting the user for input and displaying text based on the input.
 	 */
     		

	@Override
	public void roomEngine(Map map) throws IOException {
		Scanner scnr = new Scanner(System.in);
		audioEngine.playSong("Pompeii - Medieval Cover Bardcore.mp3");
 		try {
 			BufferedReader trap = new BufferedReader(new FileReader("monsterLevelText.txt"));
             	String line = trap.readLine(); 
 			while(line != null && scnr.hasNext()) {
 				System.out.print(line);
				line = trap.readLine();
            		scnr.next();
 			}
            		//reads out room enter text, with each new line being generated when the player hits enter
             	trap.close();
             if (this.Room.getMonsters() == "Snake"){
		 audioEngine.playSong("Toxic - Britney Spears (Bardcore Medieval Style).mp3");
                 System.out.print("You see a horrible, slithery snake!");
             }
             // If there's a snake in the room, it generates text. (insert toxic by britney spears) 
             else if (this.Room.getMonsters() == "Zombie"){
                 audioEngine.playSong("The Cranberries - Zombie [Medieval Bardcore Instrumental Cover].mp3");
		 System.out.print("You see a shambling corpse!");
             }
             // If there's a zombie (insert Cranberries song here)
             else if (this.Room.getMonsters() == "Frog"){
		 audioEngine.playSong("Tame Impala - The Less I know the better (Medieval style).mp3");
                 System.out.print("You see a... brightly colored frog?");
             }
             //poison dart frog - soon to have its own ending (greatful dead?).
            
             System.out.print("Maybe don't get too close... you don't have very many options.");
             // hints that the player should keep away from the monster
	
		for (int i = 0; i < getEnemyPosition.length; i++){
             	if (getPlayerPosition() == getEnemyPosition(i)) {
                 		if (this.Room.getMonsters() == "Snake"){
                    	 	System.out.print("The snake lunges! You've been bitten!");
                    	 	// if you interact with the snake
                 		}
                 		else if (this.Room.getMonsters() == "Zombie"){
                    	 	System.out.print("The zombie leaps at you with a snarl!");
                     	// if you interact with the Zombie
                 		}
                	 else if (this.Room.getMonsters() == "Frog"){
                    	 	System.out.print("You pick up the frog. It wiggles indignantly.");
                     	// if you interact with the frog
                 	} 
 				try {
                     	BufferedReader pitBuffer = new BufferedReader(new FileReader("poisonEnemy.txt"));
				String line2 =  pitBuffer.readLine();
 			        while(line2 != null && scnr.hasNext()) {
 				        System.out.print(line2);
					line2 =  pitBuffer.readLine();
            			scnr.next();
 			        }
				//reads out the poisoned ending, with each new line being generated when the player hits enter
                     pitBuffer.close();
                     IOException end;
                     throw end;
			//creates and throws an end condition to be caught by the game engine
 				}
                 
             	catch (FileNotFoundException e) {
             	e.printStackTrace();
             	}
             	catch (IOException e) {
     			e.printStackTrace();
				System.out.print("Sorry! You can't do that here.");
             	}
			//catches any errors generated by the second filereader
             	}
		}
 		}
 		catch (FileNotFoundException e) {
 			e.printStackTrace();
 		} 
 		catch (IOException e) {
 			e.printStackTrace();
			System.out.print("Sorry! You can't do that here.");
 		}
		//catches any errors generated by the first filereader
 	}
}
