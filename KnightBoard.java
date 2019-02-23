import java.*;

public class KnightBoard{

  public int[][] board; //private
  private int rows;
  private int cols;

  public KnightBoard(int row, int col) {
    rows = row;
    cols = col;
    board = new int[rows][cols];
    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < cols; y++) {
        board[x][y] = 0;
      }
    }

  }

  public String toString() {
    String output = "";
    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < cols; y++) {
        //if (board[x][y] <= 0) output+="  0";
        if (board[x][y]<10) output+= ("  " + board[x][y]);
        else output += " " + board[x][y];
      }
      output+="\n";
    }
    return output;
  }

  public boolean solve(int row, int col) {
    if (!empty()) throw new IllegalStateException();
    if (row < 0 || col < 0 || row >= rows || col >= cols) throw new IllegalArgumentException();
    board[row][col] = 1;
    return solveH(row, col, 2);
  }

  public int countSolutions(int row, int col) {
    if (!empty()) throw new IllegalStateException();
    if (row < 0 || col < 0 || row >= rows || col >= cols) throw new IllegalArgumentException();
    board[row][col] = 1;
    return countH(row, col, 2);
  }
  
//--------------- Optimization ------------------//

  public boolean solveH2(int row, int col, int num) {
    return true;
  }


//--------------- Helper Methods ----------------//

  public boolean solveH(int row, int col, int num) { //private
    int[] xMoves = {1, 1, -1, -1, 2, 2, -2, -2};
    int[] yMoves = {2, -2, 2, -2, 1, -1, 1, -1};
    if (num==rows*cols+1) return true;
    for(int a = 0; a < 8; a++) {
      if (check(row+xMoves[a], col+yMoves[a])) {
        board[row+xMoves[a]][col+yMoves[a]] = num;
        if (solveH(row+xMoves[a], col+yMoves[a], num+1)) return true;
        board[row+xMoves[a]][col+yMoves[a]] = 0;
      }
    }
    return false;
  }

  public int countH(int row, int col, int num) { //private
    int[] xMoves = {1, 1, -1, -1, 2, 2, -2, -2};
    int[] yMoves = {2, -2, 2, -2, 1, -1, 1, -1};
    if (num==rows*cols+1) {
      //System.out.println("A");
      return 1;
    }
    int sum = 0;
    for(int a = 0; a < 8; a++) {
      if (check(row+xMoves[a], col+yMoves[a])) {
        board[row+xMoves[a]][col+yMoves[a]] = num;
        sum += countH(row+xMoves[a], col+yMoves[a], num+1);
        board[row+xMoves[a]][col+yMoves[a]] = 0;
        //System.out.println("B");
      }
    }
    //System.out.println("C");
    return sum;
  }


  public boolean check(int x, int y) {
    return (x>=0 && y >=0 && x < rows && y < cols && board[x][y]==0);
  }


  public boolean empty() { //private
    for(int x = 0; x < rows; x++){
      for (int y = 0; y < cols; y++) {
        if(board[x][y]!=0) return false;
      }
    }
    return true;
  }

}
