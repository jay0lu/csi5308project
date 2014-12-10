/**
 * Created by Jaylu
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * all the way
 * use one for() to compare i-n, another for() to compare 0-i.
 * use count to calculate the message complexity.
 */
public class ElectionAlgorithm {

    private static ArrayList<Integer> tempRing = (ArrayList) makeRing.ring.clone(); //make new ring to compare
    private static ArrayList<Integer> tempIncreaseRing = (ArrayList) makeRing.ring.clone();
    private static ArrayList<Integer> tempDecreaseRing = (ArrayList) makeRing.ring.clone();
    //private static ArrayList<Integer> tempIncreaseRing = (ArrayList) makeRing.increaseRing.clone(); //clone cannot be used out of class

    public static void allTheWay() {

        System.out.println("------------------------------------------------");
        System.out.println("| Using All the way algorithm");
        System.out.println("|");

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
                System.out.println("| The leader id is " + tempRing.get(y));
            }
        }
        long endTime = System.nanoTime(); //algorithm end time

        System.out.println("| The leader is at " + (leaderAd + 1));
        System.out.println("| The message complexity is: " + count);
        System.out.println("| Running time： "+(endTime - startTime)/1000+"µs");
        System.out.println("***********************************************\n");
    }

    /**
     * as far
     */
    public static void asFar() {

        System.out.println("------------------------------------------------");
        System.out.println("| Using as far algorithm");

        long startTime = System.nanoTime();   //algorithm start time

        int count = 0;
        int x = ringElection.numNode + 2;
        for (int i = 0; i < ringElection.numNode; i++) {
            for (int j = i + 1; j < ringElection.numNode; j++) {
                count++;
                if (tempRing.get(i) > tempRing.get(j)) {
//                    count++;
                    break;
                } else if (x > tempRing.get(i)) {
                    x = tempRing.get(i);
//                    count++;
                }
            }
            for (int a = 0; a < i; a++) {
                if (tempRing.get(i) > tempRing.get(a)) {
//                    count++;
                    break;
                } else if (x > tempRing.get(i)) {
                    x = tempRing.get(i);
//                    count++;
                }
            }
            count++;
        }

        int leaderAd = 0;
        for (int y = 0; y < ringElection.numNode; y++) {
            if (x == tempRing.get(y)) {
                leaderAd = y;
                System.out.println("| The leader id is " + tempRing.get(y));
            }
            count++; // notification.
        }
        long endTime = System.nanoTime(); //algorithm end time

        System.out.println("|");
        System.out.println("| The normal case:");
        System.out.println("| The leader is at " + (leaderAd + 1));
        System.out.println("| The message complexity is: " + count);
        System.out.println("| Running time： " + (endTime - startTime) / 1000 + "µs");

        // worst case
        long wStartTime = System.nanoTime();   //algorithm start time

        Collections.sort(tempIncreaseRing);
        int wCount = 0;
        int wx = ringElection.numNode + 2;
        for (int i = 0; i < ringElection.numNode; i++) {
            for (int j = i + 1; j < ringElection.numNode; j++) {
                wCount++;
                if (tempIncreaseRing.get(i) > tempIncreaseRing.get(j)) {
//                    wCount++;
                    break;
                } else if (wx > tempIncreaseRing.get(i)) {
                    wx = tempIncreaseRing.get(i);
//                    wCount++;
                }
            }
            for (int a = 0; a < i; a++) {
                if (tempIncreaseRing.get(i) > tempIncreaseRing.get(a)) {
//                    wCount++;
                    break;
                } else if (wx > tempIncreaseRing.get(i)) {
                    wx = tempIncreaseRing.get(i);
//                    wCount++;
                }
            }
            wCount++;
        }

        int wLeaderAd = 0;
        for (int y = 0; y < ringElection.numNode; y++) {
            if (wx == tempIncreaseRing.get(y)) {
                wLeaderAd = y;
//                System.out.println("| The leader id is " + tempIncreaseRing.get(y));
            }
            wCount++; // notification.
        }
        long wEndTime = System.nanoTime(); //algorithm end time

        System.out.println("|-----------------------------------------------");
        System.out.println("| The worst case:");
        System.out.println("| " + tempIncreaseRing);
        System.out.println("| The leader is at " + (wLeaderAd + 1));
        System.out.println("| The message complexity is: " + wCount);
        System.out.println("| Running time： " + (wEndTime - wStartTime) / 1000 + "µs");
        System.out.println("|-----------------------------------------------");

        //best case
        Collections.sort(tempIncreaseRing);
        int m = 0;
        for(int bs = ringElection.numNode - 1; bs > -1; bs--){
            tempDecreaseRing.add(m,tempIncreaseRing.get(bs));
            tempDecreaseRing.remove(10);
            m++;
        }
//        System.out.println(tempDecreaseRing);

        long bStartTime = System.nanoTime();   //algorithm start time

        int bCount = 0;
        int bx = ringElection.numNode + 2;
        for(int i = 0; i < ringElection.numNode; i++){
            for(int j = i+1; j < ringElection.numNode; j++) {
                bCount++;
                if (tempDecreaseRing.get(i) > tempDecreaseRing.get(j)){
//                    bCount++;
                    break;
                }else if(bx > tempDecreaseRing.get(i)){
                    bx = tempDecreaseRing.get(i);
//                    bCount++;
                }
            }
            for(int a = 0; a < i; a++){
                if(tempDecreaseRing.get(i) > tempDecreaseRing.get(a)){
//                    bCount++;
                    break;
                }else if(bx > tempDecreaseRing.get(i)){
                    bx = tempDecreaseRing.get(i);
//                    bCount++;
                }
            }
            bCount++;
        }

        int bLeaderAd = 0;
        for (int y = 0; y < ringElection.numNode; y++) {
            if (bx == tempDecreaseRing.get(y)) {
                bLeaderAd = y;
//                System.out.println("| The leader id is " + tempDecreaseRing.get(y));
            }
            bCount++; // notification.
        }
        long bEndTime = System.nanoTime(); //algorithm end time

        System.out.println("| The best case:");
        System.out.println("| " + tempDecreaseRing);
        System.out.println("| The leader is at " + (bLeaderAd + 1));
        System.out.println("| The message complexity is: " + bCount);
        System.out.println("| Running time： "+(bEndTime-bStartTime)/1000+"µs");
        System.out.println("***********************************************\n");
    }


    /**
     * alternate
     */
    public static void alternate(){
        System.out.println("------------------------------------------------");
        System.out.println("| Using alternate algorithm");
        System.out.println("|");

        long startTime = System.nanoTime();   //algorithm start time

        ArrayList<Integer> tempStatu = new ArrayList(); //use to define the node is passive or not.
        for(int t = 0; t < ringElection.numNode; t++){
            tempStatu.add(0);
        }

        int count = 0;
        int st = 1; //stage number
        if(st%2 != 0){ // odd stage

        }

        int leaderAd = 0;
        //add notification
        long endTime = System.nanoTime(); //algorithm end time

        System.out.println("| The leader is at " + (leaderAd + 1));
        System.out.println("| The message complexity is: " + count);
        System.out.println("| Running time： "+(endTime-startTime)/1000+"µs");
        System.out.println("***********************************************\n");
    }
}
