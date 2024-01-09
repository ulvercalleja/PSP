package ut02.threads.ejercicio4;

public class Incrementador implements Runnable{
    Counter cont;

    public Incrementador (Counter c){
        this.cont = c;
    }

    @Override
    public void run() {
        for (int i = 0; i< MainCounter.NVECES; i++) {
            cont.incrementa();
        }
   
    }
}
