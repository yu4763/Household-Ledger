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
	private static int finish = 0;

	public void run() {

		data = new String[2000][9];

		try {
			System.out.println("THREAD");

			client = new Socket(serverIP, 5000);

			in = client.getInputStream();
			inr = new InputStreamReader(in);
			br = new BufferedReader(inr);

			
			
			String line= br.readLine();
			System.out.println(line);
			
			while(line == null)	{
				line = br.readLine();
			System.out.println(line);
			}
		
			int i;
			
			while(line!=null && !line.equals("")){
				String[] lineData = line.split(",");
				for(i=0;i<9;i++) {
					data[cnt][i] = lineData[i];
					System.out.println(data[cnt][i]);
				}
				
				cnt++;
				line = br.readLine();
			}
			
			System.out.println("saving : " + cnt);

			client.close();
			in.close();
			inr.close();
			br.close();


		}catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		finish = 1;

	}
	
	static String[][] getInfo(){
		return data;
	}
	
	static int getcnt(){
		return cnt;
	}
	
	static int getfin(){
		return finish;
	}

}
