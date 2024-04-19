package Main;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;	
	
public class MainClass {
	
	 static JFrame frame = new JFrame("Albyon Offline");
	 

	public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {

	   
		 File file = new File("BGM.wav");
		    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		    Clip clip = AudioSystem.getClip();
		    clip.open(audioStream);
		    clip.start();
		    
		MainPanelVariables mainVar = new MainPanelVariables();
		MainPanel panel = new MainPanel();

		frame.setSize(1300,900);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(panel.pnlBG);
//		frame.add(panel.pnlSubClass);
//		frame.add(panel);
//		frame.add(panel.btnExit);
//		frame.add(panel.pnlFinal);

		
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.black);


		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
		panel.RunStart();
		
						
	}

}

	
