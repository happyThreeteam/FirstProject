package com.sist.project;

import javax.swing.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.list.FoodHouseVO;

import java.awt.event.*;
import java.awt.*;

public class DetailForm extends JPanel{

	   JPanel p1=new JPanel(); 
	   DetailForm_p2_small p2=new DetailForm_p2_small();
	   JPanel p3=new JPanel();
	   JPanel p4=new JPanel();
	   
	   JLabel title;
	   JTextField tf;
	   JButton b; 
	   JButton back;
        
     public DetailForm(){

       p1.setBackground(Color.BLUE);
       //p2.setBackground(Color.orange);
       p3.setBackground(Color.PINK);
       p4.setBackground(Color.lightGray);
       
       title=new JLabel("Good Taste");
       
       b=new JButton("검색");
       back=new JButton("이전");       
       tf=new JTextField();
       
       setLayout(null);
      
       title.setForeground(Color.orange);
       
       
       p1.setBounds(0, 0, 1920, 310);
       p2.setBounds(0, 315, 1400, 650);
       p3.setBounds(1405, 315, 705, 380);
       p4.setBounds(1405, 700, 705, 265);
       
       tf.setBounds(540,250,800,35);
      b.setBounds(1345,242,50,50);
       back.setBounds(1400, 242, 50, 50);
      title.setForeground(Color.ORANGE);
      title.setBounds(765, 10, 350, 200);
      title.setFont(new Font("Rockwell Extra Bold",Font.BOLD,40));
      
      add(title);
      add(tf);
       add(b);
      add(p1);
       add(p2);
       add(p3);
       add(p4);
       add(back);
      
     }
    
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub

   }

}