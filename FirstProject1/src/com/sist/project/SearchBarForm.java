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
   JPanel p6=new JPanel(); // 강원도 세부사항
   JPanel p7=new JPanel(); // 서울시 세부사항
   
   JButton b;
   public JButton mpb;
   public JButton chat;
   JTextField tf;
   JLabel title;
   JLabel la;
   
   JLabel 서울, 강원도, 경기도, 인천, 충청도, 전라도, 경상도, 대전;
   JLabel 마포구, 강남구, 종로구 , 용산구, 성북구, 은평구, 구로구;
   JLabel 속초시, 강릉시, 춘천시, 원주시, 태백시, 동해시, 삼척시;
   JLabel 김해시, 진주시, 밀양시;
   JLabel 천안시, 당진시, 공주시;
   JLabel 전주시, 익산시, 남원시;
   
   public SearchBarForm() {
      p1.setBackground(Color.blue); 
      //p2.setBackground(Color.white);
      /*p3.setBackground(Color.RED);
      p4.setBackground(Color.orange);*/
      p5.setBackground(Color.green);
      //p6.setBackground(Color.GRAY);
      
        // 로고 
         title=new JLabel("GOOD TASTE");
         // 검색창 
         tf = new JTextField();
         // 검색 버튼
         b = new JButton("검색");
         // 마이페이지 버튼
         mpb = new JButton("마이페이지");
         chat=new JButton("채팅창");
         
         서울=new JLabel("서울");
         인천=new JLabel("인천");
         경기도=new JLabel("경기도");
         강원도=new JLabel("강원도");
         충청도=new JLabel("충청도");
         대전=new JLabel("대전");
         전라도=new JLabel("전라도");
         경상도=new JLabel("경상도");
         
         // 서울
         마포구=new JLabel("마포구");
         강남구=new JLabel("강남구");
         종로구=new JLabel("종로구");
         용산구=new JLabel("용산구");
         성북구=new JLabel("성북구");
         은평구=new JLabel("은평구");
         구로구=new JLabel("구로구");
         
         // 강원도
         속초시=new JLabel("속초시");
         강릉시=new JLabel("강릉시");
         춘천시=new JLabel("춘천시");
         원주시=new JLabel("원주시");
        태백시=new JLabel("태백시");
        동해시=new JLabel("동해시");
        삼척시=new JLabel("삼척시");
        
        // 경상도
        김해시=new JLabel("김해시");
         진주시=new JLabel("진주시");
         밀양시=new JLabel("밀양시");

         // 충청도
         천안시=new JLabel("천안시");
         당진시=new JLabel("당진시");
         공주시=new JLabel("공주시");
         
         // 전라도
         전주시=new JLabel("전주시");
         익산시=new JLabel("익산시");
         남원시=new JLabel("남원시");

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
      
      강원도.setBounds(1025, 55, 70, 70);
      강원도.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      서울.setBounds(1025, 103, 70, 70);
      서울.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      경기도.setBounds(1095, 151, 70, 70);
      경기도.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      대전.setBounds(1060, 240, 70, 70);
      대전.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      경상도.setBounds(1100, 305, 70, 70);
      경상도.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      인천.setBounds(490, 103, 70, 70);
      인천.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      충청도.setBounds(470, 200, 70, 70);
      충청도.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      전라도.setBounds(470, 400, 70, 70);
      전라도.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      // 서울
      강남구.setBounds(100, 630, 70, 70);
      강남구.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      종로구.setBounds(230, 320, 70, 70);
      종로구.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      용산구.setBounds(500, 460, 70, 70);
      용산구.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      성북구.setBounds(400, 490, 70, 70);
      성북구.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      은평구.setBounds(10, 610, 70, 70);
      은평구.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      구로구.setBounds(440,800, 70, 70);
      구로구.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      마포구.setBounds(200,900,70,70);
      마포구.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      // 강원도 
      속초시.setBounds(1350,310,70,70);
      속초시.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      강릉시.setBounds(1800,430,70,70);
      강릉시.setFont(new Font("맑은고딕", Font.BOLD,20));
      
      춘천시.setBounds(1480,530,70,70);
      춘천시.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      원주시.setBounds(1900,730,70,70);
      원주시.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      태백시.setBounds(1700,630,70,70);
      태백시.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      동해시.setBounds(1570,690,70,70);
      동해시.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      삼척시.setBounds(1500,850,70,70);
      삼척시.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      // 경상도
      김해시.setBounds(1410,390,70,70);
      김해시.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      진주시.setBounds(1630,490,70,70);
      진주시.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      밀양시.setBounds(1680,810,70,70);
      밀양시.setFont(new Font("맑은고딕",Font.BOLD,20));

      // 충청도
      천안시.setBounds(430, 320, 70, 70);
      천안시.setFont(new Font("맑은고딕",Font.BOLD,20));
      당진시.setBounds(150, 450, 70, 70);
      당진시.setFont(new Font("맑은고딕",Font.BOLD,20));
      공주시.setBounds(500, 580, 70, 70);
      공주시.setFont(new Font("맑은고딕",Font.BOLD,20));
      
      // 전라도
      전주시.setBounds(400, 540, 70, 70);
      전주시.setFont(new Font("맑은고딕",Font.BOLD,20));
      익산시.setBounds(50, 830, 70, 70);
      익산시.setFont(new Font("맑은고딕",Font.BOLD,20));
      남원시.setBounds(200,650,70,70);
      남원시.setFont(new Font("맑은고딕",Font.BOLD,20));

      
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
      
      p6.add(속초시);
      p6.add(강릉시); 
      p6.add(춘천시);
      p6.add(원주시);
      p6.add(태백시);
      p6.add(동해시);
      p6.add(삼척시); 
      
      p7.add(강남구);
      p7.add(종로구);
      p7.add(용산구);
      p7.add(성북구);
      p7.add(은평구);
      p7.add(구로구);
      p7.add(마포구);
      
      p7.add(천안시);
      p7.add(당진시);
      p7.add(공주시);
      
      p7.add(전주시);
      p7.add(익산시);
      p7.add(남원시);
      
      p6.add(김해시);
      p6.add(진주시);
      p6.add(밀양시);
      
      la.add(서울);
      la.add(경기도);
      la.add(강원도);
      la.add(인천);
      la.add(충청도);
      la.add(전라도);
      la.add(경상도);
      la.add(대전);
      
     
      add(속초시);
      add(강릉시); 
      add(춘천시);
      add(원주시);
      add(태백시);
      add(동해시);
      add(삼척시);
      
      add(강남구);
      add(종로구);
      add(용산구);
      add(성북구);
      add(은평구);
      add(구로구);
      add(마포구);

      add(김해시);
      add(진주시);
      add(밀양시);
      
      add(천안시);
      add(당진시);
      add(공주시);
      add(전주시);
      add(익산시);
      add(남원시);
      
      add(p6);
      add(p7);
      p7.setVisible(false);
      p6.setVisible(false);
      속초시.setVisible(false);
      강릉시.setVisible(false);
      춘천시.setVisible(false);
      원주시.setVisible(false);
      태백시.setVisible(false);
      동해시.setVisible(false);
      삼척시.setVisible(false);
      마포구.setVisible(false);
      강남구.setVisible(false);
      종로구.setVisible(false);
      용산구.setVisible(false);
      성북구.setVisible(false);
      은평구.setVisible(false);
      구로구.setVisible(false);

      김해시.setVisible(false);
      진주시.setVisible(false);
      밀양시.setVisible(false);
      천안시.setVisible(false);
      당진시.setVisible(false);
      공주시.setVisible(false);
      전주시.setVisible(false);
      익산시.setVisible(false);
      남원시.setVisible(false);
   }
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
   }
   /*@Override
   protected void paintComponent(Graphics g) {
      g.drawImage(map,0,310,810,520, this);
   }*/
}
