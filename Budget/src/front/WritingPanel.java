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
				
		
		JButton add = new JButton("입력");
		JButton delete = new JButton("삭제");
		
		
		Font titlef = new Font("HY나무B", Font.PLAIN, 30);
		Font contentf = new Font("HY나무M", Font.PLAIN, 25);
		
		date_lb.setText("날      짜 : ");
		year.setText("년");
		month.setText("월");
		day.setText("일");
		memo.setText("메      모 : ");
		price.setText("가격 : ");
		cate.setText("카테고리 : ");
		inout.setText("수입/지출 : ");
		cashcard.setText("현금/카드 : ");
		
		
		
		/* 여기 부터 날짜 입력 창 띄우기 */
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
		/* 날짜 입력 끝 */
		
		
		
		
		/* 카테고리 입력 띄우기 */
		cate.setSize(160,50);
		cate.setLocation(100,300);
		cate.setFont(titlef);
		l.add(cate);
		
		String[] types = {"식비", "교통비", "문화생활비", "학비", "저축"};
		JComboBox<String> category = new JComboBox<String>(types);
		category.setEditable(false);
		category.setFont(contentf);
		category.setSize(200, 50);
		category.setLocation(260, 300);
		l.add(category);
		/* 카테고리 입력 끝 */
		
		
		
		
		/* 수입 or 지출 입력 띄우기 */
		inout.setSize(170,50);
		inout.setLocation(580,300);
		inout.setFont(titlef);
		l.add(inout);
		
		
		controlPanel2 = new JPanel();
		controlPanel2.setFont(titlef);
		controlPanel2.setSize(500,300);
		controlPanel2.setLocation(585,300);
		controlPanel2.setOpaque(false);
		
		JCheckBox in = new JCheckBox("수입");
		JCheckBox out = new JCheckBox("지출");
		in.setOpaque(false);
		out.setOpaque(false);
		in.setFont(contentf);
		out.setFont(contentf);
		
		in.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				statusLabel.setText("수입 Checkbox: "+(arg0.getStateChange()==1?"checked":"unchecked")); //나중에 바꿀거!
			}
		});
		out.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				statusLabel.setText("지출 Checkbox: "+(arg0.getStateChange()==1?"checked":"unchecked")); //나중에 바꿀거!
			}
		});
		
		controlPanel2.add(in);
		controlPanel2.add(out);
		l.add(controlPanel2);
		/* 수입 or 지출 입력 완료 */
		
		
		
		
		
		/* 현금 or 카드 입력 띄우기  */
		cashcard.setSize(170,50);
		cashcard.setLocation(1020,300);
		cashcard.setFont(titlef);
		l.add(cashcard);
		
		controlPanel3 = new JPanel();
		controlPanel3.setFont(titlef);
		controlPanel3.setSize(500,300);
		controlPanel3.setLocation(1025,300);
		controlPanel3.setOpaque(false);
		
		JCheckBox cash = new JCheckBox("현금");
		JCheckBox card = new JCheckBox("카드");
		cash.setOpaque(false);
		card.setOpaque(false);
		cash.setFont(contentf);
		card.setFont(contentf);
		
		cash.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				statusLabel.setText("현금 Checkbox: "+(arg0.getStateChange()==1?"checked":"unchecked")); //나중에 바꿀거!
			}
		});
		card.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				statusLabel.setText("카드 Checkbox: "+(arg0.getStateChange()==1?"checked":"unchecked")); //나중에 바꿀거!
			}
		});
		
		controlPanel3.add(cash);
		controlPanel3.add(card);
		l.add(controlPanel3);
		/* 현금 or 카드 입력 완료 */
		
		
		
		
		/* 메모 입력 띄우기 */
		memo.setSize(160,50);
		memo.setLocation(100,400);
		memo.setFont(titlef);
		l.add(memo);
		
		Tmemo.setSize(660,50);
		Tmemo.setLocation(260,400);
		Tmemo.setFont(contentf);
		Tmemo.setHorizontalAlignment(JTextField.LEFT);
		l.add(Tmemo);
		/* 메모 입력 완료 */
		
		
		
		
		/* 가격 입력 띄우기 */
		price.setSize(150,50);
		price.setLocation(1020,400);
		price.setFont(titlef);
		l.add(price);
		
		Tprice.setSize(200,50);
		Tprice.setLocation(1180,400);
		Tprice.setFont(contentf);
		Tprice.setHorizontalAlignment(JTextField.CENTER);
		l.add(Tprice);
		/* 가격 입력 완료 */
		
		
		
		
		/* 입력, 삭제 버튼 띄우기 */
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
		/* 입력 삭제 버튼 완료 */
		
		
		
		statusLabel = new Label(); //나중에 지울 거!
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
/*		Checkbox cate1 = new Checkbox("식비"); //checkbox하나만 선택 가능하게 하기
		Checkbox cate2 = new Checkbox("교통비");
		Checkbox cate3 = new Checkbox("문화생활비");
		Checkbox cate4 = new Checkbox("학비");
		Checkbox cate5 = new Checkbox("저축");
*/
		
		
		
	
		
/*		cate1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				statusLabel.setText("식비 Checkbox: "+(arg0.getStateChange()==1?"checked":"unchecked")); //나중에 바꿀거!
			}
		});
		cate2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				statusLabel.setText("교통비 Checkbox: "+(arg0.getStateChange()==1?"checked":"unchecked")); //나중에 바꿀거!
			}
		});
		cate3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				statusLabel.setText("문화생활비 Checkbox: "+(arg0.getStateChange()==1?"checked":"unchecked")); //나중에 바꿀거!
			}
		});
		cate4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				statusLabel.setText("학비 Checkbox: "+(arg0.getStateChange()==1?"checked":"unchecked")); //나중에 바꿀거!
			}
		});
		cate5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				statusLabel.setText("저축 Checkbox: "+(arg0.getStateChange()==1?"checked":"unchecked")); //나중에 바꿀거!
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
