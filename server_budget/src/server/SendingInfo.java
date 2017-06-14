package server;

import java.io.*;
import java.net.*;

/**
 * �α��� �Ǿ��ִ� �������̵��� �̸��� ���� csv������ ã�� ������ �о� client�� SavingInfo socket���� ������ class
 * ���� �ش� csv���Ͽ� �ƹ��� ������ ����Ǿ� ���� ������ -1�� ������.
 * @author team 6
 *
 */
public class SendingInfo extends Thread{


	private OutputStream out = null;
	private OutputStreamWriter outw = null;
	private static int count;
	private Socket client = null;
	private String userID;


	/**
	 * SendingInfo class�� constructor.
	 * @param client	client�� SavingInfo���� ���� SwitchingServer�� ServerSocket�� ����� ����
	 * @param userID	�α��� �Ǿ� �ִ� ������� ���̵�
	 */
	SendingInfo(Socket client, String userID){
		
		this.client = client;
		this.userID = userID;
		
	}
	
	/**
	 * �α��� �Ǿ� �ִ� �������̵��� �̸��� ���� csv������ �о� �ƹ��͵� ����Ǿ� ���� ������ -1, ����Ǿ� �ִٸ� �� �پ� �о� client�� ������.
	 * ����Ǿ� �ִ� ������ �� ���� count�� �����Ѵ�.
	 */
	public void run(){


		try {

			out = client.getOutputStream();
			outw = new OutputStreamWriter(out);
			BufferedWriter bw = new BufferedWriter(outw);		

			String filename = "./files/";
			filename = filename + userID;
			filename = filename + ".csv";

			Thread.sleep(10);

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

			
			bw.close();
			outw.close();
			out.close();
			br.close();
			isr.close();
			fis.close();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * count�� ���� �����Ѵ�.
	 * @return count	�ش� ������ csv���Ͽ� ����Ǿ� �ִ� ������ �� ��
	 */
	static int getcnt(){
		return count;
	}


}