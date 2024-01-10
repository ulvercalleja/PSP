package ut03.red;

public class AscensorPaco implements IAscensor{

    private static final int TIEMPO_DESCANSO = 1000;
    int cod_ascensor;
    String planta, direccion;

    @Override
    public void config(int cod_ascensor, String ip, String puerto) {
        String plantas[] = {"S3","S2","S1","PB","01","02"};
    }

    @Override
    public void run() {
        try {
            Thread.sleep(TIEMPO_DESCANSO);
            System.out.println(String.format("El ascensor: %d está emitiendo una trama de control.", cod_ascensor));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void subir() {
        
    }

    @Override
    public void bajar() {
        
    }

    @Override
    public String getPlanta() {
        return planta;
    }

    @Override
    public String toProtocolo() {
        String protocolo = "El ascensor: " + cod_ascensor + " - en la planta: " + planta + " en dirección: " + direccion;
        return protocolo;
    }
    
}
