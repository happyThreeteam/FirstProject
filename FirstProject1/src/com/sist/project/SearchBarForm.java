package com.sist.project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SearchBarForm extends JPanel {
   CardLayout card=new CardLayout();
   JPanel p1=new JPanel();
   //JPanel p2=new JPanel();
   JPanel p3=new JPanel();
   JPanel p4=new JPanel();
   JPanel p5=new JPanel();
   JPanel p6=new JPanel(); // ������ ���λ���
   JPanel p7=new JPanel(); // ����� ���λ���
   
   JButton b;
   public JButton mpb;
   public JButton chat;
   JTextField tf;
   JLabel title;
   JLabel la;
   
   JLabel ����, ������, ��⵵, ��õ, ��û��, ����, ���, ����;
   JLabel ������, ������, ���α� , ��걸, ���ϱ�, ����, ���α�;
   JLabel ���ʽ�, ������, ��õ��, ���ֽ�, �¹��, ���ؽ�, ��ô��;
   JLabel ���ؽ�, ���ֽ�, �о��;
   JLabel õ�Ƚ�, ������, ���ֽ�;
   JLabel ���ֽ�, �ͻ��, ������;
   
   public SearchBarForm() {
      p1.setBackground(Color.blue); 
      //p2.setBackground(Color.white);
      /*p3.setBackground(Color.RED);
      p4.setBackground(Color.orange);*/
      p5.setBackground(Color.green);
      //p6.setBackground(Color.GRAY);
      
        // �ΰ� 
         title=new JLabel("GOOD TASTE");
         // �˻�â 
         tf = new JTextField();
         // �˻� ��ư
         b = new JButton("�˻�");
         // ���������� ��ư
         mpb = new JButton("����������");
         chat=new JButton("ä��â");
         
         ����=new JLabel("����");
         ��õ=new JLabel("��õ");
         ��⵵=new JLabel("��⵵");
         ������=new JLabel("������");
         ��û��=new JLabel("��û��");
         ����=new JLabel("����");
         ����=new JLabel("����");
         ���=new JLabel("���");
         
         // ����
         ������=new JLabel("������");
         ������=new JLabel("������");
         ���α�=new JLabel("���α�");
         ��걸=new JLabel("��걸");
         ���ϱ�=new JLabel("���ϱ�");
         ����=new JLabel("����");
         ���α�=new JLabel("���α�");
         
         // ������
         ���ʽ�=new JLabel("���ʽ�");
         ������=new JLabel("������");
         ��õ��=new JLabel("��õ��");
         ���ֽ�=new JLabel("���ֽ�");
        �¹��=new JLabel("�¹��");
        ���ؽ�=new JLabel("���ؽ�");
        ��ô��=new JLabel("��ô��");
        
        // ���
        ���ؽ�=new JLabel("���ؽ�");
         ���ֽ�=new JLabel("���ֽ�");
         �о��=new JLabel("�о��");

         // ��û��
         õ�Ƚ�=new JLabel("õ�Ƚ�");
         ������=new JLabel("������");
         ���ֽ�=new JLabel("���ֽ�");
         
         // ����
         ���ֽ�=new JLabel("���ֽ�");
         �ͻ��=new JLabel("�ͻ��");
         ������=new JLabel("������");

      setLayout(null);
      
      //map=Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\map.png");
      la=new JLabel(new ImageIcon("C:\\javaDev\\map.png"));
      p1.setBounds(0,0,1920,310);
      la.setBounds(150,310,1620,640);
      p5.setBounds(0,950,1920,250);
      
      p6.setBounds(1320, 310, 600, 640);
      p7.setBounds(0, 310, 600, 640);
      
      tf.setBounds(540,250,800,35);
      b.setBounds(1345,242,50,50);
      
      mpb.setBounds(1670,10,100,40);
      chat.setBounds(1780,10,100,40);
      
      title.setForeground(Color.ORANGE);
      title.setBounds(765, 10, 350, 200);
      title.setFont(new Font("Rockwell Extra Bold",Font.BOLD,40));
      
      ������.setBounds(1025, 55, 70, 70);
      ������.setFont(new Font("�������",Font.BOLD,20));
      
      ����.setBounds(1025, 103, 70, 70);
      ����.setFont(new Font("�������",Font.BOLD,20));
      
      ��⵵.setBounds(1095, 151, 70, 70);
      ��⵵.setFont(new Font("�������",Font.BOLD,20));
      
      ����.setBounds(1060, 240, 70, 70);
      ����.setFont(new Font("�������",Font.BOLD,20));
      
      ���.setBounds(1100, 305, 70, 70);
      ���.setFont(new Font("�������",Font.BOLD,20));
      
      ��õ.setBounds(490, 103, 70, 70);
      ��õ.setFont(new Font("�������",Font.BOLD,20));
      
      ��û��.setBounds(470, 200, 70, 70);
      ��û��.setFont(new Font("�������",Font.BOLD,20));
      
      ����.setBounds(470, 400, 70, 70);
      ����.setFont(new Font("�������",Font.BOLD,20));
      
      // ����
      ������.setBounds(100, 630, 70, 70);
      ������.setFont(new Font("�������",Font.BOLD,20));
      
      ���α�.setBounds(230, 320, 70, 70);
      ���α�.setFont(new Font("�������",Font.BOLD,20));
      
      ��걸.setBounds(500, 460, 70, 70);
      ��걸.setFont(new Font("�������",Font.BOLD,20));
      
      ���ϱ�.setBounds(400, 490, 70, 70);
      ���ϱ�.setFont(new Font("�������",Font.BOLD,20));
      
      ����.setBounds(10, 610, 70, 70);
      ����.setFont(new Font("�������",Font.BOLD,20));
      
      ���α�.setBounds(440,800, 70, 70);
      ���α�.setFont(new Font("�������",Font.BOLD,20));
      
      ������.setBounds(200,900,70,70);
      ������.setFont(new Font("�������",Font.BOLD,20));
      
      // ������ 
      ���ʽ�.setBounds(1350,310,70,70);
      ���ʽ�.setFont(new Font("�������",Font.BOLD,20));
      
      ������.setBounds(1800,430,70,70);
      ������.setFont(new Font("�������", Font.BOLD,20));
      
      ��õ��.setBounds(1480,530,70,70);
      ��õ��.setFont(new Font("�������",Font.BOLD,20));
      
      ���ֽ�.setBounds(1900,730,70,70);
      ���ֽ�.setFont(new Font("�������",Font.BOLD,20));
      
      �¹��.setBounds(1700,630,70,70);
      �¹��.setFont(new Font("�������",Font.BOLD,20));
      
      ���ؽ�.setBounds(1570,690,70,70);
      ���ؽ�.setFont(new Font("�������",Font.BOLD,20));
      
      ��ô��.setBounds(1500,850,70,70);
      ��ô��.setFont(new Font("�������",Font.BOLD,20));
      
      // ���
      ���ؽ�.setBounds(1410,390,70,70);
      ���ؽ�.setFont(new Font("�������",Font.BOLD,20));
      
      ���ֽ�.setBounds(1630,490,70,70);
      ���ֽ�.setFont(new Font("�������",Font.BOLD,20));
      
      �о��.setBounds(1680,810,70,70);
      �о��.setFont(new Font("�������",Font.BOLD,20));

      // ��û��
      õ�Ƚ�.setBounds(430, 320, 70, 70);
      õ�Ƚ�.setFont(new Font("�������",Font.BOLD,20));
      ������.setBounds(150, 450, 70, 70);
      ������.setFont(new Font("�������",Font.BOLD,20));
      ���ֽ�.setBounds(500, 580, 70, 70);
      ���ֽ�.setFont(new Font("�������",Font.BOLD,20));
      
      // ����
      ���ֽ�.setBounds(400, 540, 70, 70);
      ���ֽ�.setFont(new Font("�������",Font.BOLD,20));
      �ͻ��.setBounds(50, 830, 70, 70);
      �ͻ��.setFont(new Font("�������",Font.BOLD,20));
      ������.setBounds(200,650,70,70);
      ������.setFont(new Font("�������",Font.BOLD,20));

      
      add(chat);
      add(title);
      add(tf);
      add(b);
      add(mpb);
      add(p1);
      add(p3);
      add(p4);
      add(p5);
      add(la);
      add(p7);
      add(p6);
      
      p6.add(���ʽ�);
      p6.add(������); 
      p6.add(��õ��);
      p6.add(���ֽ�);
      p6.add(�¹��);
      p6.add(���ؽ�);
      p6.add(��ô��); 
      
      p7.add(������);
      p7.add(���α�);
      p7.add(��걸);
      p7.add(���ϱ�);
      p7.add(����);
      p7.add(���α�);
      p7.add(������);
      
      p7.add(õ�Ƚ�);
      p7.add(������);
      p7.add(���ֽ�);
      
      p7.add(���ֽ�);
      p7.add(�ͻ��);
      p7.add(������);
      
      p6.add(���ؽ�);
      p6.add(���ֽ�);
      p6.add(�о��);
      
      la.add(����);
      la.add(��⵵);
      la.add(������);
      la.add(��õ);
      la.add(��û��);
      la.add(����);
      la.add(���);
      la.add(����);
      
     
      add(���ʽ�);
      add(������); 
      add(��õ��);
      add(���ֽ�);
      add(�¹��);
      add(���ؽ�);
      add(��ô��);
      
      add(������);
      add(���α�);
      add(��걸);
      add(���ϱ�);
      add(����);
      add(���α�);
      add(������);

      add(���ؽ�);
      add(���ֽ�);
      add(�о��);
      
      add(õ�Ƚ�);
      add(������);
      add(���ֽ�);
      add(���ֽ�);
      add(�ͻ��);
      add(������);
      
      add(p6);
      add(p7);
      p7.setVisible(false);
      p6.setVisible(false);
      ���ʽ�.setVisible(false);
      ������.setVisible(false);
      ��õ��.setVisible(false);
      ���ֽ�.setVisible(false);
      �¹��.setVisible(false);
      ���ؽ�.setVisible(false);
      ��ô��.setVisible(false);
      ������.setVisible(false);
      ������.setVisible(false);
      ���α�.setVisible(false);
      ��걸.setVisible(false);
      ���ϱ�.setVisible(false);
      ����.setVisible(false);
      ���α�.setVisible(false);

      ���ؽ�.setVisible(false);
      ���ֽ�.setVisible(false);
      �о��.setVisible(false);
      õ�Ƚ�.setVisible(false);
      ������.setVisible(false);
      ���ֽ�.setVisible(false);
      ���ֽ�.setVisible(false);
      �ͻ��.setVisible(false);
      ������.setVisible(false);
   }
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
   }
   /*@Override
   protected void paintComponent(Graphics g) {
      g.drawImage(map,0,310,810,520, this);
   }*/
}
