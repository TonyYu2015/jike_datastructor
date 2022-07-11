package link;
// "static void main" must be defined in a public class.
public class SingleLink {
    
  Node link;
  int len; //链表长度
  
  class Node {
      public Node() {
      }
      public Node(String data, Node next) {
          this.data = data;
          this.next = next;
      }
      
      String data;
      Node next;
  }
  
  public Node find(String m) {
      Node tmp = link;
      while(tmp != null){
          if(tmp.data == m)
              return tmp;
          tmp = tmp.next;
      }
      return null;
  }
  
  private Node findPrev(String m) {
      Node tmp = link;
      Node tmpPrev = link;
      while(tmp != null){
          if(tmp.data == m)
              return tmpPrev;
          tmpPrev = tmp;
          tmp = tmp.next;
      }
      return null;
  }
  
  public Node lastLink() {
      Node tmp = link;
      while(tmp.next != null)
          tmp = tmp.next;
      return tmp;
  }
  
  public void del(String m) {
      addSentry();
      Node tmp = findPrev(m);
      tmp.next = tmp.next.next;
      delSentry();
  }
  
  public void insertLast(String m) {
      addSentry();
      Node tmp = lastLink();
      tmp.next = new Node(m, null);
      delSentry();
  }
  
  private void addSentry() {
      Node tmp = link;
      link = new Node(null, tmp);
  }
  
  private void delSentry() {
      link = link.next;
  }
  
  public void reverse() {
      if(link == null || link.next == null) return;
      Node first = new Node(link.data, null);
      Node tmp = link.next;
      Node tmpFirst;
      while(tmp != null) {
          tmpFirst = first;
          first = new Node(tmp.data, tmpFirst);
          tmp = tmp.next;
      }
      
      link = first;
  }
  
  // 检测链表中的环
  public boolean isHasCircle() {
      Node a = link;
      Node b = link;
      while(true) {
          a = a.next;
          if(a == null) return false;
          if(b.next == null || b.next.next == null) return false;
              b = b.next.next;
          if(a == b) return true;
      }
  }
  // 两个有序链表的合并
  // 循环小的链表
  public Node combine(Node a, Node b) {
      // 合并后的链表
      Node mainLink;
      Node biggerLink;
      Node tmpLink;
      if(a.data > b.data) {
          mainLink = b;
          biggerLink = a;
      }
      
      while(mainLink.next != null) {
          if(mainLink.next.data > biggerLink.data) {
              tmpLink = mainLink.next;
              mainLink.next = biggerLink;
              biggerLink = tmpLink;
          }
          mainLink = mainLink.next;
      }
      
      return mainLink;
  }
  
  private int linkLen() {
      return len;
  }
  
  // 删除链表倒是第n个节点
  public void delN(int x) {
      int l = linkLen();
      if(x > l) return;
      Node tmpLink = link;
      for(int i = 1; i < x; i++) {
          tmpLink = tmpLink.next;
      }
      tmpLink.next = tmpLink.next.next;
  }
  
  // 链表的中间节点
//   public Node middleNode() {
//       Node tmpLink = link;
//       int l = linkLen();
      
//   }
  
  
  public static void main(String[] args) {
    SingleLink SingleLink = new SingleLink();
    SingleLink.insertLast("a");
    SingleLink.insertLast("b");
    SingleLink.insertLast("c");
    System.out.println(SingleLink.isHasCircle());
    SingleLink.reverse();
    System.out.println("Hello World!");
  }
}