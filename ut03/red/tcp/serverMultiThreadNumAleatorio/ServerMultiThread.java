package ut03.red.tcp.serverMultiThreadNumAleatorio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServerMultiThread {

	private static final String EXIT = "salir";

	public static void main(String[] args) {
		ServerSocket server;
		try {
			server = new ServerSocket(1234);
			while(true) {
				// Espera cliente
				Socket socket = server.accept();
				
				new Thread(()->{
					
					try {
						DataInputStream in = new DataInputStream ( socket.getInputStream());
						DataOutputStream out = new DataOutputStream(socket.getOutputStream());
						
						String s = in.readLine();
                        System.out.println(s);
						if (s.toLowerCase().equals(EXIT)) {
							socket.close();
                            System.out.println("Conexión cerrada con el cliente.");
						} else {
							int randomNumber = new Random().nextInt(1000);
							out.writeUTF(String.valueOf(randomNumber));
						}
						
						in.close();
						out.close();
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
