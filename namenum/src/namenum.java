/*
 ID: chen_xu1
 TASK: namenum
 LANG: JAVA
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class namenum {

    static final char[][] keypad = new char[][]{{}, {},
    {'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'},
    {'J', 'K', 'L'}, {'M', 'N', 'O'}, {'P', 'R', 'S'},
    {'T', 'U', 'V'}, {'W', 'X', 'Y'}};

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter out = new PrintWriter(new FileWriter("namenum.out"));
        BufferedReader dictionary = new BufferedReader(new FileReader("dict.txt"));
        namenum instance = new namenum();

        List<String> validNames = new ArrayList<String>();
        String[] names;
        String[] dictNames = readNames(dictionary);

        String buffer = in.readLine();
        int size = buffer.length();
        short[] serialNum = new short[buffer.length()];
        for (int counter = 0; counter < size; counter++) {
            serialNum[counter] = (short) Integer.parseInt(buffer.charAt(counter) + "");
        }
        names = instance.nameGenerator(serialNum, 0);
        for (int counter = 0; counter < names.length; counter++) {
            if (isElementInArray(dictNames, names[counter])) {
                validNames.add(names[counter]);
            }
        }
        if (validNames.isEmpty()) {
            out.println("NONE");
            System.out.println("NONE");
        } else {
            String[] newNames = new String[validNames.size()];
            validNames.toArray(newNames);
            Arrays.sort(newNames);
            for (int counter = 0; counter < newNames.length; counter++) {
                out.println(newNames[counter]);
                System.out.println(newNames[counter]);
            }
        }

        out.close();
        System.exit(0);
    }

    static String[] readNames(BufferedReader input) throws IOException {
        String buffer;
        LinkedList<String> names = new LinkedList<String>();
        int counter = 0;
        buffer = input.readLine();
        while (!(buffer == null)) {
            names.add(buffer);
            buffer = input.readLine();
            counter++;
        }
        String[] output = new String[names.size()];
        names.toArray(output);
        return output;
    }

    String[] nameGenerator(short[] serialnum, int position) {
        ArrayList<String> names = new ArrayList<String>();
        if (position == serialnum.length - 1) {
            for (int counter = 0; counter < 3; counter++) {
                names.add(keypad[serialnum[position]][counter] + "");
            }
            String[] output = new String[names.size()];
            names.toArray(output);
            return output;
        }
        String[] previousNames = nameGenerator(serialnum, position + 1);
        for (int counter = 0; counter < 3; counter++) {
            for (int counter2 = 0; counter2 < previousNames.length; counter2++) {
                names.add(keypad[serialnum[position]][counter] + previousNames[counter2]);
            }
        }
        String[] output = new String[names.size()];
        names.toArray(output);
        return output;
    }

    static boolean isElementInArray(String[] array, String element) {
        for (int counter = 0; counter < array.length; counter++) {
            if (array[counter].equals(element)) {
                return true;
            }
        }
        return false;
    }
}
