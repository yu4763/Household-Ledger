package server;

import java.io.*;
import java.net.*;

public class ServerTCP {
	
	ServerSocket server = null;
	Socket client = null;
	final int port = 5000;
	
	InputStream in;
	InputStreamReader inr;
	BufferedReader br;
	
	OutputStream out;
	OutputStreamWriter outw;
	
	FileMake fm;
	
	String userID = null;
	
	ServerTCP(){
		
		try{
			
			server = new ServerSocket(port);
			System.out.println("Server wating");
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
			
			fm = new FileMake(userID);
			int check = fm.returnfinish();
			System.out.println("Server check: " + check);
			
			server.close();
			in.close();
			inr.close();
			br.close();
			ServerThread s = new ServerThread(check);
			s.run();
						
		}catch(Throwable e){
			e.printStackTrace();
		}
		
	}
}
