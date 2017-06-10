package server;

import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class WritingThread {

	private Socket client;
	private InputStream in;
	private InputStreamReader inr;
	private BufferedReader br;
	private String info;
	private String userID;
	private static int count = 0;

	WritingThread(Socket s, String id){

		client = s;
		userID = id;

		try {

			in = client.getInputStream();
			inr = new InputStreamReader(in);
			br = new BufferedReader(inr);

			String type;


			type = br.readLine();
			while( type == null ){
				type = br.readLine();
			}
			System.out.println("type: " + type);

			info = br.readLine();
			System.out.println("info : " + info);
			in.close();
			inr.close();
			br.close();
			client.close();

			String filename = "./files/";
			filename = filename + userID;
			filename = filename + ".csv";

			if(type.equals("add")){


				count++;
				info = Integer.toString(count) + "," + info;

				FileOutputStream fos = new FileOutputStream(filename, true) ;
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				osw.write(info);
				osw.flush();
				osw.write('\n');
				osw.flush();
				osw.close();
				fos.close();
			}

			else{

				FileInputStream fis = new FileInputStream(filename);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);


				String tm; 
				String num = null;

				FileOutputStream fos = new FileOutputStream("./files/..csv");
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				
				
				while( (tm = br.readLine()) != null ){
					StringTokenizer tokens = new StringTokenizer(tm);
					num = tokens.nextToken(",");
					if(num.equals(info)){
						System.out.println("delinfo: " + info);
					}
					else{
						osw.write(tm);
						osw.flush();
						osw.write('\n');
						osw.flush();
					}
				}
				osw.close();
				fos.close();
				fis.close();
				isr.close();
				br.close();
				
				File f1 = new File(filename);
				f1.delete();
				
				File f2 = new File(filename);
				File f3 = new File("./files/..csv");
				f3.renameTo(f2);
			
			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}



}
