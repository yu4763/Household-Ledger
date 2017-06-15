package client;

import java.io.*;
import java.net.*;

/**
 * 어떤 button을 눌렀는지에 대한 정보가 server에서 필요한 경우, 버튼의 정보를 서버로 전송하는 socket이다. 
 * ChangePanel class 나 EnterInformation class 에서 “enter”을 보낼 때 등에 사용된다.
 * @author team 6
 *
 */
public class SendButton {

	final String serverIP = "localhost";
	final int port = 5000;

	/**
	 * 버튼의 정보를 server로 전달한다.
	 * @param b		SendButton class가 생성될 때 인자로 받아온 버튼의 정보
	 */
	SendButton(String b){


		try {


			Thread.sleep(5);

			Socket client;
			client = new Socket(serverIP, port);

			OutputStream out = client.getOutputStream();
			OutputStreamWriter outw = new OutputStreamWriter(out);
			BufferedWriter bw = new BufferedWriter(outw);
			
			bw.write(b);
			bw.flush();
			
			bw.close();
			outw.close();
			out.close();
			client.close();
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

}