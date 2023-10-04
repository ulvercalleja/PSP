/* Crea un programa en C que determine si una palabra o frase ingresada
por el usuario es un palíndromo o no. Un palíndromo es una palabra o frase
que se lee igual de izquierda a derecha y de derecha a izquierda, ignorando
espacios y signos de puntuación. El programa debe eliminar los espacios y
considerar solo las letras en la verificación. */

#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>
#define BUFFER 1024

int main()
{
    char cadena[BUFFER], cadenaSinEspacios[BUFFER];
    int numVocales = 0;
    bool palindromo;

    printf("Introduce una frase: ");
    fgets(cadena, BUFFER, stdin);

    int i, j;
    i = 0;
    j = 0;

    // Quitar espacios
    while (cadena[i] != '\0')
    {
        if (cadena[i] != ' ')
        {
            cadenaSinEspacios[j] = cadena[i];
            j++;
        }
        i++;
    }

    int longitud = strlen(cadenaSinEspacios);

    // Comparar cadena desde el principio y desde el final
    for (int i = 0; i < longitud; i++)
    {
        for (int o = longitud; o <= 0; o--)
        {
            char actualA = tolower(cadenaSinEspacios[i]);
            char actualB = tolower(cadenaSinEspacios[o]);
            if (actualA == actualB)
            {
                palindromo = true;
            }
            else
            {
                palindromo = false;
                break;
            }
        }
    }

    if (palindromo == true)
    {
        printf("La frase es un palindromo.");
    }
    else
    {
        printf("La frase no es un palindromo.");
    }
}
/*
#include <stdio.h>
#include <stringh>
#include <ctype.h>
#define BUFFER 1024

int main() {
    char frase[BUFFER];
    int esPalindromo = 1;
    fprintf(stdout, "Introduce una frase: ");
    scanf(" %[\n]", frase];

    int longitudFrase = strlen(frase);
    for (int i = 0, j = longitudFrase - 1; i < j; i++, j--){
        while(isspace(frase[1])) {
            i++;
        }
        while(isspace(frase[1])) {
            j--;
        }
        if (tolower(frase[i]) != tolower(tolower(frase[j])){
            
        }
    }
{
            = longitudErase return 0;
}*/