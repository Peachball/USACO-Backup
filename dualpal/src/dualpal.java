/*
 ID: chen_xu1
 TASK: dualpal
 LANG: JAVA
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class dualpal {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new FileWriter("dualpal.out"));
        StringTokenizer reader = new StringTokenizer(in.readLine());
        int numOfPal = Integer.parseInt(reader.nextToken());
        int start = Integer.parseInt(reader.nextToken()) + 1;

        for (int counter = 0; counter < numOfPal; start++) {
            int numOfBases = 0;
            for (int counter2 = 2; counter2 <= 10 && numOfBases < 2; counter2++) {
                int buffer = start;
                int base = counter2;
                int a = 0;
                String newBaseValue = "";
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
                        } else if ((Math.pow(base, a) * counter1) > buffer) {
                            newBaseValue = newBaseValue + (char) (counter1 - 11 + 'A');
                            buffer = (int) (buffer - Math.pow(base, a) * (counter1 - 1));
                            break;
                        }
                    }
                }

                //Test if new number is palindrome:
                boolean status = true;
                for (int counter1 = 0; counter1 < (int) Math.round(newBaseValue.length() / 2) && status; counter1++) {
                    if (newBaseValue.charAt(counter1) != newBaseValue.charAt(newBaseValue.length() - counter1 - 1)) {
                        status = false;
                    }
                }
                if (status) {
                    numOfBases++;
                }
            }
            if (numOfBases >= 2) {
                out.println(start);
                System.out.println(start);
                counter++;
            }
        }
        out.close();
        System.exit(0);
    }
}
