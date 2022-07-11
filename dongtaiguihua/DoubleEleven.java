package dongtaiguihua;

public class DoubleEleven {
  public static int getTheClosestPrice(int n, int[] priceArr, int price, int totalPrice) {
    // initial the states
    boolean[][] states = new boolean[n][totalPrice + 1];
    if(priceArr[0] <= totalPrice) {
      states[0][priceArr[0]] = true;
    }

    // 动态规划
    for(int i = 1; i < n; i++) {
      // 不采购第i个商品
      for(int j = 0; j <= totalPrice; j++) {
        if(states[i - 1][j] == true) states[i][j] = states[i - 1][j];
      }

      // 采购第i个商品
      for(int j = 0; j <= totalPrice - priceArr[i]; j++) {
        if(states[i - 1][j] == true) {
          states[i][j + priceArr[i]] = true;
        }
      }
    }


    int p = 0;
    for(p = price; p <= totalPrice; p++) {
      if(states[n - 1][p]) break;
    }

    int preP = p;
    for(int j = n - 1; j > 0; --j) {
      if(preP - priceArr[j] >= 0 && states[j - 1][preP - priceArr[j]] == true) {
        preP = preP - priceArr[j];
        System.out.println("商品价格：" + priceArr[j] + ", 剩余价格：" + preP + ", 商品索引：" + j);
      }
    }

    if(states[0][preP] == true) {
      System.out.println(priceArr[0]);
    }

    return p;
  }  

  public static void main(String[] args) {
    int price = 200; // 满200减50
    int[] priceArr = {20, 25, 26, 30, 55, 41, 8, 15, 80, 101, 101};
    int n = 11;

    int maxPrice = getTheClosestPrice(n, priceArr, price, price * 3);

    System.out.println(maxPrice);
  }
}
