package front;

import java.io.*;
import java.net.*;

public class SavingInfo extends Thread{

	private Socket client = null;
	final String serverIP = "localhost";

	private InputStream in=null;
	private InputStreamReader inr;
	private BufferedReader br;
	private String[][] data;
	private int cnt;

	public void run() {

		data = new String[2000][9];

		try {
			System.out.println("THREAD");

			client = new Socket(serverIP, 5000);

			in = client.getInputStream();
			inr = new InputStreamReader(in);
			br = new BufferedReader(inr);

			String line;
			cnt = 0;
			int i;
			while((line = br.readLine())!=null){
				String[] lineData = line.split(",");
				for(i=0;i<9;i++) {
					data[cnt][i] = lineData[i];
				}
				
				cnt++;
			}

			client.close();
			in.close();
			inr.close();
			br.close();


		}catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		

	}
	
	String[][] getInfo(){
		return data;
	}
	
	int getcnt(){
		return cnt;
	}

}
