#include <stdio.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void broken_swap(int a, int b) {
    /* does not work because a and b are COPIES of the original 
    values. this only makes changes to the local copies, not the
    original values because they are at different memory addresses */
    int temp = a;
    a = b;
    b = temp;
}


int main() {
    int x = 5;
    int y = 10;

    printf("===Correct Swap===\n");
    printf("Before swap: x = %i, y = %i\n", x, y);
    swap(&x, &y);
    printf("After swap: x = %i, y = %i\n", x, y);

    printf("\n===Broken Swap===\n");
    printf("Before swap: x = %i, y = %i\n", x, y);
    broken_swap(x, y);
    printf("After swap: x = %i, y = %i\n", x, y);

    return 0;
}