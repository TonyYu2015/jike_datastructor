package dongtaiguihua;

/**
 * 空间
 * O(1)
 * 时间
 * (n - 1) * (n - 1)
 * O(n2)
 */
public class YangHuiSanJiao {

  public static int getTheMinPath(int[][] matrix) {
    if(matrix.length == 1) return matrix[0][0];

    for(int i = matrix.length - 2; i >= 0; i--) {
      for(int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
      }
    }

    return matrix[0][0];
  }

  public static void main(String[] args) {
    int[][] matrix = {{5}, {7,2}, {2,3,4}, {4,9,6,1}, {2,7,9,4,5}};

    int minPath = getTheMinPath(matrix);
    System.out.println(minPath);
  }
  
}
