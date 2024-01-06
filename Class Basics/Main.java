import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("names.txt");
		Scanner sc = new Scanner(f);
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> freq = new ArrayList<Integer>();

		for (int i = 0; i < 1000; i++) {
			String n = sc.nextLine();
			if (!names.contains(n)) {
				names.add(n);
				freq.add(1);
			} else {
				int index = names.indexOf(n);
				int oldFreq = freq.get(index);
				freq.set(index, oldFreq+1);
			}
		}

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i) + ": " + freq.get(i));
		}

    sc.close();
		sc = new Scanner(System.in);

		while (true) {
			System.out.print("\nType in a name: ");
			String n = sc.next();
			if (n.equals("-1")) {
				break;
			} else if (names.contains(n)) {
				System.out.println("That name is in the list and appears " + freq.get(names.indexOf(n)) + " times.");
			} else {
				System.out.println("That name is not in the list.");
			}
			
		}

		sc.close();
	}
}