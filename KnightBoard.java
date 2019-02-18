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
        if (board[x][y] <= 0) output+="  0";
        else if (board[x][y]<10) output+= ("  " + board[x][y]);
        else output += " " + board[x][y];
      }
      output+="\n";
    }
    return output;
  }

  public boolean solve(int row, int col) {
    board[row][col] = 1;
    //System.out.println(Driver.printArray(temp));
    //return solveH(temp[0], temp[1], 2, brd);
    return solveH(row, col, 1);
  }

  public int countSolutions(int row, int col) {
    return 0;
  }

  public boolean solveH(int row, int col, int num) { //private
    int[] xMoves = {1, 1, -1, -1, 2, 2, -2, -2};
    int[] yMoves = {2, -2, 2, -2, 1, -1, 1, -1};
    if (num==rows*cols+1) return true;
    for(int a = 0; a < 8; a++) {
      if (check(row+xMoves[a], col+yMoves[a])) {
        board[row+xMoves[a]][col+yMoves[a]] = num;
        if (solveH(row+xMoves[a], col+yMoves[a], num+1)) return true;
        else board[row+xMoves[a]][col+yMoves[a]] = 0;
      }
    }
    // for (int x = row; x < rows; x++) {
    //   for (int y = col; y < cols; y++) {
    //     board[x][y] = num;
    //     int[] temp = canPlaceAnother(x, y);
    //     // System.out.println(Driver.printArray(temp));
    //     // System.out.println(brd);
    //     if(temp[0]==1) return solveH(temp[1], temp[2], num+1);
    //     board[x][y] = -2;
    //   }
    // }
    return false;
  }

  public boolean check(int x, int y) {
    return (x>=0 && y >=0 && x < rows && y < cols && board[x][y]==0);
  }


  public int[] canPlaceAnother(int x, int y){ //private
    int[] output = new int[3];
    for(int x1 = 0; x1 < rows; x1++){
      for(int y1 = 0; y1 < cols; y1++) {
        //System.out.println(board[x1][y1]);
        if(board[x1][y1]==0) {
          //System.out.println("A");
          if ((Math.abs(x-x1)==1&&Math.abs(y-y1)==2)||
            (Math.abs(x-x1)==2&&Math.abs(y-y1)==1))
            {
              //System.out.println("B");
              output[0] = 1; //true
              output[1] = x1;
              output[2] = y1;
              return output;
            }
        }
      }
    }
    return output;
  }

  public boolean removeKnight(int row, int col, int num){return true;} //private

  // public boolean empty(int[] input) { //private
  //   for(int x = 0; x < input.length; x++){
  //     if(input[x]!=0) return true;
  //   }
  //   return false;
  // }

}
