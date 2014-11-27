/*
 ID: chen_xu1
 PROG: friday
 LANG: JAVA
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class friday {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new FileWriter("friday.out"));
        int years = Integer.parseInt(in.readLine());
        int month;
        int day;
        short weekday;
        int[] daysOccured = new int[7];
        short leapYear;
        weekday = 1;
        for (int counter = 0; counter < years; counter++) {
            leapYear = 0;
            if ((counter + 1900) % 100 == 0) {
                if ((counter + 1900) % 400 == 0) {
                    leapYear = 1;
                }
            } else if (counter % 4 == 0) {
                leapYear = 1;
            }
            day = 1;
            month = 1;
            for (int a = 1; a < 366 + leapYear; a++, day++, weekday++) {

                if (weekday == 8) {
                    weekday = 1;
                }
                if (day == 29 && leapYear == 0 && month == 2) {
                    day = 1;
                    month++;
                }
                if (day == 30 && leapYear == 1 && month == 2) {
                    day = 1;
                    month++;
                }
                if (day == 31 && (month == 4 || month == 6 || month == 9 || month == 11)) {
                    day = 1;
                    month++;
                }
                if (day == 32 && (month == 1 || month == 3 || month == 5
                        || month == 7 || month == 8 || month == 10)) {
                    day = 1;
                    month++;
                }
                if (day == 13) {
                    daysOccured[weekday - 1]++;
                }
            }
        }
        out.println(daysOccured[5] + " " + daysOccured[6] + " " + daysOccured[0]
                + " " + daysOccured[1] + " " + daysOccured[2] + " " + daysOccured[3]
                + " " + daysOccured[4]);
        out.close();
        System.exit(0);
    }
}
