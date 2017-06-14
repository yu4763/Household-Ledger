package server;

import java.io.*;
import java.net.*;

import java.io.*;
import java.net.*;

/**
 * ó�� ������ ServerSocket���ν� client�� Client class���� ���� Socket���� ������� ���̵�� ��ư�� ������ �޾ƿ� FileMake class�� �����ϰ�, 
 * FilkeMake�� ���� �� �� int finish�� ������ RegisterThread�� �����ϰ� �����Ų��.
 * @author team 6
 *
 */
public class ServerTCP {
	
	private ServerSocket server = null;
	private Socket client = null;
	final int port = 5000;
	
	private InputStream in;
	private InputStreamReader inr;
	private BufferedReader br;
		
	private FileMake fm;
	
	private static String userID = null;
	private static String checking = null;
	
	/**
	 * client�� ȸ�����԰� �α��ο� ���� ������ �ְ� �ޱ� ���� ServerSocket�� ����.
	 * ����ڰ� �Է��� ���̵� ������ ����ڰ� Ŭ���� ��ư ����(register or login)�� client�� ���� �޴´�.
	 * �ش� �������� �̿��� FileMake�� �۵���Ű��, FilkeMake�� ���� ���� ������ client�� �ٽ� �Ѱ��ִ� registerThread�� �۵���Ų��.
	 */
	ServerTCP(){
		
		try{
			
			server = new ServerSocket(port);
			System.out.println("Server waiting");
			client = server.accept();
			System.out.println("connection : "+client.getInetAddress());
			
			in = client.getInputStream();
			inr = new InputStreamReader(in);
			br = new BufferedReader(inr);
			
			userID = br.readLine();
			
			while( userID == null ){
				userID = br.readLine();
			}
			checking = br.readLine();
			
			
			fm = new FileMake(userID, checking);
			int check = fm.returnfinish(); //check fileMAKE
			
			in.close();
			inr.close();
			br.close();
			
			client = server.accept();
			
			RegisterThread s = new RegisterThread(check, client, server);
			s.run();
			
						
		}catch(Throwable e){
			e.printStackTrace();
		}
		
	}
	/**
	 * client�κ��� �޾ƿ� ���̵� ������ �����Ѵ�.
	 * @return userID
	 */
	static String getuserID(){
		return userID;
	}
	/**
	 * client���� ����ڰ� Ŭ���� ��ư�� ������ �����Ѵ�.
	 * @return
	 */
	static String getchecking(){
		return checking;
	}
	
	
	
}