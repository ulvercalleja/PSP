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
    double num1 = atoi(argv[2]);
    double num2 = atoi(argv[3]);
/*
    const char *operacion = argv[1];
    const char *num1_str = argv[2];
    const char *num2_str = argv[3];
    int resultado;
    int num1 = atoi (num1_str);
    int num2 = atoi (num2_str);
*/
    if (strcmp(operacion, "suma") == 0) {
        printf("%.2lf\n", num1 + num2);
    } else if (strcmp(operacion, "resta") == 0) {
        printf("%.2lf\n", num1 - num2);
    } else if (strcmp(operacion, "multiplicacion") == 0) {
        printf("%.2lf\n", num1 * num2);
    } else if (strcmp(operacion, "division") == 0) {
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