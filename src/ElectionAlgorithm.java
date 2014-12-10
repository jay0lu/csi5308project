/**
 * Created by Jaylu
 */

import java.util.ArrayList;

public class ElectionAlgorithm {
    private static ArrayList<Integer> tempRing = (ArrayList)makeRing.ring.clone(); //make new ring to compare
    public static void allTheWay(){
        int count = 0;
        int x = 19999;
        for(int i = 0;i < ringElection.numNode; i++){
            count++;
            for(int j = i+1; j < ringElection.numNode; j++){
                if(tempRing.get(j) > tempRing.get(i)){
                    if(x > tempRing.get(i)){
                        x = tempRing.get(i);
                    }
                }
                count++;
            }
            for(int a = 0;a < i; a++){
                if(tempRing.get(a) > tempRing.get(i)){
                    if(x > tempRing.get(a)) {
                        x = tempRing.get(i);
                    }
                }
                count++;
            }

        }
        for(int y = 0; y < ringElection.numNode; y++){
            if (x == tempRing.get(y)) {
                System.out.println("Leader is " + tempRing.get(y) + " , at " + (y + 1));
                System.out.println("The message complexity is: "+count);
            }
        }
        System.out.println("***********************************************");
    }
}
