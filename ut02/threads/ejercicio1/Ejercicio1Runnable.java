package ut02.threads.ejercicio1;

//Esta clase emplementa Runnable y sobrescribe el método run para imprimir "Hola Mundo"
public class Ejercicio1Runnable implements Runnable{

    @Override
    public void run() {
        System.out.println("¡Hola Mundo! Estoy en Runnable.");
    }
    
}
