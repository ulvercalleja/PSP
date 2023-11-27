#include <stdio.h>
#include <string.h>
#include <openssl/evp.h>

int main() {
    
    char current[2];

    for (current[0] = 'a'; current[0] <= 'z'; current[0]++) {
        for (current[1] = 'a'; current[1] <= 'z'; current[1]++) {

            printf("%s\n", current);
            
        }
    }

    return 0;
}