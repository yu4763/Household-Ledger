package server;

import java.io.*;
import java.net.*;

/**
 * 로그인 되어있는 유저아이디의 이름을 가진 csv파일을 찾아 내용을 읽어 client의 SavingInfo socket으로 보내는 class
 * 만약 해당 csv파일에 아무런 정보도 저장되어 있지 않으면 -1을 보낸다.
 * @author team 6
 *
 */
public class SendingInfo extends Thread{


	private OutputStream out = null;
	private OutputStreamWriter outw = null;
	private static int count;
	private Socket client = null;
	private String userID;


	/**
	 * SendingInfo class의 constructor.
	 * @param client	client의 SavingInfo에서 열려 SwitchingServer의 ServerSocket에 연결된 소켓
	 * @param userID	로그인 되어 있는 사용자의 아이디
	 */
	SendingInfo(Socket client, String userID){
		
		this.client = client;
		this.userID = userID;
		
	}
	
	/**
	 * 로그인 되어 있는 유저아이디의 이름을 가진 csv파일을 읽어 아무것도 저장되어 있지 않으면 -1, 저장되어 있다면 한 줄씩 읽어 client로 보낸다.
	 * 저장되어 있는 정보의 줄 수를 count에 저장한다.
	 */
	public void run(){


		try {

			out = client.getOutputStream();
			outw = new OutputStreamWriter(out);
			BufferedWriter bw = new BufferedWriter(outw);		

			String filename = "./files/";
			filename = filename + userID;
			filename = filename + ".csv";

			Thread.sleep(10);

			FileInputStream fis = new FileInputStream(filename);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			count = 0;

			int checknull = fis.read();
			if(checknull == -1){
				bw.write(Integer.toString(checknull));
				bw.flush();

			}
			else{

				String tm;
				while( (tm = br.readLine()) != null ){

					bw.write(tm);
					bw.flush();
					bw.write("\n");
					bw.flush();
					count++;
				}
			}

			
			bw.close();
			outw.close();
			out.close();
			br.close();
			isr.close();
			fis.close();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * count의 값을 리턴한다.
	 * @return count	해당 유저의 csv파일에 저장되어 있는 정보의 줄 수
	 */
	static int getcnt(){
		return count;
	}


}