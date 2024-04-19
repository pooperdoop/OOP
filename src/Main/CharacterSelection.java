package Main;

import java.util.Scanner;

public abstract class CharacterSelection {
	
	private int HP;
	private int MP;
	private String Class;
	private String SubClass;
	int ClassPick;					
	int subClass;			
	String CharacterName;
	
	public void setCharacter( int hp, int mp, String Class, String subclass) {
		
		this.HP = hp;
		this.MP = mp;
		this.Class = Class;
		this.SubClass = subclass;
		
	}
	
	public int getHP() {
		
		return HP;
	}
	
	public int getMP() {
		
		return MP;
	}
	public String getSubClass() {
		
		return SubClass;
	}
	
	public String getMainClass() {
		
		return Class;
	}
	
	
}










