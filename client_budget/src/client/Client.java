package client;

import java.io.*;
import java.net.*;

/**
 * �α��� ȭ�鿡�� ��ư Ŭ����, ����� ���̵�� Ŭ���� ��ư�� ����(login or register)�� ������ �����ϴ� class
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
	
	/**
	 * userID�� checking �� ���� ������ �����ϴ� class
	 * @param userID	����ڰ� �α��� ȭ�鿡�� �Է��� ���̵�
	 * @param checking	����ڰ� Ŭ���� ��ư ����(�α��� ��ư�̸� 'login', ȸ������ ��ư�̸� 'register')
	 */
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
				
				RegisterThread rt = new RegisterThread(); //0,1�޴°�
				rt.run();
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
	
		
	}
	
	
	
	
}


