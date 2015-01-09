/*
ID: chen_xu1
PROG: marathon
LANG: JAVA
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class marathon {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("marathon.in"));
        PrintWriter out = new PrintWriter(new FileWriter("marathon.out"));
        int read = Integer.parseInt(in.readLine());
        Coord[] points = new Coord[read];
        StringTokenizer reader;
        for (int counter = 0; counter < read; counter++) {
            reader = new StringTokenizer(in.readLine());
            points[counter].x = Integer.parseInt(reader.nextToken());
            points[counter].y = Integer.parseInt(reader.nextToken());
        }
        
        int totalMax = 0;
        for(int counter = 0;counter<read;counter++){
            
        }
        out.close();
        System.exit(0);
    }
}

class Coord {

    public int x;
    public int y;
}
