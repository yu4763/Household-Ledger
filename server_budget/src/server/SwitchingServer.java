package server;

import java.io.*;
import java.net.*;

/**
 * 
 * @author ¹ÚÇÑ³ª
 *
 */
public class SwitchingServer {

	final int port = 5000;
	

	/**
	 * 
	 * @param userID
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