import java.*;

public class KnightBoard{

  private int[][] board;
  private int rows;
  private int cols;

  public KnightBoard(int row, int col) {
    rows = row;
    cols = col;
    board = new int[rows][cols];
    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < cols; y++) {
        board[x][y] = -1;
      }
    }
  }

  public String toString() {
    String output = "";
    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < cols; y++) {
        //if (board[x][y] < 0) output+=" 0";
        if (board[x][y] / 10 == 0) output+= (" " + board[x][y]);
        else output += board[x][y];
      }
      output+="\n";
    }
    return output;
  }

  public boolean solve(int row, int col) {
    return true;
  }

  public int countSolutions(int row, int col) {
    return 0;
  }

  private boolean solveH(int row, int col, int num) {
    if (num==row*col) return true;
    for (int x = row; x < rows; x++) {
      for (int y = col; y < cols; y++) {
        board.placeKnight(x, y, num);
        if(!canPlaceAnother(x, y).isEmpty()) return solveH()
      }
    }
    return false;
  }

  private boolean placeKnight(int row, int col, int num) {
    board[row][col] = num;
    return true;
  }

  private static int[] canPlaceAnother(int x, int y){
    int[] output = new int[2];
    for(int x1 = 0; x < rows; x++){
      for(int y1 = 0; y < cols; y++) {
        if(board[x1][y1]==-1) {
          if ((Math.abs(x-x1)==1&&Math.abs(y-y1)==2)||
            (Math.abs(x-x1)==2&&Math.abs(x-x1)==1))
            {
              output[0] = x1;
              output[1] = y1;
            }
        }
      }
    }
    return output;
  }

  private boolean removeKnight(int row, int col, int num){return true;}

  private boolean empty(int[] input) {
    for(int x = 0; x < input.length; x++){
      if(input[x]!=0) return true;
    }
    return false;
  }

}
