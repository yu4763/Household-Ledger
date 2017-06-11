package client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FrontPanel extends JPanel{
	
	FrontPanel(){
		
		setLayout(null);
	
		ImageIcon oldIcon = new ImageIcon("./resources/darami.jpg");
		Image oldImage = oldIcon.getImage();
		Image newImage = oldImage.getScaledInstance(1700,1000,java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImage);
		JLabel l = new JLabel(newIcon);
		l.setSize(1700,1000);
		l.setLocation(0,0);
		
		Font font1 = new Font("서울남산체 B", Font.BOLD, 100);
		Font font2 = new Font("서울남산체 L", Font.PLAIN, 60);
		
		JLabel title = new JLabel("다람이 가계부");
		title.setFont(font1);
		title.setSize(800, 300);
		title.setLocation(520, 180);
		
		JButton b1 = new JButton("가계부 작성");
		JButton b2 = new JButton("가계부 분석");
		
		b1.setSize(400, 80);
		b1.setLocation(280, 580);
		b2.setSize(400, 80);
		b2.setLocation(280, 680);
		
		b1.setBorderPainted(false);
		b2.setBorderPainted(false);
		b1.setBackground(new Color(255,233,157));
		b2.setBackground(new Color(255,233,157));
		b1.setFocusPainted(false);
		b2.setFocusPainted(false);
		
		b1.setFont(font2);
		b2.setFont(font2);
		
		b1.addActionListener(new ChangePanel());
		b2.addActionListener(new ChangePanel());
		
		
		l.add(title);
		l.add(b1);
		l.add(b2);
		add(l);
		
		setSize(1700,1000);
		
	}

}
