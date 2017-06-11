package front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EnterInformation implements ActionListener{

	private String year;
	private String month;
	private String day;
	private String category;
	private String inout;
	private String cash;
	private String memo;
	private String price;
	private String sending;
	private String deletenum;

	private Socket client = null;
	final String serverIP = "localhost";

	private OutputStream out;
	private OutputStreamWriter outw;
	private BufferedWriter bw;
	
	private JTable table;
	
	EnterInformation(JTable f){
		table = f;
	}

	public void actionPerformed(ActionEvent e){
		JButton b = (JButton)e.getSource();

		if(b.getText().equals("�Է�")){
			year = Main.fr.write.getyear();
			month = Main.fr.write.getmonth();
			day = Main.fr.write.getday();
			category = Main.fr.write.getCategory();
			inout = Main.fr.write.getInout();
			cash = Main.fr.write.getIscash();
			memo = Main.fr.write.getmemo();
			price = Main.fr.write.getprice();

			if(year==null || year.equals("") || month == null || month.equals("")|| day==null || day.equals("")){
				JOptionPane.showMessageDialog(null, "��¥�� �Է��Ͽ� �ֽʽÿ�.");
			}

			else if(inout == null){
				JOptionPane.showMessageDialog(null, "���� Ȥ�� ������ �����Ͽ� �ֽʽÿ�.");
			}

			else if(cash == null){
				JOptionPane.showMessageDialog(null, "���� Ȥ�� ī�带 �����Ͽ� �ֽʽÿ�.");
			}

			else if(price==null || price.equals("")){
				JOptionPane.showMessageDialog(null, "�ݾ��� �Է��Ͽ� �ֽʽÿ�.");
			}

			else{

				try {
					client = new Socket(serverIP, 5000);
					out = client.getOutputStream();
					outw = new OutputStreamWriter(out);
					bw = new BufferedWriter(outw);

					System.out.println("client Ready");
					sending = year + "," + month + "," + day + "," + category + "," + inout + "," + cash + "," + memo + "," + price;

					System.out.println("sending info : " + sending);
					bw.write("add" + '\n');
					bw.flush();
					bw.write(sending);
					bw.flush();

					client.close();
					out.close();
					outw.close();
					bw.close();

				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
				int cnt = Main.fr.write.getcount();
				String [] row = new String[7];
				row[0] = Integer.toString(++cnt);
				row[1] = year + " / " + month + " / " + day;
				row[2] = category;
				row[3] = inout;
				row[4] = cash;
				row[5] = memo;
				row[6] = price;
				
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				m.addRow(row);
				



			}


		}


		else{

			deletenum =  Main.fr.write.getdelete();

			if(deletenum == null || deletenum.equals("")){
				JOptionPane.showMessageDialog(null, "������ �׸��� ��ȣ�� �Է��� �ֽʽÿ�.");
			}

			else{


				try {
					client = new Socket(serverIP, 5000);
					System.out.println("client Ready");

					out = client.getOutputStream();
					outw = new OutputStreamWriter(out);
					bw = new BufferedWriter(outw);

					System.out.println("delete: " + deletenum);
					bw.write("delete" + '\n');
					bw.flush();
					bw.write(deletenum);
					bw.flush();

					client.close();
					out.close();
					outw.close();
					bw.close();

				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}

	}
}