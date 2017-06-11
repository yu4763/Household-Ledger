package client;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BeforeAnalyzePanel extends JPanel{
	
	public JLabel l;
	
	BeforeAnalyzePanel(){
		setLayout(null);
		
		ImageIcon oldIcon = new ImageIcon("./resources/darami.jpg");
		Image oldImage = oldIcon.getImage();
		Image newImage = oldImage.getScaledInstance(1700,1000,java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImage);		
		JLabel l = new JLabel(newIcon);
		l.setSize(1700,1000);
		l.setLocation(0,0);
		
		Font titlef = new Font("���ﳲ��ü B", Font.PLAIN, 30);
		Font contentf = new Font("���ﳲ��ü L", Font.PLAIN, 25);
		
		
		/* Ȩ ��ư */
		JButton home = new JButton("Ȩ");
		home.setSize(80,80);
		home.setLocation(100,80);
		home.setBackground(new Color(236,230,204));
		home.setFont(titlef);
		l.add(home);
		
		home.addActionListener(new ChangePanel());
		/* Ȩ��ư �Ϸ� */
		
		
		/* �޷��� �м�â ��ư */
		JButton calender = new JButton("�޷� �м�");
		calender.setSize(270,100);
		calender.setLocation(650,450);
		calender.setBackground(new Color(236,230,204));
		calender.setFont(titlef);
		l.add(calender);
		
		calender.addActionListener(new ChangePanel());
		/* �޷��� �м�â ��ư �Ϸ�*/
		
		
		/* �Ϲ� �м�â ��ư */
		JButton analyze = new JButton("ī�װ� �м�");
		analyze.setSize(270,100);
		analyze.setLocation(950,450);
		analyze.setBackground(new Color(236,230,204));
		analyze.setFont(titlef);
		l.add(analyze);
		
		analyze.addActionListener(new ChangePanel());
		/* �Ϲ� �м�â ��ư �Ϸ�*/
		
		add(l);
		setSize(1700,1000);
	}
	
}
