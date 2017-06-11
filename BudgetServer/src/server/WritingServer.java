package server;

import java.io.*;
import java.net.*;

public class WritingServer {
	
	
	private ServerSocket server = null;
	private Socket client = null;
	final int port = 5000;
	
	private InputStream in;
	private InputStreamReader inr;
	private BufferedReader br;
	
	private String userID = null;
	
	
	WritingServer(String userID){
		
		this.userID = userID;
		
		try{
			server = new ServerSocket(port);
			client = server.accept();
	        new SendingInfo(client, userID);
			
			while (true) {
		        client = server.accept();
		        new WritingThread(client, userID);
		     
		    }	
						
		}catch(Throwable e){
			e.printStackTrace();
		}
		
		
		
	}	
	
	
	
}
