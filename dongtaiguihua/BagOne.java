package dongtaiguihua;
public class BagOne {
  public static int bag_1 (int[] items, int n, int w) {
    boolean[] slates = new boolean[w + 1];
    slates[0] = true;
    if(items[0] <= w) {
      slates[items[0]] = true;
    }

    for(int i = 1; i < n; i++) {
      for(int j = w - items[i]; j >= 0; j--) {
        if(slates[j] == true) slates[j + items[i]] = true;
      }
    }

    for(int i = w; i >= 0; i--) {
      if(slates[i] == true) return i;
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(1111);
  }
}