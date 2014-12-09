/**
 * Created by Jaylu
 * Get size of ring
 */
import java.io.*;

public class ringElection {

    public static void main(String[] args) throws IOException {
        while (true) {
            int num;
            BufferedReader buf;
            String str;
            buf = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input an integer:");
            str = buf.readLine();
            num = Integer.parseInt(str);
            System.out.println("String=" + str);
            System.out.println("Integer=" + str);
        }
    }
}
