package front;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class FrontPage extends JFrame{
	
	FrontPage(){
		setTitle("�ٶ��� ����� ���α׷�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container plate = getContentPane();
		plate.setLayout(null);
		setSize(1700, 1000);
		
		ImageIcon image = new ImageIcon("./resources/darami.png");
		JLabel l = new JLabel(image);
		l.setSize(1700,1000);
		plate.add(l);
		
		JButton button1 = new JButton("����� �ۼ�");
		JButton button2 = new JButton("����� �м�");
		
		plate.setLayout(null);
		plate.add(button1);
		plate.add(title);
		
		setVisible(true);
	}
	
	

}
