/*Crea un programa Java que describa las ips que tiene en ordenador en linux */

/*NOTA: Para ejecutar este programa mediante javac y java (comandos) 
 Asegúrate de estar en el directorio que contiene el directorio entrenamiento. Puedes usar el comando cd .. para cambiar de directorio.
 Una vez hecho esto: javac entrenamiento/ut01/Ejercicio10.java y java entrenamiento.ut01.Ejercicio10
*/

package entrenamiento.procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio10 {
    public static void main(String[] args) {

        String[] comandos = {"ifconfig", "-a"}; // Array que contiene los comandos que se ejecutarán. 

        try {
            // Crea un objeto ProcessBuilder que representa un proceso
            ProcessBuilder procesoCreado = new ProcessBuilder(comandos);

            // Inicio del proceso
            Process proceso = procesoCreado.start();

            // Lectura de la salida del Proceso
            BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea = "";
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error intentando crear un proceso: " + e.getMessage());
        }
    }
}