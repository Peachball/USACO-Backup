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
        int size = Integer.parseInt(in.readLine());
        
        out.close();
        System.exit(0);
    }
}
