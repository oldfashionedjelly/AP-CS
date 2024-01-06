import java.util.*;
public class BruteForce {
  int[][] lengths;
  BruteForce(int[][] distances) {
    this.lengths = distances;
  } 
  ArrayList<String> places = new ArrayList<>(Arrays.asList("H", "A", "B", "C"));
    ArrayList<ArrayList<String>> callBruteForce(int[][] lengths, ArrayList<Integer> path_sums)
  {
    ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
    ArrayList<String> toVisit = new ArrayList<String>(places);
    toVisit.remove(0);
    int sum = 0;
    ArrayList<String> path = new ArrayList<String>();
    path.add(places.get(0));
    mainBruteForce(path, toVisit, paths, sum, path_sums);
    return paths;
  }
  void mainBruteForce(ArrayList<String> path, ArrayList<String> toVisit, ArrayList<ArrayList<String>> paths, int sum, ArrayList<Integer> path_sums)
  {
    if (toVisit.size() == 0)
    {
      path.add(places.get(0));
      paths.add(path);
      for(int p = 0; p < path.size()-1; p++)
      {
        int current = places.indexOf(path.get(p));
        int next = places.indexOf(path.get(p+1));
        sum += (lengths[current][next]);
      }
      path_sums.add(sum);
    } 
    else
    {
      for(int i = 0; i < toVisit.size(); i++)
      {
        String loc = toVisit.get(i);
        path.add(loc);
        ArrayList<String> new_toVisit = new ArrayList<String>(toVisit);
        new_toVisit.remove(i);
        mainBruteForce(new ArrayList<String>(path), new_toVisit, paths, sum, path_sums);
        path.remove(path.size()-1);
      }
    }
  }
  String findPath(int[][] lengths) {
    ArrayList<Integer> path_sums = new ArrayList<Integer>();
    ArrayList<ArrayList<String>> paths = callBruteForce(lengths, path_sums);
    int min_sum = Integer.MAX_VALUE;
    ArrayList<String> shortest_path = new ArrayList<String>();
    for(int j = 0; j < paths.size(); j++)
    {
      ArrayList<String> curr = paths.get(j);
      int s = path_sums.get(j);
      if(s < min_sum)
      {
        min_sum = s;
        shortest_path = curr;
      }
    }
    return "Shortest path: " + shortest_path + "; Distance: " + min_sum;
  }
}