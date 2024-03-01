package ut03.red.udp.Ascensor;

public interface IAscensor {

    public void config(int cod_ascensor, String ip, String puerto);

    public void run();

    public void subir();

    public void bajar();

    public String getPlanta();
    
    public String toProtocolo();
}
