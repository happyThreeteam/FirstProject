package com.sist.project;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.security.cert.PKIXRevocationChecker.Option;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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
      
       // ��Ʈ��ũ(��ȭ�� �ʿ�)
       Socket s;// ���� ����
       BufferedReader in;// �������� ������ ����� �ޱ�
       OutputStream out; // ������ ��û�� ������
       int no=0;
      public ClientMainForm()  
      {
         setLayout(card);
         
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
               sbf.����.addMouseListener(this);
               sbf.������.addMouseListener(this);
               sbf.���.addMouseListener(this);
               sbf.��û��.addMouseListener(this);
               sbf.����.addMouseListener(this);
               sbf.��õ.addMouseListener(this);
               sbf.��⵵.addMouseListener(this);
               sbf.����.addMouseListener(this);

               sbf.p6.addMouseListener(this);
               sbf.���ʽ�.addMouseListener(this);
               sbf.������.addMouseListener(this);
               sbf.������.addMouseListener(this);
               sbf.������.addMouseListener(this);
               sbf.���α�.addMouseListener(this);
               sbf.��걸.addMouseListener(this);
               sbf.���ϱ�.addMouseListener(this);
               sbf.����.addMouseListener(this);
               sbf.���α�.addMouseListener(this);
               sub.button1.addActionListener(this);
               sub.button2.addActionListener(this);
               mp.ch.addActionListener(this);
               df.mpb.addActionListener(this);
               sub.mpb.addActionListener(this);
               sub2.mpb.addActionListener(this);
               for(int i=0; i<10; i++) {
            	   sub.p4.sps[i].bu5.addMouseListener(this);
               }
              
		         add("LOGIN", login);
		         
		         add("SUB", sub);
		         add("SBF", sbf);
		         add("MP", mp);
		        
		         add("SUB2", sub2);
		         add("DF", df);  
		         add("CHAT",chat);
		        
		         setSize(1920, 1080);
          
          setDefaultCloseOperation(EXIT_ON_CLOSE); // application ��������
          
          setVisible(true);
          setResizable(false);
      }
      public static void main(String[] args) {
         //ClientMainForm cmf=new ClientMainForm();
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
        	 if(login.tf.getText().isEmpty())
        	 {
        		 JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���.", "���̵� ����", JOptionPane.WARNING_MESSAGE);
        	 }
        	 else if(login.pf.getText().isEmpty())
        	 {
        		 JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է����ּ���.", "��й�ȣ ����", JOptionPane.WARNING_MESSAGE);
        	 }
        	 else
        	 {
        		 int input=JOptionPane.showConfirmDialog(null, "�α����Ͻðڽ��ϱ�?",null,JOptionPane.OK_OPTION);
        		 if(input==0)
        		 {
        			 card.show(getContentPane(), "SBF");
        		 }
        		 if(input==1)
        		 {
        			 card.show(getContentPane(), "LOGIN");
        		 }
        	 }
            
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
         
         if(e.getSource()==mp.ch)
         {
        	 card.show(getContentPane(), "LOGIN");
        	 login.tf.setText(mp.id_answer.getText());
        	 login.pf.setText(null);
         }
         
         if(e.getSource()==login.b2)  // �α��ο��� ��� ������ ���
         {
            System.exit(0);
         }
         if(e.getSource()==sbf.mpb) // ��ġ����(����)���� ���������� ��ư Ŭ����
         {
            card.show(getContentPane(), "MP");
         }
         
         if(e.getSource()==df.mpb)
         {
        	 card.show(getContentPane(), "MP");
         }
         if(e.getSource()==sub.mpb)
         {
        	 card.show(getContentPane(), "MP");
         }
         if(e.getSource()==sub2.mpb)
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
            card.show(getContentPane(), "SUB2");
         }
         if(e.getSource()==sub.e1) {
        	 card.show(getContentPane(), "SBF");
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
            setResizable(true);
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
         
         
         
         
         if(e.getSource()==sub.button1)
			{
				if(sub.p4.curpage>1)
				{
					sub.p4.curpage--;
				    tempList=FoodData1.FoodLocation(no, sub.p4.curpage);
					sub.p4.sub1_p4_print(tempList,sub.p4.curpage);
					
				}
			}
			if(e.getSource()==sub.button2)
			{
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
        
         if(e.getSource()==sbf.������)
         {
            sbf.������.setForeground(Color.ORANGE);
           // sbf.p6.setVisible(true);
            
            sbf.���ʽ�.setVisible(true);
            sbf.������.setVisible(true);
            sbf.��õ��.setVisible(true);
            sbf.���ֽ�.setVisible(true);
            sbf.�¹��.setVisible(true);
            sbf.���ؽ�.setVisible(true);
            sbf.��ô��.setVisible(true);
            
           if(e.getClickCount()==2)
           {
              sbf.������.setForeground(Color.black);
              sbf.���ʽ�.setVisible(false);
               sbf.������.setVisible(false);
               sbf.��õ��.setVisible(false);
               sbf.���ֽ�.setVisible(false);
               sbf.�¹��.setVisible(false);
               sbf.���ؽ�.setVisible(false);
               sbf.��ô��.setVisible(false);
           }
         }
         
         else if(e.getSource()==sbf.����)
         {
           
            sbf.����.setForeground(Color.ORANGE);
            sbf.p7.setVisible(true);
            
            sbf.������.setVisible(true);
            sbf.���α�.setVisible(true);
            sbf.��걸.setVisible(true);
            sbf.���ϱ�.setVisible(true);
            sbf.����.setVisible(true);
            sbf.���α�.setVisible(true);
            sbf.������.setVisible(true);
            if(e.getClickCount()==2)
            {
               sbf.����.setForeground(Color.black);
              sbf.������.setVisible(false);
              sbf.���α�.setVisible(false);
              sbf.��걸.setVisible(false);
              sbf.���ϱ�.setVisible(false);
              sbf.����.setVisible(false);
              sbf.���α�.setVisible(false);
              sbf.������.setVisible(false);
            }
         }
         else if(e.getSource()==sbf.���)
         {
            sbf.���.setForeground(Color.ORANGE);
            sbf.p6.setVisible(true);
            
            sbf.���ؽ�.setVisible(true);
            sbf.���ֽ�.setVisible(true);
            sbf.�о��.setVisible(true);
            if(e.getClickCount()==2)
            {
               sbf.���.setForeground(Color.black);
              sbf.���ؽ�.setVisible(false);
              sbf.���ֽ�.setVisible(false);
              sbf.�о��.setVisible(false);
            }
         }
         else if(e.getSource()==sbf.��û��)
         { 
            sbf.��û��.setForeground(Color.ORANGE);
            sbf.p7.setVisible(true);
            
            sbf.õ�Ƚ�.setVisible(true);
            sbf.������.setVisible(true);
            sbf.���ֽ�.setVisible(true);  
            if(e.getClickCount()==2)
            {
               sbf.��û��.setForeground(Color.black);
              sbf.õ�Ƚ�.setVisible(false);
              sbf.������.setVisible(false);
              sbf.���ֽ�.setVisible(false);
            }
         }
         else if(e.getSource()==sbf.����)
         {
            sbf.����.setForeground(Color.ORANGE);
            sbf.p7.setVisible(true);
            
            sbf.���ֽ�.setVisible(true);
            sbf.�ͻ��.setVisible(true);
            sbf.������.setVisible(true);  
            if(e.getClickCount()==2)
            {
               sbf.����.setForeground(Color.black);
              sbf.���ֽ�.setVisible(false);
              sbf.�ͻ��.setVisible(false);
              sbf.������.setVisible(false);
            }
         }
         else if(e.getSource()==sbf.��õ)
         {
            sbf.��õ.setForeground(Color.ORANGE);  
            if(e.getClickCount()==2)
            {
               sbf.��õ.setForeground(Color.black);
            }
         }
         else if(e.getSource()==sbf.��⵵)
         {
            sbf.��⵵.setForeground(Color.ORANGE);  
            if(e.getClickCount()==2)
            {
               sbf.��⵵.setForeground(Color.black);
            }
         }
         else if(e.getSource()==sbf.����)
         {
            sbf.����.setForeground(Color.ORANGE);
            if(e.getClickCount()==2)
            {
               sbf.����.setForeground(Color.black);
            }
         }
         //if(e.getSource()==sub.p4)
         if(e.getSource()==sbf.���ʽ�)
         {
        	 tempList.clear();
        	 setResizable(true);
        	 ArrayList<CategoryVO> list=FoodData1.FoodLocation(3,1);
        	no=3;
             sub.p4.sub1_p4_print(list, 1);
            card.show(getContentPane(), "SUB");
            sub.pp.setText("���ʽ�");
         }
         if(e.getSource()==sbf.������)
         {
        	 setResizable(true);
        	 tempList.clear();
        	 ArrayList<CategoryVO> list=FoodData1.FoodLocation(4,1);
        	 no=4;
             sub.p4.sub1_p4_print(list, 1);
            card.show(getContentPane(), "SUB");
            sub.pp.setText("������");
         }
         if(e.getSource()==sbf.������)
         { 
        	 setResizable(true);
        	 tempList.clear();
        	 ArrayList<CategoryVO> list=FoodData1.FoodLocation(1,1);
        	 no=1;
             sub.p4.sub1_p4_print(list, 1);
        	 card.show(getContentPane(), "SUB");
            sub.pp.setText("������");
            
         }
         if(e.getSource()==sbf.������)
         {
        	 setResizable(true);
        	 tempList.clear();
        	 ArrayList<CategoryVO> list=FoodData1.FoodLocation(2,1);
        	 no=2;
             sub.p4.sub1_p4_print(list, 1);
            card.show(getContentPane(), "SUB");
            sub.pp.setText("������");
         }
         
         
         for(int i=0; i<10; i++) {
        	 if(e.getSource()==sub.p4.sps[i].bu5)
             {
        		 FoodHouseVO vo=FoodDetail1.FoodDetail(sub.p4.sps[i].la1.getText());
        		 df.p2.sub_print(vo);
        		 card.show(getContentPane(), "DF");
        		 mp.la.setText(vo.getTitle());
        		 try {
		        		URL url=new URL(vo.getPoster());
		         		Image img=getImageSizeChange(new ImageIcon(url), 400, 350);
		         		mp.la2.setIcon(new ImageIcon(img));
        		 }catch(Exception ex) {}
        		 
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
      public Image getImageSizeChange(ImageIcon icon,int width,int height)
	    {
	    	Image img=icon.getImage();
	    	Image change=img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    	return change;
	    }
}
















