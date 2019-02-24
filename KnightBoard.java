import java.util.*;
import java.io.*;

public class KnightBoard{

  public int[][] board; //private
  private int rows;
  private int cols;
  //public int[][] moves;

  public KnightBoard(int row, int col) {
    rows = row;
    cols = col;
    board = new int[rows][cols];
    //moves = new int[row][cols];
    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < cols; y++) {
        board[x][y] = 0;
        //numMoves(moves, x, y, 1);
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


  public boolean solveOpt(int row, int col) {
    if (!empty()) throw new IllegalStateException();
    if (row < 0 || col < 0 || row >= rows || col >= cols) throw new IllegalArgumentException();
    board[row][col] = 1;
    return solveH2(row, col, 2);
  }

//--------------- Optimization ------------------//

  public boolean solveH2(int row, int col, int level) {
    int[] xMoves = {1, 1, -1, -1, 2, 2, -2, -2};
    int[] yMoves = {2, -2, 2, -2, 1, -1, 1, -1};
    if (level==rows*cols+1) return true;
    for (int a = 0; a < 8; a++) {
      //System.out.println("A");
      int[] temp = getMoves(row, col, xMoves, yMoves);
      if(temp[0]==1) {
        board[temp[1]][temp[2]] = level;
        //System.out.println(temp[1] + " ; " + temp[2]);
        if (solveH2(temp[1], temp[2], level+1)) {
          //System.out.println("B");
          return true;
        }
      }
      //else board[row][col] = 0;
    }
    return false;
  }


//--------------- Helper Methods ----------------//

  public int[] getMoves(int x, int y, int[] xMoves, int[] yMoves) {
    int[] output = new int[3];
    int min = rows*cols;
    for(int a = 0; a < 8; a++) {
      if(check(x+xMoves[a], y+yMoves[a])) {
        int temp = getnumMoves(x+xMoves[a], y+yMoves[a], xMoves, yMoves);
        if(temp < min){
          //System.out.println("C");
          min = temp;
          output[0] = 1;
          output[1] = x+xMoves[a];
          output[2] = y+yMoves[a];
        }
      }
    }
    return output;
  }

  public int getnumMoves(int x, int y, int[] xMoves, int[] yMoves){
    int num = 0;
    for(int a = 0; a<8; a++) {
      if (check(x+xMoves[a], y+yMoves[a])) num++;
    }
    return num;
  }

  public void updateMoves(int[][]data, int level) {
    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < cols; y++) {
        numMoves(moves, x, y, level);
      }
    }
  }

  private void numMoves(int[][] data, int x, int y, int level){
    int[] xMoves = {1, 1, -1, -1, 2, 2, -2, -2};
    int[] yMoves = {2, -2, 2, -2, 1, -1, 1, -1};
    int num = 0;
    for(int a = 0; a < 8; a++) {
      if (check(x+xMoves[a], y+yMoves[a]) && board[x+xMoves[a]][y+yMoves[a]]!=level) {
        num++;
      }
    }
    data[x][y] = num;
  }

  private int[] getMove(int[][] moves, int x, int y, int[] xMoves, int[] yMoves) {
    int[] output = new int[2];
    int min = rows*cols;
    for(int a = 0; a < 8; a++) {
      if (check(x+xMoves[a], y+yMoves[a])) { //if coordinates are a valid move, tries to find minimum
        if(moves[x+xMoves[a]][y+yMoves[a]] < min) {
          min = moves[x+xMoves[a]][y+yMoves[a]];
          output[0] = x+xMoves[a];
          output[1] = y+yMoves[a];
        }
      }
    }
    return output;
  }

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


  public boolean check(int x, int y) { //private
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
