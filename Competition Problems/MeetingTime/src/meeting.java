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

/*
 ID: Peachball
 TASK: meeting
 LANG: JAVA
 */
public class meeting {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("meeting.in"));
        PrintWriter out = new PrintWriter(new FileWriter("meeting.out"));
        StringTokenizer reader = new StringTokenizer(in.readLine());
        int goal = Integer.parseInt(reader.nextToken());
        int numofInput = Integer.parseInt(reader.nextToken());
        Fields[] routes = new Fields[numofInput];

        //Reading function:
        for (int counter = 0; counter < numofInput; counter++) {
            reader = new StringTokenizer(in.readLine());
            routes[counter] = new Fields(Integer.parseInt(reader.nextToken()),
                    Integer.parseInt(reader.nextToken()),
                    Integer.parseInt(reader.nextToken()),
                    Integer.parseInt(reader.nextToken()));
        }

        //MORE BRUTE FORCE!!!
        Arrays.sort(routes, new FieldComparator());
        ArrayList<Integer> possibilitiesB = new ArrayList<Integer>();
        ArrayList<Integer> possibilitiesE = new ArrayList<Integer>();
        int[] times = new int[16];
        int frequency = frequency(routes);
        while (frequency > times[0]) {
            boolean finished = false;
            int bufferB = 0;
            int bufferE = 0;
            int currentNode = 1; //Value of field
            int bufferedNode = 0; //Location of field start in array
            int previousNode = 0;
            while (currentNode != goal) {
                bufferedNode = linearSearch(routes, currentNode);
                if (bufferedNode == -1 || bufferedNode >= routes.length) {
                    break;
                }
                bufferedNode += times[currentNode - 1];
                if (bufferedNode >= routes.length) {
                    times[routes[previousNode].start - 1]++;
                    times[currentNode - 1] = 0;
                    continue;
                }
                if (routes[bufferedNode].start != currentNode) {
                    times[routes[previousNode].start - 1]++;
                    times[currentNode - 1] = 0;
                    continue;
                }
                if (routes[bufferedNode].end == goal) {
                    times[currentNode - 1]++;
                    currentNode = goal;
                    bufferB += routes[bufferedNode].BessieSpeed;
                    bufferE += routes[bufferedNode].ElsieSpeed;
                    finished = true;
                    break;
                }
                bufferB += routes[bufferedNode].BessieSpeed;
                bufferE += routes[bufferedNode].ElsieSpeed;
                currentNode = routes[bufferedNode].end;
                previousNode = bufferedNode;
            }
            if (finished) {
                possibilitiesB.add(bufferB);
                possibilitiesE.add(bufferE);
            }
        }

        if (possibilitiesB.isEmpty() || possibilitiesE.isEmpty()) {
            out.println("IMPOSSIBLE");
            out.close();
            System.exit(0);
        }
        Collections.sort(possibilitiesB);
        Collections.sort(possibilitiesE);
        int max = possibilitiesB.size();
        int shortestDistance = Integer.MAX_VALUE;
        for (int counter = 0; counter < max; counter++) {
            if (Collections.binarySearch(possibilitiesE, possibilitiesB.get(counter)) >= 0
                    && shortestDistance > possibilitiesB.get(counter)) {
                shortestDistance = possibilitiesB.get(counter);
            }
        }

        if (shortestDistance == Integer.MAX_VALUE) {
            out.println("IMPOSSIBLE");
        } else {
            out.println(shortestDistance);
        }
        out.close();
        System.exit(0);
    }

    static int linearSearch(Fields[] stuff, int start) {
        for (int counter = 0; counter < stuff.length; counter++) {
            if (stuff[counter].start == start) {
                return counter;
            }
        }
        return -1;
    }

    static int frequency(Fields[] stuff) {
        int numoftimes = 0;
        while (stuff[numoftimes].start == 1) {
            numoftimes++;
        }
        return numoftimes;
    }
}

class Fields {

    public int start;
    public int end;
    public int BessieSpeed;
    public int ElsieSpeed;

    public Fields(int start, int end, int BessieSpeed, int ElsieSpeed) {
        this.start = start;
        this.end = end;
        this.BessieSpeed = BessieSpeed;
        this.ElsieSpeed = ElsieSpeed;
    }

    public Fields(int start) {
        this(start, -1, -1, -1);
    }

}

class FieldComparator implements Comparator<Fields> {

    @Override
    public int compare(Fields t, Fields t1) {
        if (t.start != t1.start) {
            return t.start - t1.start;
        } else {
            return t.end - t1.end;
        }
    }
}

class StartComparator implements Comparator<Fields> {

    @Override
    public int compare(Fields t, Fields t1) {
        return t.start - t1.start;
    }

}
