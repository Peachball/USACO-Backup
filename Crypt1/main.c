/* 
ID: chen_xu1
TASK: crypt1
LANG: C
 */

#include <stdio.h>
#include <stdlib.h>

int digits(const int x) {
    int buffer = x;
    int counter = 1;
    while (buffer > 9) {
        buffer = buffer / 10;
        counter++;
    }
    return counter;
}

int main(int argc, char** argv) {
    FILE *in, *out;
    in = fopen("crypt1.in", "r");
    out = fopen("crypt1.out", "w");

    //read input here
    int numofInput;
    int buffer;
    int counter = 0;
    fscanf(in, "%d", &numofInput);
    int digits[numofInput];
    for (counter = 0; counter < numofInput; counter++) {
        buffer = getc(in);
        if (buffer - '0' < 0 || buffer - '0' > 9) {
            counter--;
        } else {
            digits[counter] = buffer - '0';
        }
    }

    while(1){
        
    }


    return (EXIT_SUCCESS);
}

