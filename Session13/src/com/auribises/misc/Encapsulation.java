package com.auribises.misc;

class Settings{
	@SuppressWarnings("unused")
	private String usernameString = "john.watson"; // Encapsulation -> limiting access of attribute to only this class boundary
	int volume;
}

public class Encapsulation {

	public static void main(String[] args) {
		
		Settings settings = new Settings();
//		settings.username = "fionna.flynn";
		settings.volume = 5;

	}

}
