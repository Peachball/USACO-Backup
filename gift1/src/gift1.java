/*
 ID: chen_xu1
 PROG: gift1
 LANG: JAVA
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class gift1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new FileWriter("gift1.out"));
        int numofPeople = Integer.parseInt(in.readLine());
        Person[] people = new Person[numofPeople];
        StringTokenizer splitter;
        int position;
        int donatedMoney;
        int numofPeopleDonated;
        int amountDonated;
        int leftovers;
        int totalAmountDonated;
        for (int counter = 0; counter < numofPeople; counter++) {
            people[counter] = new Person(in.readLine(), 0);
        }
        for (int counter = 0; counter < numofPeople; counter++) {
            position = check(in.readLine(), people);
            splitter = new StringTokenizer(in.readLine());
            totalAmountDonated = Integer.parseInt(splitter.nextToken());
            numofPeopleDonated = Integer.parseInt(splitter.nextToken());
            if (numofPeopleDonated == 0) {
                amountDonated = 0;
                totalAmountDonated = 0;
            } else {
                amountDonated = (int) Math.floor(totalAmountDonated / numofPeopleDonated);
            }
            leftovers = totalAmountDonated - amountDonated * numofPeopleDonated;
            people[position].money += leftovers;
            people[position].money -= totalAmountDonated;
            for (int a = 0; a < numofPeopleDonated; a++) {
                position = check(in.readLine(), people);
                people[position].money += amountDonated;
            }
        }
        //Output
        for (int counter = 0; counter < people.length; counter++) {
            out.println(people[counter].name + " " + people[counter].money);
        }
        out.close();
        System.exit(0);
    }

    private static int check(String input, Person[] people) {
        int length = people.length;
        for (int counter = 0; counter < length; counter++) {
            if (people[counter].name.equals(input)) {
                return counter;
            }
        }
        return -1;
    }
}

class Person {

    public String name;
    public int money;

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
    }
}
