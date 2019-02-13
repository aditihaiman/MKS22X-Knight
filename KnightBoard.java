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
        if (board[x][y] / 10 == 0) output+= (" " + board[x][y]);
        else output += board[x][y];
      }
      output+="\n";
    }
    return output;
  }

  public boolean solve(int row, int col) {}

  public int countSolutions(int row, int col) {}

  private boolean solveH(int row, int col, int level) {}

}
