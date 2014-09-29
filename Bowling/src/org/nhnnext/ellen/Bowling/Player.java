package org.nhnnext.ellen.Bowling;

public class Player {
	
	private static final int LAST_FRAME_NUM = 9;

	public String name;
	private Frame[] frame = new Frame[10];
	
	
	public Player(String name) {
		this.name = name;
	}

	public void savePoint(int frameNumber, int firstPoint, int secondPoint, int thirdPoint) {
		if (frameNumber == LAST_FRAME_NUM)
			frame[frameNumber] = new LastFrame(firstPoint, secondPoint, thirdPoint);
		else
			frame[frameNumber] = new Frame(firstPoint, secondPoint);
		
		PointCalculator calculator = new PointCalculator();
		calculator.calculatePoint(frame);
	}
	
	public Frame[] getFrame() {
		return frame;
	}
	
	
}
