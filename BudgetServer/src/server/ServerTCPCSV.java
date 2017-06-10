package server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCPCSV {
	
	private ServerSocket server = null;
	private Socket client = null;
	final int port = 5000;
	
	private InputStream in;
	private InputStreamReader inr;
	private BufferedReader br;
		
	private FileMake fm;
	
	private String userID = null;
	private String checking = null;
	
	ServerTCPCSV(){
		try{
			
			server = new ServerSocket(port);
			System.out.println("Server waiting");
			client = server.accept();
			System.out.println("connection : "+client.getInetAddress());
			
			in = client.getInputStream();
			inr = new InputStreamReader(in);
			br = new BufferedReader(inr);
			
			userID = br.readLine();
			
			while( userID == null ){
				userID = br.readLine();
			}
			
			System.out.println(userID);
			
			in.close();
			inr.close();
			br.close();
			server.close();
			
			AnalyzeThread at = new AnalyzeThread(userID);
			at.run();
			
						
		}catch(Throwable e){
			e.printStackTrace();
		}
		
	}
}
