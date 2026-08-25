#include <stdio.h>

void print_math(int a, int b) {
    printf("Sum: %6i\n", a + b);
    printf("Product: %2i\n", a * b);
}

int main () {
    int a, b;

    printf("Enter first number: ");
    scanf("%i", &a);

    printf("Enter second number: ");
    scanf("%i", &b);

    print_math(a, b);

    return 0;
}