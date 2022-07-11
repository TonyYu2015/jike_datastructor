package link;

// "static void main" must be defined in a public class.
public class CycleLink {
  Node link;
  int len;
  
  class Node {
      public Node(){}
      public Node(String data, Node next) {
          this.data = data;
          this.next = next;
      }
      String data;
      Node next;
  }
  
  public Node find(String m) {
      Node tmp = link;
      int i = 0;
      while(i < len) {
          if(tmp.data == m) {
              return tmp;
          }
          tmp = tmp.next;
          i++;
      }
      return null;
  }
  
  public Node findPrev(String m) {
      Node tmp = link;
      Node tmpPrev = link;
      int i = 0;
      while(i < len) {
          if(tmp.data == m) {
              return tmpPrev;
          }
          tmpPrev = tmp;
          tmp = tmp.next;
          i++;
      }
      return null;
  }
  
  public void del(String m) {
      Node tmpPrev = findPrev(m);
      tmpPrev.next = tmpPrev.next.next;
  }
  
  public void insert(String m, String n) {
      Node tmp = find(m);
      if(tmp != null) {
          Node newNode = new Node(n, tmp.next);
          tmp.next = newNode;
      }
  }
  
  public static void main(String[] args) {
      System.out.println("Hello World!");
  }
}