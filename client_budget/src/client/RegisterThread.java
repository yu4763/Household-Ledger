package client;

import java.io.*;
import java.net.*;

/**
 * �α��� Ȥ�� ȸ������ �� server ���� ������ ���� (�α��� Ȥ�� ȸ������ ���� ����) �� �޾ƿ�. ( 0: ���ο� ���̵��̹Ƿ� ȸ������ ����, 1: ������ �ִ� ���̵��̹Ƿ� �α��� ����)
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
