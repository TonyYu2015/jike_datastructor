package sort;

// 递推公示：merge(p,r) = merge(merge(p,q), merge(q+1, r))
// 终止条件：p >= r
public class Merge {
  public static void sort(int[] arr, int start, int end) {
    if(start >= end) return;
    int tmp = (start + end)/2;
    sort(arr, start, tmp);
    sort(arr, tmp+1, end);
    int[] prevIndexArr = new int[]{start, tmp};
    int[] nextIndexArr = new int[]{tmp+1, end};
    merge(arr, prevIndexArr, nextIndexArr);
  }

  private static void merge(int[] arr, int[] prevArr, int[] nextArr) {
    int k = 0;
    int prevStartIndex = prevArr[0];
    int prevEndIndex = prevArr[1];
    int nextStartIndex = nextArr[0];
    int nextEndIndex = nextArr[1];
    System.out.println(nextEndIndex);
    System.out.println(prevStartIndex);
    int[] tmpArr = new int[nextEndIndex - prevStartIndex];

    while((prevStartIndex <= prevEndIndex) && (nextStartIndex <= nextEndIndex)) {
      if(arr[prevStartIndex] < arr[nextStartIndex]) {
        tmpArr[k] = arr[prevStartIndex];
        prevStartIndex++;
      } else {
        tmpArr[k] = arr[nextStartIndex];
        nextStartIndex++;
      }
      k++;
    }

    int start = prevStartIndex;
    int end = prevEndIndex;
    if(nextStartIndex <= nextEndIndex) {
      start = nextStartIndex;
      end = nextEndIndex;
    }

    while(start <= end) {
      tmpArr[k] = arr[start];
      k++;
      start++;
    }

    int m = prevArr[0];
    for(int i = 0; i < (end - start); i++) {
      arr[m + i] = tmpArr[i];
    }
  }
}
