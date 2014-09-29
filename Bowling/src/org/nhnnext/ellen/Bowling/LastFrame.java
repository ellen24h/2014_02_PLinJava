package org.nhnnext.ellen.Bowling;

public class LastFrame extends Frame {
	public int thirdPoint;
	
	public LastFrame(int firstPoint, int secondPoint, int thirdPoint) {
		super(firstPoint, secondPoint);
		this.thirdPoint = thirdPoint;
	}

	@Override
	public String toString() {
		String firstPoint;
		String secondPoint;
		String thirdPoint = " ";

		if ( this.firstPoint == 10 ) {
			firstPoint = "X";
			if ( this.secondPoint == 10 ) {
				secondPoint = "X";
				if ( this.thirdPoint == 10 ) {
					thirdPoint = "X";
				}
				else {
					thirdPoint = "" + this.thirdPoint;
				}
			}
			else {
				secondPoint = "" + this.secondPoint;
				
				if ( this.secondPoint + this.thirdPoint == 10 )
					thirdPoint = "/";
				else
					thirdPoint = "" + this.thirdPoint;
			}
		}
		else {
			firstPoint = "" + this.firstPoint;
			if ( this.firstPoint + this.secondPoint == 10 ) {
				secondPoint = "/";
				
				if (this.thirdPoint == 10)
					thirdPoint = "X";
				else
					thirdPoint = "" + this.thirdPoint;
			}
			else {
				secondPoint = "" + this.secondPoint;
			}
		}

		return "" + firstPoint + secondPoint + thirdPoint;
	}

	public int getScore() {
		return super.getScore() + thirdPoint;
	}
}
