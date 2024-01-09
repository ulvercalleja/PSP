package ut03.red;

public class IAscensor {
    private static final long TIEMPO_DESCANSO = 100;
    int cod_ascensor;
    String planta, direccion;

    
    public IAscensor(int cod_ascensor, String planta, String direccion) {
        this.cod_ascensor = cod_ascensor;
        this.planta = planta;
        this.direccion = direccion;
    }

    public void config(int cod_ascensor, String ip, String puerto) {
        
    }

    public void run() {
        try {
            Thread.sleep(TIEMPO_DESCANSO);
            System.out.println(String.format("El ascensor: %d está descansando", cod_ascensor));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void subir() {
         
    }

    public void bajar() {
         
    }

    public String getPlanta() {
        return planta;
    }
    
    public String toProtocolo() {
        String protocolo = "El ascensor: " + cod_ascensor + " - en la planta: " + planta + " en dirección: " + direccion;
        return protocolo;
    }
}
