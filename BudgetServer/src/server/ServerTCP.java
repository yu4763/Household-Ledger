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
	
	private String userID = null;
	private String checking = null;
	
	ServerTCP(){
		
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
			checking = br.readLine();
			
			System.out.println(userID);
			System.out.println(checking);
			
			fm = new FileMake(userID, checking);
			int check = fm.returnfinish(); //check fileMAKE
			System.out.println("Server check: " + check);
			
			in.close();
			inr.close();
			br.close();
			server.close();
			
			ServerThread s = new ServerThread(check, checking);
			s.run();
			
						
		}catch(Throwable e){
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
