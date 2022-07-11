package queue;

// "static void main" must be defined in a public class.
//  循环队列
public class QueueArrCycle {
  private String[] arr;
  private int len;
  private int head;
  private int tail;

  // 初始化队列,申请一个大小为l的队列
  public QueueArrCycle(int l) {
    arr = new String[l];
    len = l;
  }

  // 入队
  // 时间复杂度：O(1)
  public boolean enqueue(String m) {
    // 队列已满
    if((tail + 1) % len == head) return false;

    arr[tail] = m;
    tail = (tail + 1) % len;
    return true;
  }   
  
  // 出队
  // 时间复杂度：O(1)
  public String dequeue() {
    if(head == tail) return null;
    String tmpItem = arr[head];
    head = (head + 1) % len;
    return tmpItem;
  }

  public static void main(String[] args) {
      System.out.println("Hello World!");
  }
}