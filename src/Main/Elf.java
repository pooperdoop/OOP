package Main;

public class Elf extends CharacterSelection{
	
	private int hp, mp;
	private String sub, mainClass;
	
	public Elf(int Class, int subclass) {
		
		
		if(subClass == 1) {
			
			hp = 1000;
			mp = 1500;
			sub = "High Elf";
			mainClass = "Elf";
			
		}
		else{
			
			hp = 1200;
			mp = 1300;
			sub = "Dark Elf";
			mainClass = "Elf";
		}
			
		super.setCharacter(hp, mp, mainClass, sub);
	}
}
