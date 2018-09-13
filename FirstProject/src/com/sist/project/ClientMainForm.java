package com.sist.project;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.sist.common.Function;

import java.util.*;

public class ClientMainForm extends JFrame implements ActionListener{
		CardLayout card=new CardLayout();
		Login login=new Login(); 
		Mypage mp =new Mypage();
		SearchBarForm sbf=new SearchBarForm();
		sub1Frame sub=new sub1Frame();
		sub2Frame sub2=new sub2Frame();
		DetailForm df=new DetailForm();
		Chat chat=new Chat();
		
		 // ��Ʈ��ũ(��ȭ�� �ʿ�)
	    Socket s;// ���� ����
	    BufferedReader in;// �������� ������ ����� �ޱ�
	    OutputStream out; // ������ ��û�� ������
		public ClientMainForm()  
		{
			setLayout(card);
			add("SBF", sbf);
			add("LOGIN", login);
			add("CHAT",chat);
			add("MP", mp);
			
			
			add("SUB", sub);
			
			
			add("SUB2",sub2);
			add("DF", df); 
			
			
			setSize(1920, 1080);
			 
			 login.b1.addActionListener(this);
			 login.b2.addActionListener(this);
			 sbf.mpb.addActionListener(this);
			 sbf.b.addActionListener(this);
			 sub2.b.addActionListener(this);
			 mp.b1.addActionListener(this);
			 sub2.back.addActionListener(this);
			 sub.d.addActionListener(this);
			 df.back.addActionListener(this);
			 sbf.chat.addActionListener(this);
			 chat.tf.addActionListener(this);
			 chat.back.addActionListener(this);
			 
			 setDefaultCloseOperation(EXIT_ON_CLOSE); // application ��������
			 
			 setVisible(true);
			 setResizable(false);
		}
		public static void main(String[] args) {
			ClientMainForm cmf=new ClientMainForm();
		}
		public void connection(String id,String name)
		{
			try
			{
				s=new Socket("211.238.142.54",2357);
				
				in=new BufferedReader(
						new InputStreamReader(s.getInputStream()));
				out=s.getOutputStream();
				out.write((Function.LOGIN+"|"+id+"|"+name+"\n").getBytes());
			}catch(Exception ex){}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==login.b1)  // �α����ϸ� �����ִ� �������� �Ѿ
			{
				/*String id=login.tf.getText();
				String name=login.pf.getText();
				connection(id, name);*/
				//login.setVisible(false);
				
				card.show(getContentPane(), "SBF");
				mp.id_answer.setText(login.tf.getText());
				mp.pwd_answer.setText(login.pf.getText());
				if(login.man.isSelected())
				{
					mp.sex_answer.setText(login.man.getText());
				}
				if(login.woman.isSelected())
				{
					mp.sex_answer.setText(login.woman.getText());
				}
				
			}
			if(e.getSource()==login.b2)  // �α��ο��� ��� ������ ���
			{
				System.exit(0);
			}
			if(e.getSource()==sbf.mpb) // ��ġ����(����)���� ���������� ��ư Ŭ����
			{
				card.show(getContentPane(), "MP");
			}
			if(e.getSource()==sbf.b) // ��ġ����(����)���� �˻���ư Ŭ����
			{
				card.show(getContentPane(), "SUB2");
			}
			if(e.getSource()==mp.b1) // �������������� Ȯ�δ����� ��ġ��������
			{
				card.show(getContentPane(), "SBF"); 
			}
			
			if(e.getSource()==sub2.b)
			{
				System.out.println("����");
				card.show(getContentPane(), "SUB2");
				
			}
			
			if(e.getSource()==sub2.back) // �˻�â���� ���� ��ư ������ ��ġ����(����)����
			{
				card.show(getContentPane(), "SBF");
			}
			
			if(e.getSource()==sub.d) // �޺��ڽ� ���� �� ������������ ==> ���� ����
			{
					card.show(getContentPane(), "DF");
			}
			
			// DetailForm���� ������ư Ŭ���� Sub1Frame���� �Ѿ��
			if(e.getSource()==df.back)
			{
				card.show(getContentPane(), "SUB");
			}
			// ���������� ���� ä��â ��ư Ŭ���� ä��â���� �Ѿ��
			if(e.getSource()==sbf.chat)
			{
				card.show(getContentPane(), "CHAT");
			}
			if(e.getSource()==chat.back)
			{
				card.show(getContentPane(), "SBF");
			}
			if(e.getSource()==chat.tf)   // ä��â
			{
				String s=chat.tf.getText();
				chat.ta.append(s+"\n");
				chat.tf.setText("");
			}
			
			
			
			
			// ������ Ŭ���ϸ� Sub1Frame(�޺�)���� �Ѿ��
			//Sub1Frame���� �޺������ϸ� �˻��� ������ �������� �����ϸ� DetailForm
			// �޺��ڽ� ���� ���ϸ� ���â
			
		}
}















