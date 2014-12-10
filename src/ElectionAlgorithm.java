/**
 * Created by Jaylu
 */

import java.util.ArrayList;

/**
 * all the way
 * use one for() to compare i-n, another for() to compare 0-i.
 * use count to calculate the message complexity.
 */
public class ElectionAlgorithm {
    private static ArrayList<Integer> tempRing = (ArrayList) makeRing.ring.clone(); //make new ring to compare

    public static void allTheWay() {
        long startTime = System.nanoTime();   //algorithm start time
        int count = 0;
        int x = ringElection.numNode + 2; //initialize x bigger than nodeId, store the smallest id.
        for (int i = 0; i < ringElection.numNode; i++) {
            count++;
            for (int j = i + 1; j < ringElection.numNode; j++) {
                if (tempRing.get(j) > tempRing.get(i)) {
                    if (x > tempRing.get(i)) {
                        x = tempRing.get(i);
                    }
                }
                count++;
            }
            for (int a = 0; a < i; a++) {
                if (tempRing.get(a) > tempRing.get(i)) {
                    if (x > tempRing.get(a)) {
                        x = tempRing.get(i);
                    }
                }
                count++;
            }
        }

        int leaderAd = 0; //leader address in ring
        for (int y = 0; y < ringElection.numNode; y++) {
            if (x == tempRing.get(y)) {
                leaderAd = y;
                System.out.println("The leader id is " + tempRing.get(y));
            }
            count++;
        }
        long endTime = System.nanoTime(); //algorithm end time

        System.out.println("| The leader is at " + (leaderAd + 1));
        System.out.println("------------------------------------------------");
        System.out.println("| Using All the way algorithm");
        System.out.println("| The message complexity is: " + count);
        System.out.println("| Running time： "+(endTime-startTime)/1000+"µs");
        System.out.println("***********************************************");
    }

    /**
     * as far
     */
    public static void asFar(){
        

    }

}
