package client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;


public class ChangePanel implements ActionListener{

	final String serverIP = "localhost";
	
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