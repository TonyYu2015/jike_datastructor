package link;

public class Huiwen {
  public static class Node {
    public Node() {}
    public Node(char data, Node next) {
      this.data = data;
      this.next = next;
    }

    char data;
    Node next;
  }  

  // 双指针
  public static boolean isHuiWen(Node m) {
    if(m.next == null) return false;
    if(m.next.next == null) return m.data == m.next.data;
    Node slow = m;
    Node fast = m.next.next;
    Node prev = m;

    while(fast.next != null) {
      Node tmp = prev;
      prev = prev.next;
      prev.next = tmp;

      slow = slow.next;
      fast = fast.next.next;
    }

    while(true) {
      if(prev.data != slow.data) {
        return false;
      }
      if(slow.next == null) {
        return true;
      }
      prev = prev.next;
      slow = slow.next;
    }
  }

  public static void main(String[] args) {
    // 生成单向链表
    String str = "abcabc";
    Node link = null;
    for(int i = 0; i < str.length(); i++) {
      if(i == 0) {
        link = new Node(str.charAt(i), null);
      } else {
        link.next = new Node(str.charAt(i), null);
        link = link.next;
      }
    }

    boolean bol = isHuiWen(link, str.length());
    System.out.println(bol);
  }
}
