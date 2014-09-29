package org.nhnnext.ellen.Bowling;

public class PointCalculator {
	
	private static final int LAST_FRAME_NUM = 9;
	
	public void calculatePoint(Frame[] frame) {
		int accScore = 0;

		try {
			for (int frameNumber=0; frameNumber < frame.length; frameNumber++) {
				int frameScore = frame[frameNumber].getScore();
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
		
		if (frameNumber == LAST_FRAME_NUM)
			return 0;
		
		if (frame[frameNumber].isStrike()) {
			if (frame[frameNumber+1] == null)
				throw new Exception("#");
			
			firstBonusPoint = frame[frameNumber+1].firstPoint;
			
			if (frame[frameNumber+1].isStrike()) {
				if (frameNumber == LAST_FRAME_NUM - 1) {
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
		else if (frame[frameNumber].isSpare()) {
			if (frameNumber == LAST_FRAME_NUM) {
				bonusScore = ((LastFrame)frame[frameNumber]).thirdPoint;
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
