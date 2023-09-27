/*Enunciado: Crea un programa que solicite al usuario ingresar un 
número entero positivo y determine si es un número primo o no.
*/
#include <stdio.h>
int main() {
    int num;
    int i;
    int a = 0;

    printf("Introduce un numero");
    scanf("%d", &num);
    while (num <1 )
    {
        printf("Introduce un numero POSITIVO");
        scanf("%d", &num);
    }
    for (i=1;i<=num;i++) {
        if(num%i==0) // si num1 módulo de i es 0, incrementamos a en 1.
        a++;
    }
    if(a==2){
        printf("El número es primo");
    } else { printf("El número no es primo"); }

    return 0;

}
