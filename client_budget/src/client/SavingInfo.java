package client;

import java.io.*;
import java.net.*;

/**
 * ó�� �α��� �� ��, �׸��� �ۼ�ȭ�鿡�� �Է�/ ���� ������ ������ ���� �Ŀ� �۵��ϰ� �Ǵ� class 
 * client �� ������ �ִ� ������ �޾ƿ��� ���� socket�� ����.
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
	 * server�κ��� ������ ������ ������ ������ �ҷ��´�. (userID.csv ���Ͽ� �ִ� ����)
	 * ������ �ƹ� ������ ����Ǿ� ���� ������ -1�� �޾ƿ��� �ȴ�.
	 * �׷��� ���� ��� �޾ƿ��� �������� data �������迭�� �����Ѵ�.
	 * �޾ƿ� data �� �� ���� cnt�� �����Ѵ�.
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
	 * data�� �����Ѵ�.
	 * @return data 	server�κ��� �޾ƿ� �������� ����Ǵ� ������ �迭
	 */
	static String[][] getInfo(){
		return data;
	}

	/**
	 * cnt ���� �����Ѵ�.
	 * @return cnt 		server�κ��� �޾ƿ� �������� ����
	 */
	static int getcnt(){
		return cnt;
	}

}