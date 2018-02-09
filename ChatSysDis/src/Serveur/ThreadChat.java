package Serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ThreadChat extends Thread {
	
	String message;
	Socket socket;
	
	public ThreadChat(Socket socket) {
		this.message = "";
		
		this.socket = socket;
	}
	
	@Override
	public void run() {
		InputStream stream;
		try {
			stream = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			String line = ""; 
			int i = 0;
			while((line = reader.readLine()) != null)
			{
				System.out.println("MSG"+ ++i + " : " + line);
			}
			socket.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String getMessage(){
		return this.message;
	}
	
	
	

}
