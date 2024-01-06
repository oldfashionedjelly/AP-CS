import java.lang.Comparable;

public class Car implements Comparable<Car>
{
 private int year;
 public Car(int y)
 {
   year = y;
 }
 public int  compareTo(Car x)
 {
   return this.year - x.year;
 }
}
