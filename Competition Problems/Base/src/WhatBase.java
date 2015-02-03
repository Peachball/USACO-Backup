import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WhatBase {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("whatbase.in"));
        PrintWriter out = new PrintWriter(new FileWriter("whatbase.out"));
        int numofInput = Integer.parseInt(in.readLine());
        int[][] input = new int[numofInput][2];
        int[][] solutions = new int[numofInput][2];
        for (int counter = 0; counter < numofInput; counter++) {
            StringTokenizer reader = new StringTokenizer(in.readLine());
            input[counter][0] = Integer.parseInt(reader.nextToken());
            input[counter][1] = Integer.parseInt(reader.nextToken());
        }
        for (int counter2 = 0; counter2 < numofInput; counter2++) {
            int x = 10;
            int y = 10;
            int[] digitX = new int[3];
            int[] digitY = new int[3];
            for (int counter = 0; counter < 3; counter++) {
                digitX[counter] = input[counter2][0] % 10;
                digitY[counter] = input[counter2][1] % 10;
                input[counter2][0] = input[counter2][0] / 10;
                input[counter2][1] = input[counter2][1] / 10;
            }
            while (digitX[0] + digitX[1] * x + digitX[2] * x * x != digitY[0] + digitY[1] * y + digitY[2] * y * y) {
                if (digitX[0] + digitX[1] * x + digitX[2] * x * x > digitY[0] + digitY[1] * y + digitY[2] * y * y) {
                    y++;
                } else {
                    x++;
                }
            }
            solutions[counter2][0] = x;
            solutions[counter2][1] = y;
        }

        for (int counter = 0; counter < numofInput; counter++) {
            out.println(solutions[counter][0] + " " + solutions[counter][1]);
        }
        out.close();
        System.exit(0);
    }
}
