package com.sist.project;

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class sub1Frame extends JPanel{
	JPanel p1 = new JPanel();
	JComboBox p2 ;
	JComboBox p3 ;
	JPanel p4 = new JPanel(); 
	
	
	
	JTextField tf; 
	JButton b;  // �˻���ư
	JButton d;  // �޺��ڽ� ��ư
	
	Image pan1;
	 
	String ����[]= {"���� ����","�߽�", "�ѽ�", "�Ͻ�","���"};
	String ����[] = {"���� ����","~5õ", "5õ~1��", "1��~2��", "2��~3��", "3��~4��", "4��~5��","5��~"};
	
	public sub1Frame(){
		
		 
		
		tf = new JTextField();	
	    b = new JButton("�˻�");
	    d = new JButton("�˻�");
	    p4.setBackground(Color.RED);
	    
	    
		setLayout(null);
		
		p2 = new JComboBox<String>(����);
		p3 = new JComboBox<String>(����);
		
		
		p1.setBounds(0, 310, 1920, 60);
		p2.setBounds(860, 327, 100, 20);
		p3.setBounds(960, 327, 100, 20);
		tf.setBounds(540,250,800,35);
		b.setBounds(1345,242,50,50);
		d.setBounds(1065, 315, 50 ,50);
		p4.setBounds(0, 370, 1920, 2000);
	
	    
		add(p2, BorderLayout.NORTH);
		add(p3, BorderLayout.NORTH);
		
	    
		add(tf);
		add(b);
		add(d);
		add(p1);
		add(p4);
	
		
		
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	   protected void paintComponent(Graphics g) {
	      g.drawImage(pan1,0,0,1920,310, this);
	   }


}

