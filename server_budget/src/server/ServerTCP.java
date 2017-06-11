package server;

import java.io.*;
import java.net.*;

import java.io.*;
import java.net.*;

public class ServerTCP {
	
	private ServerSocket server = null;
	private Socket client = null;
	final int port = 5000;
	
	private InputStream in;
	private InputStreamReader inr;
	private BufferedReader br;
		
	private FileMake fm;
	
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
			
			in.close();
			inr.close();
			br.close();
			server.close();
			
			RegisterThread s = new RegisterThread(check, checking, userID);
			s.run();
			
						
		}catch(Throwable e){
			e.printStackTrace();
		}
		
	}
	
	
	
}