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
//	public Panel controlPanel1;
	public JPanel controlPanel2;
	public JPanel controlPanel3;
	
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
		
		
		Font titlef = new Font("HY����B", Font.PLAIN, 30);
		Font contentf = new Font("HY����M", Font.PLAIN, 25);
		
		date_lb.setText("��      ¥ : ");
		year.setText("��");
		month.setText("��");
		day.setText("��");
		memo.setText("��      �� : ");
		price.setText("���� : ");
		cate.setText("ī�װ� : ");
		inout.setText("����/���� : ");
		cashcard.setText("����/ī�� : ");
		
		
		
		/* ���� ���� ��¥ �Է� â ���� */
		date_lb.setSize(160, 50);
		date_lb.setLocation(100, 200);
		date_lb.setFont(titlef);
		l.add(date_lb);
		
		Tyear.setSize(130,50);
		Tyear.setLocation(260, 200);
		Tyear.setFont(contentf);
		Tyear.setHorizontalAlignment(JTextField.CENTER);
		l.add(Tyear);
		
		year.setSize(50, 50);
		year.setLocation(395, 200);
		year.setFont(contentf);
		l.add(year);
		
		Tmonth.setSize(90,50);
		Tmonth.setLocation(445, 200);
		Tmonth.setFont(contentf);
		Tmonth.setHorizontalAlignment(JTextField.CENTER);
		l.add(Tmonth);
		
		month.setSize(50, 50);
		month.setLocation(535, 200);
		month.setFont(contentf);
		l.add(month);
		
		Tday.setSize(90,50);
		Tday.setLocation(590, 200);
		Tday.setFont(contentf);
		Tday.setHorizontalAlignment(JTextField.CENTER);
		l.add(Tday);
		
		day.setSize(90, 50);
		day.setLocation(685, 200);
		day.setFont(contentf);
		l.add(day);
		/* ��¥ �Է� �� */
		
		
		
		
		/* ī�װ� �Է� ���� */
		cate.setSize(160,50);
		cate.setLocation(100,300);
		cate.setFont(titlef);
		l.add(cate);
		
		String[] types = {"�ĺ�", "�����", "��ȭ��Ȱ��", "�к�", "����"};
		JComboBox<String> category = new JComboBox<String>(types);
		category.setEditable(false);
		category.setFont(contentf);
		category.setSize(200, 50);
		category.setLocation(260, 300);
		l.add(category);
		/* ī�װ� �Է� �� */
		
		
		
		
		/* ���� or ���� �Է� ���� */
		inout.setSize(170,50);
		inout.setLocation(580,300);
		inout.setFont(titlef);
		l.add(inout);
		
		
		controlPanel2 = new JPanel();
		controlPanel2.setFont(titlef);
		controlPanel2.setSize(500,300);
		controlPanel2.setLocation(585,300);
		controlPanel2.setOpaque(false);
		
		JCheckBox in = new JCheckBox("����");
		JCheckBox out = new JCheckBox("����");
		in.setOpaque(false);
		out.setOpaque(false);
		in.setFont(contentf);
		out.setFont(contentf);
		
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
		
		controlPanel2.add(in);
		controlPanel2.add(out);
		l.add(controlPanel2);
		/* ���� or ���� �Է� �Ϸ� */
		
		
		
		
		
		/* ���� or ī�� �Է� ����  */
		cashcard.setSize(170,50);
		cashcard.setLocation(1020,300);
		cashcard.setFont(titlef);
		l.add(cashcard);
		
		controlPanel3 = new JPanel();
		controlPanel3.setFont(titlef);
		controlPanel3.setSize(500,300);
		controlPanel3.setLocation(1025,300);
		controlPanel3.setOpaque(false);
		
		JCheckBox cash = new JCheckBox("����");
		JCheckBox card = new JCheckBox("ī��");
		cash.setOpaque(false);
		card.setOpaque(false);
		cash.setFont(contentf);
		card.setFont(contentf);
		
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
		
		controlPanel3.add(cash);
		controlPanel3.add(card);
		l.add(controlPanel3);
		/* ���� or ī�� �Է� �Ϸ� */
		
		
		
		
		/* �޸� �Է� ���� */
		memo.setSize(160,50);
		memo.setLocation(100,400);
		memo.setFont(titlef);
		l.add(memo);
		
		Tmemo.setSize(660,50);
		Tmemo.setLocation(260,400);
		Tmemo.setFont(contentf);
		Tmemo.setHorizontalAlignment(JTextField.LEFT);
		l.add(Tmemo);
		/* �޸� �Է� �Ϸ� */
		
		
		
		
		/* ���� �Է� ���� */
		price.setSize(150,50);
		price.setLocation(1020,400);
		price.setFont(titlef);
		l.add(price);
		
		Tprice.setSize(200,50);
		Tprice.setLocation(1180,400);
		Tprice.setFont(contentf);
		Tprice.setHorizontalAlignment(JTextField.CENTER);
		l.add(Tprice);
		/* ���� �Է� �Ϸ� */
		
		
		
		
		/* �Է�, ���� ��ư ���� */
		add.setSize(100,50);
		add.setLocation(1300,400);
		add.setFont(titlef);
		l.add(add);
		
		delete.setSize(100,50);
		delete.setLocation(1450,400);
		delete.setFont(titlef);
		l.add(delete);
		
		Tdelete.setSize(100,50);
		Tdelete.setLocation(1550,400);
		Tdelete.setFont(titlef);
		Tdelete.setHorizontalAlignment(JTextField.CENTER);
		l.add(Tdelete);
		/* �Է� ���� ��ư �Ϸ� */
		
		
		
		statusLabel = new Label(); //���߿� ���� ��!
		statusLabel.setText("statusLabel");
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setFont(titlef);
		statusLabel.setSize(350,100);
		statusLabel.setLocation(200,800);
		
/*		controlPanel1 = new Panel();
		controlPanel1.setFont(titlef);
		controlPanel1.setSize(700,300);
		controlPanel1.setLocation(170,300);
*/		
		
		
/*		
*/		
/*		Checkbox cate1 = new Checkbox("�ĺ�"); //checkbox�ϳ��� ���� �����ϰ� �ϱ�
		Checkbox cate2 = new Checkbox("�����");
		Checkbox cate3 = new Checkbox("��ȭ��Ȱ��");
		Checkbox cate4 = new Checkbox("�к�");
		Checkbox cate5 = new Checkbox("����");
*/
		
		
		
	
		
/*		cate1.addItemListener(new ItemListener() {
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
		
*/
		
		
		
		
		
/*		controlPanel1.add(cate1);
		controlPanel1.add(cate2);
		controlPanel1.add(cate3);
		controlPanel1.add(cate4);
		controlPanel1.add(cate5);
*/
/*				
		controlPanel3.add(cash);
		controlPanel3.add(card);
*/		
		l.add(statusLabel);
	//	l.add(controlPanel1);
		
			
		add(l);
		setSize(1700,1000);
		
	}	
	

}
