package ut02.threads.ejercicio1;

//Esta clase extiende de Thread y sobrescribe el método run para imprimir "Hola Mundo"
public class Ejercicio1Thread extends Thread { 

    @Override
    public void run() {
        System.out.println("¡Hola Mundo! Estoy en thread.");
    }
    
}
