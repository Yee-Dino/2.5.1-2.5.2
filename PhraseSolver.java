/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board game;
  private Boolean solved;
  /* your code here - constructor(s) */ 
  public PhraseSolver(){
    player1 = new Player();
    player2 = new Player();
    game = new Board();
    solved = false;

  }
  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    boolean tempCorrect;
    while (!solved) 
    {
      
      /* your code here - game logic */

      game.setLetterValue();
      
      System.out.println(game.getPartialPhrase()); //prints out the partial phrase at the start for the player to see.
      System.out.println("\n This guess is worth " + game.getLetterValue() + " points");
      
      //if player 1 is going
      if(currentPlayer == 1){ 
        System.out.println(player1.getPlayer() + "'s turn");
        System.out.println("Enter a letter: "); 
      }

      //if player 2 is going
      if(currentPlayer == 2){
        System.out.println(player2.getPlayer() + "'s turn");
        System.out.println("Enter a letter: "); 
      }


      //gets user guess
      String guess = input.nextLine(); // player inputs their guess

      if(game.getPartialPhrase().contains(guess)){ // checks to see if the guess was a repeat
        tempCorrect = false;

      }
      else{
        tempCorrect = true;
      }
      
      correct = game.guessLetter(guess); //checks if the word had the guess in it
      if(tempCorrect == false){ // makes it an invalid guess when the guess is a repeat
        correct = tempCorrect;
      }
      //checks if we should switch players
      if(!correct && !game.isSolved(guess)){
        if(currentPlayer == 1){
          currentPlayer = 2;
          
        }
        else{
          currentPlayer = 1;
        }
      }
      //checks to see if there's a repeat letter 

      //checks for points gained and adds points to players accordingly
      else{

        if(currentPlayer == 1){
          
          player1.addScore(game.getLetterValue());
          System.out.println(player1.getPlayer() + " scored " + game.getLetterValue() + " points!");
        }
        else{
          player2.addScore(game.getLetterValue());
          System.out.println(player2.getPlayer() + " scored  " + game.getLetterValue() + " points!");
        }
      }
      
      /* your code here - determine how game ends */
      

      //checks if user typed out full phrase, which is how they win.
      if(game.isSolved(guess)){
        if(currentPlayer == 1){ // adds some score to whichever player solved it.
          player1.addScore(1000);
          System.out.println(player1.getPlayer() + " solved the phrase!"); 
        }
        else{
          System.out.println(player2.getPlayer() + " solved the phrase!");
          player2.addScore(1000);
        }
        
        //adds up totals
        System.out.println("Total Scores: \n\n" + player1.getPlayer() + " scored " + player1.getScore() + " points.\n" + player2.getPlayer() + " scored " + player2.getScore() + " points.");

        //ends game loop
        solved = true;
      }
      //if it's not solved, then the game continues.
      else{
        System.out.println("\n");

        System.out.println("still going\n\n");
        
      }
    }
  
  }
}