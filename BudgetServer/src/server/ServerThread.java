package server;

import java.io.*;
import java.net.*;


public class ServerThread extends Thread {
	private int check;
	Socket client = null;
	OutputStream out = null;
	OutputStreamWriter outw = null;;


	public ServerThread(int check) {
		this.check = check;
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
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
