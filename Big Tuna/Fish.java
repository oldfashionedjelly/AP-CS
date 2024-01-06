public class Fish {
    private String type;
    private double length;
  
    public Fish(String t, double l) {
      type = t;
      length = l;
    }
  
    public String getType() {
      return type;
    }
  
    public void setType(String t) {
      type = t;
    }
  
    public double getLength() {
      return length;
    }
  
    public void setLength(double l) {
      length = l;
    }
  
    public String toString() {
      return "Type: " + type + " Length: " + length;
    }
  }
  