public class Employee {
    private String name;
    private double hours;
    private double rate;
    private double totalPay;
  
    public Employee(String n, double h, double r) {
      setName(n);
      setHours(h);
      setRate(r);
      calcTotalPay();
    }
  
    public void calcTotalPay() {
      totalPay = hours * rate;
    }
  
    public void setName(String no) {
      name = no;
    }
  
    public void setHours(Double hrs) {
      if (hrs <= 37.0) {
        hours = hrs;
      } else {
        hours = 37.0;
      }
    }
  
    public void setRate(Double r) {
      if (r <= 25.0) {
        rate = r;
      } else {
        rate = 25.0;
      }
    }
  
    public double getTotalPay() {
      return totalPay;
    }
  
  }
  