package org.nhnnext.ellen.Bowling;

public class Frame {
	public int firstPoint;
	public int secondPoint;
	public int accScore = -1;

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
	
	public String getAccScore()
	{
		if ( accScore < 0 )
			return "";
		
		return "" + accScore;
	}
	
	@Override
	public String toString() {
		String firstPoint = (this.firstPoint == 10) ? "X" : "" + this.firstPoint;
		String secondPoint = (this.firstPoint == 10) ? " " :
				(this.firstPoint + this.secondPoint == 10) ? "/" :
				("" + this.secondPoint);

		return " " + firstPoint + secondPoint;
	}

	public int getScore() {
		return firstPoint + secondPoint;
	}
}
