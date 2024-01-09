package entrenamientoJava.ejercicioListadoEspacio;
/* Crea un programa que reciba varias rutas y ejecuta por cada una de ellas du -h RUTA | tail -1. 
 * javac entrenamientoJava/ejercicioListadoEspacio/ListadoUsoEspacio.java
 * java entrenamientoJava.ejercicioListadoEspacio.ListadoUsoEspacio /home/ulver/Desktop
    Uso de espacio para el directorio: /home/ulver/Desktop
    4,0K    /home/ulver/Desktop
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListadoUsoEspacio {
    public static void main(String[] args) throws IOException {

        // Verifica si se proporcionaron argumentos. Si no hay argumentos, sale del programa.
        if (args.length == 0) {
            System.exit(1);
        }

        // Recorre cada directorio proporcionado como argumento.
        for (int i = 0; i < args.length; i++) {
            // Construye el comando "du -h <directorio>" para obtener el uso de espacio.
            String[] commands = {"du", "-h", args[i]};
            try {
                System.out.println("Uso de espacio para el directorio: " + args[i]);

                // Crea un constructor de procesos y ejecuta el comando.
                ProcessBuilder pb = new ProcessBuilder(commands);
                Process process = pb.start();
                process.waitFor(); // Espera a que el proceso termine.

                // Lee la salida del proceso e imprime las líneas.
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String s = null;
                while ((s = stdInput.readLine()) != null) {
                    System.out.println(s);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
