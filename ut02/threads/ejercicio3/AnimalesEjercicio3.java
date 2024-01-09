package ut02.threads.ejercicio3;

import java.util.Random;

/* Thread que recibe el tipo de animal, la acción y el número máximo.
 * Cada vez que escriba una estrofa, el thread generará un número aleatorio entre 100000 y 300000 y verificará si es primo.
*/
public class AnimalesEjercicio3 extends Thread {
    private String nombreAnimal;
    private String accion;
    private int numMaximo;

    public AnimalesEjercicio3(String nombreAnimal, String accion, int numMaximo) {
        this.nombreAnimal = nombreAnimal;
        this.accion = accion;
        this.numMaximo = numMaximo;
    }

    public void run() {
        for (int i = 1; i <= numMaximo; i++) { 
            int numeroAleatorio = numeroAleatorio(100000, 300000);

            System.out.println(i + " " + nombreAnimal + " " + accion + " sobre la tela de una araña\n" +
                    "Como veían que resistía, fueron a llamar otro " + nombreAnimal);

            if (esPrimo(numeroAleatorio) == true) {
                System.out.println("El numero aleatorio " + numeroAleatorio + " SI es primo.");
            } else {
                System.out.println("El numero aleatorio " + numeroAleatorio + " NO es primo.");
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            
        }
    }

    public int numeroAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public boolean esPrimo (int numero) {
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; 
            }
        }
    
        return true;
    }
}
