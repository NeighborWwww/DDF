import java.util.*;

public class test_2{
  public static void main(String[] args) {
    String a  = "100 0.9/1.0 a   8.8   test";

    StringTokenizer st = new StringTokenizer(a);
      while (st.hasMoreTokens()) {
        System.out.println(st.nextToken());
      }

    }
}
