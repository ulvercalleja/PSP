package ut02.threads.ejercicio3;
/*Un elefante se balanceaba sobre la tela de una araña
Como veía que resistía, fue a llamar otro elefante
Dos elefantes se balanceaban sobre la tela de una araña
Como veían que resistía, fueron a llamar otro elefante

Basándote en esa canción, crea un Thread que reciba el tipo de animal, la acción y el número máximo. 
Cada vez que escriba una estrofa, el thread generará un número aleatorio entre 100000 y 300000 y verificará si es primo.

Crea un programa principal que gestion 3 canciones infantiles de forma concurrente con distintas prioridades (setPriority) */
public class MainEjercicio3 {
    public static void main(String[] args) {
        AnimalesEjercicio3 husky = new AnimalesEjercicio3("Husky", "tiraba del trineo", 5);
        AnimalesEjercicio3 gatito = new AnimalesEjercicio3("Gatito", "arañaba gente", 3);
        AnimalesEjercicio3 loro = new AnimalesEjercicio3("Loro", "repetia cosas", 5);

        Thread threadHusky = new Thread(husky);
        Thread threadGatito = new Thread(gatito);
        Thread threadLoro= new Thread(loro);

        threadHusky.setPriority(Thread.MAX_PRIORITY);
        threadGatito.setPriority(Thread.NORM_PRIORITY);
        threadLoro.setPriority(Thread.MIN_PRIORITY);

        threadHusky.start();
        threadGatito.start();
        threadLoro.start();
    }
}
