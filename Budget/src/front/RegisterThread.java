package front;

import java.io.*;
import java.net.*;

public class RegisterThread extends Thread{
	
	Socket client = null;
	final String serverIP = "localhost";
	
	InputStream in;
	InputStreamReader inr;
	private static int check = -1;
	
	public void run() {
		
		check = -1;
		
		try {
			System.out.println("THREAD");
			synchronized(this)
			{
			    this.wait(3);
			}
		
			client = new Socket(serverIP, 5000);
			
			in = client.getInputStream();
			inr = new InputStreamReader(in);
			
			check = in.read();
			
			System.out.println("check : " + check);
			
			client.close();
			in.close();
			inr.close();
					
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		
		
	}
	
	public static int returncheck(){
		return check;
	}
	
}
