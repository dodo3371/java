import java.util.Random;
import java.util.Scanner;

public class homework2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Random randomGenerator = new Random();
		int row = 0;
		int column = 0;
		int[][] board = new int[row][column];
		boolean[][] isVisited = new boolean[row][column];

		while(true)
		{
			System.out.println("=====================");
			System.out.println("  1. Make new game");
			System.out.println("  2. Start game");
			System.out.println("  3. Quit");
			System.out.println("=====================");
			System.out.print(" *Select Menu: ");
			int menu = input.nextInt();

			/*
			 * 1을 입력하면 게임을 할 테이블을 생성한다.
			 * 행과 열을 입력받아 그 크기의 테이블을 생성한다.
			 * 게임이 진행될 때 방문여부를 판단할 boolean 테이블도 함께 생성한다.
			 */
			if(menu == 1)
			{
				System.out.println("=====================");
				System.out.print(" *Number of Rows? ");
				row = input.nextInt();
				System.out.print(" *Number of Columns? ");
				column = input.nextInt();
				board = new int[row][column];
				isVisited = new boolean[row][column];
				
				/*
				 * 생성한 테이블에 당첨 또는 꽝을 채우는 과정
				 * 랜덤으로 값을 생성해서 0.2보다 작으면 1, 그보다 크면서 0.5보다 작으면 2, 그 외에는 0을 대입한다.
				 */
				for(int i = 0; i < row; ++i)
				{
					for(int j = 0; j < column; ++j)
					{
						if(Math.random() < 0.2)
							board[i][j] = 1;
						else if(Math.random() < 0.5)
							board[i][j] = 2;
						else
							board[i][j] = 0;
					}
				}
				System.out.println("Now you can start new game!");
			}
			/*
			 * 2를 입력하면 게임을 실행한다.
			 * 5번 입력받을 때까지, 혹은 그 전에 당첨을 찾을때까지 게임을 진행한다.
			 */
			else if(menu == 2)
			{
				System.out.println("=====================");
				for(int i = 0; i < row; ++i)
				{
					System.out.print("    ");
					for(int j = 0; j < column; ++j)
						System.out.print("□ ");
					System.out.println("");
				}
				
				int chance = 5;
				while(true)
				{
					if(chance == 0)
					{
						System.out.println("Oops, you had a bad luck! Try new game!");
						break;
					}
					
					System.out.print("Which lot do you want to pick? (" + chance + " chances left): ");
					int y = input.nextInt();
					int x = input.nextInt();
					isVisited[y][x] = true;

					/*
					 * 입력받은 좌료는 방문한 좌표로 표시하고
					 * 방문한 좌표는 □ 대신 저장된 값을 출력한다.
					 */
					for(int i = 0; i < row; ++i)
					{
						System.out.print("    ");
						for(int j = 0; j < column; ++j)
						{
							if(!isVisited[i][j])
								System.out.print("□ ");
							else if(board[i][j] == 0)
								System.out.print("X ");
							else
								System.out.print(board[i][j] + " ");
						}
						System.out.println("");
					}
					
					/*
					 * 입력받은 좌표의 값이 당첨이면 while문은 빠져나온다.
					 * 그렇지 않으면 chance값을 하나 감소시키고 while문을 계속 돈다.
					 */
					if(board[y][x] != 0)
					{
						System.out.println("Congratulation! You won LAPTOP!");
						break;
					}
					else
					{
						System.out.println("It's blank. Try again!");
						chance--;
					}
				}
			}
			/*
			 * 3을 입력하면 프로그램을 종료한다.
			 */
			else
			{
				System.out.println("Good-bye!");
				break;
			}
		}
	}
}
