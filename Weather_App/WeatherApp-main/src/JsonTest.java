public class JsonTest {
      public static void main(String[] args){
      String s = "{\"visibility\":10000,\"timezone\":7200}";
      String[] ar = s.split(",");
      System.out.println(ar[0]);
      }
      /* {"visibility":10000,"timezone":7200,"main":{"temp":274.33,"temp_min":274.33,"grnd_level":1002,"humidity":88,"pressure":1029,"sea_level":1029,
"feels_like":270.39,"temp_max":274.33},"clouds":{"all":100},"sys":{"country":"UA","sunrise":1706680166,"sunset":1706713278},"dt":1706731296,"
coord":{"lon":26.9727,"lat":50.4013},"weather":[{"icon":"04n","description":"overcast clouds","main":"Clouds","id":804}],
"name":"Rivne","cod":200,"id":693581,"base":"stations","wind":{"deg":253,"speed":3.89,"gust":9.99}} */

}