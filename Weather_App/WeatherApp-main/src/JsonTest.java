public class JsonTest {
      public static void main(String[] args){
      String s = "{\"visibility\":10000,\"timezone\":7200}";
      String[] ar = s.split(",");
      System.out.println(ar[0]);
      }
}