package ProgrammingAssignmentsCh3;

/**
 * Hangman Program
 * Programming Assignment #2
 * @author Jeremy Francispillai
 * @SDate April 16, 2013
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hangman2 extends JApplet{

	Label title,word, winL;
	Container cp;
	JButton EBtn;
	String Title;
	JButton a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z, restart;
	Panel p1,p2,p3;
	String [] words = {"HELLO", "PENCIL", "DINNER", "PROGRAMMING", "ERASER", "SACREDHEART",
			"COMPUTER", "CHEESE", "HANGMAN", "PRINTER", "HOLEPUNCHER", "BREAD", "MUSIC", "NOTEBOOK", "JAVA", "ELEPHANT"};
	int temp = 0;
	int wrong = 0;
	boolean correct = false;
	int points = 0;
	//int starting=97;
	//int starting2=65;
	public void init(){
		restart = new JButton("New Word");
		a = new JButton("A");
		b = new JButton("B");
		c = new JButton("C");
		d = new JButton("D");
		e = new JButton("E");
		f = new JButton("F");
		g = new JButton("G");
		h = new JButton("H");
		i = new JButton("I");
		j = new JButton("J");
		k = new JButton("K");
		l = new JButton("L");
		m = new JButton("M");
		n = new JButton("N");
		o = new JButton("O");
		p = new JButton("P");
		q = new JButton("Q");
		r = new JButton("R");
		s = new JButton("S");
		t = new JButton("T");
		u = new JButton("U");
		v = new JButton("V");
		w = new JButton("W");
		x = new JButton("X");
		y = new JButton("Y");
		z = new JButton("Z");
		
		setSize(800,400);
		this.setLayout(new GridLayout(1,2));
		//add(a);
		EBtn = new JButton ("Change the title");
		title = new Label("                                                      HANGMAN");
		
		word = new Label("");
		winL = new Label("");
		temp = (int)Math.floor(Math.random()*words.length);
		
		for(int i=0; i<words[temp].length(); i++){
			word.setText(word.getText()+"_ ");
		}
		z.setLocation(4, 5);
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p2.setLayout(new GridLayout(3,1));
		p3.setLayout(new GridLayout(1,2));
		p1.setLayout(new GridLayout(7,4));
		cp = new Container();
		cp.setLayout(new GridLayout(5,1));
		cp.add(p2);
		add(cp);
		p2.add(title);
		p2.add(word);
		p2.add(p3);
		p3.add(restart);
		p3.add(winL);
		
		//add(p2);
		add(p1);
		final JButton[] letters = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z};
		for(int i=0; i<letters.length; i++){
			p1.add(letters[i]);
			
			final JButton Btest = letters[i];
			Btest.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					correct = false;
					char letter = Btest.getText().charAt(0);
					int length = word.getText().length();
					for(int i=0; i<length; i+=2){
						if (words[temp].charAt(i/2)==letter){
							String tempw = "";
							for(int j=0; j<length;j++){
								if(j%2==0){
									if(j==i){
										tempw+=letter;
										correct = true;
									}else{
										tempw+=word.getText().charAt(j);
									}
									//System.out.println(tempw);
								}else{
									tempw += " ";
								}
							}
							//System.out.println(tempw);
							word.setText(tempw);
							boolean tempb = false;
							for(int k=0; k<word.getText().length(); k++){
								if(word.getText().charAt(k)=='_'){
									tempb=true;
								}
							}
							if(!tempb && wrong < 8){
								winL.setText("YOU WIN!!");//   WWWWIININNN
							}
							
						}else{
							points++;
						}
					}
					if(!correct){
						wrong++;
						if(wrong>8 && winL.getText().equals("")){
							winL.setText("YOU LOSE!!!");
						}
					}
					Btest.setEnabled(false);
					repaint();
				}
			});
		}
		
		
		
		restart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				word.setText("");
				temp = (int)Math.floor(Math.random()*words.length);
				wrong = 0;
				for(int i=0; i<words[temp].length(); i++){
					word.setText(word.getText()+"_ ");
				}
				for(int i=0; i<letters.length; i++){
					final JButton tButton = letters[i];
					tButton.setEnabled(true);
				}
				winL.setText("");
				repaint();
			}
		});
		//p1.add(a);
		//add(title);
		/*add(EBtn);
		EBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				Title=JOptionPane.showInputDialog("New Title");
				repaint();
			}
		});*/
	}
	public void paint(Graphics g){
		super.paint(g);
		//g.set
		//g.drawString(Title, 10, 10);
		//g.fillRect(40, 100, 150, 240);
		g.fillRect(40, 350, 150, 20);
		g.fillRect(100, 80, 20, 280);
		g.fillRect(100, 80, 150, 20);
		
		if(wrong>0){
			g.fillOval(200, 100, 80, 80);
			if(wrong>1){
				g.fillRect(235, 180, 15, 70);
				if(wrong>2){
				g.fillRect(230, 250, 10, 50);
				if(wrong>3){
				g.fillRect(245, 250, 10, 50);
				if(wrong>4){
				g.fillRect(200, 200, 40, 10);
				if(wrong>5){
				g.fillRect(245, 200, 40, 10);
				if(wrong>6){
				g.setColor(Color.white);
				g.fillOval(225, 120, 10, 10);
				if(wrong>7){
				g.fillOval(250, 120, 10, 10);
				if(wrong>8){
				g.fillOval(234, 150, 15, 15);
				}
				}
				}
				}
				}
				}
				}
			}
		}
			
	}

}
