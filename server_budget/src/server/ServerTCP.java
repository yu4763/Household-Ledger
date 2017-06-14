package server;

import java.io.*;
import java.net.*;

import java.io.*;
import java.net.*;

/**
 * 처음 열리는 ServerSocket으로써 client의 Client class에서 열린 Socket에서 사용자의 아이디와 버튼의 종류를 받아와 FileMake class에 전달하고, 
 * FilkeMake가 실행 된 후 int finish의 정보를 RegisterThread에 전달하고 실행시킨다.
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
	 * client와 회원가입과 로그인에 관한 정보를 주고 받기 위한 ServerSocket을 연다.
	 * 사용자가 입력한 아이디 정보와 사용자가 클릭한 버튼 정보(register or login)을 client로 부터 받는다.
	 * 해당 정보들을 이용해 FileMake를 작동시키고, FilkeMake를 통해 얻은 정보를 client로 다시 넘겨주는 registerThread를 작동시킨다.
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
	 * client로부터 받아온 아이디 정보를 리턴한다.
	 * @return userID
	 */
	static String getuserID(){
		return userID;
	}
	/**
	 * client에서 사용자가 클릭한 버튼의 정보를 리턴한다.
	 * @return
	 */
	static String getchecking(){
		return checking;
	}
	
	
	
}