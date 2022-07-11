package dongtaiguihua;


/**
 * 最优子结构 
 * lcs(i, j, max_len) = max(lcs(i - 1, j - 1, max_len), lcs(i, j - 1, max_len), lcs(i - 1, j, max_len))
 */
public class LongestCommonSubStrinng {
  public static int lcss(char [] a, int n, char [] b, int m ) {
    int [][] max_len = new int[n][m];
    // 初始化0行j列 
    for(int j = 0; j < m; j++) {
      if(a[0] == b[j]) max_len[0][j] = 1;
      else if(j != 0) max_len[0][j] = max_len[0][j - 1];
      else max_len[0][j] = 0;
    }

    // 初始化i行0列
    for(int i = 0; i < n; i++) {
      if(a[i] == b[0]) max_len[i][0] = 1;
      else if(i != 0) max_len[i][0] = max_len[i - 1][0];
      else max_len[i][0] = 0;
    }

    for(int i = 1; i < n; i++) {
      for(int j = 1; j < m; j++) {
        if(a[i] == b[j]) {
          max_len[i][j] = max(max_len[i - 1][j], max_len[i][j - 1], max_len[i - 1][j - 1]) + 1;
        } else {
          max_len[i][j] = max(max_len[i - 1][j], max_len[i][j - 1], max_len[i - 1][j - 1]);
        }
      }
    }

    return max_len[n -1][m - 1];
  }

  public static int max(int x, int y, int z) {
    int maxv = Integer.MIN_VALUE;
    if(x > maxv) maxv = x;
    if(y > maxv) maxv = y;
    if(z > maxv) maxv = z;

    return maxv;
  }

   public static void main(String [] args) {
    char [] a = {'m', 'i', 'f', 'r', 'i', 'c'};
    int n = 6;
    char [] b = {'m', 'i', 'f', 'a', 'r', 'c'};
    int m = 6;

    int edist = lcss(a, n, b, m);

    System.out.println(edist);
   }
}
