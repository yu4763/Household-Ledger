package server;

import java.io.*;
import java.net.*;


public class SendingInfo extends Thread{

	private Socket client;
	private String userID;
	private OutputStream out = null;
	private OutputStreamWriter outw = null;


	SendingInfo(Socket client, String userID){
		this.client = client;
		this.userID = userID;
		
		try {
			out = client.getOutputStream();
			outw = new OutputStreamWriter(out);
			BufferedWriter bw = new BufferedWriter(outw);		
				
			String filename = "./files/";
			filename = filename + userID;
			filename = filename + ".csv";
			
			
			FileInputStream fis = new FileInputStream(filename);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			String tm;
			while( (tm = br.readLine()) != null ){
				
				bw.write(tm);
				bw.flush();
				bw.write("\n");
				bw.flush();
				
			}
			
			br.close();
			isr.close();
			fis.close();
			bw.close();
			outw.close();
			out.close();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
