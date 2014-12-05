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
//    String[] nameGenerator(short[] serialnum, int position) {
//        ArrayList<String> names = new ArrayList<String>();
//        if (position == serialnum.length - 1) {
//            for (int counter = 0; counter < 3; counter++) {
//                names.add(keypad[serialnum[position]][counter] + "");
//            }
//            String[] output = new String[names.size()];
//            names.toArray(output);
//            return output;
//        }
//        String[] previousNames = nameGenerator(serialnum, position + 1);
//        for (int counter = 0; counter < 3; counter++) {
//            for (int counter2 = 0; counter2 < previousNames.length; counter2++) {
//                names.add(keypad[serialnum[position]][counter] + previousNames[counter2]);
//            }
//        }
//        String[] output = new String[names.size()];
//        names.toArray(output);
//        return output;
//    }

//    static String[] nameGen2(short[] serialnum) {
//        String name;
//        ArrayList<String> valids = new ArrayList<String>();
//        short[] counters = new short[serialnum.length];
//        for (int counter = 0; counter < (int) Math.pow(3, serialnum.length); counter++) {
//            name = null;
//            for (int counter2 = 0; counter2 < serialnum.length; counter2++) {
//                if (name == null) {
//                    name = keypad[serialnum[counter2]][counters[counter2]] + "";
//                } else {
//                    name = name + keypad[serialnum[counter2]][counters[counter2]];
//                }
//            }
//            if (isElementInArray(dictNames, name)) {
//                valids.add(name);
//            }
//
//            counters[0]++;
//            for (int counter2 = 0; counter2 < counters.length; counter2++) {
//                if (counters[counters.length - 1] > 2) {
//                    String[] names = new String[valids.size()];
//                    valids.toArray(names);
//                    return names;
//                }
//                if (counters[counter2] > 2) {
//                    counters[counter2] = 0;
//                    counters[counter2 + 1]++;
//                }
//            }
//        }
//        String[] names = new String[valids.size()];
//        valids.toArray(names);
//        return names;
//    }
    /*
     //    static boolean isElementInArray(String[] array, String element) {
     //        int position1 = 0;
     //        int position2 = array.length;
     //        int status = 0;
     //        boolean alt = true;
     //       
     //        while (position1 != position2 && !(Math.abs(position1 - position2) == 1
     //                && compare(element, array[position1]) != 0
     //                && compare(element, array[position2]) != 0)) {
     //            if(alt){
     //            counter = (int) (position1 + position2) / 2;
     //            } else{
     //                
     //            }
     //            switch (status) {
     //                case 0:
     //                    return true;
     //                case 1:
     //                    position1 = counter;
     //                    alt = true;
     //                    break;
     //                case 2:
     //                    position2 = counter;
     //                    alt = false;
     //                    break;
     //            }
     //        } // true is position1
     //          // false is poisition2
     //        return false;
     //    }
     */
}
