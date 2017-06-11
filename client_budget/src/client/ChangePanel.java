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
		
		/*ImageIcon oldIcon2 = new ImageIcon("./resources/homeButton.jpg");
		Image oldImage2 = oldIcon2.getImage();
		Image newImage2 = oldImage2.getScaledInstance(80,80,java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon2 = new ImageIcon(newImage2);*/
		
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
		
		if(b.getText().equals("일반 분석")){
			Main.fr.change("analyze");
		}
		
		if(b.getText().equals("뒤로")){
			Main.fr.change("beforeanalyze");
		}
	}

}