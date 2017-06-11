package front;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AnalyzePanel extends JPanel{
	
	JPanel graph = new JPanel();
	int[] data = {0,0,0,0,0,0,0};
	
	SavingInfo info = new SavingInfo();
	String[][] dataCSV = new String[100][9];
	int cnt;
	
	AnalyzePanel(){
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
		
		
		/* �ڷ� ��ư */
		JButton back = new JButton("�ڷ�");
		back.setSize(130,80);
		back.setLocation(250,80);
		back.setBackground(new Color(236,230,204));
		back.setFont(titlef);
		l.add(back);
		
		back.addActionListener(new ChangePanel());
		/* �ڷ� ��ư �Ϸ� */
		
		
		/* ���� �׷��� �� */
		Calendar today = Calendar.getInstance();
		int currentYear = today.get(Calendar.YEAR);
		int currentMonth = today.get(Calendar.MONTH)+1;
		
		JPanel pmonth = new JPanel();
		pmonth.setLocation(500,180);
		pmonth.setSize(650,100);
		pmonth.setOpaque(false);
		
		JButton before = new JButton("before");
		JButton after = new JButton("after");
		JTextField TcurrentYear = new JTextField(currentYear+"��");
		JTextField TcurrentMonth = new JTextField(currentMonth+"��");
		before.setFont(titlef);
		after.setFont(titlef);
		TcurrentYear.setFont(titlef);
		TcurrentMonth.setFont(titlef);
		before.setBackground(new Color(255,255,255));
		before.setOpaque(false);
		after.setBackground(new Color(255,255,255));
		after.setOpaque(false);
		
		pmonth.add(before);
		pmonth.add(TcurrentYear);
		pmonth.add(TcurrentMonth);
		pmonth.add(after);
		TcurrentYear.setEnabled(false);
		TcurrentMonth.setEnabled(false);
		
		
		l.add(pmonth);
		
		/* �� �Ϸ� */

		
		/* ���� �׷��� */
		dataCSV = info.getInfo();
		cnt = info.getcnt();
		
		graph.setSize(500,500);
		graph.setLocation(300,200);
		//graph.setOpaque(false);
		
		drawChart();
		
		//l.add(graph);
		
		
		
		
		
		/* ���� �׷��� �Ϸ�*/
		
		
		/* ���� �׷��� ���� ���� */
		JPanel color = new JPanel();
		color.setLocation(300,800);
		color.setSize(1000,120);
		color.setOpaque(false);
		
		JButton b1 = new JButton("�ĺ�");
		JButton b2 = new JButton("�����");
		JButton b3 = new JButton("��ȭ��Ȱ��");
		JButton b4 = new JButton("�к�");
		JButton b5 = new JButton("����");
		JButton b6 = new JButton("�뵷");
		JButton b7 = new JButton("����");
		
		b1.setForeground(new Color(185,24,35));
		b2.setForeground(new Color(231,146,20));
		b3.setForeground(new Color(138,186,43));
		b4.setForeground(new Color(50,175,219));
		b5.setForeground(new Color(135,17,126));
		b6.setForeground(new Color(235,205,213));
		b7.setForeground(new Color(209,175,148));
		
		b1.setFont(titlef);
		b1.setBackground(new Color(255,255,255));
		b1.setOpaque(false);
		b2.setFont(titlef);
		b2.setBackground(new Color(255,255,255));
		b2.setOpaque(false);
		b3.setFont(titlef);
		b3.setBackground(new Color(255,255,255));
		b3.setOpaque(false);
		b4.setFont(titlef);
		b4.setBackground(new Color(255,255,255));
		b4.setOpaque(false);
		b5.setFont(titlef);
		b5.setBackground(new Color(255,255,255));
		b5.setOpaque(false);
		b6.setFont(titlef);
		b6.setBackground(new Color(255,255,255));
		b6.setOpaque(false);
		b7.setFont(titlef);
		b7.setBackground(new Color(255,255,255));
		b7.setOpaque(false);
		
		color.add(b1);
		color.add(b2);
		color.add(b3);
		color.add(b4);
		color.add(b5);
		color.add(b6);
		color.add(b7);
		
		l.add(color);
		/* ���� ���� �Ϸ� */
		
		add(l);
		setSize(1700,1000);
	}
	
	void drawChart(){
		int sum = 0;
		for(int i=0;i<data.length;i++){
			
		}
	}
}
