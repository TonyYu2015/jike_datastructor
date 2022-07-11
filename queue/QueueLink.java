package queue;

// 基于链表实现队列
public class QueueLink {
  public QueueLink() {
    this.head = new Node();
  }

  Node head;
  Node tail;

  // 链表节点
  class Node {
    public Node() {}
    
    public Node(String m, Node next) {
      this.data = m;
      this.next = next;
    }
    
    String data;
    Node next;
  }

  // 入队
  public boolean enqueue(String m) {
    // 还未初始化队列
    if(head == null) 
      return false;
    if(head.data == null) 
      head.data = m;
    else
      tail = tail.next = new Node(m, null);
    return true;
  }

  // 出队
  public String dequeue() {
    // 还未初始化队列
    if(head == null) 
      return null;
    if(tail == null)
      head = null;
    else 
      head = head.next;
    return head.data;
  }
}
