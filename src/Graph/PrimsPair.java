package Graph;

import Heap.GenericHeap;

import java.util.HashMap;

class PrimsPair implements Comparable<PrimsPair> {
    String vName;
    String acquiredFrom;
    int cost;
    @Override
    public int compareTo(PrimsPair o) {
        return this.cost - o.cost;
    }
}

//public Graph prims(){
//    Graph mst = new Graph();
//    HashMap<String, PrimsPair> map = new HashMap<>();
//    GenericHeap<PrimsPair> minHeap = new GenericHeap<PrimsPair>();
//
//    for (String v : vertices.keySet()) {
//        PrimsPair primsPair = new PrimsPair();
//        primsPair.vName = v;
//        primsPair.acquiredFrom = null;
//        primsPair.cost = Integer.MAX_VALUE;
//        map.put(v, primsPair);
//        minHeap.add(primsPair);
//    }
//    while (!minHeap.isEmpty()) {
//        PrimsPair rp = minHeap.delete();
//        map.remove(rp.vName);
//        if (rp.acquiredFrom != null) {
//            mst.addVertex(rp.vName);
//        }else{
//            mst.addVertex(rp.vName);
//            mst.addEdge(rp.acquiredFrom, rp.vName, rp.cost);
//        }
//        for (String neighbour : vertices.get(rp.vName).neighbours.keySet()) {
//            if (map.containsKey(neighbour)) {
//                int oc = map.get(neighbour).cost;
//                int nc = vertices.get(rp.vName).neighbours.get(neighbour);
//                if (nc < oc) {
//                    map.get(neighbour).acquiredFrom = rp.vName;
//                    map.get(neighbour).cost = nc;
//                    minHeap.remove(map.get(neighbour));
//                    minHeap.add(map.get(neighbour));
//                }
//            }
//        }
//    }
//    return mst;
//}
