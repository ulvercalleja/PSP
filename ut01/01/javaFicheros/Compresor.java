import java.util.Date;
import java.text.SimpleDateFormat;

public class Compresor {
    public static void main(String[] args) {
        
        if (args.length == 0) {
            System.out.println("Debes proporcionar al menos una ruta de directorio como argumento.");
            return;
        }

        Date Ahora = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String nombreFecha = dateFormat.format(Ahora);
        
        for (String ruta : args) {
            ProcessBuilder pb = new ProcessBuilder("tar", "-cvf",ruta+nombreFecha, ruta);
        }
        
    }
    
}