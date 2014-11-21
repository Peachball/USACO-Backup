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

    public static BufferedReader in;
    public static PrintWriter out;
    public static int size;
    public static boolean[][] square1;
    public static boolean[][] square2;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        in = new BufferedReader(new FileReader("transform.in"));
        out = new PrintWriter(new FileWriter("transform.out"));
        String reader;
        size = Integer.parseInt(in.readLine());
        square1 = new boolean[size][size];
        square2 = new boolean[size][size];
        for (int counterY = 0; counterY < size; counterY++) {
            reader = in.readLine();
            for (int counterX = 0; counterX < size; counterX++) {
                square1[counterY][counterX] = reader.charAt(counterX) == '@';
            }
        }
        for (int counterY = 0; counterY < size; counterY++) {
            reader = in.readLine();
            for (int counterX = 0; counterX < size; counterX++) {
                square2[counterY][counterX] = reader.charAt(counterX) == '@';
            }
        }

        out.close();
        System.exit(0);
    }

    static boolean check90() {
        boolean status = true;
        return status;
    }

    static boolean check180() {
        boolean status = true;
        return status;
    }

    static boolean check270() {
        boolean status = true;
        return status;
    }

    static boolean checkXReflection() {
        boolean status = true;
        for (int counterY = 0; counterY < size && status; counterY++) {
            for (int counterX = 0; counterX < Math.round(size / 2); counterX++) {
                if (!((square1[counterY][counterX] && square2[counterY][size - 1 - counterX])
                        || !(square1[counterY][counterX] && square2[counterY][size - 1 - counterX]))) {
                    status = false;
                }
            }
        }
        return status;

    }

    static boolean checkYReflection() {
        boolean status = true;
        for (int counterX = 0; counterX < size && status; counterX++) {
            for (int counterY = 0; counterY < Math.round(size / 2); counterY++) {
                if (!((square1[counterY][counterX] && square2[size - 1 - counterY][counterX])
                        || !(square1[counterY][counterX] && square2[size - 1 - counterY][counterX]))) {
                    status = false;
                }
            }
        }
        return status;
    }

    static boolean[][] rotate90(boolean[][] given) {
        int size = given.length;
        boolean[][] buffer = new boolean[size][size];
        for (int counterY = 0; counterY < size; counterY++) {
            for (int counterX = 0; counterX < size; counterX++) {
                if (counterX <= counterY) {
                    buffer[counterY][counterX] = given[counterX+counterY][/*figure out what this should be...*/];
                }
            }
        }
        return buffer;
    }
}
