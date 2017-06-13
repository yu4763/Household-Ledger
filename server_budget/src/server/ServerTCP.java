package server;

import java.io.*;
import java.net.*;

import java.io.*;
import java.net.*;

/**
 * client와 회원가입과 로그인에 관한 정보를 주고 받기 위한 ServerSocket을 연다.
 *
 * @author 박한나
 *
 */
public class ServerTCP {
	
	private ServerSocket server = null;
	private Socket client = null;
	final int port = 5000;
	
	private InputStream in;
	private InputStreamReader inr;
	private BufferedReader br;
		
	private FileMake fm;
	
	private static String userID = null;
	private static String checking = null;
	
	/**
	 * 
	 */
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
			
			
			fm = new FileMake(userID, checking);
			int check = fm.returnfinish(); //check fileMAKE
			
			in.close();
			inr.close();
			br.close();
			
			client = server.accept();
			
			RegisterThread s = new RegisterThread(check, client, server);
			s.run();
			
						
		}catch(Throwable e){
			e.printStackTrace();
		}
		
	}
	
	static String getuserID(){
		return userID;
	}
	
	static String getchecing(){
		return checking;
	}
	
	
	
}