package org.nhnnext.ellen.Bowling;

import java.util.Scanner;

public class Bowling {

	private static final int LAST_FRAME_NUM = 9;

	public static void main(String[] args) {
		
		System.out.print("몇 명이서 게임을 하나요: ");
		Scanner scanner = new Scanner(System.in);
		int numOfPlayer = scanner.nextInt();
		
		Player player[] = new Player[numOfPlayer];
		
		scanner.nextLine();
for (int i = 0; i < numOfPlayer ; i++) {
			System.out.print((i + 1) + "번째 player의 이름을 입력하세요: ");
			String name = scanner.nextLine();
			player[i] = new Player(name);
		}
		
		
		for (int frameNumber = 0; frameNumber < 10; frameNumber++) {
			System.out.println("====" + (frameNumber+1) + "번째 프레임 ====");
			for (int j = 0; j < numOfPlayer; j++) {
				System.out.print(player[j].name + "의 첫번째 점수를 입력하세요: ");
				int firstPoint = scanner.nextInt();
				
				int secondPoint = 0;
				if ( (frameNumber == LAST_FRAME_NUM) || (firstPoint < 10) )
				{
					System.out.print(player[j].name + "의 두번째 점수를 입력하세요: ");
					secondPoint = scanner.nextInt();
				}

				int thirdPoint = 0;
				if ((frameNumber == LAST_FRAME_NUM) && (firstPoint+secondPoint >= 10)) {
					System.out.print(player[j].name + "의 세번째 점수를 입력하세요: ");
					thirdPoint = scanner.nextInt();
				}
				
				player[j].savePoint(frameNumber, firstPoint, secondPoint, thirdPoint);
				printScoreBoard(player);
			}	
		}
	}

	public static void printScoreBoard(Player[] players) {
		System.out.println("======================================================");
		for (Player player : players)
		{
			printScoreBoard(player);
			System.out.println("======================================================");
		}
	}

	public static void printScoreBoard(Player player) {
		System.out.format("| %10s |", player.name);
		
		for (Frame frame : player.getFrame())
		{
			if ( frame == null )
				break;
			System.out.print(frame + "|");
		}
		System.out.println();

		System.out.print("|            |");
		for (Frame frame : player.getFrame())
		{
			if ( frame == null )
				break;
			System.out.format("%3s|", frame.getAccScore());
		}
		System.out.println();
	}

}
