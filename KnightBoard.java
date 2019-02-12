import java.*;

public class KnightBoard{

  private int[][] board;

  public KnightBoard(int rows, int cols) {
    board = new int[rows][cols];
    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < cols; y++) {
        board[x][y] = -1;
      }
    }
  }

  public String toString() {}

  public boolean solve(int row, int col) {}

  public int countSolutions(int row, int col) {}

  private boolean solveH(int row, int col, int level) {}

}
