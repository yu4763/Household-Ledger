package server;

import java.io.*;
import java.net.*;

/**
 * serverTCP에서 전달받은 int check 정보 (= FileMake의 int finish 정보)를 client에 보내기 위해 열리는 ServerSocket으로써 해당 정보를 client의 RegisterThread에 보낸다.
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
	 * RegisterThread의 constructor.
	 * @param check 	사용자가 client에서 입력한 아이디가 이미 회원가입 되어있는 아이디이면 1, 새로운 아이디면 0이다.
	 * @param client	client의 RegisterThread에서 열려 serverTCP의 ServerSocket에 연결된 소켓
	 * @param server	serverTCP에서 연 ServerSocket.
	 */
	public RegisterThread(int check, Socket client, ServerSocket server) {

		this.check = check;
		this.checking = ServerTCP.getchecking();
		this.userID = ServerTCP.getuserID();
		this.client = client;
		this.server = server;
	}

	/**
	 * check의 정보를 client에 보내고 isregister method를 호출한다.
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
	 * 로그인이 되지 못한 경우( 사용자가 회원가입 버튼을 클릭한 경우나, 로그인 버튼을 클릭했지만 check 값이 0인 경우 ) 에는 serverTCP를 다시 부르고, 
	 * 로그인이 된 경우 (사용자가 로그인 버튼을 클릭했고, check값이 1인 경우 )에는 SwithcingServer를 부른다.
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