package ut02.threads.ejercicio2;
/* Clase que implementa la interfaz Runnable y sobrescribe el método 
run para imprimir los números del 1 al 10*/

public class Ejercicio2Runnable implements Runnable{

    private static final int NUM_MAX = 10;

    @Override
    public void run() {
        for (int i = 1; i <= NUM_MAX; i++) {
            System.out.println("¡Hola! Soy la clase Runnable y mi numero es el: " + i);
        }
    }
    
}
