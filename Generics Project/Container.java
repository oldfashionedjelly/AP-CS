import java.util.ArrayList;

public class Container<T> {

  ArrayList<T> elements = new ArrayList<>();
  
  public Container() {
    
  }

  public void addElement(T element) {
    elements.add(element);
  }

  public void removeElement(T element) {
    elements.remove(element);
  }

  public T getElement(int index) {
    return elements.get(index);
  }

  public void display() {
    for (T element : elements) {
      System.out.println(element);
    }
  }
}