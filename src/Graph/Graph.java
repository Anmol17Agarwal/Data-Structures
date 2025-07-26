package Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private class Vertex {
        HashMap<String, Integer> neighbours= new HashMap<>();
    }

    HashMap<String, Vertex> vertices;

    Graph() {
        vertices = new HashMap<>();
    }

    public int getVertexCount() {
        return vertices.size();
    }

    public boolean containsVertex(String vName) {
        return vertices.containsKey(vName);
    }

    public void addVertex(String vName) {
        vertices.put(vName, new Vertex());
    }

    public void removeVertex(String vName) {
        Vertex vertex = vertices.get(vName);
        ArrayList<String> keys = new ArrayList<>(vertex.neighbours.keySet());
        for (String key : keys) {
            Vertex neighbourVertex = vertices.get(key);
            neighbourVertex.neighbours.remove(vName);

        }
        vertices.remove(vName);
    }

    public int getEdgeCount() {
        int count = 0;
        ArrayList<String> edges = new ArrayList<>(vertices.keySet());
        for (String edge : edges) {
            Vertex vertex = vertices.get(edge);
            count += vertex.neighbours.size();
        }
        return count / 2;
    }

    public boolean containsEdge(String vName, String vName2) {
        Vertex vertex = vertices.get(vName);
        Vertex vertex2 = vertices.get(vName2);
        if (vertex == null || vertex2 == null || !vertex.neighbours.containsKey(vName2)) {
            return false;
        }
        return true;
    }

    public void addEdge(String vName, String vName2, int cost) {
        Vertex vertex = vertices.get(vName);
        Vertex vertex2 = vertices.get(vName2);
        if (vertex == null || vertex2 == null || vertex.neighbours.containsKey(vName2)) {
            return;
        }
        vertex.neighbours.put(vName2, cost);// 2k neighbours put C with given cost
        vertex2.neighbours.put(vName, cost);// 4k neighbours put A with given cost
    }

    public void removeEdge(String vName, String vName2) {
        Vertex vertex = vertices.get(vName);
        Vertex vertex2 = vertices.get(vName2);
        if (vertex == null || vertex2 == null || !vertex.neighbours.containsKey(vName2)) {
            return;
        }
        vertex.neighbours.remove(vName2);// 2k neighbours remove C
        vertex2.neighbours.remove(vName);// 4k neighbours remove A
    }

    public void printGraph() {
        System.out.println("======================");
        ArrayList<String> keys = new ArrayList<>(vertices.keySet());
        for (String key : keys) {
            Vertex vertex = vertices.get(key);
            System.out.println(key+":->"+vertex.neighbours);
        }

        System.out.println("======================");
    }

    public boolean hasPath(String vName, String vName2, HashMap<String, Boolean> visited) {
        Graph g = new Graph();
        visited.put(vName, true);
        if(g.containsEdge(vName,vName2)){
            return true;
        }
        Vertex vertex = vertices.get(vName);
        if (vertex == null) return false;
        ArrayList<String> keys = new ArrayList<>(vertex.neighbours.keySet());
        for (String key : keys) {
            if(!visited.containsKey(key) && g.hasPath(key,vName2,visited)){
                return true;
            }
        }
        return false;
    }
}

