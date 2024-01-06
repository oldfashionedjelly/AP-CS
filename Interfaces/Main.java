import java.lang.Comparable;

class Main {
 public static void main(String[] args) {
   Car c = new Car(2020);
   Comparable x = new Car(2020);
   Comparable s = new String("sallyjoebob");
   Comparable r = new String("sallyjoebilly");
   System.out.println(((String)s).length());
   System.out.println(((String)r).length());

   System.out.println(x.compareTo(c)); 
   System.out.println(((String)r).compareTo((String)s)); 
 }
}
