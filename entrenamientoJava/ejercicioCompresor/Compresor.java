package entrenamientoJava.ejercicioCompresor;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* Investiga el comando tarde linux para crear backups de directorios.

Crea un programa que reciba por parámetro varias rutas del sistema de fichero. El programa comprimirá cada una de ellas con un proceso. Si se reciben 3 directorios creará 3 archivos comprimidos con el nombre de cada directorio y la fecha YYYY-MM-DD.

Ejemplo de ejecución:

java Compresor /home/jorge /var/www /etc
Para simplificar el problema puedes asumir que todos los directorios existen.

Creará en el directorio donde se ejecute:

home_jorge_2023_10_30.tar
var_www_2023_10_30.tar
etc_2023_10_30.tar */

public class Compresor {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java Compresor directorio1 directorio2 ...");
            System.exit(1);
        }

        // Obtener la fecha actual en el formato YYYY-MM-DD
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
        String fechaActual = dateFormat.format(new Date());

        // Recorrer cada directorio proporcionado como argumento
        for (String directorio : args) {
            comprimirDirectorio(directorio, fechaActual);
        }

        System.out.println("Proceso completado.");
    }

    public static void comprimirDirectorio(String directorio, String fechaActual) {
        try {
            // Obtener el nombre del directorio sin la ruta completa
            String nombreDirectorio = directorio.substring(directorio.lastIndexOf('/') + 1);

            // Crear el comando tar para comprimir el directorio
            String comando = "tar -cvf " + nombreDirectorio + "_" + fechaActual + ".tar " + directorio;

            // Ejecutar el comando en un proceso
            Process proceso = Runtime.getRuntime().exec(comando);

            // Esperar a que el proceso termine
            int resultado = proceso.waitFor();

            if (resultado == 0) {
                System.out.println("Directorio '" + directorio + "' comprimido con éxito.");
            } else {
                System.out.println("Error al comprimir el directorio '" + directorio + "'.");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

