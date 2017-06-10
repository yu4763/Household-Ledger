package server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AnalyzeThread {
	private String id;
	private Socket client = null;
	private OutputStream out = null;
	private OutputStreamWriter outw = null;
	
	public AnalyzeThread(String id){
		this.id = id;
	}
	
	public void run(){
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(5000);
			System.out.println("HERE");

			client = ss.accept();
			System.out.println("ACCEPTED");
			
			out = client.getOutputStream();
			outw = new OutputStreamWriter(out);
			
			out.close();
			outw.close();
			ss.close();
			
			AnalyzeServer as = new AnalyzeServer(id);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
