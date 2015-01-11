/* 
ID: chen_xu1
TASK: crypt1
LANG: C
 */

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {
    FILE *in, *out;
    in =fopen("crypt1.in", "r");
    out =fopen( "crypt1.out", "w");

    //read input here
    int numofInput;
    int counter = 0;
    fscanf(in, "%d\n", &numofInput);
    char buffer[10];
    fscanf(in,"%s",buffer);
    for (counter = 0; counter < numofInput; counter++) {
        printf("%c", buffer[counter]);
    }

    return (EXIT_SUCCESS);
}

