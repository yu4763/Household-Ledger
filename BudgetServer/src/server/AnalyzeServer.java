package server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class AnalyzeServer {
	private ServerSocket server = null;
	private Socket client = null;
	final int port = 5000;
	
	private InputStream in;
	private InputStreamReader inr;
	private BufferedReader br;
	
	private String id = null;
	
	AnalyzeServer(String id){
		this.id = id;
		
		try{
			server = new ServerSocket(port);
			
			while (true) {
		        client = server.accept();
		        new CSVThread(client, id);
		     
		    }	
						
		}catch(Throwable e){
			e.printStackTrace();
		}
	}
}
