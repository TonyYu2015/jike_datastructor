package arr;

public class BSearch {
   public boolean find(int[] a, int n, int val) {
     int low = 0;
     int high = n - 1;
     while(low <= high) {
      int mid = low + (high - low)/2;
      if(a[mid] ==  val)  {
        return true;
      }else if(a[mid] > val)  {
        high = mid  - 1;
      }else{
        low = mid + 1;
      }
     }
     return false;
   }
}
