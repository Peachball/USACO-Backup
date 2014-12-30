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
        int unitCost = 0;

        //initialize the markers
        for (int counter = 0; counter < markers.length; counter++) {
            markers[counter] = counter;
        }

        //Figure out whether or not the cheapest ppl give enough milk
        int bufferedUnitsObtained = 0;
        int bufferedCost = 0;
        for (int counter = 0; counter < markers.length; counter++) {
            bufferedUnitsObtained += farmers.get(markers[counter]).unitsSellable;
            bufferedCost += farmers.get(markers[counter]).unitsSellable * farmers.get(markers[counter]).costPerUnit;
            if (bufferedUnitsObtained > unitsNeeded) {
                int diff = bufferedUnitsObtained - unitsNeeded;
                bufferedCost -= diff * farmers.get(markers[counter]).costPerUnit;
                bufferedUnitsObtained = unitsNeeded;
                break;
            }
        }
        unitsObtained = bufferedUnitsObtained;

        int currentMarker = markers.length - 1;

        //Check if total units is less than required amount
        while (unitsObtained >= unitsNeeded) {
            if (currentMarker < 0) {
                currentMarker = markers.length - 1;
            }

            //move markers
            int bufferedMarker = markers[currentMarker];
            bufferedUnitsObtained = farmers.get(markers[currentMarker]).unitsSellable;
            while (bufferedUnitsObtained > farmers.get(bufferedMarker).unitsSellable) {
                bufferedMarker++;
                if (currentMarker < markers.length - 1 && bufferedMarker >= markers[currentMarker + 1]) {
                    bufferedMarker = markers[currentMarker];
                    break;
                }
            }
            markers[currentMarker] = bufferedMarker;
            //sum up units
            unitsObtained = 0;
            for (int counter = 0; counter < markers.length; counter++) {
                unitsObtained += farmers.get(markers[counter]).unitsSellable;
            }
            currentMarker--;
        }

        //Check pricing of total sum
        bufferedCost = 0;
        unitsObtained = 0;
        for (int counter = 0; counter < markers.length; counter++) {
            bufferedCost += farmers.get(markers[counter]).costPerUnit * farmers.get(markers[counter]).unitsSellable;
            unitsObtained += farmers.get(markers[counter]).unitsSellable;
        }
        if (unitsObtained > unitsNeeded) {
            int diff = bufferedUnitsObtained - unitsNeeded;
            bufferedCost -= diff * farmers.get(markers[markers.length - 1]).costPerUnit;
        }
        out.println(bufferedCost);
        System.out.println(bufferedCost);
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
