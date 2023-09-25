#include <stdio.h>

int main(void) {
    int num;
    int suma;
    printf("Introduce un numero");
    scanf("%d", &num);
    printf("Introduce el siguiente numero");
    scanf("%d", &num);

    suma+=num;
    printf("La suma es %d\n",&suma);
    return 0;
}