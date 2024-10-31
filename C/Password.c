#include <stdlib.h>
#include <stdio.h>

int main() {
    int pin, attempt = 3;

    do {
        printf("Enter your pin: ");
        scanf("%d", &pin);
        attempt--;

        if (pin != 4008) {
            printf("Incorrect PIN\n");
        }

        if (attempt == 0 && pin != 4008) {
            printf("Incorrect PIN and no further attempts left\n");
            exit(EXIT_FAILURE);
        }
    } while (pin != 4008);

    printf("Welcome User!\n");
    return 0;
}
