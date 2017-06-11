package front;

import java.io.*;
import java.net.*;

public class RegisterThread extends Thread{

	private Socket client = null;
	final String serverIP = "localhost";

	private InputStream in=null;
	private InputStreamReader inr;
	private static int check = -1;

	public void run() {

		check = -1;

		try {
			System.out.println("THREAD");

			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			client = new Socket(serverIP, 5000);

			in = client.getInputStream();
			inr = new InputStreamReader(in);
			check = in.read();


			System.out.println("check : " + check);

			client.close();
			in.close();
			inr.close();

		}catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		

	}

	public static int returncheck(){
		return check;
	}

}
