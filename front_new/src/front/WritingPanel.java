package front;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class WritingPanel extends JPanel{
	
	ImageIcon daram;
	
	public Label statusLabel;
	public Panel controlPanel1;
	public Panel controlPanel2;
	public Panel controlPanel3;
	
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
		JLabel memo = new JLabel();
		JLabel price = new JLabel();
		JLabel cate = new JLabel();
		JLabel inout = new JLabel();
		JLabel cashcard = new JLabel();
		JTextField Tyear = new JTextField(Integer.toString(now.get(Calendar.YEAR)));
		JTextField Tmonth = new JTextField(Integer.toString(now.get(Calendar.MONTH)+1));
		JTextField Tday = new JTextField(Integer.toString(now.get(Calendar.DAY_OF_MONTH)));
		JTextField Tmemo = new JTextField(20);
		JTextField Tprice = new JTextField(10);
		JTextField Tdelete = new JTextField(4);
		
		JButton add = new JButton("�Է�");
		JButton delete = new JButton("����");
		
		
		Font font = new Font("MD��Ʈü", Font.PLAIN, 30);
		
		date_lb.setText("��¥ : ");
		year.setText("��");
		month.setText("��");
		day.setText("��");
		memo.setText("�޸� : ");
		price.setText("���� : ");
		cate.setText("ī�װ� : ");
		inout.setText("����/���� : ");
		cashcard.setText("����/ī�� : ");
		
		date_lb.setSize(150, 50);
		date_lb.setLocation(100, 200);
		date_lb.setFont(font);
		l.add(date_lb);
		
		Tyear.setSize(130,50);
		Tyear.setLocation(200, 200);
		Tyear.setFont(font);
		Tyear.setHorizontalAlignment(JTextField.CENTER);
		l.add(Tyear);
		
		year.setSize(50, 50);
		year.setLocation(335, 200);
		year.setFont(font);
		l.add(year);
		
		Tmonth.setSize(90,50);
		Tmonth.setLocation(385, 200);
		Tmonth.setFont(font);
		Tmonth.setHorizontalAlignment(JTextField.CENTER);
		l.add(Tmonth);
		
		month.setSize(50, 50);
		month.setLocation(480, 200);
		month.setFont(font);
		l.add(month);
		
		Tday.setSize(90,50);
		Tday.setLocation(530, 200);
		Tday.setFont(font);
		Tday.setHorizontalAlignment(JTextField.CENTER);
		l.add(Tday);
		
		day.setSize(90, 50);
		day.setLocation(625, 200);
		day.setFont(font);
		l.add(day);
		
		cate.setSize(150,50);
		cate.setLocation(100,300);
		cate.setFont(font);
		l.add(cate);
		
		inout.setSize(160,50);
		inout.setLocation(850,300);
		inout.setFont(font);
		l.add(inout);
		
		cashcard.setSize(160,50);
		cashcard.setLocation(1240,300);
		cashcard.setFont(font);
		l.add(cashcard);
		
		memo.setSize(150,50);
		memo.setLocation(100,400);
		memo.setFont(font);
		l.add(memo);
		
		Tmemo.setSize(700,50);
		Tmemo.setLocation(200,400);
		Tmemo.setFont(font);
		Tmemo.setHorizontalAlignment(JTextField.LEFT);
		l.add(Tmemo);
		
		price.setSize(150,50);
		price.setLocation(950,400);
		price.setFont(font);
		l.add(price);
		
		Tprice.setSize(200,50);
		Tprice.setLocation(1050,400);
		Tprice.setFont(font);
		Tprice.setHorizontalAlignment(JTextField.CENTER);
		l.add(Tprice);
		
		add.setSize(100,50);
		add.setLocation(1300,400);
		add.setFont(font);
		l.add(add);
		
		delete.setSize(100,50);
		delete.setLocation(1450,400);
		delete.setFont(font);
		l.add(delete);
		
		Tdelete.setSize(100,50);
		Tdelete.setLocation(1550,400);
		Tdelete.setFont(font);
		Tdelete.setHorizontalAlignment(JTextField.CENTER);
		l.add(Tdelete);
		
		
		
		statusLabel = new Label(); //���߿� ���� ��!
		statusLabel.setText("statusLabel");
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setFont(font);
		statusLabel.setSize(350,100);
		statusLabel.setLocation(200,800);
		
		controlPanel1 = new Panel();
		controlPanel1.setFont(font);
		controlPanel1.setSize(700,300);
		controlPanel1.setLocation(170,300);
		
		controlPanel2 = new Panel();
		controlPanel2.setFont(font);
		controlPanel2.setSize(500,300);
		controlPanel2.setLocation(850,300);
		
		controlPanel3 = new Panel();
		controlPanel3.setFont(font);
		controlPanel3.setSize(500,300);
		controlPanel3.setLocation(1240,300);
		
		Checkbox cate1 = new Checkbox("�ĺ�"); //checkbox�ϳ��� ���� �����ϰ� �ϱ�
		Checkbox cate2 = new Checkbox("�����");
		Checkbox cate3 = new Checkbox("��ȭ��Ȱ��");
		Checkbox cate4 = new Checkbox("�к�");
		Checkbox cate5 = new Checkbox("����");
		
		Checkbox in = new Checkbox("����");
		Checkbox out = new Checkbox("����");
		
		Checkbox cash = new Checkbox("����");
		Checkbox card = new Checkbox("ī��");
		
		cate1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				statusLabel.setText("�ĺ� Checkbox: "+(arg0.getStateChange()==1?"checked":"unchecked")); //���߿� �ٲܰ�!
			}
		});
		cate2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				statusLabel.setText("����� Checkbox: "+(arg0.getStateChange()==1?"checked":"unchecked")); //���߿� �ٲܰ�!
			}
		});
		cate3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				statusLabel.setText("��ȭ��Ȱ�� Checkbox: "+(arg0.getStateChange()==1?"checked":"unchecked")); //���߿� �ٲܰ�!
			}
		});
		cate4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				statusLabel.setText("�к� Checkbox: "+(arg0.getStateChange()==1?"checked":"unchecked")); //���߿� �ٲܰ�!
			}
		});
		cate5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				statusLabel.setText("���� Checkbox: "+(arg0.getStateChange()==1?"checked":"unchecked")); //���߿� �ٲܰ�!
			}
		});
		
		in.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				statusLabel.setText("���� Checkbox: "+(arg0.getStateChange()==1?"checked":"unchecked")); //���߿� �ٲܰ�!
			}
		});
		out.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				statusLabel.setText("���� Checkbox: "+(arg0.getStateChange()==1?"checked":"unchecked")); //���߿� �ٲܰ�!
			}
		});
		
		cash.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				statusLabel.setText("���� Checkbox: "+(arg0.getStateChange()==1?"checked":"unchecked")); //���߿� �ٲܰ�!
			}
		});
		card.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				statusLabel.setText("ī�� Checkbox: "+(arg0.getStateChange()==1?"checked":"unchecked")); //���߿� �ٲܰ�!
			}
		});
		
		controlPanel1.add(cate1);
		controlPanel1.add(cate2);
		controlPanel1.add(cate3);
		controlPanel1.add(cate4);
		controlPanel1.add(cate5);
		
		controlPanel2.add(in);
		controlPanel2.add(out);
		
		controlPanel3.add(cash);
		controlPanel3.add(card);
		
		l.add(statusLabel);
		l.add(controlPanel1);
		l.add(controlPanel2);
		l.add(controlPanel3);
		
		
		
		
		
		add(l);
		setSize(1700,1000);
		
	}	
	

}
