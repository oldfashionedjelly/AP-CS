// 1. The class can hold only objects (Strings, Double, Integer, etc)
// 2. Keep track of and Return the PHYSICAL SIZE of the Array & the LOGICAL SIZE of the array (2 get methods)
// 3.  Add an element to the END of the array
// 4. Add an Element to the Beginning of the array 
// 5. Double the size of the array if it gets full
// 6.  Find a given element in the array and tell if it exists or not (if it exists, tell the index location)
// 7.  Return the object at a given INDEX 
// 8. Remove a specified array element and close any gaps, update logical size, if not there let user know
// 9. DISPLAY all of the elements in the array

import java.util.*;

public class MyArrayList
{
  public int size;
  public MyArrayList(int s)
  {
    size=s;
  }
  Object[] array = new Object[size];
  int cellsUsed = 0;
  int length = array.length;

  public void setElements(int index, Object elem)
  {
    array[index] = elem;
  }
  
  public int getPhysicalSize()
  {
    return array.length;
  }
  
  public int getLogicalSize()
  {
    cellsUsed = 0;
	  for(int i = 0; i < array.length; i++)
    {
      if(array[i] != null)
      {
        cellsUsed++;
      }
    }
    return cellsUsed;
  }

  public void addBeginningElement(Object elem) {
    Object[] newArray = new Object[array.length + 1];
    newArray[0] = elem;

    for (int i = 1; i < newArray.length; i++) {
      newArray[i] = array[i-1];
    }

    array = newArray;
    length++;
  }

  public void addEndElement(Object elem)
  {
    array = Arrays.copyOf(array, array.length + 1);
    array[array.length - 1] =  elem;
    length = array.length;
    
  }

  public int findElement(Object elem)
  {
    int counter = 0;
    for(int i = 0; i < array.length; i++)
    {
      if(elem.equals(array[i]))
      {
        counter++;
        return counter;
      }
    }
    return -1;
  }
  public Object getIndex(int index)
  {
    return array[index];
  }

	public void removeElem (Object elem) {
		if (!Arrays.asList(array).contains(elem)) {
			System.out.println("This element is not found in the array.");
		} else {
			int index = Arrays.asList(array).indexOf(elem);
			Object[] newArray = new Object[length-1];
			for (int i = 0; i < index; i++) {
				newArray[i] = array[i];
			}
			for (int i = index; i < newArray.length; i++) {
				newArray[i] = array[i+1];
			}
			array = newArray;
			length--;
		}
	}
  
  public boolean doubleArrayLength()
  {
    if(array.length == cellsUsed)
    {
      Object[] array = new Object[length * 2];      
      return true;
    }
    else
    {
      return false;
    }
  }
  
  public void displayArray()
  {
    for(int i = 0; i < array.length; i++)
    {
      System.out.print(array[i] + ", ");
    }
  }
}