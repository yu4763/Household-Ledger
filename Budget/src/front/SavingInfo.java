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
	private static int cnt = 0;


	public void run() {

		data = new String[2000][9];

		try {
			System.out.println("THREAD");

			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			client = new Socket(serverIP, 5000);

			in = client.getInputStream();
			inr = new InputStreamReader(in);
			br = new BufferedReader(inr);



			String line= br.readLine();

			while(line == null)	{
				line = br.readLine();
				System.out.println(line);
			}

			System.out.println(line);
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
				
				client.close();
				in.close();
				inr.close();
				br.close();
			}

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
