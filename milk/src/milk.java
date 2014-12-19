/*
 ID: chen_xu1
 TASK: milk
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
import java.util.StringTokenizer;

public class milk {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("milk.in"));
        PrintWriter out = new PrintWriter(new FileWriter("milk.out"));
        StringTokenizer reader;

        //Initialize the requirements
        reader = new StringTokenizer(in.readLine());
        int unitsNeeded = Integer.parseInt(reader.nextToken());
        int numofFarmers = Integer.parseInt(reader.nextToken());
        int[] markers = new int[numofFarmers];
        String buffer = in.readLine();
        ArrayList<Farmer> farmers = new ArrayList<Farmer>();

        //Reading function;
        while (buffer != null) {
            reader = new StringTokenizer(buffer);
            farmers.add(new Farmer(Integer.parseInt(reader.nextToken()), Integer.parseInt(reader.nextToken())));
            buffer = in.readLine();
        }
        Collections.sort(farmers, new FarmerCostComparator());
        int unitsObtained = 0;
        int bufferedPrice = 0;

        for (int counter = 0; counter < markers.length; counter++) {
            markers[counter] = counter;
        }

        //Move the markers in the correct fashion
        while (unitsObtained >= unitsNeeded) {
            //Sum up the current number of units
            int bufferedUnitsObtained= 0;
            while (bufferedUnitsObtained == 0) {
                
            }
        }

        out.close();
        System.exit(0);
    }
}

class FarmerCostComparator implements Comparator<Farmer> {

    @Override
    public int compare(Farmer t, Farmer t1) {
        return t.costPerUnit - t1.costPerUnit;
    }

}

class Farmer {

    public int costPerUnit;
    public int unitsSellable;

    public Farmer(int costPerUnit, int unitsSellable) {
        this.costPerUnit = costPerUnit;
        this.unitsSellable = unitsSellable;
    }

}
