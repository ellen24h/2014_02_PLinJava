package org.nhnnext.ellen.Bowling;

public class Player {
	
	public String name;
	private Frame[] frame = new Frame[10];
	
	
	public Player(String name) {
		this.name = name;
	}

	public void savePoint(int frameNumber, int firstPoint, int secondPoint, int thirdPoint) {
		frame[frameNumber] = new Frame(firstPoint, secondPoint, thirdPoint);
	}
	
	
}
