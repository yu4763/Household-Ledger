package client;

import java.io.*;
import java.net.*;

public class Client {

	private Socket client = null;
	final String serverIP = "localhost";
	
	private OutputStream out;
	private OutputStreamWriter outw;
	private BufferedWriter bw;
	
	
	Client(String userID, String checking){

	
			try {
				client = new Socket(serverIP, 5000);
				System.out.println("client Ready");
				
				out = client.getOutputStream();
				outw = new OutputStreamWriter(out);
				bw = new BufferedWriter(outw);
						
				bw.write(userID + '\n');
				bw.flush();
				bw.write(checking);
				bw.flush();
				
				client.close();
				out.close();
				outw.close();
				bw.close();
				
				RegisterThread rt = new RegisterThread(); //0,1¹Þ´Â°Å
				rt.run();
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
	
		
	}
	
	
	
	
}


