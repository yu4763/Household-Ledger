package front;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyFrame extends JFrame{
	
	public FrontPanel front;
	public WritingPanel write;
	public LoginPanel login;
	
	MyFrame(){
		
		front = new FrontPanel();
		write = new WritingPanel();
		login = new LoginPanel();
		setTitle("다람이 가계부 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(login);
		setVisible(true);
		setSize(1730,1080);
	
	}
	
	public void change(String panelName){
		
		this.getContentPane().removeAll();
		
		if(panelName == "writing"){
			this.getContentPane().add(write);			
		}
		
		if(panelName=="home"){
			this.getContentPane().add(front);
		}
		
		revalidate();
		repaint();
	
				
	}
		

	
}
