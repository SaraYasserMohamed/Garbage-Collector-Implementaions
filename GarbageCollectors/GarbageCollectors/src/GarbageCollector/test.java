package GarbageCollector;

import java.util.HashSet;
import java.util.LinkedList;

public class test {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashSet<Integer> taken = new HashSet<Integer>();
        boolean independent = false;
        LinkedList<Integer> [] pre = new LinkedList<Integer> [5];
        if(prerequisites.length == 0){
            return true;
        }
        for (int i = 0; i < prerequisites.length; i++) {

        }


        return true;
    }
}
