package dongtaiguihua;

/**
 * dp[i] = max(dp[j]) + 1  0 < j < i dp[j] < dp[i] 
 */
public class LongestIncresLen {
  public static int lil(int [] nums) {
    if(nums.length == 0) return 0;
    int [] dp = new int[nums.length];
    dp[0] = 1;
    int maxL = 1;
    for(int i = 1; i < nums.length; i++) {
      dp[i] = 1;
      for(int j = 0; j < i; j++) {
        if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
      }
      maxL = Math.max(maxL, dp[i]);
    }
    return maxL;
  }  

  public static void main(String [] args) {
    int [] arr = {2, 9, 3, 2, 5, 1, 7};
    int reLen = lil(arr);
    System.out.println(reLen);
  }
}
