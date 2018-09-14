package com.sist.project;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import com.sist.common.Function;

import java.util.*;

public class ClientMainForm extends JFrame implements ActionListener, MouseListener{
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
      
      
      
       // 네트워크(전화가 필요)
       Socket s;// 서버 연결
       BufferedReader in;// 서버에서 들어오는 결과값 받기
       OutputStream out; // 서버로 요청값 보내기
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
                     JOptionPane.showMessageDialog(null, "경고 메시지 내용", "경고 메시지 제목", JOptionPane.WARNING_MESSAGE);
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
                     JOptionPane.showMessageDialog(null, "경고 메시지 내용", "경고 메시지 제목", JOptionPane.WARNING_MESSAGE);
                  }
               }
            });

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
               sub.e1.addActionListener(this);
               sbf.서울.addMouseListener(this);
               sbf.강원도.addMouseListener(this);
               sbf.경상도.addMouseListener(this);
               sbf.충청도.addMouseListener(this);
               sbf.전라도.addMouseListener(this);
               sbf.인천.addMouseListener(this);
               sbf.경기도.addMouseListener(this);
               sbf.대전.addMouseListener(this);

               sbf.p6.addMouseListener(this);
               sbf.속초시.addMouseListener(this);
               sbf.강릉시.addMouseListener(this);
               sbf.강남구.addMouseListener(this);
               sbf.마포구.addMouseListener(this);
               sbf.종로구.addMouseListener(this);
               sbf.용산구.addMouseListener(this);
               sbf.성북구.addMouseListener(this);
               sbf.은평구.addMouseListener(this);
               sbf.구로구.addMouseListener(this);
               //===========================================================================================================
               js=new JScrollPane(sbf,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
               
               sbf.setPreferredSize(new Dimension(1920,1080));
               js.setPreferredSize(new Dimension(1920,980));
               js.setBounds(10,15,730,650);
               
               js.setViewportView(sbf);
               //===========================================================================================================sbf전체 스크롤바
               //===========================================================================================================
                js1=new JScrollPane(mp,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
               
               mp.setPreferredSize(new Dimension(1920,1080));
               js1.setPreferredSize(new Dimension(1920,980));
               js1.setBounds(10,15,730,650);
               
               js1.setViewportView(mp);
               //===========================================================================================================mp전체 스크롤바
               
               //===========================================================================================================
               js2=new JScrollPane(sub,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
               
               sub.setPreferredSize(new Dimension(1920,1080));
               js2.setPreferredSize(new Dimension(1920,980));
               js2.setBounds(10,15,730,650);
               
               js2.setViewportView(sub);
               //============================================================================================================sub1전체 스크롤바
               //===========================================================================================================
               js3=new JScrollPane(sub2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
               
               sub2.setPreferredSize(new Dimension(1920,1080));
               js3.setPreferredSize(new Dimension(1920,980));
               js3.setBounds(10,15,730,650);
               
               js3.setViewportView(sub2);
               //===========================================================================================================sub2전체 스크롤바
             //===========================================================================================================
               js4=new JScrollPane(df,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
               
               df.setPreferredSize(new Dimension(1920,1080));
               js4.setPreferredSize(new Dimension(1920,980));
               js4.setBounds(10,15,730,650);
               
               js4.setViewportView(df);
               //===========================================================================================================sub2전체 스크롤바
               add("SBF", js);
         add("LOGIN", login);
         add("MP", js1);
         add("SUB", js2);
         add("SUB2", js3);
         add("DF", js4);
         add("CHAT",chat);
      
         
         setSize(1920, 1080);
          
          


          
          
          setDefaultCloseOperation(EXIT_ON_CLOSE); // application 완전종료
          
          setVisible(true);
          setResizable(false);
      }
      public static void main(String[] args) {
         //ClientMainForm cmf=new ClientMainForm();
         try
            {
                  UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");//신호등
               
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
         if(e.getSource()==login.b1)  // 로그인하면 지도있는 페이지로 넘어감
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
         if(e.getSource()==sub.e1) {
        	 card.show(getContentPane(), "SBF");
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
      @Override
      public void mouseClicked(MouseEvent e) {
         // TODO Auto-generated method stub
        
         if(e.getSource()==sbf.강원도)
         {
            sbf.강원도.setForeground(Color.ORANGE);
           // sbf.p6.setVisible(true);
            
            sbf.속초시.setVisible(true);
            sbf.강릉시.setVisible(true);
            sbf.춘천시.setVisible(true);
            sbf.원주시.setVisible(true);
            sbf.태백시.setVisible(true);
            sbf.동해시.setVisible(true);
            sbf.삼척시.setVisible(true);
            
           if(e.getClickCount()==2)
           {
              sbf.강원도.setForeground(Color.black);
              sbf.속초시.setVisible(false);
               sbf.강릉시.setVisible(false);
               sbf.춘천시.setVisible(false);
               sbf.원주시.setVisible(false);
               sbf.태백시.setVisible(false);
               sbf.동해시.setVisible(false);
               sbf.삼척시.setVisible(false);
           }
         }
         
         else if(e.getSource()==sbf.서울)
         {
           
            sbf.서울.setForeground(Color.ORANGE);
            sbf.p7.setVisible(true);
            
            sbf.강남구.setVisible(true);
            sbf.종로구.setVisible(true);
            sbf.용산구.setVisible(true);
            sbf.성북구.setVisible(true);
            sbf.은평구.setVisible(true);
            sbf.구로구.setVisible(true);
            sbf.마포구.setVisible(true);
            if(e.getClickCount()==2)
            {
               sbf.서울.setForeground(Color.black);
              sbf.강남구.setVisible(false);
              sbf.종로구.setVisible(false);
              sbf.용산구.setVisible(false);
              sbf.성북구.setVisible(false);
              sbf.은평구.setVisible(false);
              sbf.구로구.setVisible(false);
              sbf.마포구.setVisible(false);
            }
         }
         else if(e.getSource()==sbf.경상도)
         {
            sbf.경상도.setForeground(Color.ORANGE);
            sbf.p6.setVisible(true);
            
            sbf.김해시.setVisible(true);
            sbf.진주시.setVisible(true);
            sbf.밀양시.setVisible(true);
            if(e.getClickCount()==2)
            {
               sbf.경상도.setForeground(Color.black);
              sbf.김해시.setVisible(false);
              sbf.진주시.setVisible(false);
              sbf.밀양시.setVisible(false);
            }
         }
         else if(e.getSource()==sbf.충청도)
         { 
            sbf.충청도.setForeground(Color.ORANGE);
            sbf.p7.setVisible(true);
            
            sbf.천안시.setVisible(true);
            sbf.당진시.setVisible(true);
            sbf.공주시.setVisible(true);  
            if(e.getClickCount()==2)
            {
               sbf.충청도.setForeground(Color.black);
              sbf.천안시.setVisible(false);
              sbf.당진시.setVisible(false);
              sbf.공주시.setVisible(false);
            }
         }
         else if(e.getSource()==sbf.전라도)
         {
            sbf.전라도.setForeground(Color.ORANGE);
            sbf.p7.setVisible(true);
            
            sbf.전주시.setVisible(true);
            sbf.익산시.setVisible(true);
            sbf.남원시.setVisible(true);  
            if(e.getClickCount()==2)
            {
               sbf.전라도.setForeground(Color.black);
              sbf.전주시.setVisible(false);
              sbf.익산시.setVisible(false);
              sbf.남원시.setVisible(false);
            }
         }
         else if(e.getSource()==sbf.인천)
         {
            sbf.인천.setForeground(Color.ORANGE);  
            if(e.getClickCount()==2)
            {
               sbf.인천.setForeground(Color.black);
            }
         }
         else if(e.getSource()==sbf.경기도)
         {
            sbf.경기도.setForeground(Color.ORANGE);  
            if(e.getClickCount()==2)
            {
               sbf.경기도.setForeground(Color.black);
            }
         }
         else if(e.getSource()==sbf.대전)
         {
            sbf.대전.setForeground(Color.ORANGE);
            if(e.getClickCount()==2)
            {
               sbf.대전.setForeground(Color.black);
            }
         }

         if(e.getSource()==sbf.속초시)
         {
            card.show(getContentPane(), "SUB");
            sub.pp.setText("속초시");
         }
         if(e.getSource()==sbf.강릉시)
         {
            card.show(getContentPane(), "SUB");
            sub.pp.setText("강릉시");
         }
         if(e.getSource()==sbf.강남구)
         {
            card.show(getContentPane(), "SUB");
            sub.pp.setText("강남구");
         }
         if(e.getSource()==sbf.마포구)
         {
            card.show(getContentPane(), "SUB");
            sub.pp.setText("마포구");
         }

        
      }
      @Override
      public void mousePressed(MouseEvent e) {
         // TODO Auto-generated method stub
         
      }
      @Override
      public void mouseReleased(MouseEvent e) {
         // TODO Auto-generated method stub
         
      }
      @Override
      public void mouseEntered(MouseEvent e) {
         // TODO Auto-generated method stub
         
      }
      @Override
      public void mouseExited(MouseEvent e) {
         // TODO Auto-generated method stub
         
      }
}
















