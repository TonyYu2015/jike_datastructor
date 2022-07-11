package link;
// "static void main" must be defined in a public class.
// 没有加限制长度
public class LinkLRU {
  private Node list;
  private Node tmpOne;
  public LinkLRU() {
      list = new Node();
  }
  // 双向链表节点
  class Node {
      public Node(String data, Node prev, Node next) {
          this.next = next;
          this.prev = prev;
          this.data = data;
      }
      public Node() {
      }
      Node next;
      Node prev;
      String data;
  }
  
  private void del() {
      if(tmpOne.prev != null) tmpOne.prev.next = tmpOne.next;
      if(tmpOne.next != null) tmpOne.next.prev = tmpOne.prev;
  }
  
  private void insert(Node m) {
      if(m != null) {
          // tmpOne.next = list;
          // tmpOne.prev = null;
      } else {
          if(list.data == null){
               list = tmpOne;
          } else {
              tmpOne.next = list;
              tmpOne.prev = null;
              list.prev = tmpOne;
          }
              
          System.out.print(list.data);
      }
  }
  
  private Node find(String m) {
      Node a = list;
      while(a != null) {
          if(a.data == m)
              return a;
          a = a.next;
      }
      return null;
  }
  
  
  public void update(String m) {
      tmpOne = find(m);
      if(tmpOne != null){
          del();
      } else {
          tmpOne = new Node(m, null, null);
      }
      insert(null);

    //   Node xx = list;
      // System.out.print("======>>>");
      // while(xx != null) {
      //     System.out.print(xx.data);
      //     xx = xx.next;
      // }
  }
  
  public static void main(String[] args) {
      LinkLRU Lru = new LinkLRU();
      Lru.update("a");
      Lru.update("b");
      Lru.update("c");
      Lru.update("e");
      Lru.update("a");
      Lru.update("b");
  }
}