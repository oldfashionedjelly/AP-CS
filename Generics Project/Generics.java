public class Generics {
    public static void main(String[] args) {
      Container<Integer> integerContainer = new Container<>();
      Container<String> stringContainer = new Container<>();
  
      integerContainer.addElement(10);
      integerContainer.addElement(20);
      integerContainer.addElement(30);
      integerContainer.addElement(40);
      integerContainer.display();
  
      System.out.println("");
  
      integerContainer.removeElement(20);
      integerContainer.display(); 
  
      System.out.println("");
  
      System.out.println(integerContainer.getElement(0));
  
      System.out.println("");
      System.out.println("");
  
      stringContainer.addElement("Hello");
      stringContainer.addElement("How");
      stringContainer.addElement("Are");
      stringContainer.addElement("You");
      stringContainer.display();
  
      System.out.println("");
  
      stringContainer.removeElement("How");
      stringContainer.display();
  
      System.out.println("");
  
      System.out.println(stringContainer.getElement(0));
    }
  }