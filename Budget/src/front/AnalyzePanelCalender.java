package front;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AnalyzePanelCalender extends JPanel{
	ImageIcon daram;
	
	AnalyzePanelCalender(){
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
		
		
		/* �޷� */
		int year = 0;
		int month = 0;
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1,1);
		
		int lastOfDate = cal.getActualMaximum(Calendar.DATE);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		//�޷� ���
		
		
		
		
		add(l);
		setSize(1700,1000);
	}
}
