package dongtaiguihua;
/**
 * 莱文斯坦距离算法
 * 计算2个字符间的差异允许：增加、删除、编辑3个动作
 */
public class LaiWenSiLength {
   public static int lwstDP(char [] a, int n, char [] b, int m) {
    int [][] minDist = new int[n][m];

    // 初始化第0行
    for(int j = 0; j < m; j++) {
      if(a[0] == b[j]) minDist[0][j] = j;
      else if(a[0] != b[j]) minDist[0][j] = minDist[0][j - 1] + 1;
      else minDist[0][j] = 1;
    }

    // 初始化第0列
    for(int i = 0; i < n; i++) {
      if(a[i] == b[0]) minDist[i][0] = i;
      else if(a[i] != b[0]) minDist[i][0] = minDist[i - 1][0] + 1;
      else minDist[i][0] = 1;
    }

    for(int i = 1; i < n; i++) {
      for(int j = 1; j < m; j++) {
        if(a[i] == b[j]) {
          minDist[i][j] = min(minDist[i - 1][j], minDist[i][j - 1], minDist[i - 1][j - 1]);
        } else {
          minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1] + 1);
        }
      }
    }

    return minDist[n - 1][m - 1];
   }

   public static int min(int x,  int y, int z) {
    int minv = Integer.MAX_VALUE;
    if(x < minv) minv = x;
    if(y < minv) minv = y;
    if(z < minv) minv = z;
    return minv;
   }

   public static void main(String [] args) {
    char [] a = {'m', 'a', 'f', 'r', 'i', 'c'};
    int n = 6;
    char [] b = {'m', 'i', 't', 'a', 'r', 'c'};
    int m = 6;

    int edist = lwstDP(a, n, b, m);

    System.out.println(edist);
   }
}
