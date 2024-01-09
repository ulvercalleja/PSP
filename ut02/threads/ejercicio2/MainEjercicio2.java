package ut02.threads.ejercicio2;
/*Crea una clase que implemente la interfaz Runnable y sobrescriba el método run 
para imprimir los números del 1 al 10. Luego, instancia y ejecuta el hilo en la clase principal.

Modifica el programa anterior para que cree un array de N Threads y los espere. A cada thread le 
dará un nombre (Método setName) y escribirá la tabla de un número. NOTA: La salida estará desordenada.

Ejecuta el comando en la terminal, y vuelca su salida a un fichero. Utiliza las redirecciones de 
linux y el comando sort para verificar que has escrito todas las tablas.

ulver@ulver-VirtualBox:~/PSP$ javac ut02/threads/ejercicio2/MainEjercicio2.java ut02/threads/ejercicio2/Ejercicio2Runnable.java ut02/threads/ejercicio2/Ejercicio2RunnableV2.java
ulver@ulver-VirtualBox:~/PSP$ java ut02.threads.ejercicio2.MainEjercicio2 5 > salida.txt
ulver@ulver-VirtualBox:~/PSP$ sort salida.txt
ulver@ulver-VirtualBox:~/PSP$ */

public class MainEjercicio2 {
    public static void main(String[] args) {
        Thread runnable = new Thread(new Ejercicio2Runnable());
        runnable.start();

        try {
            runnable.join(); // Espera a que el hilo termine
        } catch (InterruptedException e) {
            System.out.println("Error esperando a hilo: " + e.getMessage());
        }

        int nThreads = Integer.parseInt(args[0]); //El numero de threads se recibiran en la linea de comandos!!

        // Crea el array de N threads
        Thread arrayThreads[] = new Thread[nThreads];
        for (int i = 0; i < nThreads; i++) {
            arrayThreads[i] = new Thread(new Ejercicio2RunnableV2(i + 1));
            arrayThreads[i].setName("Tabla del " + (i + 1) + ": "); // Establece el nombre del hilo
            arrayThreads[i].start();
        }

        // Esperar a que todos los threads terminen
        for (int i = 0; i < arrayThreads.length; i++) {
            try {
                arrayThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
