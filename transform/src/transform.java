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
    public static int status;

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
        status = 7;
        do {
            if (check90()) {
                status = 1;
                continue;
            }
            if (check180()) {
                status = 2;
                continue;
            }
            if (check270()) {
                status = 3;
                continue;
            }
            if (checkXReflection(square1, square2)) {
                status = 4;
                continue;
            }
            if (checkXReflection(rotate90(square1), square2)) {
                status = 5;
                continue;
            }
            if (checkXReflection(rotate90(rotate90(square1)), square2)) {
                status = 5;
                continue;
            }
            if (checkXReflection(rotate90(rotate90(rotate90(square1))), square2)) {
                status = 5;
                continue;
            }
            if (checkArray(square1, square2)) {
                status = 6;
       
            }
        } while (false);
        System.out.println(status);
        out.println(status);
        out.close();
        System.exit(0);
    }

    static boolean check90() {
        boolean status = true;
        boolean[][] buffer;
        buffer = rotate90(square1);
        status = checkArray(buffer, square2);
        return status;
    }

    static boolean check180() {
        boolean status = true;
        boolean[][] buffer;
        buffer = rotate90(square1);
        buffer = rotate90(buffer);
        status = checkArray(buffer, square2);
        return status;
    }

    static boolean check270() {
        boolean status = true;
        boolean[][] buffer;
        buffer = rotate90(square1);
        buffer = rotate90(buffer);
        buffer = rotate90(buffer);
        status = checkArray(buffer, square2);
        return status;
    }

    static boolean checkXReflection(boolean[][] array1, boolean[][] array2) {
        boolean status = true;
        int size = array1.length;
        for (int counterY = 0; counterY < size && status; counterY++) {
            for (int counterX = 0; counterX < Math.round(size / 2); counterX++) {
                if ((array1[counterY][counterX] && array2[counterY][size - 1 - counterX])
                        || !(array1[counterY][counterX] && array2[counterY][size - 1 - counterX])) {
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
                buffer[counterY][counterX] = given[size - 1 - counterX][counterY];
            }
        }
        return buffer;
    }

    static boolean checkArray(boolean[][] array1, boolean[][] array2) {
        boolean similarity = true;
        int size = array1.length;
        for (int counterY = 0; counterY < size && similarity; counterY++) {
            for (int counterX = 0; counterX < size && similarity; counterX++) {
                if (!(array1[counterY][counterX] == array2[counterY][counterX])) {
                    similarity = false;
                }
            }
        }
        return similarity;
    }
}
