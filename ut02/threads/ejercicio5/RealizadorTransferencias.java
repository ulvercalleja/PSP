package ut02.threads.ejercicio5;

public class RealizadorTransferencias implements Runnable {
    Transferencia tran;
    private String nombre;

    public RealizadorTransferencias(Transferencia c, String nombre) {
        this.tran = c;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println(nombre + " inicia la transferencia.");
        tran.transferir(nombre);
        System.out.println(nombre + " completa su transferencia.");
    }
}
