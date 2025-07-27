package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class DFS {
    private class Pair {
        String vName;
        String psf;// path so far
    }

    public boolean dfs(Graph g, String src, String dest) {
        HashMap<String, Boolean> visited = new HashMap<>();
        LinkedList<DFS.Pair> stack = new LinkedList<>(); // stack for DFS

        //create new pair
        Pair sp = new Pair();
        sp.vName = src;
        sp.psf = src;

        //add pair to stack
        stack.addFirst(sp);

        //while stack is not empty keep going on doing the work
        while (!stack.isEmpty()) {

            //remove the pair from the stack
            Pair rv = stack.removeFirst();

            if(visited.containsKey(rv.vName)){
                continue;
            }
            //mark the vertex as visited
            visited.put(rv.vName, true);

            if (g.containsEdge(rv.vName, dest)) {
                System.out.println(rv.psf+"->"+dest);
                return true;
            }

            //neighbours
            Graph.Vertex vertex = g.vertices.get(rv.vName);
            ArrayList<String> neighbours = new ArrayList<>(vertex.neighbours.keySet());

            for (String neighbour : neighbours) {
                if (!visited.containsKey(neighbour)) {
                    Pair np = new Pair();
                    np.vName = neighbour;
                    np.psf = rv.psf + "->" + neighbour;
                    stack.addFirst(np);
                }
            }
        }
        return false;
    }
}
