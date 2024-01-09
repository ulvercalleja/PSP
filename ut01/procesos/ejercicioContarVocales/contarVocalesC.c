/* Escribe un programa en C que le pida al usuario ingresar una cadena de caracteres 
y luego cuente y muestre en pantalla el número de vocales (mayúsculas y minúsculas) 
presentes en la cadena. El programa debe ser sensible a mayúsculas y minúsculas. */

#include <stdio.h>
#include <string.h>
#include <ctype.h>
#define BUFFER 1024

int main() {
    char cadena[BUFFER];
    int numVocales = 0;
    printf("Introduzca una cadena:\n");
    fgets(cadena, BUFFER, stdin);

    int longitud = strlen(cadena);

    for (int i = 0; i < longitud; i++)
    {
        char actual = tolower(cadena[i]);

        if (actual == 'a' || actual == 'e' || actual == 'i' || actual == 'o' || actual == 'u') {
            numVocales++;
        }
    }
    
    printf("La cadena tiene: %d vocales.\n", numVocales);

    getch();
    
    return 0;
}
