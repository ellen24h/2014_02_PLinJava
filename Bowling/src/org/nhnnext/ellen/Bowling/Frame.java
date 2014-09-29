package org.nhnnext.ellen.Bowling;

public class Frame {
	public int firstPoint;
	public int secondPoint;
	public int thirdPoint;
	public int accScore;

	public Frame(int firstPoint, int secondPoint, int thirdPoint) {
		this.firstPoint = firstPoint;
		this.secondPoint = secondPoint;
		this.thirdPoint = thirdPoint;
	}

	
	public boolean isStrike() {
		return (firstPoint == 10);
	}
	
	public boolean isSpare() {
		return ((firstPoint + secondPoint) == 10);
	}
	
	
}