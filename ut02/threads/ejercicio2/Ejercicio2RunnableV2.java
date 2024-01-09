package ut02.threads.ejercicio2;

public class Ejercicio2RunnableV2 implements Runnable{

    private static final int MULTIPLICADOR = 10;
    private int numero;
    
    public Ejercicio2RunnableV2(int numero) {
        this.numero = numero;
    }

    public void run() {
        int resultado = 0;

        for (int i = 1; i <= MULTIPLICADOR; i++) { // Hace la tabla de multiplicar del numero
            resultado = numero * i;
            System.out.println(numero + "*" + i + "=" + resultado);
        }

        System.out.println(String.format("Tabla del %d terminada.", numero));
    }
    
}
