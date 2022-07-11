package stack;

// "static void main" must be defined in a public class.
public class Stack {
    
  private String [] stack;
  private int len;
  private int count;
  
  public Stack(int l) {
      this.stack = new String[len];
      this.len = l;
      this.count = 0;
  }
  
  public void push(String m) {
      if(count == len)
          expandStack();
      stack[count] = m;
      count++;
  }
  
  private void expandStack() {
      String[] newStack = new String[len * 2];
      for(int i = 0; i < len; i++) {
          newStack[i] = stack[i];
      }
      len *= 2;
      stack = newStack;
  }
  
  public void pop() {
      if(count == 0)
          System.out.println("栈中已经没有数据了");
      stack[count - 1] = null;
      count--;
  }
  
  public static void main(String[] args) {
      System.out.println("Hello World!");
  }
}