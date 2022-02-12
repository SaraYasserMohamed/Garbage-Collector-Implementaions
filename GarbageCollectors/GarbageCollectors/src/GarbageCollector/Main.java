package GarbageCollector;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        test test = new test();
        int[][] prerequisite = new int[8][2];
        prerequisite[0][0] = 0;
        prerequisite[1][0] = 3;
        prerequisite[2][0] = 5;
        prerequisite[3][0] = 6;
        prerequisite[4][0] = 11;
        prerequisite[5][0] = 13;
        prerequisite[6][0] = 15;
        prerequisite[7][0] = 17;

        prerequisite[0][1] = 10;
        prerequisite[1][1] = 18;
        prerequisite[2][1] = 5;
        prerequisite[3][1] = 11;
        prerequisite[4][1] = 14;
        prerequisite[5][1] = 1;
        prerequisite[6][1] = 1;
        prerequisite[7][1] = 4;

        test.canFinish(20,prerequisite);
    }
}
