package ut02.threads.ejercicio5;

public class Transferencia {
    private int cuenta = 0;
    private static final int nTransferencias = 1000;
    private static final int dinero = 10;
  
    public Transferencia(int cuenta) {
      this.cuenta = cuenta;
    }
    
    public synchronized void transferir(String nombre) {
        System.out.println("El thread de " + nombre + " adquiere el bloqueo del objeto cuenta.");

        for(int i = 0; i < nTransferencias; i++){
            cuenta = cuenta + dinero;
        }
        System.out.println("El thread de " + nombre + " libera el bloqueo.");
    }
    
    public String toString() {
      return String.valueOf(cuenta);
    }
}
