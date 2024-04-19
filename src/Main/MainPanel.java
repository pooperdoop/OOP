package Main;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class MainPanel extends JPanel implements Runnable, ActionListener{
	
	MainPanelVariables main = new MainPanelVariables();
	MiddleMan mid = new MiddleMan();
	public JPanel pnlBG = new JPanel();
	ImageIcon img = new ImageIcon();
    JLabel imgSubClass = new JLabel(img);


	public MainPanel() {

	pnlBG.add(this);
	pnlBG.add(main.pnlSubClass);
	pnlBG.add(main.pnlFinal);
	pnlBG.add(main.btnExit);
	pnlBG.setSize(1300,900);
	pnlBG.add(main.label);
	pnlBG.setLayout(null);
	this.setSize(1300, 900);
	this.setBackground(new Color(0,0,0,30));
	this.setLayout(null);
	main.label.setBounds(0,0,1300,900);
	
	main.pnlSubClass.setSize(1300, 900);
	main.pnlSubClass.setBackground(new Color(0,0,0,30));
	main.pnlSubClass.setLocation(1300,0);
	main.pnlSubClass.setVisible(true);
	main.pnlSubClass.setLayout(null);
	
	main.pnlFinal.setSize(1300, 900);
	main.pnlFinal.setBackground(new Color(0,0,0,30));
	main.pnlFinal.setLocation(2750,0);
	main.pnlFinal.setVisible(true);
	main.pnlFinal.setLayout(null);
	
	for (int i = 0; i<4;i++) {
		main.btnClasses[i] = new JButton();
		main.lblClasses[i] = new JLabel();
		main.btnClasses[i].addActionListener(this);
		this.add(main.btnClasses[i]);
		
		main.btnClasses[i].setFocusable(false);
		main.btnClasses[i].setBounds(main.buttGap, 300, 150,250);
		main.lblClasses[i].setBounds(main.buttGap, 600, 200,100);
		main.lblClasses[i].setFont(new Font("GUMDROP", Font.BOLD, 50));
		main.lblClasses[i].setForeground(Color.black);
		main.btnClasses[i].setFont(new Font("GUMDROP", Font.BOLD, 100));
		main.btnClasses[i].setBackground(new Color(147,233,190));
		this.add(main.lblClasses[i]);
		main.buttGap+=335;
	}
	main.lblClasses[0].setText("Human");
	main.lblClasses[1].setText("Elven");
	main.lblClasses[2].setText("Demon");
	main.lblClasses[3].setText("Dwarf");
	
	main.btnExit.setBounds(1250,5, 45, 45);
	main.btnExit.addActionListener(this);
	
	main.lblChooseClass.setFont(new Font("GUMDROP", Font.BOLD,140));
	main.lblChooseClass.setBounds(170,50,1000,140);
	main.lblChooseSub.setFont(new Font("GUMDROP", Font.BOLD,100));
	main.lblChooseSub.setBounds(220,50,1000,140);
	main.pnlSubClass.add(main.lblChooseSub);
	this.add(main.lblChooseClass);
	main.buttGap = 575;
	
	for (int i = 0; i<2;i++) {
		
		main.btnBack[i] = new JButton("<-");
		main.btnBack[i].setBounds(0,0,50,50);
		main.btnBack[i].setFont(new Font("TIMES NEW ROMAN", Font.BOLD,15));
		main.btnBack[i].setFocusable(false);
		main.btnBack[i].addActionListener(this);
		main.btnBack[i].setBackground(Color.cyan);

		main.btnSwitchCharacter[i] = new JButton();
		main.btnSwitchCharacter[i].addActionListener(this);
		main.btnSwitchCharacter[i].setFocusable(false);
		main.btnSwitchCharacter[i].setBounds(main.buttGap2, 400, 80,80);
		main.btnSwitchCharacter[i].setFont(new Font("ERAS", Font.BOLD,30));
		main.btnSwitchCharacter[i].setBackground(Color.pink);
		main.pnlSubClass.add(main.btnSwitchCharacter[i]);
		main.buttGap2+=900;

		
		main.pnlSubClassSmaller[2] = new JPanel();
		main.pnlSubClassSmaller[2].setSize(550,225);
		main.pnlSubClassSmaller[2].setBackground(new Color(128,128,128));
		main.pnlSubClassSmaller[2].setLocation(25,450);
		main.pnlSubClassSmaller[i] = new JPanel();
		main.pnlSubClassSmaller[i].setSize(250,400);
		main.pnlSubClassSmaller[i].setBackground(new Color(128,128,128));
		main.pnlSubClassSmaller[i].setLocation(main.smallGap,25);
		main.pnlSubClassSmall.add(main.pnlSubClassSmaller[i]);
		main.pnlSubClassSmall.add(main.pnlSubClassSmaller[2]);
		main.smallGap += 300;
		}
	main.pnlSubClassSmaller[0].setLayout(new FlowLayout(FlowLayout.CENTER,1000,55));
	
	main.pnlSubClassSmall.setSize(600,700);
	main.pnlSubClassSmall.setBackground(new Color(0,0,0,0));
	main.pnlSubClassSmall.setLocation(350,150);
	main.pnlSubClassSmall.setLayout(null);
	main.pnlSubClass.add(main.pnlSubClassSmall);

	main.pnlSubClass.add(main.btnBack[0]);
	main.pnlFinal.add(main.btnBack[1]);
	
	main.btnSwitchCharacter[0].setText("<");
	main.btnSwitchCharacter[1].setText(">");
	main.lblSubClass.setFont(new Font("GUMDROP", Font.CENTER_BASELINE, 40));
	main.lblSubClass.setForeground(Color.BLACK);
	main.pnlSubClassSmaller[0].add(main.lblSubClass);
	main.pnlSubClassSmaller[0].add(imgSubClass);
	

	}
	void RunStart() {
		
		main.thread = new Thread(this);
		
		getPixels();
		
		main.thread.start();	
	}
	
	public void run() {
		double drawInterval = 1000000000/60;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;        
        long timer = 0;
        int drawCount = 0;
        
        while(main.thread != null) {
			
			currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1) {
//          	repaint();
//       		 	System.out.println("Debuggering rn lmao its a good thing its not..... FreddyFazBear");
            	
	            	 if(main.Clicked == true) {
	            		 
	            		 if (main.LOR == 1) {
	            			 try {
								SwitchSub();
							} catch (LineUnavailableException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (UnsupportedAudioFileException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	            		 }
	            		 if(main.LOR == 2 || main.LOR == 3) {
	            			 System.out.println("N");
	            			 PanelMove();
	            				GetValues();
	            				ChangeValues();
	            			
	            			

	            		 }            		 	            		
	 	            }
	            	 delta--;
		                drawCount++;
	            }
            if (timer >= 1000000000) {
                drawCount = 0;
                timer = 0;
            	}
	            
	        }
		}
	
	
	public void SwitchSub() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		
			GetValues();
			ChangeValues();
			

		
	}
	
	public void GetValues() {
		main.HP = mid.getHP();
		main.MP = mid.getMP();
	}
	
	public void PanelMove() {
		
		if(main.LOR == 2) {
		main.panel1Movement-= 100;
		main.panel2Movement-= 100;
		main.panel3Movement-= 100;
		
		this.setLocation(main.panel1Movement,0);
		main.pnlSubClass.setLocation(main.panel2Movement, 0);
		main.pnlFinal.setLocation(main.panel3Movement, 0);
		
		if(main.panel1Movement == -1300 && main.firstEdge == false) {
			System.out.println(main.panel1Movement);
			 main.Clicked = false;
			 main.firstEdge = true;
			 System.out.println("BLOCKA");
		}
		else if(main.panel1Movement == -2600) {
			 main.Clicked = false;
			 main.firstEdge = false;
		}
	  }
		else {
			main.panel1Movement+= 100;
			main.panel2Movement+= 100;	
			main.panel3Movement+= 100;	
			
			this.setLocation(main.panel1Movement,0);
			main.pnlSubClass.setLocation(main.panel2Movement, 0);
			main.pnlFinal.setLocation(main.panel3Movement, 0);
			
			if(main.panel1Movement == 0 ) {
				 main.Clicked = false;
				 main.firstEdge = false;
			}
			else if(main.panel1Movement == -1300 && main.firstEdge == false) {
				System.out.println("B ABY");
				main.Clicked = false;
				 main.firstEdge = true;
			}
		}
	}
	
	
	public void getPixels() {
		
		try {
			
			main.Human = ImageIO.read(getClass().getResourceAsStream("/sprites/Walta.png"));
			main.Elf = ImageIO.read(getClass().getResourceAsStream("/sprites/elf.png"));
			main.Demon = ImageIO.read(getClass().getResourceAsStream("/sprites/Demon.png"));
			main.Dwarf = ImageIO.read(getClass().getResourceAsStream("/sprites/pengDwarf.png"));			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		main.btnClasses[0].setIcon(new ImageIcon(main.Human));
		main.btnClasses[1].setIcon(new ImageIcon(main.Elf));
		main.btnClasses[2].setIcon(new ImageIcon(main.Demon));
		main.btnClasses[3].setIcon(new ImageIcon(main.Dwarf));
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i<2; i++) {
			
			if(e.getSource() == main.btnSwitchCharacter[0]) {
				System.out.println("DAMN");
				main.LOR = 0;
				main.Clicked = true;
//         		CheckLimit();
			}
			
		if(e.getSource() == main.btnSwitchCharacter[1]) {
			System.out.println("DAMN");
			main.LOR = 1;
			main.Clicked = true;
//     		CheckLimit();
			}
		}
		
		for (int i = 0; i<4; i++) {
		if(e.getSource() == main.btnClasses[i]) {
			
			main.Clicked = true;
			main.LOR = 2;			
			
				if(e.getSource() == main.btnClasses[i]) {
					
					main.Clicked = true;
					
					if(e.getSource() == main.btnClasses[0]) {
						
						main.ClassPick = 1;
						
					}
					if(e.getSource() == main.btnClasses[1]) {
						

						main.ClassPick = 2;
						
					}
					if(e.getSource() == main.btnClasses[2]) {
			

						main.ClassPick = 3;
			
					}
					if(e.getSource() == main.btnClasses[3]) {

						main.ClassPick = 4;
			
					}			
			}
		}			
	}
		for(int i = 0; i <2; i++) {
			
			if(e.getSource() == main.btnSwitchCharacter[i]) {
				
				main.Clicked = true;
				main.LOR = 1;
				main.miniPanelY = 1300;
					if (main.SubClass == 1) {
						main.SubClass = 2;
					}

					else if (main.SubClass == 2) {
						main.SubClass = 1;
					}				
			}
			
			if(e.getSource() == main.btnBack[i]) {
				
				main.pnlSubClassSmall.setLocation(340,150);
				main.Clicked = true;
				main.LOR = 3;
				
			}
			
		}
		
		if(e.getSource() == main.btnExit) {
			
			System.exit(0);
			
		}
	}
	
	public void ChangeValues(){
		
	    
		if(main.ClassPick == 1) {
			if(main.SubClass == 1) {

				main.lblSubClass.setText("Hero");
				img = new ImageIcon(getClass().getResource("/sprites/Blackta.png"));
				imgSubClass.setIcon(img);
			}
			else {
				main.lblSubClass.setText("Rouge");
				img = new ImageIcon(getClass().getResource("/sprites/Navita.png"));
				imgSubClass.setIcon(img);
				
				
			}
		}
		else if (main.ClassPick == 2) {
			if(main.SubClass == 1) {

				main.lblSubClass.setText("High Elf");
				img = new ImageIcon(getClass().getResource("/sprites/elfhigh.png"));
				imgSubClass.setIcon(img);
				
			}
			else {
				main.lblSubClass.setText("Dark Elf");
				img = new ImageIcon(getClass().getResource("/sprites/elfwhite.png"));
				imgSubClass.setIcon(img);
				
				
			}
		}
		
		else if (main.ClassPick == 3) {
			if(main.SubClass == 1) {

				main.lblSubClass.setText("Arch Demon");
				img = new ImageIcon(getClass().getResource("/sprites/Demonic.png"));
				imgSubClass.setIcon(img);
				
			}
			else {
				main.lblSubClass.setText("Youkai");
				img = new ImageIcon(getClass().getResource("/sprites/Devil.png"));
				imgSubClass.setIcon(img);
				
				
			}
		}
		
		else if (main.ClassPick == 4) {
			if(main.SubClass == 1) {

				main.lblSubClass.setText("Warrior");
				img = new ImageIcon(getClass().getResource("/sprites/pengdwarfRed.png"));
				imgSubClass.setIcon(img);
				
			}
			else {
				main.lblSubClass.setText("Smith");
				img = new ImageIcon(getClass().getResource("/sprites/pengdwarfNegative.png"));
				imgSubClass.setIcon(img);
					
			}
		}
	    
		}
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		Graphics2D g2 = (Graphics2D)g;
//		
//		 g2.drawImage(main.BG, 0,0,100,100,null);
//	}
}
