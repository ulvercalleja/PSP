/*Crea un programa que permita hacer lo siguiente: primer parámetro operación suma, 
resta, multiplicación o división. Si es división el segundo operador no puede ser 0.
Ten en cuenta que necesita al menos 3 parámetros, de lo contrario deberá aparecer un mensaje de error.*/

#include <stdio.h>

int main(int argc, char *argv[]) {

    printf("Por favor, introduzca la operacion que desea realizar: \n");
    printf("Sumar\n Restar\n Multiplicar\n Dividir\n");
    
    if (argc != 4) {
        printf("ERROR: El programa necesita 3 parámetros.\n");
        return 1;
    }

    char *operacion = argv[1];
    double num1 = atof(argv[2]);
    double num2 = atof(argv[3]);

    if (operacion == "suma") {
        printf("%.2lf\n", num1 + num2);
    } else if (operacion == "resta") {
        printf("%.2lf\n", num1 - num2);
    } else if (operacion == "multiplicacion") {
        printf("%.2lf\n", num1 * num2);
    } else if (operacion == "division") {
        if (num2 == 0) {
            printf("ERROR: No se puede dividir por 0.\n");
        } else {
            printf("%.2lf\n", num1 / num2);
        }
    } else {
        printf("ERROR: Por favor, introduzca una de estas operaciones: suma, resta, multiplicacion o division.\n");
    }
    
    return 0;
}