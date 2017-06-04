package front;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

public class WritingPanel extends JPanel{
	
	ImageIcon daram;
	
	public JLabel l;
	public Label statusLabel;
	public JPanel tablePanel;
	
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
		
		
		JRadioButton in = new JRadioButton("����");
		JRadioButton out = new JRadioButton("����");
		in.setOpaque(false);
		out.setOpaque(false);
		in.setFont(contentf);
		out.setFont(contentf);
		
		ButtonGroup group1 = new ButtonGroup();
		group1.add(in);
		group1.add(out);
		
		
		JPanel controlPanel1 = new JPanel();
		controlPanel1.setFont(titlef);
		controlPanel1.setSize(500,300);
		controlPanel1.setLocation(570,300);
		controlPanel1.setOpaque(false);
		controlPanel1.add(in);
		controlPanel1.add(out);
		
		
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
		
		l.add(controlPanel1);
		/* ���� or ���� �Է� �Ϸ� */
		
		
		
		
		
		/* ���� or ī�� �Է� ����  */
		cashcard.setSize(170,50);
		cashcard.setLocation(1020,300);
		cashcard.setFont(titlef);
		l.add(cashcard);
		
		JRadioButton cash = new JRadioButton("����");
		JRadioButton card = new JRadioButton("ī��");
		cash.setOpaque(false);
		card.setOpaque(false);
		cash.setFont(contentf);
		card.setFont(contentf);
		
		ButtonGroup group2 = new ButtonGroup();
		group2.add(cash);
		group2.add(card);
		
		
		JPanel controlPanel2 = new JPanel();
		controlPanel2.setFont(titlef);
		controlPanel2.setSize(500,300);
		controlPanel2.setLocation(1025,300);
		controlPanel2.setOpaque(false);
		controlPanel2.add(cash);
		controlPanel2.add(card);
		
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
		
		l.add(controlPanel2);
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
		
		Tprice.setSize(150,50);
		Tprice.setLocation(1130,400);
		Tprice.setFont(contentf);
		Tprice.setHorizontalAlignment(JTextField.CENTER);
		l.add(Tprice);
		/* ���� �Է� �Ϸ� */
		
		
		
		
		/* �Է�, ���� ��ư ���� */
		JButton add = new JButton("�Է�");
		JButton delete = new JButton("����");
		
		add.setSize(100,50);
		add.setLocation(1320,400);
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
	
		l.add(statusLabel);
		
		
		/* ǥ  ����� */
		String[][] data = new String[20][9];
		String[] title = new String[9];
		title[0] = "��ȣ";
		title[1] = "��";
		title[2] = "��";
		title[3] = "��";
		title[4] = "ī�װ�";
		title[5] = "����/����";
		title[6] = "ī��/����";
		title[7] = "�޸�";
		title[8] = "�ݾ�";
		
		DefaultTableModel model = new DefaultTableModel(data,title);
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setSize(800,300);
		scroll.setLocation(200,500);
		l.add(scroll);
		
		int count = 0;
		
		
		/* ǥ �Է� */	
		
		ActionListener listener1 = new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				try{
					data[count][0] = String.valueOf(count+1); //��ȣ
					data[count][1] = Tyear.getText(); //��
					data[count][2] = Tmonth.getText(); //��
					data[count][3] = Tday.getText(); //��
					data[count][4] = category.getActionCommand(); //ī�װ�
					data[count][5] = ; //����/����
					data[count][6] = ; //ī��/����
					data[count][7] = Tmemo.getText(); //�޸�
					data[count][8] = Tprice.getText(); //�ݾ�					
					
					table.updateUI();
					count++;
					Tyear.setText("");
					Tmonth.setText("");
					Tday.setText("");
					Tmemo.setText("");
					Tprice.setText("");
				}catch(Exception e){
					JOptionPane.showMessageDialog(getParent(), data.length+"�� �ʰ�");
				}
			}
		};
		add.addActionListener(listener1);
		
		ActionListener listener2 = new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				//delete
			}
		};
		add.addActionListener(listener2);
		
		l.add(add);
		l.add(delete);
		
			
		add(l);
		setSize(1700,1000);
		
	}


}
