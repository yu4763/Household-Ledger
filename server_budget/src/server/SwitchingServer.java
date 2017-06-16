package server;

import java.io.*;
import java.net.*;

/**
 * client에서 사용자가 선택하는 button의 정보를 받아 필요한 thread를 실행하는 class이다.
 * 이 class에서 열리는 ServerSocket은 선언된 이후 계속 열려 있으면서 client의 접속을 기다린다.
 * @author team 6
 *
 */
public class SwitchingServer {

	final int port = 5000;
	

	/**
	 * 사용자가 클릭한 button의 정보를 받아오는 class
	 * 사용자가 클릭한 button이 로그인 버튼이면(login)이면 SendingInfo 를 작동시킨다.
	 * 사용자가 클릭한 button이 가계부 작성 버튼이면(writing)이면 그 뒤에 사용자가 클릭하는 버튼의 정보를 한번 더 받는다.
	 * 가계부 작성 버튼 이후에 클릭한 버튼이 홈 버튼이면(home) 다시 처음으로 돌아와 사용자가 클릭하는 버튼의 정보를 받는다.
	 * 가계부 작성 버튼 이후에 입력이나 삭제버튼을 누르면  WritingThread와 SendingInfo를 순서대로 작동시킨다. (홈버튼을 클릭하기 전까지 반복)
	 * @param userID	로그인 되어 있는 사용자의 아이디
	 */
	SwitchingServer(String userID){

		try{

			ServerSocket server = new ServerSocket(port);
			Socket client;

			while(true){

				client = server.accept();
						
				InputStream in = client.getInputStream();
				InputStreamReader inr = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(inr);

				String button;

				button = br.readLine();
				while( button == null ){
					button = br.readLine();
				}

				br.close();
				inr.close();
				in.close();


				if(button.equals("login")){

					client = server.accept();
					SendingInfo si = new SendingInfo(client, userID);
					si.run();
				}

				if(button.equals("writing")){


					while(true){
						
						client = server.accept();

						InputStream in2 = client.getInputStream();
						InputStreamReader inr2 = new InputStreamReader(in2);
						BufferedReader br2 = new BufferedReader(inr2);

						String button2;

						button2 = br2.readLine();
						while( button2 == null ){
							button2 = br2.readLine();
						}

						br2.close();
						inr2.close();
						in2.close();

						if(button2.equals("home")){
							break;
						}

						else{

							client = server.accept();
							WritingThread wt = new WritingThread(client, userID);
							wt.run();

							client = server.accept();
							SendingInfo si = new SendingInfo(client, userID);
							si.run();
							
						}

					}
				}



			}

		}catch(Throwable e){
			e.printStackTrace();
		}

	}


}