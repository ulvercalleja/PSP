package ut03.red.tcp.serverMultiThreadNumAleatorio;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class ClienteManda {

	public static void main(String[] args) {

		try {
			Socket socket = new Socket("127.0.0.1", 1234);
			DataOutputStream  out = new DataOutputStream(socket.getOutputStream());

			Scanner sc = new Scanner(System.in);
			System.out.println("Introduzca una cadena. Para salir escriba 'salir'.");
        	String message = sc.nextLine();
			out.writeUTF(message);

            BufferedReader in = new BufferedReader (new InputStreamReader( socket.getInputStream()));
            System.out.println(in.readLine());
			sc.close();
			in.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
