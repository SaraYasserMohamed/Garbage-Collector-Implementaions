package GarbageCollector;

import java.util.*;

public class copyGarbageCollector {
    LinkedList<Integer> roots;
    Heap heap;
    int j = 0;

    public copyGarbageCollector(Heap heap, LinkedList<Integer> roots){
        this.roots=roots;
        this.heap=heap;
    }

    public Heap createHeap(){
        Heap newHeap = new Heap();
        Queue<Integer> vertices = new LinkedList<>(roots);
        int current;
//adding vertices
        while (!vertices.isEmpty()) {
            current = vertices.poll();
            if (newHeap.getNode(current) == null) {
                newHeap.addVertex(current, j, j +(heap.getNode(current).getMemoryEnd() - heap.getNode(current).getMemoryStart()));
                j = j +(heap.getNode(current).getMemoryEnd() - heap.getNode(current).getMemoryStart()) + 1;
                ArrayList<Integer> children = heap.getChildren(current);
                vertices.addAll(children);
            }
        }
//adding edges
        for (Map.Entry<Node, ArrayList<Node>> nodeArrayListEntry : newHeap.getAdjNodes().entrySet()) {
            Node node = (Node) ((Map.Entry) nodeArrayListEntry).getKey();
            ArrayList<Integer> children = heap.getChildren(node.getValue());
            for (Integer child : children) {
                if (newHeap.getNode(child) != null) {
                    newHeap.addEdge(node.getValue(), child);
                }
            }
        }
        return newHeap;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashSet<Integer> taken = new HashSet<Integer>();
        boolean independent = false;
        for (int i = 0; i < prerequisites.length; i++){
            for (int j = 0; j < prerequisites.length; j++){
                if (prerequisites[i][0] == prerequisites[j][1] && i != j && !taken.contains(prerequisites[j][0])){
                    independent = true;
                    if(prerequisites[i][1] == prerequisites[j][0]){
                        return false;
                    }
                }
            }
            if (numCourses == 0 ){
                return false;
            }
            if (!independent && taken.add(prerequisites[i][0])){
                numCourses --;
            }
            independent = false;
        }

        for (int i = 0; i < prerequisites.length; i++){
            for (int j = 0; j < prerequisites.length; j++){
                if (!taken.contains(prerequisites[i][0])){
                    independent = true;
                }
            }
            if (numCourses == 0 && i == prerequisites.length-1){
                return false;
            }
            if (!independent){
                taken.add(prerequisites[i][1]);
                numCourses --;
            }
        }
        return true;
    }
}
