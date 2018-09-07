package com.sist.project;

import java.awt.CardLayout;

import javax.swing.JFrame;
import java.util.*;

public class ClientMainForm extends JFrame{
		CardLayout card=new CardLayout();
		Login login=new Login(); 
		Mypage mp =new Mypage();
		SearchBarForm sbf=new SearchBarForm();
		sub1Frame sub=new sub1Frame();
		DetailForm df=new DetailForm();
		
		public ClientMainForm()  
		{
			setLayout(card);
			add("LOGIN", login); 
			add("SUB", sub);
			add("DF", df); 
			add("SBF", sbf);
			add("MP", mp);
			setSize(1920, 1080);
			setVisible(true);
			
			 setDefaultCloseOperation(EXIT_ON_CLOSE);     // application 완전종료
			 
			 
		}
		public static void main(String[] args) {
			ClientMainForm cmf=new ClientMainForm();
		}
}















