/*Crea un programa que reciba un número n por parámetro. 
El programa creará n hijos y les enviará una señal a cada uno de ellos para matarlos.*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <signal.h>

#define MIN_HIJOS 0
#define NUM_HIJO 0
#define NUM_ERROR_HIJO -1

int main(int argc, char *argv[]) {
    
    int numHijos = atoi(argv[1]); // Leer numero introducido por parametros

    if (numHijos <= MIN_HIJOS) {
        printf("El número de hijos debe ser un entero positivo.\n");
        return 1;
    }
    
    for (int i = 0; i < numHijos; i++) {

        pid_t hijo = fork();

        if (hijo == NUM_ERROR_HIJO) { // Comprobar si se ha creado hijo correctamente
            perror("Error al crear el primer hijo");
            exit(EXIT_FAILURE);

        } else if (hijo == NUM_HIJO) { // Proceso hijo
            hijo = getpid();
            printf("PID HIJO: %d", hijo);
        }
    }
    /*
    for (int i = 0; i < numHijos; i++) {
        printf("Hijo muerto: %d\n", hijos[i]);
        kill(hijos[i], SIGKILL);
    } */
    
    return 0;
}