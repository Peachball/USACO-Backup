/*
 ID: chen_xu1
 TASK: namenum
 LANG: JAVA
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class namenum {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter out = new PrintWriter(new FileWriter("namenum.out"));
        BufferedReader dictionary = new BufferedReader(new FileReader("dict.txt"));
        List<String> validNames = new ArrayList<>();
        String[] dictNames = new String[5000];

        out.close();
        System.exit(0);
    }

    static void readNames(String[] output, BufferedReader input) {
        
    }
}
