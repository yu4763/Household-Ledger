package server;

import java.io.*;
import java.net.*;


public class RegisterThread extends Thread {
	private int check;
	private String checking;
	private String userID;
	private Socket client = null;
	private OutputStream out = null;
	private OutputStreamWriter outw = null;


	public RegisterThread(int check, String checking, String userID) {
		this.check = check;
		this.checking = checking;
		this.userID = userID;
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

			outw.write(check); //check 보내기
			outw.flush();
			
			out.close();
			outw.close();
			ss.close();
			
			isregister();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	void isregister(){ //연속적으로
		if(checking.equals("register") || (checking.equals("login") && check == 0)){
			ServerTCP ss2 = new ServerTCP();
		}
		else if(checking.equals("login") && check == 1 ){
			SwitchingServer ws = new SwitchingServer(userID);
			
		}
	}
	
	
}
