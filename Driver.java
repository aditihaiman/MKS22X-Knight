import java.util.*;
import java.io.*;

public class Driver {

  public static void main(String[] args) {
    KnightBoard board1 = new KnightBoard(5, 6);
    //System.out.println(board1);

//testing solve without optimization
    board1 = new KnightBoard(1, 1);
    //System.out.println("1x1: " + board1.countSolutions(0,0));
    board1 = new KnightBoard(4, 5);
    //System.out.println("4x5: " + board1.countSolutions(0,0));
    board1 = new KnightBoard(5, 5);
    //System.out.println("5x5: " + board1.countSolutions(0,0));
    board1 = new KnightBoard(5, 6);
    System.out.println(board1.solve(0,0));
    System.out.println(board1);
    //System.out.println("5x6: " + board1.countSolutions(0,0));


/* testing optimization

    System.out.println(board1);
    System.out.println(printArray(board1.moves) + "\n");
    board1.board[0][0] = 1;
    System.out.println(board1);
    board1.updateMoves(board1.moves, 1);
    System.out.println(printArray(board1.moves));
    board1.board[2][1] = 2;
    System.out.println(board1);
    board1.updateMoves(board1.moves, 2);
    System.out.println(printArray(board1.moves));
*/

  board1 = new KnightBoard(6, 6);
  System.out.println(board1.solveOpt(0,0));
  System.out.println(board1);




  }

  public static String printArray(int[] data) {
    String output = "[";
    for (int x = 0; x < data.length; x++) {
      if (x==data.length-1) output+= data[x]+"]";
      else output+=data[x]+", ";
    }
    return output;
  }

  public static String printArray(int[][] data) {
    String output = "[[";
    for (int x = 0; x < data.length; x++) {
      for(int y = 0; y < data[x].length; y++) {
        if (y==data.length) output+= data[x][y]+"]";
        else output+=data[x][y]+", ";
      }
      if(x<data.length-1)output+="\n [";
    }
    return output + "]";
  }

}
