package com.sist.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.text.JTextComponent;

import com.sist.list.CategoryVO;
import com.sist.list.FoodData1;

public class sub1Frame extends JPanel{
	
	 ArrayList<CategoryVO> list=new ArrayList<CategoryVO>();
	
   JPanel p1 = new JPanel();
   JComboBox p2 ;
   JComboBox p3 ;
   sub1_p4 p4 = new sub1_p4();
   
   JTextField tf;
   JButton b;  
   JButton d;
   JButton e1;
  // JComboBox cb;
  // JComboBox cb2;
   
   JButton button1=new JButton("����");
   JButton button2=new JButton("����");
   JButton mpb;
   Image pan1;
   
   JLabel la; //null ��
    
   
   
  JTextField pp=new JTextField(); // �������� �޾ƿ��� ���� �̸��Դϴ�
   
  // String ����[]= {"���� ����","�߽�", "�ѽ�", "�Ͻ�","���"};
   //String ����[] = {"���� ����","~5õ", "5õ~1��", "1��~2��", "2��~3��", "3��~4��", "4��~5��","5��~"};
   
   
   public sub1Frame(){
      pp.setEditable(false);
      
      tf = new JTextField();   
       b = new JButton("�˻�");
       d = new JButton("�˻�");
       e1 = new JButton("����");
       mpb = new JButton("����������");

	     
      setLayout(null);
      
      p1.setBounds(0, 310, 1920, 60);
      
      tf.setBounds(540,250,800,35);
      b.setBounds(1345,242,50,50);
      
      d.setBounds(1065, 315, 50 ,50);
      p4.setBounds(0, 350, 1920, 620);
      
      e1.setBounds(1405, 242, 50, 50);
      pp.setBounds(900, 327, 100, 20);
      
      mpb.setBounds(1780,10,100,40);
      
      button1.setBounds(860,  980, 70 ,  50);
      button2.setBounds(960,  980, 70 ,  50);
      button1.setOpaque(true);
      button2.setOpaque(true);
      
      b.setOpaque(true);  
      d.setOpaque(true);
      e1.setOpaque(true);
      mpb.setOpaque(true);
      add(tf);
      add(b);
      
      add(d);
      add(e1);
      add(pp);
      add(p1);
      add(p4);
      add(button1);
      add(button2);
      add(mpb);
   }

  
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub

   }
   
   @Override
      protected void paintComponent(Graphics g) {
         g.drawImage(pan1,0,0,1920,310, this);
      }

  
}