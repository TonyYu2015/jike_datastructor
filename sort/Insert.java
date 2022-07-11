package sort;

// 原地排序，稳定排序，时间复杂度O(n^2)
public class Insert {
  public static void sort(int[] arr, int n) {
    if(n <= 1) return;
    for(int i = 1; i < n; i++) {
      int j = i - 1;
      int value = arr[i];
      for(; j >= 0; j--) {
        if(arr[j] > value) {
          arr[j + 1] = arr[j];
        } else {
          break;
        }
      }
      arr[j+1] = value;
    }
  }
}
