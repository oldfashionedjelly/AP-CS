import java.util.*;

public class aStar {
  public static ArrayList<Node> findPath(Cube cube, Node start, Node goal, Node[] debris) {
    //openSet=places it can go; closedSet=places it can't go (debris, previous nodes)
    ArrayList<Node> openSet = new ArrayList<>();
    Set<Node> closedSet = new HashSet<>();

    //add debris
    for (Node d: debris) {
      closedSet.add(d);
    }

    start.setG(0);
    start.setH(goal);
    openSet.add(start);

    while (!openSet.isEmpty()) {
      //sort based on fCost
      Collections.sort(openSet, new Comparator<Node>() {
        public int compare(Node n1, Node n2) {
          return Double.compare(n1.getG() + n1.getH(), n2.getG() + n2.getH());
        }
      });

      Node current = openSet.remove(0);

      if (current.x == goal.x && current.y == goal.y && current.z == goal.z) {
        return reconstructPath(current);
      }

      closedSet.add(current);
			ArrayList<Node> neighbors = getNeighbors(cube, current);
      for (Node neighbor : neighbors) {
				
        if (closedSet.contains(neighbor)) {
          continue;
        }
        current.setG(start);
        double tempG = current.getG();
        
        neighbor.setG(start);
        if (tempG < neighbor.getG()) {
          neighbor.setG(tempG);
          neighbor.setH(goal);
          neighbor.parent = current;

          if (!openSet.contains(neighbor)) {
            openSet.add(neighbor);
          }
        }
      }
    }
    return null;
  }

  //reconstruct the path once the goal node is reached, going from goal to start
  public static ArrayList<Node> reconstructPath(Node current) {
    ArrayList<Node> path = new ArrayList<>();
    while (current != null) {
      path.add(current);
      current = current.parent;
    }
    Collections.reverse(path);
    return path;
  }

  public static ArrayList<Node> getNeighbors(Cube cube, Node node) {
      ArrayList<Node> neighbors = new ArrayList<>();
      int x = node.x, y = node.y, z = node.z;
      for (int dx = -1; dx <= 1; dx++) {
          for (int dy = -1; dy <= 1; dy++) {
              for (int dz = -1; dz <= 1; dz++) {
                  if (dx != 0 || dy != 0 || dz != 0) {
                      int nx = x + dx, ny = y + dy, nz = z + dz;
                      if (isValidCoordinate(cube, nx, ny, nz)) {
                          neighbors.add(cube.getNode(nx, ny, nz));
                      }
                  }
              }
          }
      }
      return neighbors;
  }
  public static boolean isValidCoordinate(Cube cube, int x, int y, int z) {
      return x >= 0 && x < cube.getSize() &&
             y >= 0 && y < cube.getSize() &&
             z >= 0 && z < cube.getSize();
  }
}