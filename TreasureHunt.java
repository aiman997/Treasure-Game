import java.util.Scanner;


public class TreasureHunt{

  public static void main(String args[]){
    boolean[][] treasure = new boolean[9][9];
    boolean[][] board = new boolean[9][9];
    boolean gameOver = false;
    int row = 0;
    int column = 0;
    int userLives = 3;
    int userPoints = 0;
    Scanner scan = new Scanner(System.in);

    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        treasure[i][j] = false;
      }
    }
    treasure[0][0] = true;
    treasure[1][1] = true;
    treasure[2][2] = true;

    for (int i = 0; i < 3; i++){
      System.out.println();
      for(int j = 0; j < 3; j++){
        System.out.print(" ? ");
      }
    }

    while(gameOver == false){
      System.out.println();
      System.out.println("which row");
      row = scan.nextInt();
      System.out.println("Which Column");
      column = scan.nextInt();

      board[row][column] = true;
      updateBoard(board, treasure);

      if(treasure[row][column]){
        userPoints += 1;
      }
      if(userPoints == 3){
        System.out.println();
        System.out.println("All treasure found!!!");
        gameOver = true; //end game
      }
      if(treasure[row][column] == false){
        userLives -= 1;
      }
      if(userLives == 0){
        System.out.println();
        System.out.println("Game Over Out Of Lives");
        gameOver = true;
      }
      System.out.println();
      System.out.println("Points: " + userPoints);
      System.out.println("Lives Left: " + userLives);

    }

  }

  public static void updateBoard(boolean[][] updBoard, boolean[][]treasure){

    //clear consle
    System.out.print('\u000C');

    for(int i = 0; i < 3; i++){
      System.out.println();
      for(int j = 0; j < 3; j++){
        if(updBoard[i][j] == true && treasure[i][j] == true){
          System.out.print(" X ");
        }
        else if(updBoard[i][j] == true && treasure[i][j] == false){
          System.out.print(" O ");
        }
        else{
          System.out.print(" ? ");
        }
      }
    }
  }


}
