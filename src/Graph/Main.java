package Graph;

import BinarySearchTree.BST;

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

        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "D", 2);
        graph.addEdge("B", "C", 3);
        graph.addEdge("C", "D", 4);
        graph.addEdge("D", "E", 5);
        graph.addEdge("E", "F", 6);
        graph.addEdge("E", "G", 7);
        graph.addEdge("F", "G", 8);

        graph.printGraph();

//        System.out.println(graph.getVertexCount());
//        System.out.println(graph.getEdgeCount());
//
//        System.out.println(graph.containsEdge("A","B"));
//        System.out.println(graph.containsEdge("A","C"));
//
//        System.out.println(graph.containsVertex("A"));
//
//        graph.removeEdge("A","D");
//        graph.printGraph();
//
//        graph.removeVertex("F");
//        graph.printGraph();
//
//        graph.addVertex("F");
//        graph.printGraph();

//        graph.addEdge("F", "E", 1);
//        graph.addEdge("F", "G", 1);
//        graph.printGraph();
//        System.out.println(graph.hasPath("A","G",new HashMap<>()));

        BFS bfs = new BFS();
        DFS dfs = new DFS();
//        System.out.println(bfs.bfs(graph,"A","G"));
//        System.out.println(dfs.dfs(graph,"A","G"));
//        BFT bft = new BFT();
//        bft.bft(graph);
//        DFT dft = new DFT();
//        dft.dft(graph);
//        IsCyclic isCyclic = new IsCyclic();
//        System.out.println(isCyclic.isCyclic(graph));
        IsConnected isConnected = new IsConnected();
        System.out.println(isConnected.isConnected(graph));
    }
}
