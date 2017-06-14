package client;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

/**
 * ��¥�� �ݾ��ε� char���̰ų� �ʿ��� �׸��� null(�Է��� ���� ���� ���) ������ ó���� Ȯ���Ѵ�. �Է��� ��Ȯ�� ��� ����� �ۼ�ȭ�鿡�� �Է� Ȥ�� ���� ��ư�� ���� �� ����Ǵ� ActionListener �ν� Ȩ ��ư�� ���� �� �ƴ϶�� �濡�� ��enter���̶�� ������ ������, Server�� ������ �޾Ƶ��� �غ� �Ǹ� �Է¹�ư����, ���� ��ư���� ������ ������, �� ���� �Էµ� ������ ������. ���� ������ �Ϸ�� �ڿ��� SavingInfo class�� ���� Client���� update �� ������ �ҷ��ͼ� ����. 
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

		if(b.getText().equals("�Է�")){
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
				//System.out.println("���ڸ� �Է��ϼ���");
				JOptionPane.showMessageDialog(null, "��¥�� �ݾ׿��� ���ڸ� �Է��� �ֽʽÿ�.");
				check = 0;
			}

			if(check==1){


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
				JOptionPane.showMessageDialog(null, "������ �׸��� ��ȣ�� �Է��� �ֽʽÿ�.");
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