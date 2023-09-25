#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main(void) {
    pid_t id;   //Declaro variable para declarar id de procesos

    int n = 42;
    double pi = 3.14;

    // CLONACION!
    id = fork();

    // Ahora hay dos procesos
    if(id != 0) {
        // Padre
        printf("Soy el padre, mi id es %d, mi hijo es:  %d\n" , getpid(), id);
    } else {
        //Hijo
        printf("Soy el hijo mi id es %d, mi hijo es:  %d\n" , getpid(), id);
    }

    return 0;
}