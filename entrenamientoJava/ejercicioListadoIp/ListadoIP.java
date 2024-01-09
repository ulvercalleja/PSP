package entrenamientoJava.ejercicioListadoIp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Crea un programa que sea capas de mostrar un listado de todas las ip que tiene un sistema. Se debe poder ejecutar tanto en Windows como en Linux.
ulver@ulver-VirtualBox:~/PSP$ javac entrenamientoJava/ejercicioListadoIp/ListadoIP.java
ulver@ulver-VirtualBox:~/PSP$ java entrenamientoJava.ejercicioListadoIp.ListadoIP
Direcciones IP encontradas:
inet 10.0.2.15  netmask 255.255.255.0  broadcast 10.0.2.255
inet 127.0.0.1  netmask 255.0.0.0
ulver@ulver-VirtualBox:~/PSP$
*/
public class ListadoIP {
    public static void main(String[] args) throws InterruptedException {
        // Obtiene el nombre del sistema operativo en minúsculas.
        String sistemaOperativo = System.getProperty("os.name").toLowerCase();

        // Verifica el sistema operativo y llama al método correspondiente para listar las IPs.
        if (sistemaOperativo.contains("win")) {
            listarIPsWindows();
        } else if (sistemaOperativo.contains("nix") || sistemaOperativo.contains("nux")
                || sistemaOperativo.contains("mac")) {
            listarIPsLinux();
        } else {
            System.out.println("Sistema operativo no soportado.");
        }
    }

    // Método para listar las IPs en Windows.
    public static void listarIPsWindows() throws InterruptedException {
        ejecutarComando("ipconfig");
    }

    // Método para listar las IPs en sistemas basados en Unix (Linux, MacOS).
    public static void listarIPsLinux() throws InterruptedException {
        ejecutarComando("ifconfig");
    }

    // Método para ejecutar un comando y procesar su salida para extraer las direcciones IP.
    public static void ejecutarComando(String commands) throws InterruptedException {
        try {
            // Crea un constructor de procesos y ejecuta el comando proporcionado.
            ProcessBuilder pb = new ProcessBuilder(commands);
            Process process = pb.start();
            process.waitFor(); // Espera a que el proceso termine.

            // Lee la salida del proceso.
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String s;
            System.out.println("Direcciones IP encontradas:");

            // Lee cada línea de la salida y muestra las líneas que contienen direcciones
            // IP.
            while ((s = stdInput.readLine()) != null) {
                if (s.matches(".*\\d+\\.\\d+\\.\\d+\\.\\d+.*")) {
                    System.out.println(s.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
