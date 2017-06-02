package front;

import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class WritingPanel extends JPanel{
	
	ImageIcon daram;
	
	WritingPanel(){

		setLayout(null);
	
		ImageIcon oldIcon = new ImageIcon("./resources/darami.jpg");
		Image oldImage = oldIcon.getImage();
		Image newImage = oldImage.getScaledInstance(1700,1000,java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImage);
		JLabel l = new JLabel(newIcon);
		l.setSize(1700,1000);
		l.setLocation(0,0);
		
		Calendar now = Calendar.getInstance();
		
		JLabel date_lb = new JLabel();
		JLabel year = new JLabel();
		JLabel month = new JLabel();
		JLabel day = new JLabel();
		JTextField Tyear = new JTextField(Integer.toString(now.get(Calendar.YEAR)));
		JTextField Tmonth = new JTextField(Integer.toString(now.get(Calendar.MONTH)+1));
		JTextField Tday = new JTextField(Integer.toString(now.get(Calendar.DAY_OF_MONTH)));
		
		
		Font font = new Font("MD아트체", Font.PLAIN, 30);
		
		date_lb.setText("날짜 : ");
		year.setText("년");
		month.setText("월");
		day.setText("일");
		
		date_lb.setSize(150, 50);
		date_lb.setLocation(100, 200);
		date_lb.setFont(font);
		l.add(date_lb);
		
		Tyear.setSize(130,50);
		Tyear.setLocation(250, 200);
		Tyear.setFont(font);
		Tyear.setHorizontalAlignment(JTextField.CENTER);
		l.add(Tyear);
		
		year.setSize(50, 50);
		year.setLocation(385, 200);
		year.setFont(font);
		l.add(year);
		
		Tmonth.setSize(90,50);
		Tmonth.setLocation(435, 200);
		Tmonth.setFont(font);
		Tmonth.setHorizontalAlignment(JTextField.CENTER);
		l.add(Tmonth);
		
		month.setSize(50, 50);
		month.setLocation(530, 200);
		month.setFont(font);
		l.add(month);
		
		Tday.setSize(90,50);
		Tday.setLocation(580, 200);
		Tday.setFont(font);
		Tday.setHorizontalAlignment(JTextField.CENTER);
		l.add(Tday);
		
		day.setSize(90, 50);
		day.setLocation(675, 200);
		day.setFont(font);
		l.add(day);
		
		
		
		
		add(l);
		setSize(1700,1000);
		
	}

}
