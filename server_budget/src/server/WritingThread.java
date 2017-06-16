package server;

import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

/**
 * client의 EnterInformation Socket으로 부터 작성화면에서 사용자가 입력한 정보를 받아와 서버에 저장하는 class. 
 * 먼저 사용자가 클릭한 button 이 입력(add) 인지 삭제(delete)인지를 받아온다.
 * 입력이면 날짜 + 카테고리 + 입출금여부 + 현금/카드 + 메모 + 금액 정보를 가진 String, 삭제이면 삭제하고 싶은 정보의 번호를 받아온다. 
 * 입력이면 해당 정보를 파일에 추가 기입하고, 삭제인 경우 그 정보를 제외한 나머지 정보를 입력한 새로운 파일을 만들고 원본 파일을 삭제한 후 새로 만든 파일의 이름을 유저아이디로 다시바꾼다.
 * @author team 6
 *
 */
public class WritingThread {

	private Socket client;
	private InputStream in;
	private InputStreamReader inr;
	private BufferedReader br;
	private String info;
	private String userID;
	private int count;
	final int port = 18806;
	

	/**
	 * WritingThread의 constructor
	 * @param s 	client의 EnterInformation에서 열려 SwitchingServer의 ServerSocket에 연결된 소켓
	 * @param id	로그인 되어 있는 사용자의 아이디
	 */
	WritingThread(Socket s, String id){

		client = s;
		userID = id;		
		count = SendingInfo.getcnt();
	}
	
	/**
	 * 먼저 사용자가 클릭한 button 이 입력(add) 인지 삭제(delete)인지를 받아온다.
	 * 입력이면 날짜 + 카테고리 + 입출금여부 + 현금/카드 + 메모 + 금액 정보를 가진 String을 가져와 userID.csv파일에 저장한다. 
	 * 삭제이면 삭제하고 싶은 정보의 번호를 받아와, 삭제해야 할 정보를 제외한 다른 정보들을 입력한 파일을 새로 만든 후 기존의 userID.csv을 삭제하고 새로만든 파일의 이름을 userID로 변경한다.
	 */
	public void run(){	

		try {

			in = client.getInputStream();
			inr = new InputStreamReader(in);
			br = new BufferedReader(inr);

			String type;


			type = br.readLine();
			while( type == null ){
				type = br.readLine();
			}

			info = br.readLine();
			in.close();
			inr.close();
			br.close();
			client.close();

			String filename = "./files/";
			filename = filename + userID;
			filename = filename + ".csv";
						

			if(type.equals("add")){
				
			
				info = Integer.toString(++count) + "," + info;

				FileOutputStream fos = new FileOutputStream(filename, true) ;
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				osw.write(info);
				osw.flush();
				osw.write('\n');
				osw.flush();
				osw.close();
				fos.close();

		        
			}

			else {
				

				FileInputStream fis = new FileInputStream(filename);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);


				String tm; 
				String num = null;
				String rest = null;

				FileOutputStream fos = new FileOutputStream("./files/..csv");
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				
				int i = 1;
				while( (tm = br.readLine()) != null ){
					StringTokenizer tokens = new StringTokenizer(tm);
					num = tokens.nextToken(",");
					rest = tokens.nextToken("\n");
					if(num.equals(info)){
						
					}
					else{
						osw.write(Integer.toString(i) + rest);
						osw.flush();
						osw.write('\n');
						osw.flush();
						i++;
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
				
				boolean a;
				a = f3.renameTo(f2);
				while(!a){
					a = f3.renameTo(f2);
				}
				
				FileOutputStream new1 = new FileOutputStream("./files/..csv") ;
				new1.close();
			
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		


	}



}