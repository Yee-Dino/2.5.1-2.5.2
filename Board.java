/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 * 
 * Coded by: Jonathan Adrian and Aditya Das
 *
 * This class sets the board. It creates the solution phrase, and runs through any changes that happen. It is also what prints things out to the console for the player to play. It's basically the UI of the program.
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue; 

  /* your code here - constructor(s) */ 
  public Board(){
    solvedPhrase = "";
    phrase = loadPhrase();
    setLetterValue();
  }
  /* your code here - accessor(s) */
  public String getSolvedPhrase(){
    return phrase;
  }
  public String getPartialPhrase(){
    return solvedPhrase;
  }
  public int getLetterValue(){
    return currentLetterValue;
  }
  /* your code here - mutator(s)  */


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  

  public boolean guessLetter(String guess) //declares the variable
  {
    boolean foundLetter = false; // automatically sets the start to say tha the solution has not been found yet. This makes the game replayable.
    String newSolvedPhrase = ""; //declares a new variable that will be used to replace the underscores with the letters that the user guesses.
    
    for (int i = 0; i < phrase.length(); i++) //for loop that goes through the solution phrase.
    {
      if (phrase.substring(i, i + 1).equals(guess)) //if statement that checks if the guess is equal to the letter in the solution phrase.
      {
        newSolvedPhrase += guess + " "; //if the guess is equal to the letter in the solution phrase, the guess is added to the newSolved
        foundLetter = true; //sets the foundLetter variable to true.
      }
      else //if it wasn't equal to the letter in the solution phrase
      {
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  //the underscore is added to the newSolvedPhrase.
      }
    }
    solvedPhrase = newSolvedPhrase; //sets the solvedPhrase to the variable with the letters guessed in the word.
    return foundLetter; //returns if the user got the entire word.
  } 
} 