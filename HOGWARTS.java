import java.util.Scanner;
import java.util.ArrayList;
public class HOGWARTS {
public static void ChoosingTeam(int key){
    if(key == 1){
        System.out.println("You Chose Team GRYFFINDOR!\n Now Please Select a Player:");
    }else if(key == 2){
        System.out.println("You Chose Team SLYTHERIN!\n Now Please Select a Player:1");
    }else{
        System.out.println("Invalid Choice! PREASE PRESS ~~~ 1 OR 2 ~~~");
    } 
       
}




public static void main(String[] args){
///Printing the name of the game
 System.out.println("~~~~~~ WELCOME TO BEYOND HOGWARTS ~~~~~~~~\n");
 /// object for choosing the team
 Scanner scanner = new Scanner(System.in);
 System.out.println("TO PLAY THE GAME PLEASE CHOOSE A TEAM FROM BELOW\n" + "1. TEAM GRYFFINDOR\n" + "2. TEAM SLYTHERIN" );
 int input = scanner.nextInt();
 ChoosingTeam(input);
///ArrayList for team members and objects
ArrayList<String> GRYFFINDOR = new ArrayList<>();
 GRYFFINDOR.add("1. HARRY POTTER"); 
 GRYFFINDOR.add("2. ALBUS DUMBLEDORE");
 ArrayList<String> SLYTHERIN = new ArrayList<>();
 SLYTHERIN.add("1. DRACO MALFOY"); 
 SLYTHERIN.add("2. SEVERUS SNAPE");

 scanner.close();
}
}


    



















