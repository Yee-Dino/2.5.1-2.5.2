/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private String name;
  private int score;
  /* your code here - constructor(s) */ 
  public Player(){
    System.out.println("Enter name: ");
    Scanner sc = new Scanner(System.in);
    name = sc.nextLine();
    score = 0;
    System.out.println(name + " has been added to the game.\n");
  }
  /* your code here - accessor(s) */ 
  public String getPlayer(){
    return name;
  }
  public int getScore(){
    return score;
  }
  /* your code here - mutator(s) */ 
}