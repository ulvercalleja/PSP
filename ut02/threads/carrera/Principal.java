package ut02.threads.carrera;

public class Principal {
    private static final int TOTAL_CARRERA = 100;
    private static final int NUM_CORREDORES = 10;

    public static void main(String[] args) {
        
        
        Thread [] arrayThread = new Thread [NUM_CORREDORES];

        System.out.println("¡¡ESTO COMIENZA... YA!!");
        
        for (int i = 0; i < NUM_CORREDORES; i++) {
            arrayThread[i] = new Thread(new Corredor(TOTAL_CARRERA, (int) (Math.random()*5000)));
        }
        
        for (Thread corredor : arrayThread) {
            corredor.start();
        }

        for (Thread corredor : arrayThread) {
            try {
                corredor.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("¡¡SE ACABÓ!! ¡¡NO HAY TIEMPO PARA MÁS!!");
    }
}
