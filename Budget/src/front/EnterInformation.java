package front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

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
	

	public void actionPerformed(ActionEvent e){
		
		new SendButton("enter");
		
		JButton b = (JButton)e.getSource();

		if(b.getText().equals("입력")){
			year = Main.fr.write.getyear();
			month = Main.fr.write.getmonth();
			day = Main.fr.write.getday();
			category = Main.fr.write.getCategory();
			inout = Main.fr.write.getInout();
			cash = Main.fr.write.getIscash();
			memo = Main.fr.write.getmemo();
			price = Main.fr.write.getprice();

			if(year==null || year.equals("") || month == null || month.equals("")|| day==null || day.equals("")){
				JOptionPane.showMessageDialog(null, "날짜를 입력하여 주십시오.");
			}

			else if(inout == null){
				JOptionPane.showMessageDialog(null, "수입 혹은 지출을 선택하여 주십시오.");
			}

			else if(cash == null){
				JOptionPane.showMessageDialog(null, "현금 혹은 카드를 선택하여 주십시오.");
			}

			else if(price==null || price.equals("")){
				JOptionPane.showMessageDialog(null, "금액을 입력하여 주십시오.");
			}

			else{

				try {
					
					Thread.sleep(20);
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
				}catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			
		
				
				try {
				
					Thread.sleep(15);
					SavingInfo si = new SavingInfo();
					si.run();
					Thread.sleep(2);
					Main.fr.change("writing");	
					
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
						

			}


		}


		else{

			deletenum =  Main.fr.write.getdelete();

			if(deletenum == null || deletenum.equals("")){
				JOptionPane.showMessageDialog(null, "삭제할 항목의 번호를 입력해 주십시오.");
			}

			else{


				try {
					
					Thread.sleep(20);
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
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				try {
					Thread.sleep(15);
					SavingInfo si = new SavingInfo();
					si.run();
					Thread.sleep(2);
					Main.fr.change("writing");	
					
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				

			}
			
			

		}

	}

}