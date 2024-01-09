package ut02.threads.ejercicio4;

public class Counter {
    private int c = 0;
  
    public Counter (int c) {
      this.c = c;
    }
    
    public synchronized void incrementa() {
      c= c+1;
    }
    public synchronized void decrementa() {
      c =c-1;
    }
    
    public String toString() {
      return String.valueOf(c);
    }

}
