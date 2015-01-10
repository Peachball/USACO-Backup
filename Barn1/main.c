/*
ID:chen_xu1
PROG:barn1
LANG:C
 */
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#define length(x) (sizeof(x)/sizeof(x[0])) //This is dangerous, but done...

int integercmp(const void *start, const void *end) {
    return ((int*) start) - ((int*) end);
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
    memset(boardLocations,0,maxBoards * sizeof(boardLocations[0]));
    for (counter = 0; counter < numofCows; counter++) {
        fscanf(in, "%d", &cowLocations[counter]);
    }

    //implement solution
    while (i < maxBoards) {
        diff = 0;
        bufferLocation = 0;
        qsort(boardLocations, maxBoards, sizeof (boardLocations[0]), integercmp);

        //find the largest gap between cows
        for (counter = 0; counter < length(cowLocations) - 1; counter++) {
            if (cowLocations[counter + 1] - cowLocations[counter] > diff
                    && bsearch(&counter, boardLocations, maxBoards, sizeof (boardLocations[0]), integercmp) != NULL) {
                bufferLocation = counter;
                diff = cowLocations[counter + 1] - cowLocations[counter];
            }
        }

        //record the gap
        boardLocations[i] = bufferLocation;
    }

    //Calculate num of stalls covered based on board locations
    qsort(boardLocations, maxBoards, sizeof (boardLocations[0]), integercmp);
    diff = 0;
    int previousCow = 0;
    for (counter = 0; counter < maxBoards; counter++) {
        diff += cowLocations[boardLocations[counter]] - previousCow;
        previousCow = cowLocations[boardLocations[counter] + 1];
    }
    
    fprintf(out,"%d\n",diff);
    printf(out,"%d\n",diff);
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

