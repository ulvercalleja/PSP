/*Crea un proceso que cree un proceso hijo, el envíe 3 números enteros aleatorios a través de un pipe. 
El proceso hijo los ordenará y los escribirá en el fichero salida.txt.*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <time.h>

//#define NUM_NUMALEATORIO 3
int main(int argc, char *argv[]) {

    // Crear pipe 
    int pipe_fd[2];
    
    if (pipe(pipe_fd) == -1) {
        perror("No se ha creado el pipe o tubería");
        return 1;
    }

    // Crear hijo
    pid_t hijo = fork();

    if (hijo == -1) {
        perror("Error al crear el proceso hijo");
        exit(EXIT_FAILURE);
    }

    if (hijo > 0){ // Código del proceso padre al ser mayor de 0

        // Leer los números del pipe
        int numerosAleatorios[3];
        read(pipe_fd[0], numerosAleatorios, sizeof(numerosAleatorios));

        // Esperar a que el hijo termine
        wait(NULL);

         // Abrir el archivo de salida
        FILE *archivo_salida = fopen("salida.txt", "w");

        // Escribir los números ordenados en el archivo
        fprintf(archivo_salida, "%d %d %d\n", numerosAleatorios[0], numerosAleatorios[1], numerosAleatorios[2]);

        // Cerrar el archivo de salida
        fclose(archivo_salida);

    } else {

        // Generar un número aleatorio entre 0 y 100
        int numerosAleatorios[3];

        // Semilla para la generación de números aleatorios
        srand(time(NULL));
        for (int i = 0; i < 3; i++) {
            numerosAleatorios[i] = rand() % 101;
        }

        // Ordenar los números
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2 - i; j++) {
                if (numerosAleatorios[j] > numerosAleatorios[j + 1]) {
                    int temp = numerosAleatorios[j];
                    numerosAleatorios[j] = numerosAleatorios[j + 1];
                    numerosAleatorios[j + 1] = temp;
                }
            }
        }

        // Escribir los números en el pipe
        write(pipe_fd[1], numerosAleatorios, sizeof(numerosAleatorios));

        // Salir del proceso hijo
        exit(EXIT_SUCCESS);
    }
    return 0;
}