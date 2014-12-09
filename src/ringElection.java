/**
 * Created by Jaylu
 * Get size of ring
 */
import java.io.*;

public class ringElection {

    public static void main(String[] args) throws IOException {
        while (true) {
            int num;
            int numNode = 0;
            BufferedReader buf;
            String str;
            buf = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("-----------------------------------");
            System.out.println("Ring Election Algorithm Comparison");
            System.out.println("-----------------------------------");
            System.out.println("Input the number of nodes(smaller than 10000):");
            str = buf.readLine();
            num = Integer.parseInt(str); // string to integer
            if(num > 10000)
                System.out.println("The number is too big to display, please enter a number smaller than 10000.");
            else
                numNode = num;

            // System.out.println("String=" + str);
            // System.out.println("Integer=" + str);
            System.out.println("The number of nodes in ring is: " + numNode);
        }
    }
}
