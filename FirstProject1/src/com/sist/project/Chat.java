package com.sist.project;

import java.awt.*;

import javax.swing.*;

public class Chat extends JPanel{
   
   JLabel title;
   JLabel title1;
   JPanel p1=new JPanel();
   JTextArea ta=new JTextArea();
   JScrollPane js=new JScrollPane(ta);
   JTextField tf=new JTextField();
   JPanel p2=new JPanel();
   JPanel p=new JPanel();
   JButton back=new JButton("¿Ã¿¸");
   
   Chat()
   {
      setLayout(null);
      
      title=new JLabel("GOOD TASTE");
      title.setForeground(Color.ORANGE);
      title.setBounds(765, 10, 400, 200);
      title.setFont(new Font("Rockwell Extra Bold",Font.BOLD,50));
       
       title1=new JLabel("CHATING");
       title1.setBounds(50, 130, 350, 200);
       title1.setFont(new Font("Rockwell Extra Bold",Font.BOLD,30));
       
      
      //p1.setBackground(Color.pink);
      //ta.setBackground(Color.blue);
      
      p1.setBounds(0, 0, 1920, 250);
      
      js.setBounds(100,280,900,700);
      tf.setBounds(100, 985,900,40);
      
      p2.setBounds(1050,280,770, 600);
      back.setBounds(1050,900, 80, 40);
      
      back.setFont(new Font("∏º¿∫ ∞ÌµÒ",Font.BOLD,20));
      
      p.setBounds(0, 0 ,1920, 1080);
      p.setBackground(Color.PINK);
      
      
      
       add(title);
       add(title1);
       add(p1);
      add(js);
      add(tf);
      add(p2);
      add(back);
      add(p);

   }
}