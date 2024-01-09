package ut02.threads.ejercicio1;

/*Hilos:
Crea una clase que extienda de Thread y sobrescriba el método run para imprimir "Hola Mundo" en la consola. 
Luego, instancia y ejecuta el hilo en la clase principal.
Crea un versión de forma que implementes Runnable.
Crea una versión con un Lambda.
Haz un método princpial que arranque los 3 threads. */

public class MainEjercicio1 {
    public static void main(String[] args) {
        //Instanciamos y ejecutamos el thread
        Ejercicio1Thread thread = new Ejercicio1Thread();
        thread.start();

        Thread runnable = new Thread(new Ejercicio1Runnable()); 
        runnable.start();

        //Version con lamda
        Runnable runnableLamba = () -> { System.out.println("¡Hola Mundo! Estoy en Lamba runnable"); };
        runnableLamba.run();
    }
}

