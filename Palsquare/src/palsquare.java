/*
 ID: chen_xu1
 PROG: palsquare
 LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class palsquare {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        BufferedReader in = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new FileWriter("palsquare.out"));

        int base = Integer.parseInt(in.readLine());
        String newBaseSquare;
        String newBaseValue;

        //Brute Force (test every square to see if it is palindrome):
        for (int counter = 1; counter <= 300; counter++) {

            int a = 0;
            int x = counter * counter;
            int buffer = counter;
            newBaseSquare = "";
            newBaseValue = "";

            //Convert original number into base (int to String)
            for (int counter1 = 0;; counter1++) {       //Find the highest digit...
                if (Math.pow(base, counter1) > buffer) {
                    a = counter1 - 1;
                    break;
                }
            }
            for (; a >= 0; a--) {     //Input the appropriate digits into the string
                for (int counter1 = 0; counter1 <= base; counter1++) {     //check what is multiplied with the power
                    if ((Math.pow(base, a) * counter1) > buffer && counter1 - 1 < 10) {
                        newBaseValue = newBaseValue + (counter1 - 1);
                        buffer = (int) (buffer - Math.pow(base, a) * (counter1 - 1));
                        break;
                    } else if ((Math.pow(base, a) * counter1) > x) {
                        newBaseValue = newBaseValue + (char) (counter1 - 11 + 'A');
                        x = (int) (x - Math.pow(base, a) * (counter1 - 1));
                        break;
                    }
                }
            }

            //Convert square into base (int to String)
            a = 0;
            x = counter * counter;
            for (int counter1 = 0;; counter1++) {       //Find the highest digit...
                if (Math.pow(base, counter1) > x) {
                    a = counter1 - 1;
                    break;
                }
            }
            for (; a >= 0; a--) {     //Input the appropriate digits into the string
                for (int counter1 = 0; counter1 <= base; counter1++) {     //check what is multiplied with the power
                    if ((Math.pow(base, a) * counter1) > x && counter1 - 1 < 10) {
                        newBaseSquare = newBaseSquare + (counter1 - 1);
                        x = (int) (x - Math.pow(base, a) * (counter1 - 1));
                        break;
                    } else if ((Math.pow(base, a) * counter1) > x) {
                        newBaseSquare = newBaseSquare + (char) (counter1 - 11 + 'A');
                        x = (int) (x - Math.pow(base, a) * (counter1 - 1));
                        break;
                    }
                }
            }

            //Test if new number is palindrome:
            boolean status = true;
            for (int counter1 = 0; counter1 < (int) Math.round(newBaseSquare.length() / 2) && status; counter1++) {
                if (newBaseSquare.charAt(counter1) != newBaseSquare.charAt(newBaseSquare.length() - counter1 - 1)) {
                    status = false;
                }
            }

            //Print out number if true
            if (status) {
                out.println(newBaseValue + " " + newBaseSquare);
                System.out.println(newBaseValue + " " + newBaseSquare);
            }
        }
        out.close();
        System.exit(0);
    }
}
