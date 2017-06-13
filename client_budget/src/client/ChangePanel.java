package client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;

/**
 * 버튼 클릭 시, 버튼의 텍스트에 따라 Client 화면을 바꾸고 몇 가지 필요한 경우 ( ex) 가계부 작성 버튼, 홈 버튼 ) server에도 어떤 버튼을 클릭했는지 정보를 보내는 class (정보를 보낼 때에는 SendButton class 이용)
 * @author team 6
 *
 */
public class ChangePanel implements ActionListener{
	
	/**
	 * 버튼 클릭시 버튼의 텍스트에 따라 server에 어떤 버튼을 클릭했는지 보내고 client 화면을 바꾼다.
	 */
	public void actionPerformed(ActionEvent e){
		JButton b = (JButton)e.getSource();
		
		if(b.getText().equals("가계부 작성")){
			
			new SendButton("writing");
			Main.fr.change("writing");
			
		}
		
		if(b.getText().equals("홈")){
		
			new SendButton("home");
			Main.fr.change("home");
			
		}
		
		if(b.getText().equals("가계부 분석")){
			Main.fr.change("beforeanalyze");
		}
		
		if(b.getText().equals("달력 분석")){
			Main.fr.change("analyzecalender");
		}
		
		if(b.getText().equals("카테고리 분석")){
			Main.fr.change("analyze");
		}
		
		if(b.getText().equals("뒤로")){
			Main.fr.change("beforeanalyze");
		}
	}

}