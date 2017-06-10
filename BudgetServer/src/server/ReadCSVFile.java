package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFile {
	
	String[][] data = new String[100][9];
	
	ReadCSVFile(){
		try{
		//유저 아이디 비교해서 맞는 csv파일 찾기
		File csv = new File();
		
		BufferedReader br = new BufferedReader(new FileReader(csv));
		String line = "";
		int r = 0;
		
		while((line = br.readLine())!=null){
			String[] lineData = line.split(",",-1);
			for(int i=0;i<9;i++) data[r][i] = lineData[i];
			
			for(int i=0;i<9;i++) System.out.print(data[r][i]+",");
			System.out.print("");
			
			r++;
		}
			
		br.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
