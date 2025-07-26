package Graph;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "D", 2);
        graph.addEdge("B", "C", 3);
        graph.addEdge("C", "D", 4);
        graph.addEdge("D", "E", 5);
        graph.addEdge("E", "F", 6);
        graph.addEdge("E", "G", 7);
        graph.addEdge("F", "G", 8);

        graph.printGraph();

        System.out.println(graph.getVertexCount());
        System.out.println(graph.getEdgeCount());

        System.out.println(graph.containsEdge("A","B"));
        System.out.println(graph.containsEdge("A","C"));

        System.out.println(graph.containsVertex("A"));

        graph.removeEdge("D","E");
        graph.printGraph();

        graph.removeVertex("F");
        graph.printGraph();

        graph.addVertex("F");
        graph.printGraph();

        graph.addEdge("F", "E", 1);
        graph.addEdge("F", "G", 1);
        graph.printGraph();
        System.out.println(graph.hasPath("A","G",new HashMap<>()));
    }
}
