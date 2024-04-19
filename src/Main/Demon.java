package Main;

public class Demon extends CharacterSelection{
	
	private int hp, mp;
	private String sub, mainClass;
	
	public Demon(int Class, int subclass) {
		
		
		if(subClass == 1) {
			
			hp = 2500;
			mp = 1000;
			sub = "Arch Demon";
			mainClass = "Demon";
			
		}
		else{
			
			hp = 2000;
			mp = 1100;
			sub = "Youkai";
			mainClass = "Demon";
		}
			
		super.setCharacter(hp, mp, mainClass, sub);
	}
}