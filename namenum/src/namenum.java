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
        ArrayList<String> names = new ArrayList<String>();
        dictNames = readDictionary(dictionary);

        String buffer = in.readLine();
        int size = buffer.length();
        short[] serialNum = new short[buffer.length()];
        for (int counter = 0; counter < size; counter++) {
            serialNum[counter] = (short) Integer.parseInt(buffer.charAt(counter) + "");
        }
        //Convert Dictionary name into number.
        for (int counter = 0; counter < dictNames.length; counter++) {

            short[] buffer2 = new short[dictNames[counter].length()];

            //Loop to convert each char into a short for the buffer
            for (int counter2 = 0; counter2 < dictNames[counter].length(); counter2++) {

                //Loop to determine which character to check
                for (int counter5 = 0; counter5 < dictNames[counter].length(); counter5++) {

                    //Another loop to figure out which number each letter is...
                    //loop to figure out keypad position
                    for (int counter3 = 2; counter3 < keypad.length; counter3++) {

                        //Second loop to check the letter
                        for (int counter4 = 0; counter4 < 3; counter4++) {
                            if (keypad[counter3][counter4] == dictNames[counter].charAt(counter5)) {
                                buffer2[counter5] = (short) counter3;
                            }
                        }
                    }
                }
            }
            if (Arrays.equals(serialNum, buffer2)) {
                names.add(dictNames[counter]);
            }
        }

        //Print out results
        if (names.size() > 0) {
            for (int counter = 0; counter < names.size(); counter++) {
                out.println(names.get(counter));
                System.out.println(names.get(counter));
            }
        } else {
            out.println("NONE");
            System.out.println("NONE");
        }
        out.close();
        System.exit(0);
    }

    static boolean isElementInArray(String[] stringray, String element) {
        int intdex = Arrays.binarySearch(stringray, element);
        return (intdex >= 0);
    }

    static String[] readDictionary(BufferedReader input) throws IOException {
        String buffer;
        LinkedList<String> names = new LinkedList<String>();
        int counter = 0;
        buffer = input.readLine();
        while (!(buffer == null)) {   //Copy the dict.txt into the dictionary
            names.add(buffer);
            buffer = input.readLine();
            counter++;
        }
        String[] output = new String[names.size()];
        names.toArray(output);

        //Put in loop that converts output to numbers
        // Achievment Get: Make Brennan Ragequit
        return output;
    }
}
