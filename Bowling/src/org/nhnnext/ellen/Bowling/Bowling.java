package org.nhnnext.ellen.Bowling;

import java.util.Scanner;

public class Bowling {

	public static void main(String[] args) {
		
		System.out.println("몇 명이서 게임을 하나요?");
		Scanner scanner = new Scanner(System.in);
		int numOfPlayer = Integer.parseInt(scanner.nextLine());
		
		Player player[] = new Player[numOfPlayer];
		
		for (int i = 0; i < numOfPlayer ; i++) {
			System.out.println((i + 1) + "번째 player의 이름을 입력하세요!");
			String name = scanner.nextLine();
			player[i] = new Player(name);
		}
		
		
		for (int frameNumber = 0; frameNumber < 10; frameNumber++) {
			System.out.println("====" + frameNumber + "번째 프레임 ====");
			for (int j = 0; j < numOfPlayer; j++) {
				System.out.println(player[j].name + "의 첫번째 점수를 입력하세요.");
				int firstPoint = Integer.parseInt(scanner.nextLine());
				System.out.println(player[j].name + "의 두번째 점수를 입력하세요.");
				int secondPoint = Integer.parseInt(scanner.nextLine());
				int thirdPoint = 0;
				
				//TODO 스트라이크 나오면 두번째 스코어가 없잖아! 
				//TODO 10번째 프레임이 스페어가 나오거나 스트라이크가 나오면 어떻게 할거야?
				if ((frameNumber == 10) && (firstPoint+secondPoint == 10)) {
					System.out.println(player[j].name + "의 세번째 점수를 입력하세요.");
					thirdPoint = Integer.parseInt(scanner.nextLine());
				}
				
				player[j].savePoint(frameNumber, firstPoint, secondPoint, thirdPoint);
			}	
		}
	}
	
	public void printScoreBoard() {
		
	}

}
