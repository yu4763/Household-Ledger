package client;

import java.io.*;
import java.net.*;

public class SendButton {

	final String serverIP = "localhost";
	final int port = 5000;
	
	SendButton(String b){


		try {


			Thread.sleep(5);

			Socket client;
			client = new Socket(serverIP, port);

			OutputStream out = client.getOutputStream();
			OutputStreamWriter outw = new OutputStreamWriter(out);
			BufferedWriter bw = new BufferedWriter(outw);
			
			bw.write(b);
			bw.flush();
			
			bw.close();
			outw.close();
			out.close();
			client.close();
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

}