package sort;

// 空间复杂度为O(1),原地排序
// 只有当数据大小不一样时才会交换，所以属于稳定的排序算法
// 时间复杂度：
//    最好情况：数组为有序，无需交换，只需要一次循环，为O(n)
//    最坏情况：数组完全逆序，需要 (n + ... + 2 + 1) => O(n2)
//    平均情况：
public class Bubble {
  public static void sort(int[] arr, int n) {
    for(int j = 0; j < n; j++) {
      boolean flag = false;
      for(int i = 0; i < n - j - 1; i++) {
        if(arr[i] > arr[i+1]) {
          int tmp = arr[i];
          arr[i] = arr[i+1];
          arr[i+1] = tmp;
          flag = true;
        }
      }

      if(!flag) break;
    }
  }
}
