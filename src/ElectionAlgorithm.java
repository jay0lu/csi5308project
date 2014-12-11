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
                    break;
                } else if (x > tempRing.get(i)) {
                    x = tempRing.get(i);
                }
            }
            for (int a = 0; a < i; a++) {
                if (tempRing.get(i) > tempRing.get(a)) {
                    break;
                } else if (x > tempRing.get(i)) {
                    x = tempRing.get(i);
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
                    break;
                } else if (wx > tempIncreaseRing.get(i)) {
                    wx = tempIncreaseRing.get(i);
                }
            }
            for (int a = 0; a < i; a++) {
                if (tempIncreaseRing.get(i) > tempIncreaseRing.get(a)) {
                    break;
                } else if (wx > tempIncreaseRing.get(i)) {
                    wx = tempIncreaseRing.get(i);
                }
            }
            wCount++;
        }

        int wLeaderAd = 0;
        for (int y = 0; y < ringElection.numNode; y++) {
            if (wx == tempIncreaseRing.get(y)) {
                wLeaderAd = y;
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
                    break;
                }else if(bx > tempDecreaseRing.get(i)){
                    bx = tempDecreaseRing.get(i);
                }
            }
            for(int a = 0; a < i; a++){
                if(tempDecreaseRing.get(i) > tempDecreaseRing.get(a)){
                    break;
                }else if(bx > tempDecreaseRing.get(i)){
                    bx = tempDecreaseRing.get(i);
                }
            }
            bCount++;
        }

        int bLeaderAd = 0;
        for (int y = 0; y < ringElection.numNode; y++) {
            if (bx == tempDecreaseRing.get(y)) {
                bLeaderAd = y;
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

        ArrayList<Integer> tempState = new ArrayList(); //use to define the node is passive or not. 1 is passive
        for(int t = 0; t < ringElection.numNode; t++){
            tempState.add(0);
        }
//        System.out.println(tempStatu);

        int count = 0;
        int dowhile = 0; //count number of passive node.
//        int oJump = 0; // jump passive node in odd stage
        int eJump = 0; // jump passive node in even stage
        int nodeLeft = ringElection.numNode;
        int x = ringElection.numNode+2; //store the small id
        int st = 0; //stage number
        while(dowhile != ringElection.numNode-1) {
            st++;

            //odd stage
            if(st%2 != 0){
                for(int i = 0; i < ringElection.numNode-1; i++){
                    int jump = 0; //jump passive node
                    if(tempState.get(i) == 0){  //self node is passive

                    }else if(tempState.get(i + 1) == 0){  //next node is passive
                        jump = i + 1;
                    }
                    while(tempState.get(jump) == 0 && jump < ringElection.numNode - 1){
                        jump++;
                    }
                    if(tempRing.get(i) < tempRing.get(jump)){
                        tempState.add(jump,1);
                        tempState.remove(jump+1); //change state
                    }else{
                        if(tempRing.get(i) < tempRing.get(i + 1)){
                            tempState.add(i+1, 1);
                            tempState.remove(i + 2);
                        }
                    }
                    for(int i = 0; i < ringElection.numNode - 1; i++){
                        int jump = 0;
                        if(tempState)
                        if(tempState.get(i) == 0){
                            jump = i;
                        }

                    }
                }
            }
        }



            for(int i = 0; i < ringElection.numNode; i++) {
                if (tempStatu.get(i) == 0) {
                    dowhile++;
                }
            }




        int leaderAd = 0;
        //add notification
        for (int z = 0; z < ringElection.numNode; z++) {
            if (x == tempRing.get(z)) {
                leaderAd = z;
                System.out.println("| The leader is "+tempRing.get(z));
            }
            count++; // notification.
        }

        long endTime = System.nanoTime(); //algorithm end time

        System.out.println("stage number "+st);
        System.out.println("| The leader is at " + (leaderAd + 1));
        System.out.println("| The message complexity is: " + st*ringElection.numNode);
        System.out.println("| Running time： "+(endTime-startTime)/1000+"µs");
        System.out.println("***********************************************\n");
    }
}
