package com.sist.project;
import javax.swing.*;
import java.awt.*; // Image
import java.awt.color.*;
import java.awt.event.ActionEvent;
public class Login extends JPanel {
	Image back;
	JLabel title;
	JLabel la1, la2;
	JRadioButton man;
	JRadioButton woman;
	
	JTextField tf; 
	JPasswordField pf;
	JButton b1,b2;
	Login()  
	{ 
		back=Toolkit.getDefaultToolkit().getImage("C:\\javaDev\\icecream.jpg");
		
		// ��ġ 
		la1=new JLabel("���̵�");
		la2=new JLabel("��й�ȣ");
		man= new JRadioButton("����");
		woman= new JRadioButton("����");
		ButtonGroup mw=new ButtonGroup();
		mw.add(man);
		mw.add(woman);
		
		title=new JLabel("GOOD TASTE");
		
		tf=new JTextField();
		pf=new JPasswordField();
		
		b1=new JButton("�α���");
		b2=new JButton("���");
		
		// ��ġ
		setLayout(null); //��ġ�� ������� �ʰ� ���� ��ġ
		//la1.setForeground(Color.white);
		// 800/2 ==> 400-20 ==> 380
		// 600/2 ==> 300-30 ==> 270
		
		//la2.setForeground(Color.white);
		
		
		la1.setFont(new Font("���� ���",Font.BOLD,20));
		la2.setFont(new Font("���� ���",Font.BOLD,20));
		
		title.setForeground(Color.BLACK);
		title.setBounds(50,0, 500,200);
		title.setFont(new Font("Rockwell Extra Bold",Font.BOLD,50));
		
		
		
		man.setFont(new Font("���� ���",Font.BOLD,20));
		woman.setFont(new Font("���� ���",Font.BOLD,20));
		
		man.setOpaque(false);
		woman.setOpaque(false);
		
		woman.setSelected(true);
		
		JPanel p=new JPanel();
		p.setOpaque(false);	// ���� ��������� �ٲ�°�
		p.add(b1);
		p.add(b2);
		
	
		b1.setFont(new Font("���� ���",Font.BOLD,15));
		b2.setFont(new Font("���� ���",Font.BOLD,15));
		
		JPanel all=new JPanel();
		all.setOpaque(false);
		all.add(la1);
		all.add(la2);
		all.add(man);
		all.add(woman);
		all.add(tf);
		all.add(pf);
		la1.setBounds(100, 200, 100, 40);
		la2.setBounds(100, 250, 100, 40);
		man.setBounds(100, 300, 100, 30);
		woman.setBounds(210, 300, 100, 30);
		tf.setBounds(190, 200, 100, 30);
		pf.setBounds(190, 250, 100, 30);
		p.setBounds(100, 340, 185, 35);
		//add(all);
		
		add(la1);
		add(la2);
		
		add(title);
		
		add(tf);
		add(pf);
		add(p);
		
		add(man);
		add(woman);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(),getHeight(), this);
	}
}












