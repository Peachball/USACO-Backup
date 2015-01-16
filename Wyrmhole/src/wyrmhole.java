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
            input[counter].x = Integer.parseInt(read.nextToken());
            input[counter].y = Integer.parseInt(read.nextToken());
        }

        for(int counter = 0;;counter++){
            Wormhole wormholes[] = new Wormhole[max];
            
        }
        out.close();
        System.exit(0);
    }
}

class /* STRUCT */ Wormhole {

    public Coord input;
    public Coord output;
}
class /* STRUCT */ Coord{
    public int x;
    public int y;
    public Coord(){
        
    }
}