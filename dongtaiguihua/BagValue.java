package dongtaiguihua;

/**
 * 1. 初始化状态
 * 2. 从第一个开始往后遍历，每个物品都有装与不装两种选择,把value赋值到每种状态
 * 空间 
 *  states n * w
 *  O(n * w) 
 * 时间
 * n * w + n * (w*2) + w = (3n + 1) * w
 * O(n * w)
 */
public class BagValue {
    public static int getTheMaxValue(int[] value, int[] weight, int n, int w ) {
      int[][] states = new int[n][w + 1];
      // initital
      for(int i = 0; i < n; ++i) {
        for(int j = 0; j < w + 1; ++j) {
          states[i][j] = -1;
        }
      }

      states[0][0] = 0;
      if(weight[0] < w) {
        // first value
        states[0][weight[0]] = value[0];
      }

      // start calculate
      for(int i = 1; i < n; ++i) {
        // not pack i
        for(int j = 0; j <= w; ++j) {
          if(states[i - 1][j] >= 0) states[i][j] = states[i - 1][j];
        }

        // pack i
        for(int j = 0; j <= w - weight[i]; ++j) {
          if(states[i - 1][j] >= 0) {
            int cv = states[i - 1][j] + value[i];
            if(cv > states[i][j + weight[i]]) {
              states[i][j + weight[i]] = cv;
            }
          }
        }
      }

      int maxValue = 0;
      for(int i = 1; i < w + 1; ++i) {
        if(states[n - 1][i] > maxValue) maxValue = states[n - 1][i];
      }
      return maxValue;

    } 

    public static void main(String[] args) {
      int[] weight = {2, 3, 4, 6, 8};
      int[] value = {10, 8, 21, 14, 12};
      int maxW = 12;
      int n = 5;

      int maxValue = getTheMaxValue(value, weight, n, maxW);

      System.out.println(maxValue);
    }
}
