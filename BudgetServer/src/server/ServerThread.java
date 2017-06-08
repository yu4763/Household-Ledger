package server;

import java.io.*;
import java.net.*;


public class ServerThread extends Thread {
	private int check;
	private String checking;
	Socket client = null;
	OutputStream out = null;
	OutputStreamWriter outw = null;;


	public ServerThread(int check, String checking) {
		this.check = check;
		this.checking = checking;
	}

	public void run() {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(5000);
			System.out.println("HERE");

			client = ss.accept();
			System.out.println("ACCEPTED");
			
			out = client.getOutputStream();
			outw = new OutputStreamWriter(out);

			outw.write(check); //check 보내기
			outw.flush();
			
			out.close();
			outw.close();
			ss.close();
			
			isregister();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	void isregister(){ //연속적으로
		if(checking.equals("register") || (checking.equals("login") && check == 0)){
			ServerTCP ss2 = new ServerTCP();
		}
		else{ //writingThread 생성 + WritingTread.run //writingPanel에서 새로운 소캣 만들기, 선택 누를때마다 thread 생성
			//유저아이디 계속 넘겨서 살려놓기 파일이름
			
		}
	}
	
}
