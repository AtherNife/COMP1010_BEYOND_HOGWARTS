import java.util.Scanner;
import java.util.ArrayList;
public class HOGWARTS {
    static ArrayList<String> GRYFFINDOR = new ArrayList<>();
    static ArrayList<String> SLYTHERIN = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

public static void TeamMember(){
    GRYFFINDOR.add(" HARRY POTTER"); 
    GRYFFINDOR.add("ALBUS DUMBLEDORE");
    SLYTHERIN.add("DRACO MALFOY"); 
    SLYTHERIN.add("SEVERUS SNAPE");
}

public static void ChoosingTeam(){
    System.out.println("TO PLAY THE GAME PLEASE CHOOSE A TEAM FROM BELOW\n" + "1. TEAM GRYFFINDOR\n" + "2. TEAM SLYTHERIN" );
    int teamChoice = scanner.nextInt();
    if(teamChoice == 1){
        System.out.println("You Chose Team GRYFFINDOR!\n Now Please Select a Player:");
        for(int i=0; i<GRYFFINDOR.size(); i++){
            System.out.println((i + 1) + " . " + GRYFFINDOR.get(i));
        }
        int playerChoice = scanner.nextInt();
          if(playerChoice >= 1 && playerChoice <= GRYFFINDOR.size()){
            System.out.println("You have selected Player: " + GRYFFINDOR.get(playerChoice-1));
          }else{
            System.out.println("Invalid Player Selection. Can't Proceed!");
          }
    }else if(teamChoice == 2){
        System.out.println("You Chose Team SLYTHERIN!\n Now Please Select a Player:1");
        for(int i=0; i<SLYTHERIN.size(); i++){
            System.out.println((i + 1) + " . " + SLYTHERIN.get(i));
        }
        int playerChoice = scanner.nextInt();
          if(playerChoice >= 1 && playerChoice <= SLYTHERIN.size()){
            System.out.println("You have selected Player: " + SLYTHERIN.get(playerChoice-1));
          }else{
            System.out.println("Invalid Player Selection. Can't Proceed!");
          }
    }else{
        System.out.println("Invalid Choice! PREASE PRESS ~~~ 1 OR 2 ~~~");
    } 
       
}


public static void main(String[] args){
///Printing the name of the game
 System.out.println("~~~~~~ WELCOME TO BEYOND HOGWARTS ~~~~~~~~\n");
 TeamMember();
 ChoosingTeam();
 scanner.close();
}
}


    



















