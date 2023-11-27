/*Crea un proceso que cree dos procesos hijos, luego generará N (20) números aleatorios. 
Enviará los pares al primer hijo, los impares al segundo. Los hijos escribirán por pantalla "
Soy el hijo 1|2, he recibido ". Por cada número que mande el padre.*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <time.h>

#define n 20
int main(int argc, char *argv[]) {
    int pipePares[2];
    pipe(pipePares); //Crear tuberia

    int pipeImpares[2];
    pipe(pipeImpares); //Crear tuberia

    // Crear el primer hijo
    pid_t hijo1 = fork();

    if (hijo1 == -1) {
        perror("Error al crear el primer hijo");
        exit(EXIT_FAILURE);
    }

    // Crear el segundo hijo
    pid_t hijo2 = fork();

    if (hijo2 == -1) {
        perror("Error al crear el primer hijo");
        exit(EXIT_FAILURE);
    }

    // Generar un número aleatorio entre 0 y 100
    int numerosAleatorios[n];

    // Semilla para la generación de números aleatorios
    srand(time(NULL));
    for (int i = 0; i < n; i++) {
            numerosAleatorios[i] = rand() % 101;
    }

    if (hijo1 == 0){

        int numerosPares[20];
        int incrementadorPar = 0;

        //Recorrer array de numerosAleatorios para saber si es par
        for (int i = 0; i < n; i++) {

            if (numerosAleatorios[i] % 2 == 0) {
                numerosPares[incrementadorPar] = numerosAleatorios[i]; //Array de todos los numero pares
                incrementadorPar++;
            } 
        }
        write(pipePares[1], &incrementadorPar, sizeof(int));
        write(pipePares[1], numerosPares, sizeof(numerosPares)); //Escribir datos en la tubería
        exit(0);
    }

    if (hijo2 == 0){
        
        int numerosImpares[20];
        int incrementadorImpar = 0;

        //Recorrer array de numerosAleatorios para saber si es impar
        for (int i = 0; i < n; i++) {

            if (numerosAleatorios[i] % 2 != 0) {
                numerosImpares[incrementadorImpar] = numerosAleatorios[i]; //Array de todos los numero impares
                incrementadorImpar++;
            }
        }
        write(pipeImpares[1], &incrementadorImpar, sizeof(int));
        write(pipeImpares[1], numerosImpares, sizeof(numerosImpares)); //Escribir datos en la tubería
        exit(0);
    }
     // Proceso padre
    int numerosPares[20];
    int numerosImpares[20];
    int incrementadorPar = 0;
    int incrementadorImpar = 0;
    int incrementadorHijo1 = 0;
    int incrementadorHijo2 = 0;

    read(pipePares[0], &incrementadorPar, sizeof(int)); // Leer datos de la tubería
    read(pipePares[0], numerosPares, sizeof(numerosPares));

    read(pipeImpares[0], &incrementadorImpar, sizeof(int)); // Leer datos de la tubería
    read(pipeImpares[0], numerosImpares, sizeof(numerosImpares));

    // Determinar la cantidad de elementos escritos por cada hijo
    for (int i = 0; i < n; i++) {
        if (numerosAleatorios[i] % 2 == 0) {
            incrementadorHijo1++;
        } else {
            incrementadorHijo2++;
        }
    }
    
    printf("Números pares:\n");
    for (int i = 0; i < incrementadorHijo1; i++) {
        printf("Soy el hijo 1 y este es mi número par: %d. Tengo un total de: %d numeros pares\n", numerosImpares[i], incrementadorPar);
    }

    printf("Números impares:\n");
    for (int i = 0; i < incrementadorHijo2; i++) {
        printf("Soy el hijo 2 y este es mi número impar: %d. Tengo un total de: %d numeros impares\n", numerosImpares[i], incrementadorImpar);
    }

    wait(NULL);
    wait(NULL);

    return 0;
}