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
    static String[] dictNames;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter out = new PrintWriter(new FileWriter("namenum.out"));
        BufferedReader dictionary = new BufferedReader(new FileReader("dict.txt"));
        namenum instance = new namenum();

        List<String> validNames = new ArrayList<String>();
        String[] names;
        dictNames = readNames(dictionary);

        String buffer = in.readLine();
        int size = buffer.length();
        short[] serialNum = new short[buffer.length()];
        for (int counter = 0; counter < size; counter++) {
            serialNum[counter] = (short) Integer.parseInt(buffer.charAt(counter) + "");
        }
        names = instance.nameGen2(serialNum);
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

    static String[] nameGen2(short[] serialnum) {
        String name;
        ArrayList<String> valids = new ArrayList<String>();
        short[] counters = new short[serialnum.length];
        for (int counter = 0; counter < (int) Math.pow(3, serialnum.length); counter++) {
            name = null;
            for (int counter2 = 0; counter2 < serialnum.length; counter2++) {
                if (name == null) {
                    name = keypad[serialnum[counter2]][counters[counter2]] + "";
                } else {
                    name = name + keypad[serialnum[counter2]][counters[counter2]];
                }
            }
            if (isElementInArray(dictNames, name)) {
                valids.add(name);

            }
            counters[0]++;
            for (int counter2 = 0; counter2 < counters.length; counter2++) {
                if (counters[counters.length - 1] > 2) {
                    String[] names = new String[valids.size()];
                    valids.toArray(names);
                    return names;
                }
                if (counters[counter2] > 2) {
                    counters[counter2] = 0;
                    counters[counter2 + 1]++;
                }
            }
        }
        String[] names = new String[valids.size()];
        valids.toArray(names);
        return names;
    }

    static boolean isElementInArray(String[] array, String element) {
        int position1 = 0;
        int position2 = array.length;
        int status;
        while (position1 != position2) {
            for (int counter = 0; counter < element.length(); counter++) {
                
            }
        }
        return false;
    }

    static short compare(String element1, String element2) {
        int minSize = 0;
        if (element1.length() < element2.length()) {
            minSize = element1.length();
        } else {
            minSize = element2.length();
        }
        for (int counter = 0; counter < minSize; counter++) {
            if(element1.charAt(counter) > element2.charAt(counter)){
                return 1;
            }
            if(element1.charAt(counter)<element2.charAt(counter)){
                return 2;
            }
        }
        return 0;
    }// 0 is equalivalent
    //1 is greater than (z would be the greatest)
    //2 is less than (a would be the least)
    // 
}
