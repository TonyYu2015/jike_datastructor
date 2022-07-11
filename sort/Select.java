package sort;

// 是原地排序，但不是稳定排序，时间复杂度O(n^2)
public class Select {
  public static void sort(int[] arr, int n) {
    if(n <= 1) return;
    int i = 0;
    while(i < n) {
      int min = arr[i];
      int minIndex = i;
      for(int j = i + 1; j < n; j++) {
        if(arr[j] < min) {
          min = arr[j];
          minIndex = j;
        }
      }
      arr[minIndex] = arr[i];
      arr[i] = min;
      i++;
    }
  }
}
