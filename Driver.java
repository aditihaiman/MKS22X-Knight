public class Driver {

  public static void main(String[] args) {
    KnightBoard board1 = new KnightBoard(5, 6);
    System.out.println(board1);

    board1.board[2][1]=1;
    board1.board[0][0]=1;
    System.out.println(board1);
    System.out.println(printArray(board1.canPlaceAnother(2, 1)));

    // int[] test = new int[5];
    // System.out.println(test[4]==0);
  }

  public static String printArray(int[] data) {
    String output = "[";
    for (int x = 0; x < data.length; x++) {
      if (x==data.length-1) output+= data[x]+"]";
      else output+=data[x]+", ";
    }
    return output;
  }

}
