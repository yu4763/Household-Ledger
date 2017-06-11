package front;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class LoginPanel extends JPanel{

	ImageIcon daram;
	private String idvalue = null;


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

		Font font1 = new Font("서울남산체 B", Font.BOLD, 100);
		Font titlef = new Font("서울남산체 B", Font.PLAIN, 30);
		Font contentf = new Font("서울남산체 L", Font.PLAIN, 25);
		Font informf = new Font("서울남산체 L", Font.PLAIN, 18);

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
		JTextField pw = new JPasswordField();

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
		id.setText("");


		pw.setSize(300, 50);
		pw.setLocation(480, 585);
		pw.setFont(contentf);
		pw.setOpaque(false);
		pw.setText("");

		l.add(userID);
		l.add(id);
		l.add(userPW);
		l.add(pw);


		log.setSize(185, 50);
		log.setLocation(595, 700);
		log.setFont(contentf);

		register.setSize(235, 50);
		register.setLocation(330, 700);
		register.setFont(contentf);


		register.addActionListener(new ActionListener(){ //register 회원가입
			public void actionPerformed(ActionEvent e){
				idvalue = id.getText();

				if(idvalue == null | idvalue.equals("")){
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
				}

				else{

					Client c = new Client(idvalue, "register");
					int check = RegisterThread.returncheck();
					try {
						while( check == -1){
							Thread.sleep(2);
							check = RegisterThread.returncheck();
						}
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					if(check==0){
						JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
						id.setText("");
						pw.setText("");
					}
					else{
						JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다.");
						id.setText("");
						pw.setText("");
					}
				}
			}
		});
		
		
		
		log.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				idvalue = id.getText();

				if(idvalue == null || idvalue.equals("")){
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
				}

				else{

					Client c = new Client(idvalue, "login");
					int check = RegisterThread.returncheck();
					try {
						while( check == -1){
							Thread.sleep(2);
							check = RegisterThread.returncheck();
						}
						
						if(check==0){ 
							JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.");
							id.setText("");
							pw.setText("");
						}
						else{ // 로그인 완료
							Thread.sleep(2);
							Main.fr.change("home");
							SavingInfo si = new SavingInfo();
							si.run();
						}
						
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		
		l.add(log);
		l.add(register);


		JLabel inform = new JLabel("**회원가입을 원하실 경우 아이디와 비밀번호를 입력한 후 회원가입 버튼을 눌러주십시오.**");
		inform.setSize(800,40);
		inform.setLocation(330, 760);
		inform.setFont(informf);
		l.add(inform);

		add(l);
		setSize(1700,1000);

	}
	
}