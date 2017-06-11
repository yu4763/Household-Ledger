package front;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class WritingPanel extends JPanel{

	ImageIcon daram;

	JLabel l;
	Label statusLabel;
	JPanel tablePanel;
	Calendar now;

	private JTextField tyear; 
	private JTextField tmonth;
	private JTextField tday;
	private JTextField tmemo; 
	private JTextField tprice;
	private JTextField tdelete;
	private JComboBox<String> category;

	private JRadioButton in;
	private JRadioButton out;
	private JRadioButton cash;
	private JRadioButton card;
	private JRadioButton no1;
	private JRadioButton no2;
	

	WritingPanel(String[][] tmp, int count){


		setLayout(null);

		ImageIcon oldIcon = new ImageIcon("./resources/darami.jpg");
		Image oldImage = oldIcon.getImage();
		Image newImage = oldImage.getScaledInstance(1700,1000,java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImage);		
		JLabel l = new JLabel(newIcon);
		l.setSize(1700,1000);
		l.setLocation(0,0);

		now = Calendar.getInstance();

		JLabel date_lb = new JLabel();
		JLabel year = new JLabel();
		JLabel month = new JLabel();
		JLabel day = new JLabel();
		JLabel memo = new JLabel();
		JLabel price = new JLabel();
		JLabel cate = new JLabel();
		JLabel inout = new JLabel();
		JLabel cashcard = new JLabel();

		tyear = new JTextField(Integer.toString(now.get(Calendar.YEAR)));
		tmonth = new JTextField(Integer.toString(now.get(Calendar.MONTH)+1));
		tday = new JTextField(Integer.toString(now.get(Calendar.DAY_OF_MONTH)));
		tmemo = new JTextField(20);
		tprice = new JTextField(10);
		tdelete = new JTextField(4);

		tmemo.setText(null);
		tprice.setText(null);


		Font titlef = new Font("���ﳲ��ü B", Font.PLAIN, 30);
		Font contentf = new Font("���ﳲ��ü L", Font.PLAIN, 25);
		Font tabletif = new Font("���ﳲ��ü B", Font.PLAIN, 17);
		Font tablecof = new Font("���ﳲ��ü L", Font.PLAIN, 20);

		date_lb.setText("��      ¥ : ");
		year.setText("��");
		month.setText("��");
		day.setText("��");
		memo.setText("��      �� : ");
		price.setText("�ݾ� : ");
		cate.setText("ī�װ��� : ");
		inout.setText("����/���� : ");
		cashcard.setText("����/ī�� : ");


		/* Ȩ ��ư */
		JButton home = new JButton("Ȩ");
		home.setSize(80,80);
		home.setLocation(100,80);
		home.setBackground(new Color(236,230,204));
		home.setFont(titlef);
		l.add(home);

		home.addActionListener(new ChangePanel());
		/* Ȩ��ư �Ϸ� */



		/* ���� ���� ��¥ �Է� â ���� */
		date_lb.setSize(160, 50);
		date_lb.setLocation(100, 200);
		date_lb.setFont(titlef);
		l.add(date_lb);

		tyear.setSize(130,50);
		tyear.setLocation(260, 200);
		tyear.setFont(contentf);
		tyear.setHorizontalAlignment(JTextField.CENTER);
		l.add(tyear);

		year.setSize(50, 50);
		year.setLocation(395, 200);
		year.setFont(contentf);
		l.add(year);

		tmonth.setSize(90,50);
		tmonth.setLocation(445, 200);
		tmonth.setFont(contentf);
		tmonth.setHorizontalAlignment(JTextField.CENTER);
		l.add(tmonth);

		month.setSize(50, 50);
		month.setLocation(535, 200);
		month.setFont(contentf);
		l.add(month);

		tday.setSize(90,50);
		tday.setLocation(590, 200);
		tday.setFont(contentf);
		tday.setHorizontalAlignment(JTextField.CENTER);
		l.add(tday);

		day.setSize(90, 50);
		day.setLocation(685, 200);
		day.setFont(contentf);
		l.add(day);
		/* ��¥ �Է� �� */




		/* ī�װ��� �Է� ���� */
		cate.setSize(160,50);
		cate.setLocation(100,300);
		cate.setFont(titlef);
		l.add(cate);

		String[] types = {"�ĺ�", "�����", "��ȭ��Ȱ��", "�к�", "����", "�뵷","����"};
		category = new JComboBox<String>(types);
		category.setEditable(false);
		category.setFont(contentf);
		category.setSize(200, 50);
		category.setLocation(260, 300);
		l.add(category);
		/* ī�װ��� �Է� �� */



	
		 
		/* ���� or ���� �Է� ���� */
		inout.setSize(170,50);
		inout.setLocation(580,300);
		inout.setFont(titlef);
		l.add(inout);


		in = new JRadioButton("����");
		out = new JRadioButton("����");
		in.setOpaque(false);
		out.setOpaque(false);
		in.setFont(contentf);
		out.setFont(contentf);
		no1 = new JRadioButton();
		

		ButtonGroup group1 = new ButtonGroup();
		group1.add(in);
		group1.add(out);
		group1.add(no1);


		JPanel controlPanel1 = new JPanel();
		controlPanel1.setFont(titlef);
		controlPanel1.setSize(500,300);
		controlPanel1.setLocation(570,300);
		controlPanel1.setOpaque(false);
		controlPanel1.add(in);
		controlPanel1.add(out);

		l.add(controlPanel1);
		/* ���� or ���� �Է� �Ϸ� */





		/* ���� or ī�� �Է� ����  */
		cashcard.setSize(170,50);
		cashcard.setLocation(1020,300);
		cashcard.setFont(titlef);
		l.add(cashcard);

		cash = new JRadioButton("����");
		card = new JRadioButton("ī��");
		cash.setOpaque(false);
		card.setOpaque(false);
		cash.setFont(contentf);
		card.setFont(contentf);
		no2 = new JRadioButton();

		ButtonGroup group2 = new ButtonGroup();
		group2.add(cash);
		group2.add(card);
		group2.add(no2);


		JPanel controlPanel2 = new JPanel();
		controlPanel2.setFont(titlef);
		controlPanel2.setSize(500,300);
		controlPanel2.setLocation(1025,300);
		controlPanel2.setOpaque(false);
		controlPanel2.add(cash);
		controlPanel2.add(card);

		l.add(controlPanel2);
		/* ���� or ī�� �Է� �Ϸ� */




		/* �޸� �Է� ���� */
		memo.setSize(160,50);
		memo.setLocation(100,400);
		memo.setFont(titlef);
		l.add(memo);

		tmemo.setSize(660,50);
		tmemo.setLocation(260,400);
		tmemo.setFont(contentf);
		tmemo.setHorizontalAlignment(JTextField.LEFT);
		l.add(tmemo);
		/* �޸� �Է� �Ϸ� */



		/* ���� �Է� ���� */
		price.setSize(150,50);
		price.setLocation(1020,400);
		price.setFont(titlef);
		l.add(price);

		tprice.setSize(150,50);
		tprice.setLocation(1130,400);
		tprice.setFont(contentf);
		tprice.setHorizontalAlignment(JTextField.CENTER);
		l.add(tprice);
		/* ���� �Է� �Ϸ� */


		/* ǥ  ��� */
		String[][] data = new String[2000][7];
		String[] title = new String[7];
		title[0] = "��ȣ";
		title[1] = "��¥";
		title[2] = "ī�װ���";
		title[3] = "����/����";
		title[4] = "ī��/����";
		title[5] = "�޸�";
		title[6] = "�ݾ�";
				
		int i;
		int k;
		
		for(i=0; i<count; i++){
			for( k=0; k<9; k++){
				if(k==0)
					data[i][k] = tmp[i][k];
				else if(k==1)
					data[i][1] = tmp[i][k];
				else if(k==2 || k==3){
					if(tmp[i][k] != null)
						data[i][1] +=   "/ " + tmp[i][k];
				}
				else
					data[i][k-2] = tmp[i][k];
			}
			
		}
				
		DefaultTableModel model = new DefaultTableModel(data,title);
		JTable table = new JTable(model);
		table.getTableHeader().setFont(tabletif);
		table.setFont(tablecof);
		table.setRowHeight(35); 
		JScrollPane scroll = new JScrollPane(table);
		scroll.setSize(1250,430);
		scroll.setLocation(100,510);
		l.add(scroll);
		/* ǥ��� �� */
		
		



		/* �Է�, ���� ��ư ���� */
		JButton add = new JButton("�Է�");
		JButton delete = new JButton("����");

		add.setSize(100,50);
		add.setLocation(1320,400);
		add.setFont(titlef);
		add.addActionListener(new EnterInformation( ));
		l.add(add);

		delete.setSize(100,50);
		delete.setLocation(1450,400);
		delete.setFont(titlef);
		delete.addActionListener(new EnterInformation( ));
		l.add(delete);

		tdelete.setSize(100,50);
		tdelete.setLocation(1550,400);
		tdelete.setFont(titlef);
		tdelete.setHorizontalAlignment(JTextField.CENTER);
		l.add(tdelete);
		/* �Է� ���� ��ư �Ϸ� */

		
		
	
		
	
		add(l);
		setSize(1700,1000);
		

	}

	String getyear(){
		
		String year = tyear.getText();
		tyear.setText(Integer.toString(now.get(Calendar.YEAR)));
		return year;
	
	}

	String getmonth(){

		String month = tmonth.getText();
		tmonth.setText(Integer.toString(now.get(Calendar.MONTH)+1));
		return month;
	
	}

	String getday(){

		String day = tday.getText();
		tday.setText(Integer.toString(now.get(Calendar.DAY_OF_MONTH)));
		return day;
	
	}

	String getmemo(){

		String memo = tmemo.getText();
		tmemo.setText("");
		return memo;
	
	}

	String getprice(){

		String price = tprice.getText();
		tprice.setText("");
		return price;
	
	}

	String getCategory(){
		
		String c = category.getSelectedItem().toString();
		category.setSelectedIndex(0);
		return c;
		
	}

	String getInout(){

		if(in.isSelected()){
			no1.setSelected(true);
			return "����";
		}

		else if(out.isSelected()){
			no1.setSelected(true);
			return "����";
		}

		else
			return null;

	}

	String getIscash(){

		if(cash.isSelected()){
			no2.setSelected(true);
			return "����";
		}

		else if(card.isSelected()){
			no2.setSelected(true);
			return "ī��";
		}

		else
			return null;

	}
	
	String getdelete(){

		String del = tdelete.getText();
		tdelete.setText("");
		return del;
	
	}

	
	
}