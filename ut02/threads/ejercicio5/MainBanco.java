package ut02.threads.ejercicio5;
/* Imagina un sistema de banco en línea que maneja las cuentas de los usuarios. 
Dos usuarios, Alice y Bob, intentan transferir dinero de sus cuentas a una tercera cuenta al mismo tiempo. 
Necesitas asegurarte de que las operaciones se realicen de manera segura y sin conflictos, utilizando sincronización.

Crea dos threads, uno para cada usuario. Cada thread intentará realizar 1000 transferencia de dinero de 10 euros. 
Usa un método synchronized para asegurar que las operaciones en las cuentas no se realicen simultáneamente, evitando así condiciones de carrera.

Ejecuciones:

Haz una ejcución sin sincronización
Haz una ejecución sincronizada
Posible ejecución sincronizada:

Alice inicia la transferencia.
El thread de Alice adquiere el bloqueo del objeto cuenta.
Bob intenta iniciar su transferencia pero debe esperar.
Alice completa su transferencia y libera el bloqueo.
Bob adquiere el bloqueo y realiza su transferencia*/
public class MainBanco {
    public static void main(String[] args) {

        Transferencia c = new Transferencia(0);
        Thread bob = new Thread(new RealizadorTransferencias(c, "Bob"));
        Thread alice = new Thread(new RealizadorTransferencias(c, "Alice"));

        bob.start();
        alice.start();

        try {
            bob.join();
            alice.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("El contenido de la cuenta es: %s", c));
    
    }
}
