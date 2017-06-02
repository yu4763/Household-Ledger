package front;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyFrame extends JFrame{
	
	public FrontPanel front;
	public WritingPanel write;
	
	MyFrame(){
		
		front = new FrontPanel();
		write = new WritingPanel();
		setTitle("�ٶ��� ����� ���α׷�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(front);
		setVisible(true);
		setSize(1700,1000);
	
	}
	
	public void change(String panelName){
		
		this.getContentPane().removeAll();
		
		if(panelName == "writing"){
			this.getContentPane().add(write);			
		}
		
		revalidate();
		repaint();
	
				
	}
		

	
}
