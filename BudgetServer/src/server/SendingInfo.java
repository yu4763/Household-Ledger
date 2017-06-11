package server;

import java.io.*;
import java.net.*;


public class SendingInfo extends Thread{


	private OutputStream out = null;
	private OutputStreamWriter outw = null;
	private static int count;


	SendingInfo(ServerSocket socket, Socket client, String userID){


		try {


			out = client.getOutputStream();
			outw = new OutputStreamWriter(out);
			BufferedWriter bw = new BufferedWriter(outw);		

			String filename = "./files/";
			filename = filename + userID;
			filename = filename + ".csv";


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

			br.close();
			isr.close();
			fis.close();
			bw.close();
			outw.close();
			out.close();


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	static int getcnt(){
		return count;
	}

	static void cntplus(){
		count++;
	}

}
