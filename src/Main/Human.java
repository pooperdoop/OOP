package Main;

public class Human extends CharacterSelection{

	private int hp, mp;
	private String sub, mainClass;
	
	public Human(int Class, int subclass) {
		
		
		if(subClass == 1) {
			
			hp = 1500;
			mp = 800;
			sub = "Hero";
			mainClass = "Human";
			
		}
		else{
			
			hp = 1300;
			mp = 800;
			sub = "Rouge";
			mainClass = "Human";
		}
			
		super.setCharacter(hp, mp, mainClass, sub);
	}
	
	
}
