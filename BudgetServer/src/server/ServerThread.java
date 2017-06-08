package server;

import java.io.*;
import java.net.*;


public class ServerThread extends Thread {
	private int check;
	private String checking;
	Socket client = null;
	OutputStream out = null;
	OutputStreamWriter outw = null;;


	public ServerThread(int check, String checking) {
		this.check = check;
		this.checking = checking;
	}

	public void run() {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(5000);
			System.out.println("HERE");

			client = ss.accept();
			System.out.println("ACCEPTED");
			
			out = client.getOutputStream();
			outw = new OutputStreamWriter(out);

			outw.write(check);
			outw.flush();
			
			out.close();
			outw.close();
			ss.close();
			
			isregister();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	void isregister(){
		if(checking.equals("register") || (checking.equals("login") && check == 0)){
			ServerTCP ss2 = new ServerTCP();
		}
	}
	
}
