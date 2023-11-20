package ut02.threads.carrera;

public class Corredor implements Runnable{
    private static final long TIEMPO_DESCANSO = 500;
    private static final double MAX_INTERVALO_KM = 10;
    int kmRecorrido;
    int kmTotales;
    int dorsal;
    Object salida;
    public Corredor(int kmTotales, int dorsal, Object salida) {
        this.kmTotales = kmTotales;
        this.dorsal = dorsal;
        kmRecorrido = 0;
        this.salida = salida;
    }

    @Override
    public void run() {
        
        synchronized(salida){
            try {
                salida.wait();
            } catch (Exception e) {
                System.out.println("ERROR esperando: " + e.getMessage());
            }
        }

        System.out.println(String.format("¡¡Soy el dorsal %d inicio mi carrera!!", dorsal));
        while (kmRecorrido < kmTotales) {
            try {
                Thread.sleep((long) ((Math.random()*TIEMPO_DESCANSO)+TIEMPO_DESCANSO));
                System.out.println(String.format("¡¡Soy el dorsal %d estoy descansando tras una dura sesion!! He recorrido %d/%d kilometros", dorsal, kmRecorrido, kmTotales));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            kmRecorrido+=Math.random()*MAX_INTERVALO_KM;
        }
        System.out.println(String.format("Soy el dorsal %d TERMINÉ!!", dorsal));
    }
}
