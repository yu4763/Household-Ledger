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
	DataOutputStream dout;
	
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
			
		}catch(Throwable e){
			e.printStackTrace();
		}finally{
			try {
				in.close();
				inr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
