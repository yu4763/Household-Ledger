package server;

import java.io.*;
import java.net.*;

public class WritingThread {
	
	private Socket client;
	private InputStream in;
	private InputStreamReader inr;
	private BufferedReader br;
	private String info;
	private String userID;
	private static int count = 0;
	
	WritingThread(Socket s, String id){
		
		client = s;
		userID = id;
		
		try {
			
			in = client.getInputStream();
			inr = new InputStreamReader(in);
			br = new BufferedReader(inr);
			
			info = br.readLine();
			
			while( info == null ){
				info = br.readLine();
			}
			
			in.close();
			inr.close();
			br.close();
			client.close();
			
			String filename = "./files/";
			filename = filename + userID;
			filename = filename + ".csv";
			
			count++;
			info = Integer.toString(count) + "," + info;
			
			FileOutputStream fos = new FileOutputStream(filename, true) ;
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			osw.write(info);
			osw.flush();
			osw.write('\n');
			osw.flush();
			osw.close();
			fos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
