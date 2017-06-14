package client;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

/**
 * 날짜나 금액인데 char형이거나 필요한 항목이 null(입력이 되지 않은 경우) 인지도 처음에 확인한다. 입력이 정확할 경우 가계부 작성화면에서 입력 혹은 삭제 버튼을 누를 때 실행되는 ActionListener 로써 홈 버튼을 누른 게 아니라는 뜻에서 “enter”이라는 정보를 보내고, Server가 정보를 받아들일 준비가 되면 입력버튼인지, 삭제 버튼인지 정보를 보내고, 그 이후 입력된 정보를 보낸다. 정보 전달이 완료된 뒤에는 SavingInfo class를 통해 Client에도 update 된 정보를 불러와서 띄운다. 
 * @author team 6
 *
 */
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
	final int port = 5000;

	private OutputStream out;
	private OutputStreamWriter outw;
	private BufferedWriter bw;


	public void actionPerformed(ActionEvent e){

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


			int check = 1;

			try {
				Integer.parseInt(year);
				Integer.parseInt(month);
				Integer.parseInt(day);
				Integer.parseInt(price);

			} catch (NumberFormatException exception) {
				//System.out.println("숫자를 입력하세요");
				JOptionPane.showMessageDialog(null, "날짜와 금액에는 숫자만 입력해 주십시오.");
				check = 0;
			}

			if(check==1){


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
					
					new SendButton("enter");

					try {

						Thread.sleep(40);
						client = new Socket(serverIP, port);
						out = client.getOutputStream();
						outw = new OutputStreamWriter(out);
						bw = new BufferedWriter(outw);

						System.out.println("client Ready");
						sending = year + "," + month + "," + day + "," + category + "," + inout + "," + cash + "," + memo + "," + price;

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
		}


		else{

			deletenum =  Main.fr.write.getdelete();

			if(deletenum == null || deletenum.equals("")){
				JOptionPane.showMessageDialog(null, "삭제할 항목의 번호를 입력해 주십시오.");
			}

			else{

				new SendButton("enter");
				
				try {

					Thread.sleep(40);
					client = new Socket(serverIP, port);
					System.out.println("client Ready");

					out = client.getOutputStream();
					outw = new OutputStreamWriter(out);
					bw = new BufferedWriter(outw);

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
					Thread.sleep(20);
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