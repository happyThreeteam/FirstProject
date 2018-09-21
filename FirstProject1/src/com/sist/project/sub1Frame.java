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
   JComboBox cb;
   JComboBox cb2;
   
   JButton button1=new JButton("이전");
   JButton button2=new JButton("다음");
   
   Image pan1;
   
   JLabel la; //null 값
    
   
   
  JTextField pp=new JTextField(); // 지도에서 받아오는 지역 이름입니다
   
   String 업종[]= {"업종 선택","중식", "한식", "일식","양식"};
   String 가격[] = {"가격 선택","~5천", "5천~1만", "1만~2만", "2만~3만", "3만~4만", "4만~5만","5만~"};
   
   
   public sub1Frame(){
      pp.setEditable(false);
      
      tf = new JTextField();   
       b = new JButton("검색");
       d = new JButton("검색");
       e1 = new JButton("이전");
      

      cb=new JComboBox(업종);
      cb2=new JComboBox(가격);
      
      
   /*   cb.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            JComboBox jcb=(JComboBox)e.getSource();
            int index=jcb.getSelectedIndex();
            if(index==0 && e.getSource()== d ) {
               JOptionPane.showMessageDialog(null, "경고 메시지 내용", "경고 메시지 제목", JOptionPane.WARNING_MESSAGE);
            }
         }
      });
      cb2.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            JComboBox jcb=(JComboBox)e.getSource();
            int index=jcb.getSelectedIndex();
            if(index==0 && e.getSource()== d ) {
               JOptionPane.showMessageDialog(null, "경고 메시지 내용", "경고 메시지 제목", JOptionPane.WARNING_MESSAGE);
            }
         }
      });*/
      
	     
      setLayout(null);
      
      p1.setBounds(0, 310, 1920, 60);
      
      tf.setBounds(540,250,800,35);
      b.setBounds(1345,242,50,50);
      
      d.setBounds(1065, 315, 50 ,50);
      p4.setBounds(0, 350, 1920, 620);
      
      e1.setBounds(1405, 242, 50, 50);
      cb.setBounds(860, 327, 100, 20);
      cb2.setBounds(960, 327, 100, 20);
      pp.setBounds(760, 327, 100, 20);
      
      button1.setBounds(860,  980, 70 ,  50);
      button2.setBounds(960,  980, 70 ,  50);
      button1.setOpaque(true);
      button2.setOpaque(true);
      add(cb);
      add(cb2);
      add(tf);
      add(b);
      
      add(d);
      add(e1);
      add(pp);
      add(p1);
      add(p4);
      add(button1);
      add(button2);
      
   }

  
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub

   }
   
   @Override
      protected void paintComponent(Graphics g) {
         g.drawImage(pan1,0,0,1920,310, this);
      }

  
}