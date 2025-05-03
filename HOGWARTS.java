import java.util.Scanner;    /// to read user keyboard input
import java.util.ArrayList;  /// to create arraylists
import java.util.Random;     /// to use random functions in the program

public class HOGWARTS {
    static ArrayList<String> GRYFFINDOR = new ArrayList<>();  /// ArrayList for Gryffindore
    static ArrayList<String> SLYTHERIN = new ArrayList<>();   /// ArrayList for Slytherin
    static Scanner scanner = new Scanner(System.in);    /// Java class to take user input         

public static void TeamMember(){                 ///Method to List for the team members
    GRYFFINDOR.add("HARRY POTTER"); 
    GRYFFINDOR.add("ALBUS DUMBLEDORE");
    SLYTHERIN.add("DRACO MALFOY"); 
    SLYTHERIN.add("SEVERUS SNAPE");
}

public static void ChoosingTeam(){
    System.out.println("TO PLAY THE GAME PLEASE CHOOSE A TEAM FROM BELOW:\n" + "1. TEAM GRYFFINDOR\n" + "2. TEAM SLYTHERIN" );
    int teamChoice = scanner.nextInt();               ///to take User input to choose team 
    if(teamChoice == 1){
        System.out.println("You Chose Team GRYFFINDOR!\n" + "Enemy Player Choosed Team SLYTHERIN!\n" + "Now Please Select a Player to Continue:");
        for(int i=0; i<GRYFFINDOR.size(); i++){
            System.out.println((i + 1) + " . " + GRYFFINDOR.get(i));
        }
        int playerChoice = scanner.nextInt();   ///to take user input to choose player
          if(playerChoice >= 1 && playerChoice <= GRYFFINDOR.size()){
            System.out.println("You have selected Player: " + GRYFFINDOR.get(playerChoice-1));    ///Alternative method can be applied here
        Random random1 = new Random();
        int enemySlytherin = random1.nextInt(SLYTHERIN.size());
        String enemyPlayer1 = SLYTHERIN.get(enemySlytherin);
        System.out.println("Enemy Selected: " + enemyPlayer1);
        }else{
            System.out.println("Invalid Player Selection. Can't Proceed!");
          }
    }else if(teamChoice == 2){
        System.out.println("You Chose Team SLYTHERIN!\n" + "Enemy Team Choosed Team GRYFFINDORE! " + "Now Please Select a Player:");
        for(int i=0; i<SLYTHERIN.size(); i++){
            System.out.println((i + 1) + " . " + SLYTHERIN.get(i));
        }
        int playerChoice = scanner.nextInt();
          if(playerChoice >= 1 && playerChoice <= SLYTHERIN.size()){
            System.out.println("You have selected Player: " + SLYTHERIN.get(playerChoice-1));
            Random random2 = new Random();
            int enemyGryffindor = random2.nextInt(GRYFFINDOR.size());
            String enemyPlayer2 = GRYFFINDOR.get(enemyGryffindor); 
            System.out.println("Enemy Selected: " + enemyPlayer2); 
             System.out.println("\n~~~~~ THE GRAND HOGWARTS CHAMPIONSHIP BEGINS! ~~~~~");
try {
    Thread.sleep(3000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt(); //I wanted to add a time delay of 3 seconds between the sentences for it to feel more realist.-Ady
}

System.out.println("This is a 3-round tournament. The one who wins at least 2 rounds will be crowned the champion!\n");
try {
    Thread.sleep(3000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
          }else{
            System.out.println("Invalid Player Selection. Can't Proceed!");
          }
    }else{
        System.out.println("Invalid Choice! PREASE PRESS ~~~ 1 OR 2 ~~~");
    } 
       
}

public static void UserName(){                    ///Method for user name
    System.out.println("Enter your name: ");
    String name = scanner.nextLine();
    System.out.println("Hello " + name + "!");
} 


public static void main(String[] args){
///Printing the name of the game
 System.out.println("~~~~~~ WELCOME TO BEYOND HOGWARTS ~~~~~~~~\n");
 /// all the methods listing 
 UserName();
 TeamMember();
 ChoosingTeam();
 scanner.close();
}
}


    



















