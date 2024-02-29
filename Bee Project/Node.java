public class Node implements Comparable<Node>{
	public int x;
	public int y;
	public int z;
    public double gCost;
    public double hCost;
    public double fCost;
    public Node parent;
	
	public Node(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

  //compare the fCost of the node to the other node
  public int compareTo(Node other) {
    return Double.compare(this.gCost + this.hCost, other.gCost + other.hCost);
  }
  public static int manhattanDistance(Node node, Node goal) {
    return Math.abs(node.x - goal.x) + Math.abs(node.y - goal.y) + Math.abs(node.z - goal.z);
  }
  
  public void setG(Node start) {
    gCost=manhattanDistance(start, this);
  }

  public void setG(double g) {
    gCost=g;
  }

  public double getG() {
    return gCost;
  }

  public void setH(Node end) {
    hCost= manhattanDistance(this, end);
  }

  public double getH() {
    return hCost;
  }

  public double getF() {
    fCost=gCost+hCost;
    return fCost;
  }

}