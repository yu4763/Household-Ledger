package server;

import java.io.*;

public class FileMake {

	InputStream fin;
	BufferedReader br;
	OutputStream fout;
	OutputStreamWriter osw;

	int finish = 0; 
	//finish == 0: 새로운 아이디,  finish == 1: 이미 있는 아이디

	FileMake(String userID, String checking){

		try {

			br = new BufferedReader(new FileReader("./files/user.csv"));
			String s;
			while( (s = br.readLine()) !=null){
				if(s.equals(userID)){
					finish = 1;
					break;
				}

			}

			if(finish==0 && checking.equals("register")){
				fout = new FileOutputStream ("./files/user.csv", true);
				osw = new OutputStreamWriter(fout);
				osw.write(userID, 0, userID.length());
				osw.append('\n');
				osw.flush();
				
				String filename = "./files/";
				filename = filename + userID;
				filename = filename + ".csv";
				FileOutputStream new1 = new FileOutputStream(filename) ;
				new1.close();
				
			}


		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}	

	}

	int returnfinish(){
		return finish;
	}


}
