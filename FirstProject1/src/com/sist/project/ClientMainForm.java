package com.sist.project;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import com.sist.common.Function;
import com.sist.list.CategoryVO;
import com.sist.list.FoodData1;
import com.sist.list.FoodDetail1;
import com.sist.list.FoodHouseVO;

import java.util.*;

public class ClientMainForm extends JFrame implements ActionListener, MouseListener{
      CardLayout card=new CardLayout();
      //ClientMainForm cmf=new ClientMainForm();
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
      
      ArrayList<CategoryVO>tempList=new ArrayList<CategoryVO>();
      
       // 네트워크(전화가 필요)
       Socket s;// 서버 연결
       BufferedReader in;// 서버에서 들어오는 결과값 받기
       OutputStream out; // 서버로 요청값 보내기
       int no=0;
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
               sub.button1.addActionListener(this);
               sub.button2.addActionListener(this);
               
               for(int i=0; i<10; i++) {
            	   sub.p4.sps[i].bu5.addMouseListener(this);
               }
               add("SUB", sub);
		         add("LOGIN", login);
		         
		        
		         add("SBF", sbf);
		         add("MP", mp);
		         
		         add("SUB2", sub2);
		         
		         add("CHAT",chat);
		        
		         add("DF", df);  
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
         
         if(e.getSource()==sub.button1)
			{
				//System.out.println("1");
				if(sub.p4.curpage>1)
				{
					//System.out.println("11111111");
					sub.p4.curpage--;
				    tempList=FoodData1.FoodLocation(no, sub.p4.curpage);
					sub.p4.sub1_p4_print(tempList,sub.p4.curpage);
					
				}
			}
			if(e.getSource()==sub.button2)
			{
				//System.out.println("2222222");
				if(sub.p4.curpage<143)
				{
					sub.p4.curpage++;
					 tempList=FoodData1.FoodLocation(no, sub.p4.curpage);
					sub.p4.sub1_p4_print(tempList,sub.p4.curpage);
						
				}
			}
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
         //if(e.getSource()==sub.p4)
         if(e.getSource()==sbf.속초시)
         {
        	 tempList.clear();
        	 setResizable(true);
        	 ArrayList<CategoryVO> list=FoodData1.FoodLocation(3,1);
        	no=3;
             sub.p4.sub1_p4_print(list, 1);
            card.show(getContentPane(), "SUB");
            sub.pp.setText("속초시");
         }
         if(e.getSource()==sbf.강릉시)
         {
        	 setResizable(true);
        	 tempList.clear();
        	 ArrayList<CategoryVO> list=FoodData1.FoodLocation(4,1);
        	 no=4;
             sub.p4.sub1_p4_print(list, 1);
            card.show(getContentPane(), "SUB");
            sub.pp.setText("강릉시");
         }
         if(e.getSource()==sbf.강남구)
         { 
        	 setResizable(true);
        	 tempList.clear();
        	 ArrayList<CategoryVO> list=FoodData1.FoodLocation(1,1);
        	 no=1;
             sub.p4.sub1_p4_print(list, 1);
        	 card.show(getContentPane(), "SUB");
            sub.pp.setText("강남구");
            
         }
         if(e.getSource()==sbf.마포구)
         {
        	 setResizable(true);
        	 tempList.clear();
        	 ArrayList<CategoryVO> list=FoodData1.FoodLocation(2,1);
        	 no=2;
             sub.p4.sub1_p4_print(list, 1);
            card.show(getContentPane(), "SUB");
            sub.pp.setText("마포구");
         }
         
         
         for(int i=0; i<10; i++) {
        	 if(e.getSource()==sub.p4.sps[i].bu5)
             {
        		
        		 //card.show(getContentPane(), "DF");
            	 //System.out.println(sub.p4.sps[i].la1.getText());
            	 /*FoodHouseVO vo=FoodDetail1.FoodDetail(sub.p4.sps[i].la1.getText()+sub.p4.sps[i].la2.getText()+sub.p4.sps[i].la3.getText()
            			 																				+sub.p4.sps[i].la4.getText());*/
            	 //System.out.println(vo.getTitle()+vo.getKind());
            	 //JOptionPane.showMessageDialog(this, "업체명:"+vo.getTitle()+"\n주소:"+vo.getAddr());
        		 FoodHouseVO vo=FoodDetail1.FoodDetail(sub.p4.sps[i].la1.getText());
        		 /*System.out.println(sub.p4.sps[i].la1.getText()+sub.p4.sps[i].la2.getText()+sub.p4.sps[i].la3.getText()
            			 																				+sub.p4.sps[i].la4.getText());*/
        		
        		 
        		/* df.p2.la.setText(vo.getPoster());
        		 df.p2.la1.setText(vo.getTitle());
        		 df.p2.la2.setText(vo.getAddr());
        		 df.p2.la3.setText(vo.getPrice());
        		 df.p2.la4.setText(vo.getKind());*/
        		 df.p2.sub_print(vo);
        		 
        		 card.show(getContentPane(), "DF");
             }
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
















