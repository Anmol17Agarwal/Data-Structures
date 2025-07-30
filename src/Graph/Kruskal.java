package Graph;

import java.util.*;

public class Kruskal {
    private class Edge {
        String v1;
        String v2;
        int weight;

        public Edge(String v1, String v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
    }

    private List<Edge> edges = new ArrayList<>();
    private Set<String> vertices = new HashSet<>();

    public void addEdge(String v1, String v2, int weight) {
        edges.add(new Edge(v1, v2, weight));
        vertices.add(v1);
        vertices.add(v2);
    }

    public void kruskalMST() {
        // Sort edges by weight
        edges.sort(Comparator.comparingInt(e -> e.weight));

        DisjointSet ds = new DisjointSet();
        for (String v : vertices) {
            ds.create(v);
        }

        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            String parent1 = ds.find(edge.v1);
            String parent2 = ds.find(edge.v2);

            if (!parent1.equals(parent2)) {
                ds.union(edge.v1, edge.v2);
                mst.add(edge);
            }
        }

        // Print MST
        int totalWeight = 0;
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.v1 + " -- " + edge.v2 + " = " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total Weight of MST: " + totalWeight);
    }

    // Example usage
    public static void main(String[] args) {
        Kruskal graph = new Kruskal();

        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 1);
        graph.addEdge("C", "B", 2);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 8);
        graph.addEdge("D", "E", 6);
        graph.addEdge("E", "F", 3);
        graph.addEdge("D", "F", 7);

        graph.kruskalMST();
    }
}

