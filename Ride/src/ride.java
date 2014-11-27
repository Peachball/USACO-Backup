/*
 ID: chen_xu1
 PROG: ride
 LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class ride {

    public static void main(String args[]) throws FileNotFoundException, IOException {
        BufferedReader file = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new FileWriter("ride.out"));
        String wordOne = file.readLine();
        String wordTwo = file.readLine();
        StringTokenizer strOne = new StringTokenizer(wordOne);
//        char[] splitOne = wordOne.toCharArray();
//        char[] splitTwo = wordTwo.toCharArray();
        int sumOne = 1;
        int sumTwo = 1;
        int max = wordOne.length();
        for (int counter = 0; counter < max; counter++) {
            sumOne *= ((int) wordOne.charAt(counter) - 64);
        }
        max = wordTwo.length();
        for (int counter = 0; counter < max; counter++) {
            sumTwo *= ((int) wordTwo.charAt(counter) - 64);
        }
        if (sumOne % 47 == sumTwo % 47) {
            out.println("GO");
        } else{
            out.println("STAY");
        }
        out.close();
        System.exit(0);
    }
}
