package client;

import java.io.*;
import java.net.*;

/**
 * 처음 로그인 할 때, 그리고 작성화면에서 입력/ 삭제 정보를 서버에 보낸 후에 작동하게 되는 class 
 * client 로 서버에 있는 정보를 받아오기 위해 socket을 연다.
 * @author team 6
 *
 */
public class SavingInfo extends Thread{

	private Socket client = null;
	final String serverIP = "localhost";
	final int port = 5000;

	private InputStream in=null;
	private InputStreamReader inr;
	private BufferedReader br;
	private static String[][] data;
	private static int cnt;

	/**
	 * server로부터 이전에 유저가 저장한 정보를 불러온다. (userID.csv 파일에 있는 정보)
	 * 이전에 아무 정보도 저장되어 있지 않으면 -1을 받아오게 된다.
	 * 그렇지 않을 경우 받아오는 정보들을 data 이차원배열에 저장한다.
	 * 받아온 data 의 줄 수를 cnt에 저장한다.
	 */
	public void run() {

		data = new String[2000][9];

		try {

			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			client = new Socket(serverIP, port);

			in = client.getInputStream();
			inr = new InputStreamReader(in);
			br = new BufferedReader(inr);


			String line= br.readLine();

			while(line == null)	{
				line = br.readLine();
			}

			if(!line.equals("-1")){
				
				int i;
				cnt = 0;
				while(line!=null && !line.equals("")){
					String[] lineData = line.split(",");
					for(i=0;i<9;i++) {
						data[cnt][i] = lineData[i];
					}

					cnt++;
					line = br.readLine();
				}
				
				data[0][0] = Integer.toString(1);
				
				
				in.close();
				inr.close();
				br.close();
				client.close();
				
			}
			

		}catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		


	}

	/**
	 * data를 리턴한다.
	 * @return data 	server로부터 받아온 정보들이 저장되는 이차원 배열
	 */
	static String[][] getInfo(){
		return data;
	}

	/**
	 * cnt 값을 리턴한다.
	 * @return cnt 		server로부터 받아온 정보들의 개수
	 */
	static int getcnt(){
		return cnt;
	}

}