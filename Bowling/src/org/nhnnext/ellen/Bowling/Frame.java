package org.nhnnext.ellen.Bowling;

public class Frame {
	private int firstPoint;
	private int secondPoint;

	public Frame(int firstPoint, int secondPoint) {
		this.firstPoint = firstPoint;
		this.secondPoint = secondPoint;
	}
	
	public boolean isStrike() {
		return (firstPoint == 10);
	}
	
	public boolean isSpare() {
		return ((firstPoint + secondPoint) == 10);
	}
	
	
}