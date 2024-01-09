package entrenamientoJava.ejercicioMonitorMemoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*Crea un programa que ejecute cada N segundos (5seg) el comando free -h y escriba por pantalla el estado de la memoria del sistema.
ulver@ulver-VirtualBox:~/PSP$ javac entrenamientoJava/ejercicioMonitorMemoria/MonitorMemoria.java
ulver@ulver-VirtualBox:~/PSP$ java entrenamientoJava.ejercicioMonitorMemoria.MonitorMemoria
               total        used        free      shared  buff/cache   available
Mem:           6,2Gi       1,8Gi       2,3Gi        44Mi       2,1Gi       4,2Gi
Swap:          1,1Gi          0B       1,1Gi
               total        used        free      shared  buff/cache   available
Mem:           6,2Gi       1,8Gi       2,4Gi        43Mi       2,1Gi       4,2Gi
Swap:          1,1Gi          0B       1,1Gi
               total        used        free      shared  buff/cache   available
Mem:           6,2Gi       1,8Gi       2,3Gi        42Mi       2,1Gi       4,2Gi
Swap:          1,1Gi          0B       1,1Gi
ulver@ulver-VirtualBox:~/PSP$
*/
public class MonitorMemoria {

    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            try {

                // Ejecuta el comando free -h y obtiene el proceso
                ProcessBuilder processBuilder = new ProcessBuilder("free", "-h");
                Process process = processBuilder.start();
                // Lee la salida del proceso
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

                String s = null;
                while ((s = stdInput.readLine()) != null) {
                    System.out.println(s);
                }

                Thread.sleep(5000);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
