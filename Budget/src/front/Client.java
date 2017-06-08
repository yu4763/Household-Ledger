package front;

import java.io.*;
import java.net.*;

public class Client {

	Socket client = null;
	final String serverIP = "localhost";
	
	InputStream in;
	InputStreamReader inr;
	
	OutputStream out;
	OutputStreamWriter outw;
	BufferedWriter bw;
	
	
	Client(String userID){

		try{
			client = new Socket(serverIP, 5000);
			System.out.println("client Ready");
			
			out = client.getOutputStream();
			outw = new OutputStreamWriter(out);
			bw = new BufferedWriter(outw);
					
			System.out.println("Sending");
			System.out.println("userID : " + userID);
			bw.write(userID);
			bw.flush();
			
			client.close();
			out.close();
			outw.close();
			bw.close();
			
			RegisterThread rt = new RegisterThread();
			rt.run();
			
		}catch(Throwable e){
			e.printStackTrace();
		}
		
	}
	
	
	
	
}


