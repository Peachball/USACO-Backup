/*
 ID: chen_xu1
 PROG: marathon (bronze...)
 LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class bronze {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("marathon.in"));
        PrintWriter out = new PrintWriter(new FileWriter("marathon.out"));
        int read = Integer.parseInt(in.readLine());
        Coord[] points = new Coord[read];
        StringTokenizer reader;
        for (int counter = 0; counter < read; counter++) {
            reader = new StringTokenizer(in.readLine());
            points[counter] = new Coord();
            points[counter].x = Integer.parseInt(reader.nextToken());
            points[counter].y = Integer.parseInt(reader.nextToken());
        }

        int totalMax = 0;
        int leg1;
        int leg2;
        int shortcut;
        int largestDiff = 0;
        for (int counter = 0; counter < read - 1; counter++) {
            leg1 = distance(points[counter], points[counter + 1]);
            leg2 = -1;
            shortcut = -1;
            if (counter < read - 2) {
                leg2 = distance(points[counter + 1], points[counter + 2]);
                shortcut = distance(points[counter], points[counter + 2]);
            }
            if ((shortcut != -1 && leg2 != -1) && leg1 + leg2 - shortcut > largestDiff) {
                largestDiff = leg1 + leg2 - shortcut;
            }
            totalMax += leg1;
        }
        out.println(totalMax - largestDiff);
        System.out.println(totalMax - largestDiff);
        out.close();
        System.exit(0);
    }

    static int distance(Coord a, Coord b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}

class Coord {

    public int x;
    public int y;

    public Coord() {

    }
}
