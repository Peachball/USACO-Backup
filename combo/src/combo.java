
/*
 ID: chen_xu1
 TASK: combo
 LANG: JAVA
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class combo {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("combo.in"));
        PrintWriter out = new PrintWriter(new FileWriter("combo.out"));
        int max = Integer.parseInt(in.readLine());
        Combination farmer = new Combination();
        Combination master = new Combination();
        StringTokenizer combo1 = new StringTokenizer(in.readLine());
        StringTokenizer combo2 = new StringTokenizer(in.readLine());
        farmer.num1 = Integer.parseInt(combo1.nextToken());
        farmer.num2 = Integer.parseInt(combo1.nextToken());
        farmer.num3 = Integer.parseInt(combo1.nextToken());
        master.num1 = Integer.parseInt(combo2.nextToken());
        master.num2 = Integer.parseInt(combo2.nextToken());
        master.num3 = Integer.parseInt(combo2.nextToken());
        ArrayList<Combination> possibilities = new ArrayList<Combination>();
        for (int counter2 = -2; counter2 < 3; counter2++) {
            for (int counter3 = -2; counter3 < 3; counter3++) {
                for (int counter4 = -2; counter4 < 3; counter4++) {
                    Collections.sort(possibilities, new CombinationComparator());
                    Combination buffer = new Combination(subtract(farmer.num1, counter2, max), subtract(farmer.num2, counter3, max), subtract(farmer.num3, counter4, max));
                    if (Collections.binarySearch(possibilities, buffer, new CombinationComparator()) == -1) {
                        possibilities.add(buffer);
                    }
                    buffer = new Combination(subtract(master.num1, counter2, max), subtract(master.num2, counter3, max), subtract(master.num3, counter4, max));
                    Collections.sort(possibilities, new CombinationComparator());
                    if (Collections.binarySearch(possibilities, buffer, new CombinationComparator()) == -1) {
                        possibilities.add(buffer);
                    }
                }
            }
        }

        out.println(possibilities.size());
        System.out.println(possibilities.size());
        out.close();
        System.exit(0);
    }

    private static int subtract(int x, int y, int max) {
        if (x - y <= 0) {
            return x - y + max;
        }
        return x - y;
    }
}

class CombinationComparator implements Comparator<Combination> {

    @Override
    public int compare(Combination t, Combination t1) {
        if (t.num1 != t1.num1) {
            return t.num1 - t1.num1;
        } else if (t.num2 != t1.num2) {
            return t.num2 - t1.num2;
        } else {
            return t.num3 - t1.num3;
        }
    }

}

class Combination {

    public int num1;
    public int num2;
    public int num3;

    public Combination() {
    }

    public Combination(int x, int y, int z) {
        num1 = x;
        num2 = y;
        num3 = z;
    }
}
