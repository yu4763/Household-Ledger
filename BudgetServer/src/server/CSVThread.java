package server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class CSVThread {
	private Socket client;
	private InputStream in;
	private InputStreamReader inr;
	private BufferedReader br;
	private String info;
	private String id;
	private static int count = 0;
	
	CSVThread(Socket s, String id){
		client = s;
		this.id = id;
		
		try{
			in = client.getInputStream();
			inr = new InputStreamReader(in);
			br = new BufferedReader(inr);
		}
	}
}
