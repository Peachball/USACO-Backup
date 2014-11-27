/*
 ID: chen_xu1
 PROG: beads
 LANG: JAVA
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class beads {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new FileWriter("beads.out"));
        in.readLine();
        char[] buffer;
        char[] necklace;
        String beadString = in.readLine();
        buffer = beadString.toCharArray();
        necklace = new char[buffer.length * 2];
        System.arraycopy(buffer, 0, necklace, 0, buffer.length);
        System.arraycopy(buffer, 0, necklace, buffer.length, buffer.length);
        int length = necklace.length;
        int max = 0;
        char currentBead = 'r';
        int testerOne = 0;
        int testerTwo = 0;
        int wNum = 0;
        int overCounted = 0;
        for (int counter = 0; counter < length; counter++) {
            if (necklace[counter] == currentBead || necklace[counter] == 'w') {
                testerOne++;
                if (necklace[counter] == 'w') {
                    wNum++;
                } else {
                    wNum = 0;
                }
            } else {
                if (testerTwo + testerOne - overCounted > max) {
                    max = testerOne + testerTwo - overCounted;
                }
                currentBead = necklace[counter];
                testerTwo = testerOne;
                testerOne = wNum + 1;
                overCounted = wNum;
                wNum = 0;

            }
        }
        if (max > length / 2) {
            max = length / 2;
        }
        if (max == 0) {
            max = length / 2;
        }

        System.out.println(max);
        out.println(max);
        out.close();
        System.exit(0);
    }
}
