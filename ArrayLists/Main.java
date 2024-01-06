import java.util.*;

public class Main {
	public static void main(String args[]) {
	
	MyArrayList mya = new MyArrayList(100);
	
	String s = "Sally";
	String y = "Joe";
	String z = "Bob";
	
	mya.addBeginningElement(s);
	mya.addBeginningElement(y);
	mya.addBeginningElement(z);
	
	System.out.println(mya.getIndex(0));
	System.out.println(mya.getIndex(1));
	System.out.println(mya.getIndex(2));

	System.out.println("the number of elements is " + mya.getLogicalSize());
	
	mya.setElements(0,"David");
	
	System.out.println(mya.getIndex(0));
	System.out.println(mya.getIndex(1));
  System.out.println(mya.getIndex(2));
	
	System.out.println("Now removing Joe.");
	mya.removeElem("Joe");
	System.out.println(mya.getIndex(0));
	System.out.println(mya.getIndex(1));
	System.out.println("the number of elements is " + mya.getLogicalSize());
	
	Integer i = 210;
	Double d = 3.14159;
	mya.addBeginningElement(i);
	mya.addBeginningElement(d);

	System.out.println(mya.getIndex(2));
	System.out.println(mya.getIndex(3));
	
	int x = mya.getPhysicalSize();
	for(int a = 0; a < x; a++)
	{
		Object t = mya.getIndex(a);
		
		if (t instanceof String)
		{
			System.out.println("we have a String!");
		}
		else if (t instanceof Number)
		{
			System.out.println("we have a Number!");
		}
	}
  mya.displayArray();
  

	}
}