import java.util.*;
public class GameOfNim
{
    public static void main (String [] args)
    {
        play();
    }

    public static void play()
    {
        Scanner in = new Scanner (System.in);
        Random num = new Random ();
        int numberLeft = num.nextInt(101-10) + 10;
        int computerMode = num.nextInt(2);
        int subtraction = numberLeft;
        int turn = num.nextInt(2);
        System.out.println(turn);
        System.out.println ("The number you start out with is: " + numberLeft);

        if (computerMode == 0)
        {
            System.out.println ("The computer is in smart mode");
        }
        else if (computerMode == 1)
        {
            System.out.println ("The computer is in dumb mode");
        }

        while (numberLeft > 1)
        {
            if (turn == 1)
            {
                System.out.println ("It is your turn...");
                System.out.printf ("Please enter the number you wish to take from the pile "+(numberLeft/2) + " or less): ");
                subtraction = in.nextInt();
                numberLeft -=subtraction;
                System.out.println ("The number left is " + numberLeft);
                turn = 0;
            }
            if (numberLeft <= 1)
            {
                if (turn == 2)
                {
                    System.out.println ("You Win!");
                    return;
                }  
                else
                {
                    System.out.println ("You lose.");
                    return;
                }  
            }
            if (turn == 0)
            {
                System.out.println ("It is the computer's turn...");
                if (computerMode == 0)
                {  
                    numberLeft = smartComputer(numberLeft);
                    System.out.println ("The number left is " + numberLeft);
                }

                if (computerMode == 1)
                {
                    numberLeft-= num.nextInt(numberLeft/2);
                    System.out.println ("The number left is " + numberLeft);
                }
                turn = 1;

            }

            if (numberLeft <= 1)
            {
                if (turn == 2)
                {
                    System.out.println ("You Win!");
                    return;
                }  
                else
                {
                    System.out.println ("You lose.");
                    return;
                }  
            }
        }

        
    }

    public static int smartComputer (int num)
    {
        int power = 2;        
        while (power < num) 
        { 
            power *=2;
        }
        power /= 2;
        num = power-1;
        return num;
    }
}