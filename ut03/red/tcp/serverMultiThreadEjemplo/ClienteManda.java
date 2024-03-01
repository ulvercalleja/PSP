package ut03.red.tcp.serverMultiThreadEjemplo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ClienteManda {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 1234);
			DataOutputStream  out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("Hola mundo de los sockets!!!\n");

            BufferedReader in = new BufferedReader (new InputStreamReader( socket.getInputStream()));
            System.out.println(in.readLine());
						
			in.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
