import java.io.*;
import java.util.*;
	
class Main {
  public static void main(String[] args) throws IOException {
		beeWorld("beesetup1.txt");
	}

	public static void beeWorld(String filename) throws FileNotFoundException {
    //read in the file and parse it into arrays
		File beeList = new File(filename);
    Scanner reader = new Scanner(beeList);
		String[] dimensions = reader.nextLine().split(",");
		int size = Integer.parseInt(dimensions[0]);
    Node[] beeEnd = new Node[15];
		for(int i = 0; i < 15; i++) {
			String[] bee = reader.nextLine().split(",");
			int[] newBee = new int[3];
			int ct = 0;
			for(String b:bee) {
				Integer blah = Integer.parseInt(b);
				newBee[ct] = blah;
				ct ++;
			}
			beeEnd[i] = new Node(newBee[0], newBee[1], newBee[2]);
		}
		Node[] beeStart = new Node[15];
		for(int i = 0; i < 15; i++) {			
			String[] bee = reader.nextLine().split(",");
			int[] newBee = new int[3];
			int ct = 0;
			for(String b:bee) {
				Integer blah = Integer.parseInt(b);
				newBee[ct] = blah;
				ct ++;
			}
			beeStart[i] = new Node(newBee[0], newBee[1], newBee[2]);
		}

    Integer numDebris = Integer.parseInt(reader.nextLine());
    Node[] debris = new Node[numDebris];
    for(int i = 0; i < numDebris; i++) {
			String[] deb = reader.nextLine().split(",");
			int[] newDebris = new int[3];
			int ct = 0;
			for(String b:deb) {
				Integer blah = Integer.parseInt(b);
				newDebris[ct] = blah;
				ct ++;
			}
			debris[i] = new Node(newDebris[0], newDebris[1], newDebris[2]);
    }

		//construct a cube of nodes and run the algorithim for each of the 15 bees
    Cube cube = new Cube(size);
    int pathTotal=0;
    for (int i = 0; i < 15; i++) {
      Node endNode = beeEnd[i];
      Node startNode = beeStart[i];
      ArrayList<Node> path = aStar.findPath(cube, startNode, endNode, debris);
			if (path != null) {
					System.out.println("Bee " + (i + 1) +  " from (" + startNode.x + ", " + startNode.y +", " + startNode.z + ") to (" + endNode.x + ", " + endNode.y +", " + endNode.z + "): " + (path.size() - 1) + " moves");
          pathTotal+=path.size();
			} else {
					System.out.println("No path found for Bee " + (i + 1));
			}	
		}
    System.out.println("Total moves: " + pathTotal);
  }
}