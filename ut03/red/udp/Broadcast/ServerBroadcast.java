package ut03.red.udp.Broadcast;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class ServerBroadcast {
    public static final int SOCKET = 4321;
    private static final int BUFFER = 1024;

    public static void main(String[] args){
        try{
            DatagramSocket socket = new DatagramSocket(SOCKET);
            byte[] receivedData = new byte[BUFFER];

            while (true) {
                DatagramPacket receivedPacket = new DatagramPacket (receivedData, receivedData.length);
                socket.receive(receivedPacket);

                InetAddress ipClient = receivedPacket.getAddress();
                System.out.println("Mensaje recibido de la IP: " + ipClient.toString());
            
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
