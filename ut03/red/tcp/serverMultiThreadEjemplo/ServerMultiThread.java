package ut03.red.tcp.serverMultiThreadEjemplo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMultiThread {

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
						for (int x = 0; x < 32; x++) {
							for (int i = 0; i < 1; i++) {
								out.writeUTF(x + s.toUpperCase());
							}
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
