import java.util.*;

public class BattleShipAnyDimension {
    //define the size of the board
    public static int numRows = 1;
    public static int numCols = 10;
    //to keep track of the status of the ships
    public static int playerShips;
    public static int computerShips;
    //define the array
    public static String[][] grid = new String[numRows][numCols];
    public static int[][] missedGuesses = new int[numRows][numCols];

    public static void main(String[] args){
        System.out.println("Initalising the game board are no ships yet");

        createOceanMap();

        deployPlayerShips();

        deployComputerShips();

        do {
            Battle();
        }while(BattleShipAnyDimension.playerShips != 0 && BattleShipAnyDimension.computerShips != 0);

        gameOver();
    }

    public static void createOceanMap(){
       
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
                System.out.print(i);
        System.out.println();
        
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " ";
                if (j == 0)
                    System.out.print(i + "|" + grid[i][j]);
                else if (j == grid[i].length - 1)
                    System.out.print(grid[i][j] + "|" + i);
                else
                    System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println();
    }

    public static void deployPlayerShips(){
        Scanner input = new Scanner(System.in);

        System.out.println("Your ship are being automatically deployed for you:");
        //Instancing 3 ships for player
        BattleShipAnyDimension.playerShips = 3;
        for (int i = 1; i <= BattleShipAnyDimension.playerShips; ) {
            int x = 0;
            Random rand = new Random(); //instance of random class
            int upperbound = 9;
             //generate random values from 0-9 for automatic ship placement
            int int_random = rand.nextInt(upperbound); 
            double double_random=rand.nextDouble();
            int y = int_random;
            if(y == 4){
                y = 2;
                System.out.println("Zeroed in 2");
            }else if(y==6){
             y = 1;
             System.out.println("Zeroed in 1");
            }else{
                y=3;
                System.out.println("Zeroed in 3");
            }
          
            if(grid [0][1] == "ø"){
                System.out.println("All perameters in, lets go");   
            }
            
            if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
            {
                grid[x][y] =   "ø";
                i++;
            }
            else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid[x][y] == "ø")
                System.out.println("Forcing adapt location to 1,2,3 to avoid error");
            else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
                System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
        }
        printOceanMap();
    }

    public static void deployComputerShips(){
        System.out.println("Computer opponent is placing ships now");
        //now instance 3 ships for the computer
        BattleShipAnyDimension.computerShips = 3;
        for (int i = 1; i <= BattleShipAnyDimension.computerShips; ) {
            int x = (int)(Math.random() * 10);
            int y = (int)(Math.random() * 10);

            if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
            {
                grid[x][y] =   "x";
                System.out.println(i + ".");
                i++;
            }
        }
        printOceanMap();
    }

    public static void Battle(){
        //basically use the other methods to make the whole thing come together
        playerTurn();
        computerTurn();
        printOceanMap();
        System.out.println();
        System.out.println("Your ships: " + BattleShipAnyDimension.playerShips + " | Computer ships: " + BattleShipAnyDimension.computerShips);
        System.out.println();
    }

    public static void playerTurn(){
        System.out.println("Your go");
        int x = -1, y = -1;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter X coordinate: ");
            x = input.nextInt();
            System.out.print("Enter Y coordinate: ");
            y = input.nextInt();

            if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) //valid guess
            {
                if (grid[x][y] == "x") // makes it so that if a computer chooses the same place twice it can't pick that spot again
                {
                    System.out.println("Boom! You sunk the ship!");
                    grid[x][y] = "!";
                    --BattleShipAnyDimension.computerShips;
                }
                else if (grid[x][y] == "ø") {
                    System.out.println("Oh no, you sunk your own ship :(");
                    grid[x][y] = "x";
                    --BattleShipAnyDimension.playerShips;
                    ++BattleShipAnyDimension.computerShips;
                }
                else if (grid[x][y] == " ") {
                    System.out.println("Miss");
                    grid[x][y] = "-";
                }
            }
            else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols))  //invalid guess
                System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
        }while((x < 0 || x >= numRows) || (y < 0 || y >= numCols));  //keep re-prompting till valid guess
    }

    public static void computerTurn(){
        System.out.println("Computer's turn");
        int x = -1, y = -1;
        do {
            x = (int)(Math.random() * 10);
            y = (int)(Math.random() * 10);

            if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) //make sure guess isn't out of the boundaries of the array
            {
                if (grid[x][y] == "ø") //if player ship is already there then the player has to have their ship removed from play
                {
                    System.out.println("The Computer sunk one of your ships!");
                    grid[x][y] = "x";
                    --BattleShipAnyDimension.playerShips;
                    ++BattleShipAnyDimension.computerShips;
                }
                else if (grid[x][y] == "x") {
                    System.out.println("The Computer sunk one of its own ships");
                    grid[x][y] = "!";
                }
                else if (grid[x][y] == " ") {
                    System.out.println("Computer missed");
                    //Saving missed guesses for computer
                    if(missedGuesses[x][y] != 1)
                        missedGuesses[x][y] = 1;
                }
            }
        }while((x < 0 || x >= numRows) || (y < 0 || y >= numCols));  //keep re-prompting till valid guess
    }

    public static void gameOver(){
        System.out.println("Your ships: " + BattleShipAnyDimension.playerShips + " | Computer ships: " + BattleShipAnyDimension.computerShips);
        if(BattleShipAnyDimension.playerShips > 0 && BattleShipAnyDimension.computerShips <= 0)
            System.out.println("You've sunk all the opponent's ships captian");
        else
            System.out.println("You have lost the battle");
        System.out.println();
   }

    public static void printOceanMap(){
        System.out.println();
        //First section of Ocean Map
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println();

        //Middle section of Ocean Map
        for(int x = 0; x < grid.length; x++) {
            System.out.print(x + "|");

            for (int y = 0; y < grid[x].length; y++){
                System.out.print(grid[x][y]);
            }

            System.out.println("|" + x);
        }

        //Last section of Ocean Map
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print("—");
        System.out.println();
    }
}
