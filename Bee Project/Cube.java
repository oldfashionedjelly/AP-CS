public class Cube {
    private Node[][][] nodes;
    private int size;
    
    public Cube(int s) {
      size = s;
      nodes = new Node[size][size][size];
      initializeNodes();
    }
  
    //fill the cube with nodes
    private void initializeNodes() {
      for (int x = 0; x < nodes.length; x++) {
        for (int y = 0; y < nodes[0].length; y++) {
          for (int z = 0; z < nodes[0][0].length; z++) {
            nodes[x][y][z] = new Node(x, y, z);
          }
        }
      }
    }
  
    public Node getNode(int x, int y, int z) {
      return nodes[x][y][z];
    }
  
    public int getSize() {
      return size;
    }
  }
  