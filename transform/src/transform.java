/*
 ID: chen_xu1
 TASK: transform
 LANG: JAVA
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class transform {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new FileWriter("transform.out"));
        String reader;
        int size = Integer.parseInt(in.readLine());
        boolean[][] square1 = new boolean[size][size];
        boolean[][] square2 = new boolean[size][size];
        for (int counterY = 0; counterY < size; counterY++) {
            reader = in.readLine();
            for (int counterX = 0; counterX < size; counterX++) {
                if (reader.charAt(counterX) == '@') {
                    square1[counterY][counterX] = true;
                } else {
                    square1[counterY][counterX] = false;
                }
            }
        }
        for (int counterY = 0; counterY < size; counterY++) {
            reader = in.readLine();
            for (int counterX = 0; counterX < size; counterX++) {
                if (reader.charAt(counterX) == '@') {
                    square2[counterY][counterX] = true;
                } else {
                    square2[counterY][counterX] = false;
                }
            }
        }

        out.close();
        System.exit(0);
    }
}
