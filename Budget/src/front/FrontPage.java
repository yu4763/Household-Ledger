package front;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class FrontPage extends JFrame{
	
	FrontPage(){
		setTitle("다람이 가계부 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container plate = getContentPane();
		plate.setLayout(new BorderLayout(1700,1000));
	
		ImageIcon oldIcon = new ImageIcon("./resources/darami.jpg");
		Image oldImage = oldIcon.getImage();
		Image newImage = oldImage.getScaledInstance(1700,1000,java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImage);
		JLabel l = new JLabel(newIcon);
		l.setSize(1700,1000);
		l.setLocation(0,0);
		plate.add(l);
		
		JButton button1 = new JButton("가계부 작성");
		JButton button2 = new JButton("가계부 분석");
	
		plate.add(button1);
		plate.add(l);
		
		setVisible(true);
		setSize(1700,1000);
	}
	
	

}
