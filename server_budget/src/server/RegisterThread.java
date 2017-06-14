package server;

import java.io.*;
import java.net.*;

/**
 * serverTCP���� ���޹��� int check ���� (= FileMake�� int finish ����)�� client�� ������ ���� ������ ServerSocket���ν� �ش� ������ client�� RegisterThread�� ������.
 * @author team 6
 *
 */
public class RegisterThread extends Thread {
	private int check;
	private String checking;
	private String userID;
	private Socket client = null;
	private ServerSocket server = null;
	private OutputStream out = null;
	private OutputStreamWriter outw = null;
	
	final int port = 5000;


	/**
	 * RegisterThread�� constructor.
	 * @param check 	����ڰ� client���� �Է��� ���̵� �̹� ȸ������ �Ǿ��ִ� ���̵��̸� 1, ���ο� ���̵�� 0�̴�.
	 * @param client	client�� RegisterThread���� ���� serverTCP�� ServerSocket�� ����� ����
	 * @param server	serverTCP���� �� ServerSocket.
	 */
	public RegisterThread(int check, Socket client, ServerSocket server) {

		this.check = check;
		this.checking = ServerTCP.getchecking();
		this.userID = ServerTCP.getuserID();
		this.client = client;
		this.server = server;
	}

	/**
	 * check�� ������ client�� ������ isregister method�� ȣ���Ѵ�.
	 */
	public void run() {
		
		try {

			out = client.getOutputStream();
			outw = new OutputStreamWriter(out);

			outw.write(check); 
			outw.flush();
			
			out.close();
			outw.close();
			server.close();
			
			isregister();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * �α����� ���� ���� ���( ����ڰ� ȸ������ ��ư�� Ŭ���� ��쳪, �α��� ��ư�� Ŭ�������� check ���� 0�� ��� ) ���� serverTCP�� �ٽ� �θ���, 
	 * �α����� �� ��� (����ڰ� �α��� ��ư�� Ŭ���߰�, check���� 1�� ��� )���� SwithcingServer�� �θ���.
	 */
	void isregister(){ 
		if(checking.equals("register") || (checking.equals("login") && check == 0)){
			ServerTCP ss = new ServerTCP();
		}
		else if(checking.equals("login") && check == 1 ){
			SwitchingServer ws = new SwitchingServer(userID);
			
		}
	}
	
	
}