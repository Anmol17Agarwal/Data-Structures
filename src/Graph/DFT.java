package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class DFT {
    private class Pair {
        String vName;
        String psf;// path so far
    }

    public void dft(Graph g) {
        HashMap<String, Boolean> visited = new HashMap<>();
        LinkedList<Pair> stack = new LinkedList<>(); // stack for BFS

        ArrayList<String> keys = new ArrayList<>(g.vertices.keySet());

        for (String key : keys) {
            if (visited.containsKey(key)) {
                continue;
            }
            //create new pair
            Pair sp = new Pair();
            sp.vName = key;
            sp.psf = key;

            //add pair to stack
            stack.addFirst(sp);

            //while stack is not empty keep going on doing the work
            while (!stack.isEmpty()) {

                //remove the pair from the stack
                Pair rv = stack.removeFirst();

                if (visited.containsKey(rv.vName)) {
                    continue;
                }
                //mark the vertex as visited
                visited.put(rv.vName, true);

                System.out.println(rv.vName + " via " + rv.psf);

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
        }

    }
}
