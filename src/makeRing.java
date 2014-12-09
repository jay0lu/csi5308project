/**
 * Created by Jaylu
 * Generating N unique random numbers in a ring
 */

import java.util.HashSet;
import java.util.Random;


public class makeRing {

    // use hashset to generating unique array
    public static void main(String[] args) {
        Random rand = new Random();
        int e;
        int i;
        int g = 10;  // nodes number
        HashSet<Integer> randomNumbers = new HashSet<Integer>();

        for (i = 0; i < g; i++) {
            e = rand.nextInt(100);  //number range
            randomNumbers.add(e);
            if (randomNumbers.size() <= 10) {
                if (randomNumbers.size() == 10) {
                    g = 10;
                }
                g++;
                randomNumbers.add(e);
            }
        }
        System.out.println("Ten Unique random numbers from 1 to 10 are  : " + randomNumbers);
    }
}
