package org.nhnnext.ellen.Bowling;

public class PointCalculator {
	
	public void calculatePoint(Frame[] frame) {
		int accScore = 0;

		try {
			for (int frameNumber=0; frameNumber < frame.length; frameNumber++) {
				int frameScore = frame[frameNumber].firstPoint + frame[frameNumber].secondPoint;
				int bonusScore = bonusScore(frame, frameNumber);
				accScore += frameScore + bonusScore;
				
				frame[frameNumber].accScore = accScore;
			}
		}
		catch(Exception e) { }
	}

	public int bonusScore(Frame[] frame, int frameNumber) throws Exception {
		int bonusScore = 0;
		int firstBonusPoint;
		int secondBonusPoint;
		
		if (frame[frameNumber].isStrike()) {
			if (frameNumber == 10) {
				firstBonusPoint = frame[frameNumber].secondPoint;
				secondBonusPoint = frame[frameNumber].thirdPoint;
			}
			
			if (frame[frameNumber+1] == null)
				throw new Exception("#");
				
			firstBonusPoint = frame[frameNumber+1].firstPoint;
			
			if (firstBonusPoint == 10) {
				if (frameNumber == 9) {
					secondBonusPoint = frame[frameNumber+1].secondPoint;
				}
				else {
					if (frame[frameNumber+2] == null)
						throw new Exception("#"); 
					secondBonusPoint = frame[frameNumber+2].firstPoint;	
				}
			} 
			else {
				secondBonusPoint = frame[frameNumber+1].secondPoint;
			}
			
			bonusScore = firstBonusPoint + secondBonusPoint;
		}	
		if (frame[frameNumber].isSpare()) {
			if (frameNumber == 10) {
				bonusScore = frame[frameNumber].thirdPoint;
			}
				
			else {
				if (frame[frameNumber+1] == null)
				throw new Exception("#");
				
				bonusScore = frame[frameNumber+1].firstPoint;
			}
		}
		return bonusScore;
	}
	
}
