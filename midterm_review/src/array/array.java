package array;

public class array {
  public static void main(String[] args) {
    int[][] intArray = new int[4][5];
    for (int i = 0; i < intArray.length; i++) {
        System.out.println(intArray[i][i]);
    }

    // new array
    int[][] array = {{1,2,3,4,5}, {4,5,6,7}, {7,8,9}};
    System.out.println(array[0].length);
    System.out.println(array[1].length);
    System.out.println(array[2].length);
    System.out.println(array.length);
  }
}
