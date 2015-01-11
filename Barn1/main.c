/*
ID:chen_xu1
PROG:barn1
LANG:C
 */
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#define length(x) (sizeof(x)/sizeof(x[0])) //This is dangerous, but done...

int integercmp(const void *start, const void *end) {
    return *((int*) start) - *((int*) end);
}

int main(int argc, char** argv) {
    FILE *in = fopen("barn1.in", "r"); //file open(filename,mode);
    FILE *out = fopen("barn1.out", "w");
    assert(in != NULL && out != NULL);
    int maxBoards;
    int numofStalls;
    int numofCows;

    int counter;
    int i = 0;
    int diff;
    int bufferLocation;

    //Determine the requirements
    fscanf(in, "%d %d %d", &maxBoards, &numofStalls, &numofCows); //&sign for addresses...
    int cowLocations[numofCows];
    int boardLocations[maxBoards];
    memset(boardLocations, 0, maxBoards * sizeof (boardLocations[0]));
    for (counter = 0; counter < numofCows; counter++) {
        fscanf(in, "%d", &cowLocations[counter]);
    }
    qsort(cowLocations, numofCows, sizeof (cowLocations[0]), integercmp);

    if(maxBoards >= numofCows){
        fprintf(out,"%d\n",numofCows);
        printf("%d\n",numofCows);
        fclose(out);
        fclose(in);
        return 0;
    }
    if (maxBoards <= 1) {
        fprintf(out, "%d\n", cowLocations[length(cowLocations) - 1] - cowLocations[0] + 1);
        printf("%d\n", cowLocations[length(cowLocations) - 1] - cowLocations[0] + 1);
        fclose(out);
        fclose(in);
        return (EXIT_SUCCESS);
    }

    //implement solution
    while (i < maxBoards - 1) {
        diff = 0;
        bufferLocation = 0;
        qsort(boardLocations, maxBoards, sizeof (boardLocations[0]), integercmp);

        //find the largest gap between cows
        for (counter = 0; counter < length(cowLocations) - 1; counter++) {
            if (cowLocations[counter + 1] - cowLocations[counter] > diff
                    && bsearch(&counter, boardLocations, maxBoards, sizeof (boardLocations[0]), integercmp) == NULL) {
                bufferLocation = counter;
                diff = cowLocations[counter + 1] - cowLocations[counter];
            }
        }

        //record the gap
        i++;
        if (i < maxBoards) {
            boardLocations[0] = bufferLocation;
        }
    }

    //Calculate num of stalls covered based on board locations
    qsort(boardLocations, maxBoards, sizeof (boardLocations[0]), integercmp);
    diff = 0;
    int previousCow = cowLocations[0];
    for (counter = 0; counter < maxBoards; counter++) {
        if(boardLocations[counter] == 0){
            continue;
        }
        diff += cowLocations[boardLocations[counter]] - previousCow + 1;
        previousCow = cowLocations[boardLocations[counter] + 1];
        if (counter == maxBoards - 1) {
            diff += cowLocations[length(cowLocations) - 1] - cowLocations[boardLocations[counter] + 1] + 1;
        }
    }

    fprintf(out, "%d\n", diff);
    printf("%d\n", diff);
    fclose(out);
    fclose(in);
    return (EXIT_SUCCESS);
}
/*
 * %d is for int
 * %s is for string
 * %c is char
 * %% is the percent sign
 * etc...
 */

