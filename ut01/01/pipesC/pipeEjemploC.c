#include  <stdio.h>
#include  <signal.h>
#include  <stdlib.h>
#include <unistd.h>

void signal_handler(int signo) {
     
    if (signo == SIGUSR1) {
        printf("hola\n");
    } else if (signo == SIGUSR2) {
        printf("mundo\n");
    }
     
}

int main(void) {
     signal(SIGUSR1, signal_handler);
     signal(SIGUSR2, signal_handler);
     while (1) {
        sleep(1);
    }
}

