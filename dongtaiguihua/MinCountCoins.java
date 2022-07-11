package dongtaiguihua;

public class MinCountCoins {
  public static int minCount(int[] coinArr, int totalPrice) {
    int coinNum = 0;
    int tmpPrice = totalPrice;
    int startIndex = coinArr.length - 1;
    int i = startIndex;
    while(tmpPrice > 0) {
      if(coinArr[i] <= tmpPrice) {
        coinNum += 1;
        tmpPrice -= coinArr[i];
        if(tmpPrice == 0) break;
      } else if(i > 0) {
        i--;
      } else if(i == 0 && startIndex > 0) {
        startIndex--;
        i = startIndex;
        coinNum = 0;
        tmpPrice = totalPrice;
      }
    }


    return coinNum;
  }

  public static void main(String[] args) {
    int[] coinCount = {1, 2, 2};
    int totalPrice = 9;
    int minNum = minCount(coinCount, totalPrice);
    System.out.println(minNum);
  }
}
