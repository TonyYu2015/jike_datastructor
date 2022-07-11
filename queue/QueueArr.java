package queue;

// "static void main" must be defined in a public class.
//  顺序队列
public class QueueArr {
  private String[] arr;
  private int len;
  private int head;
  private int tail;

  // 初始化队列,申请一个大小为l的队列
  public QueueArr(int l) {
    arr = new String[l];
    len = l;  
  }

  // 入队
  /**
   * 
   * @param m
   * @return
   * 时间复杂度：
   *  最好：O(1)
   *  最坏：O(n)
   *  平均：O(1)
   *    -分析: 
   *      1/n*(n-1) + 1/n*((1 + 2 + 3 +...+ (n-1))/n)
   *      1 + 1/2
   *      O(1)
   */
  public boolean enqueue(String m) {
    if(tail == len) {
      // 队列已满
      if(head == 0) return false;
      // 未满的情况下进行数据迁移
      for(int i = head; i < tail; i++) {
        arr[i - head] = arr[i];
      }
      tail -= head;
      head = 0;
    };
    arr[tail] = m;
    tail++;
    return true;
  }   
  
  // 出队
  // 时间复杂度：O(1)
  public String dequeue() {
    if(head == len) return null;
    String tmpItem = arr[head];
    head++;
    return tmpItem;
  }

  public static void main(String[] args) {
      System.out.println("Hello World!");
  }
}