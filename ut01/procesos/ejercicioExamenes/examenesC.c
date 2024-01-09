/*Los arrays pueden ser de cualquier tipo de dato. Crea un programa
que pida al usuario las notas que ha sacado en 5 exámenes. Almacena la información
en un array. Después mostrá una lista con la nota de los exámenes y si ha aprobado o no.
La nota media, la nota más alta y la nota más baja.
*/
#include <stdio.h>
int main()
{
    float notas[5];
    float suma = 0;
    float nota_maxima = 0;
    float nota_minima = 10; // Inicializar con un valor alto para asegurar que se actualice correctamente
    int i;

    printf("Ingrese las notas de los 5 exámenes:\n");

    for (i = 0; i < 5; i++)
    {
        printf("Examen %d: ", i + 1);
        scanf("%f", &notas[i]);

        suma += notas[i];

        // Nota máxima
        if (notas[i] > nota_maxima)
        {
            nota_maxima = notas[i];
        }

        // Nota mínima
        if (notas[i] < nota_minima)
        {
            nota_minima = notas[i];
        }
    }

    // CNota media
    float nota_media = suma / 5;

    // Aprobado o no
    printf("Lista de notas:\n");
    for (i = 0; i < 5; i++)
    {
        printf("Examen %d: %.2f ", i + 1, notas[i]);
        if (notas[i] >= 5)
        {
            printf("(Aprobado)\n");
        }
        else
        {
            printf("(Suspenso)\n");
        }
    }

    // Mostrar la nota media, la nota más alta y la nota más baja
    printf("Nota media: %.2f\n", nota_media);
    printf("Nota más alta: %.2f\n", nota_maxima);
    printf("Nota más baja: %.2f\n", nota_minima);
    
    return 0;
}