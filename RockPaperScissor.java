//Jacob Gaylord
//jigaylord16@ole.augie.edu
//RockPaperScissor.java
//Description: This program simulates the game "rock, paper, scissors". Although 2 or more players can play the
//             game, this program will only consider the case when there are 2 players (one is the computer
//             itself). The program asks the player to call. The player can enter p for paper, r for rock, s for
//             scissors. The winner is determined by the following rule: paper covers rock, rock breaks scissors,
//             and scissors cut paper. If both players play the same thing, it is a tie.
//Input:       The player enters p for paper, r for rock, s for scissors when prompted.
//             The player can keep playing by entering y when prompted.
//Output:      Various messages helping the user play the game.
//             A summary report is displayed before the program ends which states how many games the user
//             won, how many games the user lost, and how many tie games.
//             The duration of the game is also displayed before the program ends.
import java.util.Scanner;
import java.util.Random;
import java.util.Date;
public class RockPaperScissor
{
  public static void main(String[] args)
  {
    Scanner keyboard=new Scanner(System.in);
    Random r=new Random();
    char userCall='p', computerCall='p', again='y', result='u';
    int userWins=0, userLosses=0, userTies=0;
    Date d=new Date();
    System.out.println("Welcome! It is "+d.toString());
    while(again=='y')
    {
      System.out.print("Please call (p,r,s): ");
      userCall=keyboard.nextLine().charAt(0);
      computerCall=generateComputerCall(r);
      result=whoWin(computerCall, userCall);
      switch(result)
      {
        case 'u': System.out.print("\tI have "+computerCall+", you won. ");
                  userWins++;
                  break;
        case 'c': System.out.print("\tI have "+computerCall+", you lost. ");
                  userLosses++;
                  break;
        case 't': System.out.print("\tI have "+computerCall+", we tied. ");
                  userTies++;
                  break;
      }
      System.out.print("Play again? (y/n):");
      again=keyboard.nextLine().charAt(0);
    }
    printReport(userWins, userLosses, userTies);
    printTimeReport(d);
  }
  //Description: Generates a random play for the computer and returns the char value.
  //Return:      The randomly generated char value.
  public static char generateComputerCall(Random r)
  {
    char result='p';
    int computerCall=r.nextInt(3);
    if(computerCall==0) result='p';
    else if(computerCall==1) result='r';
    else result='s';
    return result;
  }
  //Description: Determines the winner (either the computer or user) of the rock, paper, scissors game. A character
  //             is returned representing the output of the game.
  //Return:      A char value of 'u' for a user win, 'c' for a computer win, or 't' for a tie.
  public static char whoWin(char computer, char user)
  {
    char result='t';
    if (computer=='r')
    {
			if (user=='r')
				result='t';
				else if (user=='p')
				result='u';
				else if (user=='s')
				result='c';
		}
		else if (computer=='p')
    {
				if (user=='r')
					result='c';
				  else if (user=='p')
					result='t';
				  else if (user=='s')
					result='u';
    }
    else if (computer=='s')
    {
				if (user=='r')
					result='u';
				  else if (user=='p')
					result='c';
				  else if (user=='s')
					result='t';
		}
    return result;
  }
  //Description: Prints a summary report which states how many games the user won, how many games the user lost,
  //             and how many tie games.
  //Output:      User wins, losses, and ties printed on the screen.
  public static void printReport(int wins, int losses, int ties)
  {
    System.out.println("You won "+wins+" games");
    System.out.println("You lost "+losses+" games");
    System.out.println("You tied "+ties+" games");
  }
  //Description: Prints the duration of the game.
  //Post:        The time elapsed printed on the screen.
  public static void printTimeReport(Date d)
  {
    Date endTime=new Date();
    double seconds=(endTime.getTime()-d.getTime())/1000.0;
    System.out.printf("The game took %.2f seconds\n",seconds);
  }
}
