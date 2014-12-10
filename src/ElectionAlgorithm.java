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
        System.out.println("| Running time： "+(endTime-startTime)/1000+"µs");
        System.out.println("***********************************************");
    }

    /**
     * as far
     */
    public static void asFar(){

        System.out.println("------------------------------------------------");
        System.out.println("| Using as far algorithm");
        System.out.println("|");

        long startTime = System.nanoTime();   //algorithm start time

        int count = 0;
        int x = ringElection.numNode + 2;
        for(int i = 0; i < ringElection.numNode; i++){
            for(int j = i+1; j < ringElection.numNode; j++) {
                count++;
                if (tempRing.get(i) > tempRing.get(j)){
                    break;
                }else if(x > tempRing.get(i)){
                    x = tempRing.get(i);
                }
            }
            for(int a = 0; a < i; a++){
                count++;
                if(tempRing.get(i) > tempRing.get(a)){
                    break;
                }else if(x > tempRing.get(i)){
                    x = tempRing.get(i);
                }
            }
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

        System.out.println("| The normal case:");
        System.out.println("| The leader is at " + (leaderAd + 1));
        System.out.println("| The message complexity is: " + count);
        System.out.println("| Running time： "+(endTime-startTime)/1000+"µs");

        // worst case
        long bStartTime = System.nanoTime();   //algorithm start time

        Collections.sort(tempIncreaseRing);
        int bCount = 0;
        int bx = ringElection.numNode + 2;
        for(int i = 0; i < ringElection.numNode; i++){
            for(int j = i+1; j < ringElection.numNode; j++) {
                bCount++;
                if (tempIncreaseRing.get(i) > tempIncreaseRing.get(j)){
                    break;
                }else if(bx > tempIncreaseRing.get(i)){
                    bx = tempIncreaseRing.get(i);
                }
            }
            for(int a = 0; a < i; a++){
                bCount++;
                if(tempIncreaseRing.get(i) > tempIncreaseRing.get(a)){
                    break;
                }else if(bx > tempIncreaseRing.get(i)){
                    bx = tempIncreaseRing.get(i);
                }
            }
        }

        int bLeaderAd = 0;
        for (int y = 0; y < ringElection.numNode; y++) {
            if (bx == tempIncreaseRing.get(y)) {
                bLeaderAd = y;
                System.out.println("| The leader id is " + tempIncreaseRing.get(y));
            }
            bCount++; // notification.
        }
        long bEndTime = System.nanoTime(); //algorithm end time

        System.out.println("|-----------------------------------------------");
        System.out.println("| The worst case:");
        System.out.println("| " + tempIncreaseRing);
        System.out.println("| The leader is at " + (bLeaderAd + 1));
        System.out.println("| The message complexity is: " + bCount);
        System.out.println("| Running time： "+(bEndTime-bStartTime)/1000+"µs");
        System.out.println("***********************************************");



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
        System.out.println("***********************************************");
    }
}
