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
		
		 // 네트워크(전화가 필요)
	    Socket s;// 서버 연결
	    BufferedReader in;// 서버에서 들어오는 결과값 받기
	    OutputStream out; // 서버로 요청값 보내기
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
			 
			 setDefaultCloseOperation(EXIT_ON_CLOSE); // application 완전종료
			 
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
			if(e.getSource()==login.b1)  // 로그인하면 지도있는 페이지로 넘어감
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
			if(e.getSource()==login.b2)  // 로그인에서 취소 누르면 취소
			{
				System.exit(0);
			}
			if(e.getSource()==sbf.mpb) // 서치바폼(지도)에서 마이페이지 버튼 클릭시
			{
				card.show(getContentPane(), "MP");
			}
			if(e.getSource()==sbf.b) // 서치바폼(지도)에서 검색버튼 클릭시
			{
				card.show(getContentPane(), "SUB2");
			}
			if(e.getSource()==mp.b1) // 마이페이지에서 확인누르면 서치바폼으로
			{
				card.show(getContentPane(), "SBF"); 
			}
			
			if(e.getSource()==sub2.b)
			{
				System.out.println("성공");
				card.show(getContentPane(), "SUB2");
				
			}
			
			if(e.getSource()==sub2.back) // 검색창에서 이전 버튼 누르면 서치바폼(지도)으로
			{
				card.show(getContentPane(), "SBF");
			}
			
			if(e.getSource()==sub.d) // 콤보박스 설정 후 디테일폼으로 ==> 설정 못함
			{
					card.show(getContentPane(), "DF");
			}
			
			// DetailForm에서 이전버튼 클릭시 Sub1Frame으로 넘어가기
			if(e.getSource()==df.back)
			{
				card.show(getContentPane(), "SUB");
			}
			// 마이페이지 옆에 채팅창 버튼 클릭시 채팅창으로 넘어가기
			if(e.getSource()==sbf.chat)
			{
				card.show(getContentPane(), "CHAT");
			}
			if(e.getSource()==chat.back)
			{
				card.show(getContentPane(), "SBF");
			}
			if(e.getSource()==chat.tf)   // 채팅창
			{
				String s=chat.tf.getText();
				chat.ta.append(s+"\n");
				chat.tf.setText("");
			}
			
			
			
			
			// 지도를 클릭하면 Sub1Frame(콤보)으로 넘어가기
			//Sub1Frame에서 콤보설정하면 검색을 누르면 음식점을 선택하면 DetailForm
			// 콤보박스 설정 못하면 경고창
			
		}
}















