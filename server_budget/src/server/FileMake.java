package server;

import java.io.*;


/**
 * ����ڰ� client���� �Է��� ���̵� ȸ�����ԵǾ� �ִ� ���̵����� �ƴ����� Ȯ���ϰ� �� ������ finish�� �����Ѵ�.
 * ���� ����ڰ� client���� �䱸�� ���� ȸ�������ε�, ���� ȸ������ �Ǿ����� ���� ���̵� �Ѱܹ޾��� �� �ش� ���̵� �̸��� csv ������ �����Ѵ�.
 * finish�� ������ �ٸ� class���� ���� �� �ְ� �������ִ� method�� �����Ѵ�.
 * @author team 6
 *
 */
public class FileMake {

	private BufferedReader br;
	private OutputStream fout;
	private OutputStreamWriter osw;

	private int finish = 0; 
	//finish == 0: ���ο� ���̵�,  finish == 1: �̹� �ִ� ���̵�

	/**
	 * ȸ�����Ե� ����ڵ��� ���̵� ������ ���� user.csv ���Ͽ��� ����ڰ� �Է��� ���̵�(userID)�� �����ϴ� �� Ȯ���Ѵ�.
	 * ���� ����ڰ� ���ϴ� ���� ȸ�������ε�, userID�� �������� �ʾҴ� ���ο� ���̵��� ���� ���̵� �̸��� csv������ �����Ѵ�.
	 * @param userID	����ڰ� client ���� �Է��� userID
	 * @param checking	����ڰ� Ŭ���� ��ư�� �α��� ��ư�̸� "login", ȸ������ ��ư�̸� "register"�̶�� ���� ������ �ִ�.
	 */
	FileMake(String userID, String checking){

		try {

			br = new BufferedReader(new FileReader("./files/user.csv")); //id file
			String s;
			while( (s = br.readLine()) !=null){ //�Ȱ��� ���̵� �ִ��� ��´�.
				if(s.equals(userID)){
					finish = 1;
					break;
				}

			}

			if(finish==0 && checking.equals("register")){
				fout = new FileOutputStream ("./files/user.csv", true); //true ����� �� ���� ��ϵ�
				osw = new OutputStreamWriter(fout);
				osw.write(userID, 0, userID.length());
				osw.append('\n');
				osw.flush();
				
				String filename = "./files/";
				filename = filename + userID;
				filename = filename + ".csv";
				FileOutputStream new1 = new FileOutputStream(filename) ;
				new1.close();
				osw.close();
			}


		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}	

	}

	/**
	 * finish�� ���� �����Ѵ�.
	 * @return finish	userID�� user.csv ���Ͽ� ���� �����ϸ� 1, ���ο� ���̵�� 0�̴�.
	 */
	int returnfinish(){
		return finish;
	}


}