package client;

import java.io.*;
import java.net.*;

/**
 * 로그인 화면에서 버튼 클릭시, 사용자 아이디와 클릭한 버튼의 종류(login or register)을 서버로 전달하는 class
 * @author team 6
 *
 */
public class Client {

	private Socket client = null;
	final String serverIP = "localhost";
	final int port = 5000;
	
	private OutputStream out;
	private OutputStreamWriter outw;
	private BufferedWriter bw;
	
	
	Client(String userID, String checking){

	
			try {
				client = new Socket(serverIP, port);
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
				
				RegisterThread rt = new RegisterThread(); //0,1받는거
				rt.run();
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
	
		
	}
	
	
	
	
}


