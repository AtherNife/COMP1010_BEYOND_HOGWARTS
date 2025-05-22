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
}


// This class is the stats of all the players, we will use this as a measurement for player factors. 
 class CharacterStats {
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

    public void modifyStat(String string, int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifyStat'");
    }
}

 
//status effect class here. 
  class StatusEffect {
    private String name;
    private int duration; // in turns
    private int potency; // e.g., damage per turn or stat modifier
    private EffectType type;

    public enum EffectType {
        DAMAGE_OVER_TIME,
        STAT_MODIFIER,
        SKIP_TURN
    }

    public StatusEffect(String name, int duration, int potency, EffectType type) {
        this.name = name;
        this.duration = duration;
        this.potency = potency;
        this.type = type;
    }

    public void applyEffect(Player player) {
        switch (type) {
            case DAMAGE_OVER_TIME:
                player.reduceHp(potency);
                break;
            case STAT_MODIFIER:
                player.getStats().modifyStat("defense", -potency);
                break;
            case SKIP_TURN:
                player.setSkipNextTurn(true);
                break;
        }
    }

    public void onTurnStart(Player player) {
        if (duration > 0) {
            applyEffect(player);
            duration--;
        }
    }

    // Getters
    public String getName() { return name; }
    public int getDuration() { return duration; }
    public int getPotency() { return potency; }
    public EffectType getType() { return type; }
}
// creating a player class here, might do this differently later in a more appropriate way in regards to assignment specs. -Ady
   class Player {
    private String name;
    private int health;
    private int attackPower;

    public Player(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int attack() {
        return attackPower;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }
}
    
//wands, we're going to have 3 wands to choose from 
 class Wand {
    private String name;
    private String wood;
    private String core;
    private double length; 
    private String effectDescription;

    public Wand(String name, String wood, String core, double length, String effectDescription) {
        this.name = name;
        this.wood = wood;
        this.core = core;
        this.length = length;
        this.effectDescription = effectDescription;
    }

    // Getters
    public String getName() { return name; }
    public String getWood() { return wood; }
    public String getCore() { return core; }
    public double getLength() { return length; }
    public String getEffectDescription() { return effectDescription; }

    @Override  // again overide to ensure that the output will hold one of the values. 
    public String toString() {
        return name + " (Wood: " + wood + ", Core: " + core + ", Length: " + length + " inches) – " + effectDescription;
    }
}
// game save class. 
 class GameSaveData {
    public String playerName;
    public int playerHP;

    public GameSaveData(String playerName, int playerHP) {
        this.playerName = playerName;// called later.
        this.playerHP = playerHP; //this can be called later.
    }
}

//the skillNode class, this is also where recursive data structures take place. 
class SkillNode {
    String skillName;
    SkillNode[] prerequisites;

    public SkillNode(String skillName, SkillNode[] prerequisites) {
        this.skillName = skillName;
        this.prerequisites = prerequisites;
    }
//recursive data type. 
    public void displaySkillTree(int level) {  
        System.out.println("  ".repeat(level) + skillName);
        for (SkillNode prerequisite : prerequisites) {
            prerequisite.displaySkillTree(level + 1);
        }
    }
}
 

// battle manager class, which needed some changes in player class to function properly. 
class BattleManager {
    private Player player1;
    private Player player2;

    public BattleManager(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
    }

    public void startBattle() {
        System.out.println("Battle Start: " + player1.getName() + " vs " + player2.getName());
        Player attacker = player1;
        Player defender = player2;

        while (player1.isAlive() && player2.isAlive()) {
            int damage = attacker.attack();
            defender.takeDamage(damage);
            System.out.println(attacker.getName() + " attacks " + defender.getName() + " for " + damage + " damage.");
            System.out.println(defender.getName() + " has " + defender.getHealth() + " HP remaining.\n");

            // Swap roles
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        if (player1.isAlive()) {
            System.out.println(player1.getName() + " wins the battle!");
        } else {
            System.out.println(player2.getName() + " wins the battle!");
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


    



















