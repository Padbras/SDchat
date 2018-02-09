package Serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPServeur 
{

	static final int PORT = 6666;
	ArrayList<ThreadChat> myThreads = new ArrayList<ThreadChat>();

	
	public TCPServeur(){	
		
		try
		{
			//myThreads = new Thread[10];

			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("Serveur prêt");

			Socket socket =  serverSocket.accept();
			System.out.println("Client connecté");
			
			ThreadChat t1 = new ThreadChat(socket) ;
			
			myThreads.add(t1);
	
			InputStream stream = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			String line = ""; 
			int i = 0;
			while((line = reader.readLine()) != null)
			{
				System.out.println("MSG"+ ++i + " : " + line);
			}
			socket.close();

		} catch(IOException e) 
			{
				e.printStackTrace();
			}
		
	}
	

}

