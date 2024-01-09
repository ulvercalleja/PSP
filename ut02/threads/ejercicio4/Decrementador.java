package ut02.threads.ejercicio4;

public class Decrementador implements Runnable{
    Counter cont;

    public Decrementador (Counter c){
        this.cont = c;
    }

    @Override
    public void run() {
        for (int i = 0; i< MainCounter.NVECES; i++) {
            cont.decrementa();
        }
   
    }
}
