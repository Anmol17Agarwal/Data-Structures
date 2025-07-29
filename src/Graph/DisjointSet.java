package Graph;

import java.util.HashMap;

public class DisjointSet {

    HashMap<String, Node> map = new HashMap<>();

    private class Node {
        private String vName;
        private Node parent;
        private int rank;
    }

    public void create(String vName) {
        Node node = new Node();
        node.vName = vName;
        node.parent = node;
        node.rank = 0;
        map.put(vName, node);
    }

    public void union(String vName, String vName2) {
        Node node1 = map.get(vName);
        Node node2 = map.get(vName2);
        Node parent1 = findNode(node1);
        Node parent2 = findNode(node2);
        if (parent1.rank > parent2.rank) {
            parent2.parent = parent1;
        } else if (parent1.rank < parent2.rank) {
            parent1.parent = parent2;
        } else {
            parent2.parent = parent1;
            parent1.rank += 1;
        }
    }

    public String find(String vName) {
        return findNode(map.get(vName)).vName;
    }

    public Node findNode(Node node) {
        if (node.parent == node) {
            return node;
        }
        Node rr = findNode(node.parent);
        node.parent = rr;//path compression
        return rr;
    }
}
