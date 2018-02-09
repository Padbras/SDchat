package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;


public class ClientChat {
	Socket socket;
	
	public ClientChat() {
		try {
			System.out.println(new Date() + "-> Client démarré");
			socket = new Socket("localhost", TCP_boucle_Helper.PORT);
			System.out.println(new Date() + " -> Client connecté");
			
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			writer.println("saluuut");
			writer.flush();
			
			writer.println(TCP_boucle_Helper.END_OF_MESSAGE);
			writer.flush();
			
			InputStream stream = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			String line = ""; 
			while((line = reader.readLine()) != null){
				
				System.out.println(new Date() + "-> Recu du serveur" + ":" + line);
			}
		socket.close();
		} catch (UnknownHostException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}