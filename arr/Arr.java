package arr;

// "static void main" must be defined in a public class.
// 支持动态扩容
public class Arr {
    
  private int[] arr;
  private int len;
  private int count;
  
  public Arr(int len) {
      this.arr = new int[len];
  }
  
  public boolean find(int m) {
      for(int i = 0; i < len; i++) {
          if(arr[i] == m) return true;
      }
      return false;
  }
  
  public void push(int m) {
      if(count == len)
          expandArr();
      arr[count] = m;
      count++;
  }
  
  public void expandArr() {
      int[] newArr = new int[len * 2];
      for(int i = 0; i < len; i++) {
          newArr[i] = arr[i];
      }
      len = len * 2;
      arr = newArr;
  }
  
  public void del(int m) {
      int delIndex = 0;
      for(int i = len - 1; i > 0; i--) {
          if(arr[i] == m)
              delIndex = i;
              break;
      }
      
      for(int i = delIndex; i < len; i++) {
          arr[i] = arr[i+1];
      }
  }
  
  public static void main(String[] args) {
      System.out.println("Hello World!");
  }
}