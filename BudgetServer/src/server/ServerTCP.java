package server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerTCP {

	public static void main(String [] args){
		
		ServerSocket ss = null;
		String id, password;
		try {
			ss = new ServerSocket (5000);
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
}
