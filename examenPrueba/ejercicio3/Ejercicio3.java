/*
 *Realiza un programa Java que reciba como parámetro el nombre de un usuario. 
 El programa Java ejecutará un “ps aux” (comando linux), leerá la información del comando, 
 mostrará la cabecera y todos los procesos de ese usuario que consumen más del 0.0 de memoria.
 
ulver@ulver-VirtualBox:~/PSP$ javac examenPrueba/ejercicio3/Ejercicio3.java
java examenPrueba.ejercicio3.Ejercicio3 ulver
USER         PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
ulver       1508  0.0  0.1  17288  9912 ?        Ss   12:36   0:00 /lib/systemd/systemd --user
ulver       1517  0.0  0.4 1162864 27168 ?       S<sl 12:36   0:00 /usr/bin/pulseaudio --daemonize=no --log-target=journal
ulver       1520  0.0  0.1 243432  7620 ?        Sl   12:36   0:00 /usr/bin/gnome-keyring-daemon --daemonize --login
ulver       1525  0.0  0.4 378648 26468 ?        Ssl  12:36   0:00 cinnamon-session --session cinnamon
ulver       1766  0.0  0.1 243172  8256 ?        Ssl  12:36   0:00 /usr/libexec/gvfsd
ulver       1771  0.0  0.1 380888  6688 ?        Sl   12:36   0:00 /usr/libexec/gvfsd-fuse /run/user/1000/gvfs -f ...
ulver@ulver-VirtualBox:~/PSP$*/
package examenPrueba.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio3 {
    public static void main(String[] args) throws InterruptedException {
        String[] commands = {
                "ps",
                "aux"
        };
        // Obtiene el nombre de usuario como argumento de la línea de comandos
        String usuario = args[0];

        try {
            // Crea un constructor de procesos y ejecuta el comando
            ProcessBuilder pb = new ProcessBuilder(commands);
            Process process = pb.start();

            // Espera a que el proceso termine
            process.waitFor();
            // Lee la salida del proceso
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Imprime la cabecera
            System.out.println("USER         PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND");

            // Lee cada línea de la salida del comando "ps aux"
            String linea;
            while ((linea = stdInput.readLine()) != null) {
                // Divide la línea en partes usando espacios como separadores
                String[] partes = linea.split("\\s+"); 
                // Verifica que haya al menos 11 partes (las columnas de la salida de "ps aux")
                if (partes.length >= 11) {
                    // Extrae el nombre de usuario y el porcentaje de memoria utilizado
                    String usuarioProceso = partes[0];
                    String memoria = partes[3];

                    // Comprueba si el usuario es el proporcionado y la memoria es mayor que 0.0
                    if (usuarioProceso.equals(usuario) && Double.parseDouble(memoria) > 0.0) {
                        System.out.println(linea);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}