package server;

import java.io.*;


/**
 * 사용자가 client에서 입력한 아이디가 회원가입되어 있는 아이디인지 아닌지를 확인하고 그 정보를 finish에 저장한다.
 * 만약 사용자가 client에서 요구한 것이 회원가입인데, 아직 회원가입 되어있지 않은 아이디를 넘겨받았을 시 해당 아이디 이름의 csv 파일을 생성한다.
 * finish의 정보를 다른 class에서 얻을 수 있게 리턴해주는 method가 존재한다.
 * @author team 6
 *
 */
public class FileMake {

	private BufferedReader br;
	private OutputStream fout;
	private OutputStreamWriter osw;

	private int finish = 0; 
	//finish == 0: 새로운 아이디,  finish == 1: 이미 있는 아이디

	/**
	 * 회원가입된 사용자들의 아이디를 저장해 놓은 user.csv 파일에서 사용자가 입력한 아이디(userID)가 존재하는 지 확인한다.
	 * 만약 사용자가 원하는 것이 회원가입인데, userID가 존재하지 않았던 새로운 아이디라면 유저 아이디 이름의 csv파일을 생성한다.
	 * @param userID	사용자가 client 에서 입력한 userID
	 * @param checking	사용자가 클릭한 버튼이 로그인 버튼이면 "login", 회원가입 버튼이면 "register"이라는 값을 가지고 있다.
	 */
	FileMake(String userID, String checking){

		try {

			br = new BufferedReader(new FileReader("./files/user.csv")); //id file
			String s;
			while( (s = br.readLine()) !=null){ //똑같은 아이디 있는지 흩는다.
				if(s.equals(userID)){
					finish = 1;
					break;
				}

			}

			if(finish==0 && checking.equals("register")){
				fout = new FileOutputStream ("./files/user.csv", true); //true 적어야 앞 내용 기록됨
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
	 * finish의 값을 리턴한다.
	 * @return finish	userID가 user.csv 파일에 원래 존재하면 1, 새로운 아이디면 0이다.
	 */
	int returnfinish(){
		return finish;
	}


}