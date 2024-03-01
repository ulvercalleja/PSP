package ut03.red.udp.Broadcast;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientBroadcast {

    public static void main(String[] args) {
        try{
            DatagramSocket ds = new DatagramSocket();
            byte buffer[] = "Hola mundo \n".getBytes();
            String ip = "172.20.255.255";
            ds.setBroadcast(true);
            DatagramPacket p = new DatagramPacket(
                            buffer, 
                            buffer.length, 
                            InetAddress.getByName(ip),
                            4321
                    );

            ds.send(p);
            ds.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}