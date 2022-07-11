package sort;

import java.util.Arrays;

public class Test {
  public static void main(String [] args) {
    int[] arr = new int[]{2, 3, 5, 1, 4, 22, 7, 12, 15, 6};
    int m = 0;
    System.out.println(Arrays.toString(arr));
    // sort.Bubble.sort(arr, 10);
    // sort.Insert.sort(arr, 10);
    // sort.Select.sort(arr, 10);
    sort.Merge.sort(arr, 0, 9);
    // sort.Quick.sort(arr, 10);
    // m = sort.FindK.find(arr, 10, 4);
    // System.out.println(m);
    System.out.println(Arrays.toString(arr));
    
  } 
}
