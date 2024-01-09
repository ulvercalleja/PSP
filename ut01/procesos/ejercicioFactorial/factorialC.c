/* Enunciado: Desarrolla un programa que permita al usuario
ingresar un número entero no negativo y calcule su factorial.
Asegúrate de manejar adecuadamente los casos de entrada inválida. */

#include <stdio.h>
#include <math.h>

int main()
{
    float nIntroducido = 1;
    int i, factorial = 1;

    while (1)
    {
        printf("Ingrese un numero entero positivo: ");
        scanf("%f", &nIntroducido);
        if (nIntroducido < 0 && isnan(nIntroducido))
        {
            printf("No has introducido un numero positivo.");
        }
        else
        {
            for (i = 1; 1 < nIntroducido; i++)
            {
                factorial += 1;
                break;
            }
        }
    }
    printf("El factorial de %f es %d\n", nIntroducido, factorial);
    
    return 0;
}