package ServerPackage;
import java.io.*;
import java.net.*;
public class Server {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int serverPort = 1234;
		try {
		// la premiere étape :
		ServerSocket ss= new ServerSocket(serverPort);
		System.out.println("je suis en attente de la connexion d'un client");
		//la deuxieme etape :
		Socket s = ss.accept();
		System.out.println("un client est connecté");
		
		System.out.println("Génération de l'objet InputStream et OutputStream de la socket");
		// 3ème étape : lire une CC envoyée par un client
		// flux de communication
		InputStream is = s.getInputStream();
		// flux de traitement
		 InputStreamReader isr= new InputStreamReader(is);
		 BufferedReader br = new BufferedReader(isr);
		 String b= br.readLine();
		 System.out.println(b);
		 
		OutputStream os = s.getOutputStream();
		
		System.out.println("j'attend un nombre");
		int nb = is.read();
		int rep = nb*5;
		
		System.out.println("j'envoie la réponse");
		os.write(rep);
		//la derniere etape : fermer socket
		System.out.println("Déconnexion du client");
			s.close();	
			ss.close();	
		}catch(Exception e){}
}
}
