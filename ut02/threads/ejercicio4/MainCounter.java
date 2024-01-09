package ut02.threads.ejercicio4;
/* Crea una clase Counter con un método sincronizado increment que incremente una variable count. 
Crea dos hilos que incrementen el contador y observa el resultado. Modifica la clase Counter anterior 
para usar un bloque sincronizado en lugar de un método sincronizado.

Modifica el ejercicio para poder incrementar y decrementar, crea 5 hilos que incrementen 1000 veces y 
5 que decrementen 1000 veces. Muestra el resultado de hacer esta operación con sincronización y sin sincornización. */

public class MainCounter {
    public static final int NVECES = 1000000;
    public static void main(String[] args) {
        Counter contador = new Counter(0);
        Thread t1 = new Thread(new Incrementador(contador));
        Thread t2 = new Thread(new Incrementador(contador));
        Thread t3 = new Thread(new Incrementador(contador));
        Thread t4 = new Thread(new Incrementador(contador));
        Thread t5 = new Thread(new Incrementador(contador));
        Thread t6 = new Thread(new Decrementador(contador));
        Thread t7 = new Thread(new Decrementador(contador));
        Thread t8 = new Thread(new Decrementador(contador));
        Thread t9 = new Thread(new Decrementador(contador));
        Thread t10 = new Thread(new Decrementador(contador));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
            t9.join();
            t10.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("El contenido es: %s", contador));
    }
}
