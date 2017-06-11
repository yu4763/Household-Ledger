package server;

import java.io.*;
import java.net.*;

public class WritingServer {
	
	
	final int port = 5000;
	
	private InputStream in;
	private InputStreamReader inr;
	private BufferedReader br;
	
	
	WritingServer(String userID){
		
		
		try{
			ServerSocket server = new ServerSocket(port);
			Socket client = server.accept();
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
