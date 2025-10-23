#include <stdio.h>

int main() {
    int num, count = 0;
    scanf("%d", &num);
    while (num != 0) {
        num /= 10;
        count++;
    }
    printf("%d\n", count);
    return 0;
}