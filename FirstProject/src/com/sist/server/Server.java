package com.sist.server;
import java.util.*;

import com.sist.common.Function;

import java.net.*;
import java.io.*;
/*
 *   1. ���� ��� (�ڵ���) ==> ���� 
 *      ======
 *       Socket : �ٸ� ��ǻ�Ϳ� ���� 
 *       
 *   2. ���� ==> ���� (��ȭ��ȣ,��ȭ��)
 *             === ip , port 
 *             ���ɿ� �ɴ´�
 *             =========
 *             bind(ip,port)
 *   3. ��� (��ȭ�� �ö� ���� ��ٸ���)
 *             listen()
 *   =========================== ���ο� (P2P)
 *   ��Ƽ 
 *   ====
 *    1) ��ȯ����
 *    2) ��ż��� ==> �����ڸ��� ���� ==> Thread
 */
public class Server implements Runnable{
    // ���� ���� ���� 
	private ServerSocket ss;
	private final int PORT=2357;
	// Ŭ���̾�Ʈ ������ ���� 
	private ArrayList<Client> waitList=
			   new ArrayList<Client>();
	// Ŭ���̾�Ʈ�� IP,id....
	public Server()// ���α׷����� ���۰� ���� ���� : ������,main
	{
		// ���� ==> �����Ҷ� �Ѱ� ��ǻ�Ϳ��� �ι��� ���� �� �� ����
		try
		{
			ss=new ServerSocket(PORT);
			// ������ ==> bind():���� , listen(): ��� 
			System.out.println("Server Start...");
		}catch(Exception ex) 
		{
			System.out.println(ex.getMessage());
		}
	}
	// ���������� ó���ϴ� ��� 
	public void run()
	{
		try
		{
			// Ŭ���̾�Ʈ�� �߽��� IPȮ�� ==> Socket
			while(true)
			{
			   // Socket s==> ������ Ŭ���̾�Ʈ�� ����(IP,PORT)
			   Socket s=ss.accept();// Ŭ���̾�Ʈ�� ���ӽÿ��� ȣ�� 
			   Client client=new Client(s);
			   // ������� Ŭ���̾�Ʈ�� ����� ���۵ȴ� 
			   client.start();
			}
		}catch(Exception ex){}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server server=new Server();
        new Thread(server).start();
	}
	
	// ��� �غ� ==> ���� Ŭ���� 
    class Client extends Thread
    {
    	// �α��ν� �����ϴ� ������ id,name
    	String id;
    	String name;
    	Socket s;// ����
    	BufferedReader in;
    	OutputStream out;
    	public Client(Socket s)
    	{
    		try
    		{
    			this.s=s;
    			in=new BufferedReader(
    					new InputStreamReader(s.getInputStream()));
    			// ������ ����ϴ� Ŭ���̾�Ʈ�� ������ ���� ����
    			out=s.getOutputStream();
    			// ������ ����ϴ� Ŭ���̾�Ʈ �޼��� ����
    		}catch(Exception ex){}
    	}
    	// ��� 
    	public void run()
    	{
    		try
    		{
    			// 100|id|name
    			while(true)
    			{
    				String msg=in.readLine();
    				System.out.println("Client=>��û��:"+msg);
    				// Ŭ���̾�Ʈ�� ������ �޼���
    				// ó�� ==> ����� ������
    				StringTokenizer st=new StringTokenizer(msg, "|");
    				int no=Integer.parseInt(st.nextToken());
    				switch(no)
    				{
    				  case Function.LOGIN:
    				  {
    					
    				  }
    				  break;
    				}
    			}
    		}catch(Exception ex){}
    	}
    	/*
    	 *   ���� ==> Ŭ���̾�Ʈ ���� �޼��� 
    	 */
    	//  ��ü �����ϴ� �޼���
    	public void messageAll(String msg)
    	{
    		try
    		{
    			for(Client client:waitList)
    			{
    				client.messageTo(msg);
    			}
    		}catch(Exception ex){}
    	}
    	//  ������ �����ϴ� �޼��� 
    	public void messageTo(String msg)
    	{
    		try
    		{
    			out.write((msg+"\n").getBytes());
    		}catch(Exception ex){}
    	}
    	
    }
}







