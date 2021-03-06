import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
public class ServeurTCP_boucle {

	boolean continuer = true ;
	ServerSocket serverSocket ;
	Socket socket ;
	
	public ServeurTCP_boucle() {
		try{
			serverSocket = new ServerSocket(TCP_boucle_Helper.PORT ) ;
			int i ;
			while (continuer){
				System. out .println(new Date() + " -> Serveur Prêt") ;
				socket = serverSocket.accept() ;
				System. out .println(new Date() + " -> Client connecté");
				
				InputStream stream = socket.getInputStream() ;
				BufferedReader reader = new BufferedReader(new InputStreamReader(stream)) ;
				String line = "";
				i = 0;
				while ( (line = reader.readLine()).compareTo(TCP_boucle_Helper. END_OF_MESSAGE ) != 0 ){
					System. out .println("MSG "+ ++i + " : " + line);
				}
				PrintWriter writer = new PrintWriter(socket.getOutputStream()) ;
				writer.println("Au revoir !") ;
				writer.flush() ;
				
				try {
					Thread. sleep (20000 ) ;
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
				socket.close() ;
			}
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		}
		public static void main(String[] args) {
		new ServeurTCP_boucle() ;
		}
}