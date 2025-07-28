package Graph;

public class IsTree {
    public boolean isTree(Graph g) {
        IsConnected isConnectedObj = new IsConnected();
        IsCyclic isCyclicObj = new IsCyclic();
        return isConnectedObj.isConnected(g) && !isCyclicObj.isCyclic(g);
    }
}
