/**
 * Created by Jaylu
 * Generating N unique random numbers in a ring
 */


import java.util.*;
import java.util.Random;
import java.util.HashSet;
//import org.apache.commons.collections.CollectionUtils;


public class makeRing {

    public static ArrayList<Integer> ring = new ArrayList();
    public static ArrayList<Integer> increaseRing = (ArrayList) ring.clone();

    public static void ring() {
        //generate [0-n) unique number
        // store in st


        int n = ringElection.numNode;
        Random rand = new Random();
        boolean[] bool = new boolean[n];

        int num = 0;
        for (int i = 0; i < n; i++) {
            do {
                //do again if has same number
                num = rand.nextInt(n);

            } while (bool[num]);

            bool[num] = true;

            ring.add(num + 1); //make number [1-n]
        }

        // best case for asFar
        ArrayList increaseRing = (ArrayList) ring.clone();
        Collections.sort(increaseRing);

        System.out.println("------------------------------------------------");
        System.out.println("The ring is:");
        System.out.println(ring);
        System.out.println(increaseRing);
        System.out.println("\n");
    }
}




