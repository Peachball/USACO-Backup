/*
 ID: chen_xu1
 TASK: milk2
 LANG: JAVA
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class milk2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Enlarge Arrays...

        BufferedReader in = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new FileWriter("milk2.out"));
        StringTokenizer reader;
        int[][] times;
        times = new int[Integer.parseInt(in.readLine())][2];
        int length = times.length;
        int maxIdleTime = 0;
        int maxWorkingTime = 0;
        int position1 = 0;
        int position2 = 0;
        int maxTime = 0;
        boolean[] working;

        //Read Input File
        for (int counter = 0; counter < length; counter++) {
            reader = new StringTokenizer(in.readLine());
            times[counter][0] = Integer.parseInt(reader.nextToken());
            times[counter][1] = Integer.parseInt(reader.nextToken());
        }
        
        //Find maximum time
        for(int counter = 0;counter<length;counter++){
            if(maxTime<times[counter][1]){
                maxTime = times[counter][1];
            }
        }

        working = new boolean[maxTime];
        Arrays.fill(working, times[0][0], times[0][1], true);

        for (int counter = 0; counter < length; counter++) {

            Arrays.fill(working, times[counter][0], times[counter][1], true);
        }
        if (length == 1) {
            maxWorkingTime = times[0][1] - times[0][0];
        }

        length = working.length;
        position1 = 0;
        boolean startWork = false;

        for (int counter = 0; counter < length; counter++) {

            if (working[counter]) {
                startWork = true;
            }

            if (startWork && working[counter]) {

                if (maxIdleTime < position1) {
                    maxIdleTime = position1;
                }
                position2++;
                position1 = 0;
            }

            if (startWork && !working[counter]) {
                if (maxWorkingTime < position2) {
                    maxWorkingTime = position2;
                }
                position1++;
                position2 = 0;

            }
        }
        if (maxWorkingTime < position2 ) {
            maxWorkingTime = position2 ;
        }
        if (maxIdleTime < position1) {
            maxIdleTime = position1;
        }

        System.out.println(maxWorkingTime + " " + maxIdleTime);
        out.println(maxWorkingTime + " " + maxIdleTime);
        out.close();
        System.exit(0);
    }
}
