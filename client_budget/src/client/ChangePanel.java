package client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;

/**
 * ��ư Ŭ�� ��, ��ư�� �ؽ�Ʈ�� ���� Client ȭ���� �ٲٰ� �� ���� �ʿ��� ��� ( ex) ����� �ۼ� ��ư, Ȩ ��ư ) server���� � ��ư�� Ŭ���ߴ��� ������ ������ class (������ ���� ������ SendButton class �̿�)
 * @author team 6
 *
 */
public class ChangePanel implements ActionListener{
	
	/**
	 * ��ư Ŭ���� ��ư�� �ؽ�Ʈ�� ���� server�� � ��ư�� Ŭ���ߴ��� ������ client ȭ���� �ٲ۴�.
	 */
	public void actionPerformed(ActionEvent e){
		JButton b = (JButton)e.getSource();
		
		if(b.getText().equals("����� �ۼ�")){
			
			new SendButton("writing");
			Main.fr.change("writing");
			
		}
		
		if(b.getText().equals("Ȩ")){
		
			new SendButton("home");
			Main.fr.change("home");
			
		}
		
		if(b.getText().equals("����� �м�")){
			Main.fr.change("beforeanalyze");
		}
		
		if(b.getText().equals("�޷� �м�")){
			Main.fr.change("analyzecalender");
		}
		
		if(b.getText().equals("ī�װ� �м�")){
			Main.fr.change("analyze");
		}
		
		if(b.getText().equals("�ڷ�")){
			Main.fr.change("beforeanalyze");
		}
	}

}