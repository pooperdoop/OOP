package Main;

public class Dwarf extends CharacterSelection{
	
	private int hp, mp;
	private String sub, mainClass;
	
	public Dwarf(int Class, int subclass) {
		
		
		if(subClass == 1) {
			
			hp = 4000;
			mp = 300;
			sub = "Warrior";
			mainClass = "Dwarf";
			
		}
		else{
			
			hp = 3000;
			mp = 500;
			sub = "Smith";
			mainClass = "Dwarf";
			
		}
			
		super.setCharacter(hp, mp, mainClass, sub);
	}
}
