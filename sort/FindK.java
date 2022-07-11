package sort;

public class FindK {
  public static int find(int[] arr, int n, int k) {
    return find_c(arr, 0, n - 1, k);
  }

  private static int find_c(int[] arr, int p, int q, int k) {
    int r = partition(arr, p, q);
    int tmpR = 0;
    if(k == r + 1) tmpR = arr[r];
    if(k > r + 1) {
      tmpR = find_c(arr, r+1, q, k);
    }
    if(k < r + 1) {
      tmpR = find_c(arr, p, r-1, k);
    }

    return tmpR;
  }

  private static int partition(int[] arr, int p, int r) {
    // 分区点
    int m = arr[r];
    // 分区索引
    int q = p;
    for(int i = q; i < r; i++) {
      if(arr[i] < m) {
        int tmp = arr[q];
        arr[q] = arr[i];
        arr[i] = tmp;
        q++;
      }
    }
    arr[r] = arr[q];
    arr[q] = m;
    return q;
  }
}
