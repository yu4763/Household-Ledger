package front;

import java.awt.*;
import javax.swing.*;

public class LoginPanel extends JPanel{
	
	ImageIcon daram;
	
	LoginPanel(){
		
		daram = new ImageIcon("./resources/darami.jpg");
		
		setLayout(null);
	
		ImageIcon oldIcon = new ImageIcon("./resources/darami.jpg");
		Image oldImage = oldIcon.getImage();
		Image newImage = oldImage.getScaledInstance(1700,1000,java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImage);
		JLabel l = new JLabel(newIcon);
		l.setSize(1700,1000);
		l.setLocation(0,0);
		
		Font font1 = new Font("HY나무B", Font.BOLD, 100);
		Font titlef = new Font("HY나무B", Font.PLAIN, 30);
		Font contentf = new Font("HY나무M", Font.PLAIN, 25);
		
		JLabel title = new JLabel("다람이 가계부");
		title.setFont(font1);
		title.setSize(800, 300);
		title.setLocation(520, 100);
		l.add(title);
		
		
		
		JLabel userID = new JLabel("아이디    : ", JLabel.CENTER);
		JLabel userPW = new JLabel("비밀번호 : ", JLabel.CENTER);
		JButton log = new JButton("로그인");
		JButton register = new JButton("회원가입");
		
		JTextField id = new JTextField();
		JPasswordField pw = new JPasswordField();
		
		userID.setSize(150, 50);
		userID.setFont(titlef);
		userID.setLocation(330, 500);
		
		userPW.setSize(150, 50);
		userPW.setFont(titlef);
		userPW.setLocation(330, 585);
		
		id.setSize(300, 50);
		id.setFont(contentf);
		id.setLocation(480, 500);
		id.setOpaque(false);
		
		pw.setSize(300, 50);
		pw.setLocation(480, 585);
		pw.setFont(contentf);
		pw.setOpaque(false);
	
		l.add(userID);
		l.add(id);
		l.add(userPW);
		l.add(pw);
		
		
		log.setSize(185, 50);
		log.setLocation(595, 710);
		log.setFont(contentf);
		
		register.setSize(235, 50);
		register.setLocation(330, 710);
		register.setFont(contentf);
		
		l.add(log);
		l.add(register);
		
		add(l);
		setSize(1700,1000);
		
		
	}
}