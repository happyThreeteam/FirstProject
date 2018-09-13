package com.sist.project;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

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
		
		JScrollPane js;
		JScrollPane js1;
		JScrollPane js2;
		JScrollPane js3;
		JScrollPane js4;

		
		 // ��Ʈ��ũ(��ȭ�� �ʿ�)
	    Socket s;// ���� ����
	    BufferedReader in;// �������� ������ ����� �ޱ�
	    OutputStream out; // ������ ��û�� ������
		public ClientMainForm()  
		{
			setLayout(card);
			
			sub.cb.addActionListener(new ActionListener() {
			      
				   @Override
				   public void actionPerformed(ActionEvent e) {
				      // TODO Auto-generated method stub
				      JComboBox jcb=(JComboBox)e.getSource();
				      int index=jcb.getSelectedIndex();
				      if(index==0) {
				         JOptionPane.showMessageDialog(null, "��� �޽��� ����", "��� �޽��� ����", JOptionPane.WARNING_MESSAGE);
				      }
				      
				   }
				});
				   sub.cb2.addActionListener(new ActionListener() {
				   
				   @Override
				   public void actionPerformed(ActionEvent e) {
				      // TODO Auto-generated method stub
				      JComboBox jcb=(JComboBox)e.getSource();
				      int index=jcb.getSelectedIndex();
				      if(index==0) {
				         JOptionPane.showMessageDialog(null, "��� �޽��� ����", "��� �޽��� ����", JOptionPane.WARNING_MESSAGE);
				      }
				   }
				});

				   
				   //===========================================================================================================
				   js=new JScrollPane(sbf,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				   
				   sbf.setPreferredSize(new Dimension(1920,1080));
				   js.setPreferredSize(new Dimension(1920,980));
				   js.setBounds(10,15,730,650);
				   
				   js.setViewportView(sbf);
				   //===========================================================================================================sbf��ü ��ũ�ѹ�
				   //===========================================================================================================
				    js1=new JScrollPane(mp,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				   
				   mp.setPreferredSize(new Dimension(1920,1080));
				   js1.setPreferredSize(new Dimension(1920,980));
				   js1.setBounds(10,15,730,650);
				   
				   js1.setViewportView(mp);
				   //===========================================================================================================mp��ü ��ũ�ѹ�
				   
				   //===========================================================================================================
				   js2=new JScrollPane(sub,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				   
				   sub.setPreferredSize(new Dimension(1920,1080));
				   js2.setPreferredSize(new Dimension(1920,980));
				   js2.setBounds(10,15,730,650);
				   
				   js2.setViewportView(sub);
				   //============================================================================================================sub1��ü ��ũ�ѹ�
				   //===========================================================================================================
				   js3=new JScrollPane(sub2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				   
				   sub2.setPreferredSize(new Dimension(1920,1080));
				   js3.setPreferredSize(new Dimension(1920,980));
				   js3.setBounds(10,15,730,650);
				   
				   js3.setViewportView(sub2);
				   //===========================================================================================================sub2��ü ��ũ�ѹ�
				 //===========================================================================================================
				   js4=new JScrollPane(df,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				   
				   df.setPreferredSize(new Dimension(1920,1080));
				   js4.setPreferredSize(new Dimension(1920,980));
				   js4.setBounds(10,15,730,650);
				   
				   js4.setViewportView(df);
				   //===========================================================================================================sub2��ü ��ũ�ѹ�
				   
			add("LOGIN", login);
			add("SBF", js);
			add("MP", js1);
			add("SUB", js2);
			add("SUB2", js3);
			add("DF", js4);
			add("CHAT",chat);
			
			 
			
			
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
			try
	         {
	               UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");//��ȣ��
	            
	         }catch(Exception ex) {}
	           ClientMainForm m=new ClientMainForm();
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
				 * 
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















