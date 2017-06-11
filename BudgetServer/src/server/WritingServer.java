package server;

import java.io.*;
import java.net.*;

public class WritingServer {


	final int port = 5000;


	WritingServer(String userID){


		try{
			ServerSocket server = new ServerSocket(port);
			Socket client;
			
	
			while (true) {
	
				client = server.accept();
				new SendingInfo(server, client, userID);

				client = server.accept();
				new WritingThread(server, client, userID);

			}

		}catch(Throwable e){
			e.printStackTrace();
		}


	}	



}
