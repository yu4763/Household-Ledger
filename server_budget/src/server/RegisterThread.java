package server;

import java.io.*;
import java.net.*;

/**
 * 
 * @author ¹ÚÇÑ³ª
 *
 */
public class RegisterThread extends Thread {
	private int check;
	private String checking;
	private String userID;
	private Socket client = null;
	private ServerSocket server = null;
	private OutputStream out = null;
	private OutputStreamWriter outw = null;
	
	final int port = 5000;

<<<<<<< HEAD
	/**
	 * 
	 * @param check
	 * @param client
	 * @param server
	 */
	public RegisterThread(int check, Socket client, ServerSocket server) {
=======
	public RegisterThread(int check, String checking, String userID) {
>>>>>>> branch 'master' of https://github.com/yu4763/SoftwarePractice1
		this.check = check;
		this.checking = ServerTCP.getchecing();
		this.userID = ServerTCP.getuserID();
		this.client = client;
		this.server = server;
	}

	/**
	 * 
	 */
	public void run() {
		
		try {
<<<<<<< HEAD
=======
			ss = new ServerSocket(port);
			System.out.println("HERE");

			client = ss.accept();
			System.out.println("ACCEPTED");
>>>>>>> branch 'master' of https://github.com/yu4763/SoftwarePractice1
			
			out = client.getOutputStream();
			outw = new OutputStreamWriter(out);

			outw.write(check); 
			outw.flush();
			
			out.close();
			outw.close();
			server.close();
			
			isregister();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 
	 */
	void isregister(){ 
		if(checking.equals("register") || (checking.equals("login") && check == 0)){
			ServerTCP ss = new ServerTCP();
		}
		else if(checking.equals("login") && check == 1 ){
			SwitchingServer ws = new SwitchingServer(userID);
			
		}
	}
	
	
}