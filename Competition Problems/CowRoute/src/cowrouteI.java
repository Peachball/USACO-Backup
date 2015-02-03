import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 ID: peachball
 TASK: cowroute
 LANG: JAVA
 */
public class cowrouteI {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("cowroute.in"));
        PrintWriter out = new PrintWriter(new FileWriter("cowroute.out"));
        int start;
        int destination;
        int numofRoutes;
        StringTokenizer reader = new StringTokenizer(in.readLine());
        start = Integer.parseInt(reader.nextToken());
        destination = Integer.parseInt(reader.nextToken());
        numofRoutes = Integer.parseInt(reader.nextToken());
        Route[] routes = new Route[numofRoutes];

        //Read function
        for (int counter = 0; counter < numofRoutes; counter++) {
            reader = new StringTokenizer(in.readLine());
            int cost = Integer.parseInt(reader.nextToken());
            int numofCities = Integer.parseInt(reader.nextToken());
            routes[counter] = new Route(cost, numofCities);
            reader = new StringTokenizer(in.readLine());
            for (int counter2 = 0; counter2 < numofCities; counter2++) {

                routes[counter].stops[counter2] = Integer.parseInt(reader.nextToken());
            }
        }

        //BRUTE FORCE:
        int cheapestCost = Integer.MAX_VALUE;
        for (int counter = 0; counter < numofRoutes; counter++) {
            int bufferedCost = Integer.MAX_VALUE;
            boolean started = false;
            boolean ended = false;
            for (int counter2 = 0; counter2 < routes[counter].stops.length; counter2++) {
                if (start == routes[counter].stops[counter2]) {
                    started = true;
                } else if (started && destination == routes[counter].stops[counter2]) {
                    bufferedCost = routes[counter].cost;
                    ended = true;
                    break;
                } else if (started) {
                    bufferedCost = routes[counter].cost;
                }
            }
            if (bufferedCost < cheapestCost && ended) {
                cheapestCost = bufferedCost;
            }
        }
        int[][] info = new int[numofRoutes][2];
        for (int counter = 0; counter < numofRoutes; counter++) {
            boolean finished1 = false;
            boolean finished2 = false;
            int size = routes[counter].stops.length;
            info[counter][0] = -1;
            info[counter][1] = -1;
            for (int counter2 = 0; counter2 < size && !(finished1 && finished2); counter2++) {
                if (routes[counter].stops[counter2] == start) {
                    finished1 = true;
                    info[counter][0] = counter2;
                }
                if (routes[counter].stops[counter2] == destination) {
                    finished2 = true;
                    info[counter][1] = counter2;
                }
            }
        }

        for (int counter = 0; counter < numofRoutes; counter++) {
            for (int counter2 = 0; counter2 < numofRoutes; counter2++) {
                int bufferedStart = info[counter][0];
                int bufferedEnd = info[counter2][1];
                if (bufferedStart < 1 || bufferedEnd > routes[counter].stops.length - 2
                        || bufferedEnd == -1 || counter == counter2) {
                    continue;
                }
                for (int counter3 = bufferedStart; counter3 < routes[counter].stops.length; counter3++) {
                    int bufferedMidPoint = routes[counter].stops[counter3];
                    int status = lsearch(routes[counter2].stops, 0, bufferedEnd, bufferedMidPoint);
                    if (status < 0) {
                        continue;
                    }
                    if (routes[counter].cost + routes[counter2].cost < cheapestCost) {
                        cheapestCost = routes[counter].cost + routes[counter2].cost;
                    }
                }

            }
        }

        if (cheapestCost == Integer.MAX_VALUE) {
            out.println(-1);
            out.close();
            System.exit(0);
        }

        System.out.println(cheapestCost);
        out.println(cheapestCost);

        out.close();
        System.exit(0);
    }

    static int lsearch(int[] array, int startrange, int endrange, int item) {
        for (int counter = startrange; counter < endrange; counter++) {
            if (array[counter] == item) {
                return counter;
            }
        }
        return -1;
    }
}

class Route {

    public int cost;
    public int[] stops;

    public Route(int cost, int stops) {
        this.cost = cost;
        this.stops = new int[stops];
    }
}
