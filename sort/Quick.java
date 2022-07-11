package sort;

public class Quick {
  public static void sort(int[] arr, int n) {
    quick_sort(arr, 0, n-1);
  }

  private static void quick_sort(int[] arr, int p, int r) {
    if(p >= r) return;
    int q = partition(arr, p, r);
    quick_sort(arr, p, q-1);
    quick_sort(arr, q+1, r);
  }

  private static int partition(int[] arr, int p, int r) {
    // 分区点
    int pvit = arr[r];
    // 分区点索引
    int i = p;
    for(int j = i; j < r; j++) {
      if(arr[j] < pvit) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        i++;
      }
    }
    arr[r] = arr[i];
    arr[i] = pvit;
    return i;
  }
}
