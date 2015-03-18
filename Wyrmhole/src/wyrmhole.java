/*
 ID: chen_xu1
 TASK: wormhole
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
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class wyrmhole {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter out = new PrintWriter(new FileWriter("wormhole.out"));
        int max = 0;
        max = Integer.parseInt(in.readLine());
        Coord input[] = new Coord[max];
        for (int counter = 0; counter < max; counter++) {
            StringTokenizer read = new StringTokenizer(in.readLine());
            input[counter] = new Coord();
            input[counter].x = Integer.parseInt(read.nextToken());
            input[counter].y = Integer.parseInt(read.nextToken());
        }

        //Generate all possiblities?
        wyrmhole a = new wyrmhole();
        LinkedList<ArrayList<Coord>> possiblities = a.recursiondonhurtme(new ArrayList<Coord>(Arrays.asList(input)));

        for (ArrayList<Coord> i : possiblities) {
            for (Coord start : i) {
                boolean done = false;
                start = new Coord(start.friendx, start.friendy);
                Coord buffer = start.clone();
                while (!done) {
                    CoordComparator c =new CoordComparator(buffer);
                    Collections.sort(i,c);
                    if(buffer.x == start.x){
                        
                    }
                }
            }
        }

        out.close();
        System.exit(0);
    }

    public LinkedList<ArrayList<Coord>> recursiondonhurtme(ArrayList<Coord> input) {
        LinkedList<ArrayList<Coord>> buffer = new LinkedList<ArrayList<Coord>>();
        if (input.size() == 2) {
            input.get(0).link(input.get(1));
            input.get(1).link(input.get(0));
            buffer.add(input);
            return buffer;
        }
        ArrayList<Coord> buffer3;
        for (int counter = 1; counter < input.size(); counter++) {
            buffer3 = (ArrayList<Coord>) input.clone();
            buffer3.get(0).link(input.get(counter));
            buffer3.get(counter).link(input.get(0));
            Coord[] buffer2 = new Coord[2];
            buffer2[0] = buffer3.get(0);
            buffer2[1] = buffer3.get(counter);
            buffer3.remove(counter);
            buffer3.remove(0);
            LinkedList<ArrayList<Coord>> buffer4 = recursiondonhurtme((ArrayList<Coord>) buffer3.clone());
            for (int counter2 = 0; counter2 < buffer4.size(); counter2++) {
                buffer4.get(counter2).add(buffer2[0]);
                buffer4.get(counter2).add(buffer2[1]);
            }
            buffer.addAll(buffer4);
        }
        return buffer;
    }
}

class /* STRUCT */ Coord {

    public int x;
    public int y;
    public int friendx;
    public int friendy;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coord() {
    }

    public void link(Coord friend) {
        this.friendx = friend.x;
        this.friendy = friend.y;
    }

    @Override
    public Coord clone() {
        Coord buffer = new Coord(x, y);
        buffer.friendx = friendx;
        buffer.friendy = friendy;
        return buffer;
    }

}

class CoordComparator implements Comparator<Coord> {

    private Coord compareto;

    public CoordComparator(Coord coord) {
        compareto = coord.clone();
    }

    @Override
    public int compare(Coord o1, Coord o2) {
        if (o1.x == compareto.x && o2.x == compareto.x) {
            return Math.abs(o1.y - compareto.y) - Math.abs(o2.y - compareto.y);
        }
        return Math.abs(o1.x - compareto.x) - Math.abs(o2.x - compareto.x);
    }

}
