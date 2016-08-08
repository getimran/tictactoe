/*Tic Tac Toe Game with single player and double player mode- coded by Mohd. Imran*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FrameDemo extends JFrame
{
	FrameDemo(String s)
	{
		super(s);
		getContentPane().setBackground(Color.DARK_GRAY);
		setSize(650,430);
		setLayout(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
	}
}
class TicTacToe implements ActionListener
{
	boolean playerXturn= true, computerTurn=false;
	int flag;
	FrameDemo mainFrame,singlePlayerFrame,doublePlayerFrame;
	JPanel gamePanel,optionPanel,messagePanel; 
	JButton sp,dp,singlePsp,singlePdp,singlePexit,osp,odp,exit;
	JButton b[]=new JButton[9];
	JButton b1[]=new JButton[9];
	TicTacToe(String s)
	{
		mainFrame=new FrameDemo(s);
		JLabel mainImage= new JLabel(new ImageIcon("images/main.jpg"));
		mainImage.setBounds(0,0,650,400);
		mainFrame.add(mainImage);
		sp=new JButton(new ImageIcon("images/sp.png"));
		sp.setBounds(250,355,130,25);
		sp.addActionListener(this);
		mainImage.add(sp);
		dp=new JButton(new ImageIcon("images/dp.png"));
		dp.setBounds(450,355,130,25);
		dp.addActionListener(this);
		mainImage.add(dp);
		mainFrame.setVisible(true);
		
		singlePlayerFrame=new FrameDemo("Tic Tac Toe- Single Player Mode");
		JLabel singleP1=new JLabel("Player X: YOU");
		singleP1.setForeground(Color.WHITE);
		JLabel singleP2=new JLabel("Player O: COMPUTER");
		singleP2.setForeground(Color.WHITE);
		singleP1.setBounds(450,1,100,100);
		singleP2.setBounds(450,20,200,100);
		singlePlayerFrame.add(singleP1);
		singlePlayerFrame.add(singleP2);
		doublePlayerFrame=new FrameDemo("Tic Tac Toe- Double Player Mode");
		gameAndOptionPanel(singlePlayerFrame, b1);
		gameAndOptionPanel(doublePlayerFrame, b);			
	}
	
	public void gameAndOptionPanel(FrameDemo playerFrame, JButton button[])
	{
		gamePanel=new JPanel();
		Font f=new Font("Serif",Font.BOLD,80);
		gamePanel.setBackground(Color.DARK_GRAY);
		gamePanel.setLayout(new GridLayout(3,3,2,2));
		for(int i=0;i<b.length;i++)
		{
			button[i]=new JButton();
			button[i].setBackground(Color.WHITE);
			button[i].setFont(f);
			gamePanel.add(button[i]);
			button[i].addActionListener(this);
		}
		gamePanel.setBounds(5,2,400,385);
		playerFrame.add(gamePanel);
		
		optionPanel=new JPanel();
		optionPanel.setBackground(Color.DARK_GRAY);
		optionPanel.setLayout(new GridLayout(3,1,50,10));
		osp=new JButton(new ImageIcon("images/sp.png"));
		osp.addActionListener(this);
		odp=new JButton(new ImageIcon("images/dp.png"));
		odp.addActionListener(this);
		exit=new JButton(new ImageIcon("images/exit.png"));
		exit.addActionListener(this);
		if(playerFrame == singlePlayerFrame)
		{
			singlePsp=osp;
			singlePdp=odp;
			singlePexit=exit;
		}
		optionPanel.add(osp);
		optionPanel.add(odp);
		optionPanel.add(exit);
		optionPanel.setBounds(450,100,130,100);
		playerFrame.add(optionPanel);
	}
	
	public void winMessage(FrameDemo playerFrame,char c)
	{
		
		messagePanel=new JPanel();
		messagePanel.setBackground(Color.DARK_GRAY);
		JLabel face= new JLabel(new ImageIcon("images/face.png"));
		JLabel draw= new JLabel(new ImageIcon("images/draw.png"));
		JLabel message=new JLabel("Great!! Player "+c+" has won.");
		JLabel drawMessage=new JLabel("Match draw!! Play Again");
		message.setForeground(Color.WHITE);
		drawMessage.setForeground(Color.WHITE);
		face.setBounds(450,230,100,108);
		draw.setBounds(460,230,100,108);
		messagePanel.setBounds(420,230,180,300);
		playerFrame.add(messagePanel);
		if(c == 'X' || c=='O'){
			messagePanel.add(face);
			messagePanel.add(message);
			messagePanel.setVisible(true);
		}
		if(c=='D')
		{
			messagePanel.add(draw);
			messagePanel.add(drawMessage);
			messagePanel.setVisible(true);
		}
	}	
	
	public void reset(FrameDemo playerFrame, JButton button[])
	{
		for(int i=0;i<button.length;i++)
			{	
				button[i].setText("");
				button[i].setBackground(Color.WHITE);
			}
			playerXturn=true;
			computerTurn=false;
			playerFrame.remove(messagePanel);
			playerFrame.revalidate();
			playerFrame.repaint();
	}
	
	public void colorChange(JButton x,JButton y,JButton z)
	{
		x.setBackground(Color.RED);
		y.setBackground(Color.RED);
		z.setBackground(Color.RED);
	}
	
	public void checkIfWon(FrameDemo playerFrame, JButton button[])	
	{	
		if (button[0].getText().equals("X") && button[1].getText().equals("X") && button[2].getText().equals("X")){
			colorChange(button[0],button[1],button[2]);
			winMessage(playerFrame, 'X');
			System.out.println("Player X Won");
		}
		if (button[3].getText().equals("X") && button[4].getText().equals("X") && button[5].getText().equals("X")){
			colorChange(button[3],button[4],button[5]);
			winMessage(playerFrame, 'X');
			System.out.println("Player X Won");
		}
		if (button[6].getText().equals("X") && button[7].getText().equals("X") && button[8].getText().equals("X")){
			colorChange(button[6],button[7],button[8]);
			winMessage(playerFrame, 'X');
			System.out.println("Player X Won");
		}
		if (button[0].getText().equals("X") && button[3].getText().equals("X") && button[6].getText().equals("X")){
			colorChange(button[0],button[3],button[6]);
			winMessage(playerFrame, 'X');
			System.out.println("Player X Won");
		}
		if (button[1].getText().equals("X") && button[4].getText().equals("X") && button[7].getText().equals("X")){
			colorChange(button[1],button[4],button[7]);
			winMessage(playerFrame, 'X');
			System.out.println("Player X Won");
		}
		if (button[2].getText().equals("X") && button[5].getText().equals("X") && button[8].getText().equals("X")){
			colorChange(button[2],button[5],button[8]);
			winMessage(playerFrame, 'X');
			System.out.println("Player X Won");
		}
		if (button[0].getText().equals("X") && button[4].getText().equals("X") && button[8].getText().equals("X")){
			colorChange(button[0],button[4],button[8]);
			winMessage(playerFrame, 'X');
			System.out.println("Player X Won");
		}
		if (button[2].getText().equals("X") && button[4].getText().equals("X") && button[6].getText().equals("X")){
			colorChange(button[2],button[4],button[6]);
			winMessage(playerFrame, 'X');
			System.out.println("Player X Won");
		}
		
		if (button[0].getText().equals("O") && button[1].getText().equals("O") && button[2].getText().equals("O")){
			colorChange(button[0],button[1],button[2]);
			winMessage(playerFrame, 'O');
			System.out.println("Player O Won");
		}
		if (button[3].getText().equals("O") && button[4].getText().equals("O") && button[5].getText().equals("O")){
			colorChange(button[3],button[4],button[5]);
			winMessage(playerFrame, 'O');
			System.out.println("Player O Won");
		}
		if (button[6].getText().equals("O") && button[7].getText().equals("O") && button[8].getText().equals("O")){
			colorChange(button[6],button[7],button[8]);
			winMessage(playerFrame, 'O');
			System.out.println("Player O Won");
		}
		if (button[0].getText().equals("O") && button[3].getText().equals("O") && button[6].getText().equals("O")){
			colorChange(button[0],button[3],button[6]);
			winMessage(playerFrame, 'O');
			System.out.println("Player O Won");
		}
		if (button[1].getText().equals("O") && button[4].getText().equals("O") && button[7].getText().equals("O")){
			colorChange(button[1],button[4],button[7]);
			winMessage(playerFrame, 'O');
			System.out.println("Player O Won");
		}
		if (button[2].getText().equals("O") && button[5].getText().equals("O") && button[8].getText().equals("O")){
			colorChange(button[2],button[5],button[8]);
			winMessage(playerFrame, 'O');
			System.out.println("Player O Won");
		}
		if (button[0].getText().equals("O") && button[4].getText().equals("O") && button[8].getText().equals("O")){
			colorChange(button[0],button[4],button[8]);
			winMessage(playerFrame, 'O');
			System.out.println("Player O Won");
		}
		if (button[2].getText().equals("O") && button[4].getText().equals("O") && button[6].getText().equals("O")){
			colorChange(button[2],button[4],button[6]);
			winMessage(playerFrame, 'O');
			System.out.println("Player O Won");
		}
		if(button[0].getText().equals("")==false && button[1].getText().equals("")==false && button[2].getText().equals("")==false && button[3].getText().equals("")==false && button[4].getText().equals("")==false && button[5].getText().equals("")==false && button[6].getText().equals("")==false && button[7].getText().equals("")==false && button[8].getText().equals("")==false) 
		{
			winMessage(playerFrame, 'D');
			System.out.println("Draw!!");
		}
		
	}
	
	public void checkFor3Combinations(String s)
	{
		if(computerTurn== true)
		{
			for(int i=0;i<1;i++)
			{
			if(b1[0].getText().equals(s) && b1[1].getText().equals(s) && b1[2].getText().equals(""))
			{
				b1[2].setText("O");
				computerTurn=false;
				break;
			}
								
			if(b1[0].getText().equals(s) && b1[2].getText().equals(s) && b1[1].getText().equals(""))
			{
				b1[1].setText("O");
				computerTurn=false;
				break;
			}						
			if(b1[1].getText().equals(s) && b1[2].getText().equals(s) && b1[0].getText().equals(""))
			{
				b1[0].setText("O");
				computerTurn=false;
				break;
			}					
			if(b1[3].getText().equals(s) && b1[4].getText().equals(s) && b1[5].getText().equals(""))
			{
				b1[5].setText("O");
				computerTurn=false;
				break;
			}					
			if(b1[3].getText().equals(s) && b1[5].getText().equals(s) && b1[4].getText().equals(""))
			{
				b1[4].setText("O");
				computerTurn=false;
				break;
			}					
			if(b1[4].getText().equals(s) && b1[5].getText().equals(s) && b1[3].getText().equals(""))
			{
				b1[3].setText("O");
				computerTurn=false;
				break;
			}	
			if(b1[6].getText().equals(s) && b1[7].getText().equals(s) && b1[8].getText().equals(""))
			{
				b1[8].setText("O");
				computerTurn=false;
				break;
			}					
			if(b1[6].getText().equals(s) && b1[8].getText().equals(s) && b1[7].getText().equals(""))
			{
				b1[7].setText("O");
				computerTurn=false;
				break;
			}					
			if(b1[7].getText().equals(s) && b1[8].getText().equals(s) && b1[6].getText().equals(""))
			{
				b1[6].setText("O");
				computerTurn=false;
				break;
			}	
			if(b1[0].getText().equals(s) && b1[3].getText().equals(s) && b1[6].getText().equals(""))
			{
				b1[6].setText("O");
				computerTurn=false;
				break;
			}					
			if(b1[0].getText().equals(s) && b1[6].getText().equals(s) && b1[3].getText().equals(""))
			{
				b1[3].setText("O");
				computerTurn=false;
				break;
			}					
			if(b1[3].getText().equals(s) && b1[6].getText().equals(s) && b1[0].getText().equals(""))
			{
				b1[0].setText("O");
				computerTurn=false;
				break;
			}					
			if(b1[1].getText().equals(s) && b1[4].getText().equals(s) && b1[7].getText().equals(""))
			{
				b1[7].setText("O");
				computerTurn=false;
				break;
			}					
			if(b1[1].getText().equals(s) && b1[7].getText().equals(s) && b1[4].getText().equals(""))
			{
				b1[4].setText("O");
				computerTurn=false;
				break;
			}					
			if(b1[4].getText().equals(s) && b1[7].getText().equals(s) && b1[1].getText().equals(""))
			{
				b1[1].setText("O");
				computerTurn=false;
				break;
			}					
			if(b1[2].getText().equals(s) && b1[5].getText().equals(s) && b1[8].getText().equals(""))
			{
				b1[8].setText("O");
				computerTurn=false;
				break;
			}					
			if(b1[2].getText().equals(s) && b1[8].getText().equals(s) && b1[5].getText().equals(""))
			{
				b1[5].setText("O");
				computerTurn=false;
				break;
			}					
			if(b1[5].getText().equals(s) && b1[8].getText().equals(s) && b1[2].getText().equals(""))
			{
				b1[2].setText("O");
				computerTurn=false;
				break;
			}					
			if(b1[0].getText().equals(s) && b1[4].getText().equals(s) && b1[8].getText().equals(""))
			{
				b1[8].setText("O");
				computerTurn=false;
				break;
			}	
			if(b1[0].getText().equals(s) && b1[8].getText().equals(s) && b1[4].getText().equals(""))
			{
				b1[4].setText("O");
				computerTurn=false;
				break;
			}	
			if(b1[4].getText().equals(s) && b1[8].getText().equals(s) && b1[0].getText().equals(""))
			{
				b1[0].setText("O");
				computerTurn=false;
				break;
			}	
			if(b1[2].getText().equals(s) && b1[4].getText().equals(s) && b1[6].getText().equals(""))
			{
				b1[6].setText("O");
				computerTurn=false;
				break;
			}	
			if(b1[2].getText().equals(s) && b1[6].getText().equals(s) && b1[4].getText().equals(""))
			{
				b1[4].setText("O");
				computerTurn=false;
				break;
			}	
			if(b1[4].getText().equals(s) && b1[6].getText().equals(s) && b1[2].getText().equals(""))
			{
				b1[2].setText("O");
				computerTurn=false;
				break;
			}
			}
		}
	}
	
	public void computerOturn(JButton b)
	{
		if(b!=b1[4] && flag==0 && b1[4].getText().equals(""))
		{
			b1[4].setText("O");
			flag=1;
			computerTurn=false;
		}
		checkFor3Combinations("O");
		checkFor3Combinations("X");
		if(computerTurn==true)
		{
			System.out.println("Test");
			for(int i=0;i<b1.length;i++)
			{
				if(b1[i].getText().equals(""))
				{
					b1[i].setText("O");
					break;
				}
			}
		}
		checkIfWon(singlePlayerFrame,b1);
		playerXturn=true;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==sp)
		{
			singlePlayerFrame.setVisible(true);
			flag=0;
			mainFrame.dispose();
		}
		if(ae.getSource()==dp)
		{
			doublePlayerFrame.setVisible(true);
			mainFrame.dispose();
		}
		if(ae.getSource()==osp || ae.getSource()==singlePsp)
		{
			flag=0;
			try{
			singlePlayerFrame.setVisible(true);
			if(doublePlayerFrame.isVisible())
			{
				doublePlayerFrame.dispose();
			}
			reset(singlePlayerFrame, b1);
			}catch(Exception e){}
		}
		if(ae.getSource()==odp || ae.getSource()==singlePdp)
		{
			try{
			doublePlayerFrame.setVisible(true);
			if(singlePlayerFrame.isVisible())
			{
				singlePlayerFrame.dispose();
			}
			reset(doublePlayerFrame, b);
			}catch(Exception e){}
		}
		if(ae.getSource()==exit || ae.getSource()==singlePexit)
		{
			System.exit(0);
		}
		/* ***********************Double Player Buttons***************************** */
		if(ae.getSource()==b[0])
		{
			if(b[0].getText().equals(""))
			{
				if(playerXturn== true){
					b[0].setText("X");
					playerXturn= false;
				}
				else{
					b[0].setText("O");
					playerXturn=true;
				}
				checkIfWon(doublePlayerFrame, b);
			}
		}
		if(ae.getSource()==b[1])
		{
			if(b[1].getText().equals(""))
			{
				if(playerXturn== true){
					b[1].setText("X");
					playerXturn= false;
				}
				else{
					b[1].setText("O");
					playerXturn=true;
				}
				checkIfWon(doublePlayerFrame, b);
			}
		}
		if(ae.getSource()==b[2])
		{
			if(b[2].getText().equals(""))
			{
				if(playerXturn== true){
					b[2].setText("X");
					playerXturn= false;
				}
				else{
					b[2].setText("O");
					playerXturn=true;
				}
				checkIfWon(doublePlayerFrame, b);
			}
		}
		if(ae.getSource()==b[3])
		{
			if(b[3].getText().equals(""))
			{
				if(playerXturn== true){
					b[3].setText("X");
					playerXturn= false;
				}
				else{
					b[3].setText("O");
					playerXturn=true;
				}
				checkIfWon(doublePlayerFrame, b);
			}
		}
		if(ae.getSource()==b[4])
		{
			if(b[4].getText().equals(""))
			{
				if(playerXturn== true){
					b[4].setText("X");
					playerXturn= false;
				}
				else{
					b[4].setText("O");
					playerXturn=true;
				}
				checkIfWon(doublePlayerFrame, b);
			}
		}
		if(ae.getSource()==b[5])
		{
			if(b[5].getText().equals(""))
			{
				if(playerXturn== true){
					b[5].setText("X");
					playerXturn= false;
				}
				else{
					b[5].setText("O");
					playerXturn=true;
				}
				checkIfWon(doublePlayerFrame, b);
			}
		}
		if(ae.getSource()==b[6])
		{
			if(b[6].getText().equals(""))
			{
				if(playerXturn== true){
					b[6].setText("X");
					playerXturn= false;
				}
				else{
					b[6].setText("O");
					playerXturn=true;
				}
				checkIfWon(doublePlayerFrame, b);
			}
		}
		if(ae.getSource()==b[7])
		{
			if(b[7].getText().equals(""))
			{
				if(playerXturn== true){
					b[7].setText("X");
					playerXturn= false;
				}
				else{
					b[7].setText("O");
					playerXturn=true;
				}
				checkIfWon(doublePlayerFrame, b);
			}
		}
		if(ae.getSource()==b[8])
		{
			if(b[8].getText().equals(""))
			{
				if(playerXturn== true){
					b[8].setText("X");
					playerXturn= false;
				}
				else{
					b[8].setText("O");
					playerXturn=true;
				}
				checkIfWon(doublePlayerFrame, b);
			}
		}
		/* ***********************Single Player Buttons***************************** */
		if(ae.getSource()==b1[0])
		{
			if(b1[0].getText().equals(""))
			{
				if(playerXturn== true){
					b1[0].setText("X");
					playerXturn= false;
					computerTurn=true;
					computerOturn(b1[0]);
				}
			}
		}
		if(ae.getSource()==b1[1])
		{
			if(b1[1].getText().equals(""))
			{
				if(playerXturn== true){
					b1[1].setText("X");
					playerXturn= false;
					computerTurn=true;
					computerOturn(b1[1]);
				}
			}
		}
		if(ae.getSource()==b1[2])
		{
			if(b1[2].getText().equals(""))
			{
				if(playerXturn== true){
					b1[2].setText("X");
					playerXturn= false;
					computerTurn=true;
					computerOturn(b1[2]);
				}
			}
		}
		if(ae.getSource()==b1[3])
		{
			if(b1[3].getText().equals(""))
			{
				if(playerXturn== true){
					b1[3].setText("X");
					playerXturn= false;
					computerTurn=true;
					computerOturn(b1[3]);
				}
			}
		}
		if(ae.getSource()==b1[4])
		{
			if(b1[4].getText().equals(""))
			{
				if(playerXturn== true){
					b1[4].setText("X");
					playerXturn= false;
					computerTurn=true;
					computerOturn(b1[4]);
				}
			}
		}
		if(ae.getSource()==b1[5])
		{
			if(b1[5].getText().equals(""))
			{
				if(playerXturn== true){
					b1[5].setText("X");
					playerXturn= false;
					computerTurn=true;
					computerOturn(b1[5]);
				}
			}
		}
		if(ae.getSource()==b1[6])
		{
			if(b1[6].getText().equals(""))
			{
				if(playerXturn== true){
					b1[6].setText("X");
					playerXturn= false;
					computerTurn=true;
					computerOturn(b1[6]);
				}
			}
		}
		if(ae.getSource()==b1[7])
		{
			if(b1[7].getText().equals(""))
			{
				if(playerXturn== true){
					b1[7].setText("X");
					playerXturn= false;
					computerTurn=true;
					computerOturn(b1[7]);
				}
			}
		}
		if(ae.getSource()==b1[8])
		{
			if(b1[8].getText().equals(""))
			{
				if(playerXturn== true){
					b1[8].setText("X");
					playerXturn= false;
					computerTurn=true;
					computerOturn(b1[8]);
				}
			}
		}
	}
	public static void main(String[] args)
	{
		new TicTacToe("Tic Tac Toe");
	}
}