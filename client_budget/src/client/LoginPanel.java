package client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * �Էµ� ���̵� ������ ������ ����(Client class ���) �α��� �Ǵ� ȸ�������� �ϴ� â. 
 * (�α���, ȸ������ ������ ���� ���� ���δ� RegisterThread class�� ����Ͽ� �޾ƿ�) 
 * �α����� �Ϸ�� ��쿡�� SavingInfo class�� �ҷ� ������ �ԷµǾ� �ִ� ������ server ���� �ҷ��� �� �ֵ��� ��.
 * @author team 6
 *
 */
public class LoginPanel extends JPanel{

	ImageIcon daram;
	private String idvalue = null;

	/**
	 * ���̵� �Է��ϴ� â�� ȸ������ ��ư, �α��� ��ư�� ������.
	 * ��ư�� Ŭ���� �Է��� ���̵� ������ ��ư ������ Client class �� ����
	 * �α��� ȸ������ ���θ� RegisterThread class�� ���� �޾ƿ�
	 * �α��� or ȸ������ ���� ���θ� ����ڿ��� �˷���
	 * �α��� ������ SendButton�� ���� ������ �����ϰ�, SavingInfo class �� �۵���Ų �� FrontPanel�� ȭ�� �ٲ�.
	 */
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

		Font font1 = new Font("���ﳲ��ü B", Font.BOLD, 100);
		Font titlef = new Font("���ﳲ��ü B", Font.PLAIN, 35);
		Font contentf = new Font("���ﳲ��ü L", Font.PLAIN, 25);
		Font informf = new Font("���ﳲ��ü L", Font.PLAIN, 18);

		JLabel title = new JLabel("�ٶ��� �����");
		title.setFont(font1);
		title.setSize(800, 300);
		title.setLocation(520, 170);
		l.add(title);


		JLabel userID = new JLabel("����� : ", JLabel.CENTER);
		JButton log = new JButton("�α���");
		JButton register = new JButton("ȸ������");

		JTextField id = new JTextField();

		userID.setSize(150, 50);
		userID.setFont(titlef);
		userID.setLocation(325, 565);

		id.setSize(300, 50);
		id.setFont(contentf);
		id.setLocation(480, 565);
		id.setOpaque(false);
		id.setText("");

		l.add(userID);
		l.add(id);

		log.setSize(185, 50);
		log.setLocation(595, 700);
		log.setFont(contentf);

		register.setSize(235, 50);
		register.setLocation(330, 700);
		register.setFont(contentf);


		register.addActionListener(new ActionListener(){ //register ȸ������
			public void actionPerformed(ActionEvent e){
				idvalue = id.getText();

				if(idvalue == null || idvalue.equals("")){
					JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���.");
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
						JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�.");
						id.setText("");
					}
					else{
						JOptionPane.showMessageDialog(null, "�̹� �����ϴ� ���̵��Դϴ�.");
						id.setText("");
					}
				}
			}
		});
		
		
		log.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				idvalue = id.getText();

				if(idvalue == null || idvalue.equals("")){
					JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���.");
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
							JOptionPane.showMessageDialog(null, "�������� �ʴ� ���̵��Դϴ�.");
							id.setText("");
						}
						else{ // �α��� �Ϸ�
							Thread.sleep(2);
							new SendButton("login");
							SavingInfo si = new SavingInfo();
							si.run();
							Main.fr.change("home");
						}
						
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		
		l.add(log);
		l.add(register);


		JLabel inform = new JLabel("**ȸ�������� ���Ͻ� ��� ���̵� �Է��� �� ȸ������ ��ư�� �����ֽʽÿ�.**");
		inform.setSize(800,40);
		inform.setLocation(330, 760);
		inform.setFont(informf);
		l.add(inform);

		add(l);
		setSize(1700,1000);

	}
	
}