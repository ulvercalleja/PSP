#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int esPrimo(int n){
    int primo = 2;
    int i = 2;

    while (primo && i < n/2)
    {
        if (n%i==0)
        {
            primo = 0;
        }
        i++;
    }
    
    return primo;
}

int main(void) {
    pid_t id;   //Declaro variable para declarar id de procesos

    unsigned int n = 3203022347;

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