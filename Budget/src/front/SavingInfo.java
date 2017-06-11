package front;

import java.io.*;
import java.net.*;

public class SavingInfo extends Thread{

	private Socket client = null;
	final String serverIP = "localhost";

	private InputStream in=null;
	private InputStreamReader inr;
	private BufferedReader br;
	private static String[][] data;
	private static int cnt;

	public void run() {

		data = new String[2000][9];

		try {
			System.out.println("THREAD");

			client = new Socket(serverIP, 5000);

			in = client.getInputStream();
			inr = new InputStreamReader(in);
			br = new BufferedReader(inr);

			cnt = 0;
			int i;
			
			String line= br.readLine();
			
			while(line != null)	
				line = br.readLine();
				
			while(line!=null && !line.equals("")){
				String[] lineData = line.split(",");
				for(i=0;i<9;i++) {
					data[cnt][i] = lineData[i];
				}
				
				cnt++;
				line = br.readLine();
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
	
	static String[][] getInfo(){
		return data;
	}
	
	static int getcnt(){
		return cnt;
	}

}
