
import java.util.Scanner;
import java.util.Random; 

public class doublePlayerRun
{
    public static void main(String[] args)
    {
        start();
    }  
    
    public static void play(String f, String s)
    {
        doublePlayerEngine game = new doublePlayerEngine(); // calls the class TicTacToe 
        Scanner scan = new Scanner(System.in);// scanner 
            
        String first = f;  // takes in both variables 
        String second = s;
        int row = 0; 
        int col = 0; 
        game.printBoard();
        
        
        while(!game.checkWin())
        {
               
            System.out.println();
                
                
            System.out.println("Hello " + game.getName(first,second) + ", please enter a row!"); 
            row = scan.nextInt(); 
            System.out.println("Hello " + game.getName(first,second) + ", please enter a column!");
            col = scan.nextInt();
                
            System.out.println();
                
            if(game.pickLocation(row,col))
            {
                game.takeTurn(row,col);
                game.printBoard();
            }
            else
            {
               game.checkForMistakes(first,second);
            }
            
            if(!game.getFinalTie())
            {
                if(game.checkWin())
                {
                    if(game.getName(first,second).equals(second))
                    {
                        System.out.println("Congratulations " + first + " you WON!"); 
                        break;
                    }
                    else
                    {  
                        System.out.println("Congratulations " + second + " you WON!"); 
                        break;
                    }
                }
            }
            else
            {
                System.out.println("The game is a tie!");
                break;
            }
        }       
    }
    
    
   
    
    
        
    public static void start()
    {
        Scanner scan = new Scanner(System.in); // scanner 
        Random random = new Random(); // random 
        
        System.out.println("Welcome to Tic-Tac-Toe");  // welcome 
        System.out.println();
        
        System.out.println("Player 1 enter your name: "); //player 1
        String p1 = scan.nextLine();
        System.out.println("Player 2 enter your name: "); //player 2 
        String p2 = scan.nextLine(); 
        System.out.println();
        
        String first = ""; //first player 
        String second = "";  // second player 
        int rand = random.nextInt(2);   // decides who goes first and who goes second 
        if(rand == 0)
        {
            first = p1; //this sets player 1 as the first player 
            second = p2; // this sets player 1 as the second player 
        }
        else 
        {
            first = p2; // this sets player 2 as the first player 
            second = p1; // this sets player 1 as the second player 
        }
            
        System.out.println("Congratulations " + first + ", you will go first and be the X!");
        System.out.println("Sorry " + second + ", you will go second and be the O!");
            
        play(first, second); 
    }
        
}