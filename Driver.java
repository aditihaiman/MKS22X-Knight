public class Driver {

  public static void main(String[] args) {
    KnightBoard board = new KnightBoard(5, 6);
    System.out.println(board);

    board.placeKnight(2, 1, 1);
    System.out.println(board);
    System.out.println(board.canPlaceAnother(2, 1));

    // int[] test = new int[5];
    // System.out.println(test[4]==0);
  }

  public String printArray() {
    for (int x = 0; x < this.length; x++) {
      
    }
  }

}
