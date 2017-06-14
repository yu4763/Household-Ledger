package client;

import java.io.*;
import java.net.*;

/**
 * 로그인 혹은 회원가입 시 server 에서 보내는 숫자 (로그인 혹은 회원가입 가능 여부) 를 받아옴. ( 0: 새로운 아이디이므로 회원가입 가능, 1: 기존에 있는 아이디이므로 로그인 가능)
 * @author team 6
 *
 */
public class RegisterThread extends Thread{

	private Socket client = null;
	final String serverIP = "localhost";
	final int port = 5000;

	private InputStream in=null;
	private InputStreamReader inr;
	private static int check = -1;

	public void run() {

		check = -1;

		try {

			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			client = new Socket(serverIP, port);

			in = client.getInputStream();
			inr = new InputStreamReader(in);
			check = in.read();


			client.close();
			in.close();
			inr.close();

		}catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		

	}

	public static int returncheck(){
		return check;
	}

}
