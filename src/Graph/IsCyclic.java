package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class IsCyclic {
    private class Pair {
        String vName;
        String psf;// path so far
    }

    public boolean isCyclic(Graph g) {
        HashMap<String, Boolean> visited = new HashMap<>();
        LinkedList<Pair> queue = new LinkedList<>(); // queue for BFS

        ArrayList<String> keys = new ArrayList<>(g.vertices.keySet());

        for (String key : keys) {
            if (visited.containsKey(key)) {
                continue;
            }
            //create new pair
            Pair sp = new Pair();
            sp.vName = key;
            sp.psf = key;

            //add pair to queue
            queue.addLast(sp);

            //while queue is not empty keep going on doing the work
            while (!queue.isEmpty()) {

                //remove the pair from the queue
                Pair rv = queue.removeFirst();

                if (visited.containsKey(rv.vName)) {
                    return true;
                }
                //mark the vertex as visited
                visited.put(rv.vName, true);

                System.out.println(rv.vName + "->" + rv.psf);

                //neighbours
                Graph.Vertex vertex = g.vertices.get(rv.vName);
                ArrayList<String> neighbours = new ArrayList<>(vertex.neighbours.keySet());

                for (String neighbour : neighbours) {
                    if (!visited.containsKey(neighbour)) {
                        Pair np = new Pair();
                        np.vName = neighbour;
                        np.psf = rv.psf + "->" + neighbour;
                        queue.addLast(np);
                    }
                }

            }
        }
        return false;
    }
}
