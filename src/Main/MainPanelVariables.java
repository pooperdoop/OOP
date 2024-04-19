package Main;
import java.awt.image.*;
import java.io.File;
import javax.sound.sampled.*;
import javax.swing.*;

public class MainPanelVariables extends MainClass{
	
	public JPanel pnlSubClassSmall = new JPanel();
	public JPanel[] pnlSubClassSmaller = new JPanel[3];
	public JPanel pnlSubClass = new JPanel();
	public JPanel pnlFinal = new JPanel();
	
	public JButton btnExit = new JButton("X");
	public JButton[] btnClasses = new JButton[4];
	public JButton[] btnSwitchCharacter = new JButton[2];
	public JButton[] btnBack = new JButton[2];
	
	public JLabel[] lblClasses = new JLabel[4];
	public JLabel lblChooseClass = new JLabel("Select a Class");
	public JLabel lblChooseSub = new JLabel("Select a Subclass");
	public JLabel lblSubClass = new JLabel();
	public JLabel lblStats = new JLabel();
	public JLabel lblDesc = new JLabel();

    ImageIcon icon = new ImageIcon(getClass().getResource("/sprites/Art.gif"));
    JLabel label = new JLabel(icon);
    
	
	 public BufferedImage Human, Elf, Demon, Dwarf, Hero, Rouge, HighElves, DarkElves, ArchDemons, Youkai, Warrior, Smith, BG;
	 public int smallGap = 25;
	 public int largeGap = 150;
	 public int miniPanelY = 1300;
	 public int buttGap = 70;
	 public int Gap = buttGap;
	 public int Gap2 = 0;
	 public int RightClick = -150;
	 public int LeftClick = 425;
	 public int buttGap2 = 150;
	 public int LOR;
	 public int ClassPick;
	 public int panel1Movement;
	 public int panel2Movement = 1300;
	 public int panel3Movement = 2600;
	 public boolean Clicked = false;
	 public boolean firstEdge = false;
	 public boolean finishMoved = false;
	 public int SubClass = 2;
	 public int HP, MP;
	 
	 
	 public Thread thread;
	
	 
}
