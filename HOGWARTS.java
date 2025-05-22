import java.util.Scanner;    /// to read user keyboard input
import java.util.ArrayList;  /// to create arraylists
import java.util.Random; /// to use random functions in the program

///Here, I'm making the Attack class for the characters. -Ady
class Attack {
    String name;
    int damage;
    boolean skipOpponentTurn;
    boolean reduceNextDamage;
    double damageReductionFactor;
///I'm, defining this simple class to represent a spell or an attack. -Ady, "Double will work for the damage reduction factor"-Ady
    public Attack( String name, int damage, boolean skipOpponentTurn, boolean reduceNextDamage, double damageReductionFactor){
        this.name= name;
        this.damage=damage;
        this.skipOpponentTurn=skipOpponentTurn;
        this.reduceNextDamage=reduceNextDamage;
        this.damageReductionFactor=damageReductionFactor;
    }

// This class is the stats of all the players, we will use this as a measurement for player factors. 
    public class CharacterStats {
    private int strength;
    private int intelligence;
    private int defense;
    private int initiative;
    

    public CharacterStats(int strength, int intelligence, int defense, int initiative) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.defense = defense;
        this.initiative = initiative;
    }

    // These are the getters factors for the character stats class
    public int getStrength() { return strength; }
    public int getIntelligence() { return intelligence; }
    public int getDefense() { return defense; }
    public int getInitiative() { return initiative; }

    // This is the setters factors for the character stats class. 
    public void setStrength(int strength) { this.strength = strength; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }
    public void setDefense(int defense) { this.defense = defense; }
    public void setInitiative(int initiative) { this.initiative = initiative; }

    @Override // this is so that the compilers will be forced to allocate an error message if even one of the conditions do not hold for the code. 
    public String toString() {
        return "Strength: " + strength + ", Intelligence: " + intelligence +
               ", Defense: " + defense + ", Initiative: " + initiative;
    }
}

}/// creating a player class here, might do this differently later in a more appropriate way in regards to assignment specs. -Ady
 class Player{
    String name;
    int hp;
    ArrayList<Attack> attacks; ///used classical arrayList here, instead of the preffered Util.list, as it's more in line with what we are learning.-Ady

    public Player(String name, int hp, ArrayList<Attack> attacks) {
        this.name= name;
        this.hp = hp;
        this.attacks = attacks;
    }
    public void displayAttacks() {///setting the condition for the attacks to work. going to need to call this with the player functions later on.- Ady (REMINDER TO CALL FUNCTION!)
        for(int i=0;i<attacks.size(); i++) {
            System.out.println((i+1) + ". " + attacks.get(i).name + "(damage: " + attacks.get(i).damage + ")");
        }
    }
 }



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

        System.out.println("\n------- RAISE YOUR WANDS FOR NOW, THE GRAND HOGWARTS CHAMPIONSHIP BEGINS! Goodluck Gryffindor! -------");
try {
    Thread.sleep(3000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt(); //I wanted to add a time delay of 3 seconds between the sentences for it to feel more realist.-Ady
}
//this is where the timing delay takes place, feels more like an actual rpg now because the lines take time to process instead of being blurted out at once. 
System.out.println("This is a 3-round tournament. The one who wins at least 2 rounds will be crowned the champion!\n");
try {
    Thread.sleep(3000);

} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
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
             System.out.println("\n------- RAISE YOUR WANDS FOR NOW, THE GRAND HOGWARTS CHAMPIONSHIP BEGINS! Goodluck Slytherin! -------");
try {
    Thread.sleep(3000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt(); //I wanted to add a time delay of 3 seconds between the sentences for it to feel more realist.-Ady
}
//this is where the timing delay takes place, feels more like an actual rpg now because the lines take time to process instead of being blurted out at once. 
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


    



















