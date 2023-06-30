
//package org.arpit.java2blog;
import java.util.Scanner;
public class NumberGuess
{
    public static void main(String args[]) 
    {
        int attempt = 1;
        int userGuessNumber = 0;
        int secretNumber = (int) (Math.random() * 99 + 1);           
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome Number Guessing Game \nYou Will Be Asked To Guess A Number To Win The Game \nYou have Maximum 5 Attemp Limit");
        do {
            System.out.print("Enter a guess number between 1 to 100 : ");
            if(userInput.hasNextInt()) {
                userGuessNumber = userInput.nextInt();
                if (userGuessNumber == secretNumber)
                {    
                    System.out.println("OOhhOO!, Your Number is Correct. You Win the Game!");
                    break;
                }
                else if (userGuessNumber < secretNumber)
                    System.out.println("Your Guess Number is lower.");
                else if (userGuessNumber > secretNumber)
                    System.out.println("Your Guess Number is higher.");
                if(attempt == 5) {
                    System.out.println("You have exceeded the maximum attempt. Try Again");
                    break;
                }
                attempt++;
            }else {
                System.out.println("Enter a Valid Integer Number");
                break;
            }
        } while (userGuessNumber != secretNumber);
    }
}