package client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientAnalyze {
	
	private Socket client = null;
	final String serverIP = "localhost";
	
	private OutputStream out;
	private OutputStreamWriter outw;
	private BufferedWriter bw;

	ClientAnalyze(String id) {
		try{
			client = new Socket(serverIP,5000);
			System.out.println("client Ready");
			
			out = client.getOutputStream();
			outw = new OutputStreamWriter(out);
			bw = new BufferedWriter(outw);
					
			bw.write(id + '\n');
			bw.flush();
			
			client.close();
			out.close();
			outw.close();
			bw.close();
			
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
