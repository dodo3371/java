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
			 * 1�� �Է��ϸ� ������ �� ���̺��� �����Ѵ�.
			 * ��� ���� �Է¹޾� �� ũ���� ���̺��� �����Ѵ�.
			 * ������ ����� �� �湮���θ� �Ǵ��� boolean ���̺� �Բ� �����Ѵ�.
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
				 * ������ ���̺� ��÷ �Ǵ� ���� ä��� ����
				 * �������� ���� �����ؼ� 0.2���� ������ 1, �׺��� ũ�鼭 0.5���� ������ 2, �� �ܿ��� 0�� �����Ѵ�.
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
			 * 2�� �Է��ϸ� ������ �����Ѵ�.
			 * 5�� �Է¹��� ������, Ȥ�� �� ���� ��÷�� ã�������� ������ �����Ѵ�.
			 */
			else if(menu == 2)
			{
				System.out.println("=====================");
				for(int i = 0; i < row; ++i)
				{
					System.out.print("    ");
					for(int j = 0; j < column; ++j)
						System.out.print("�� ");
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
					 * �Է¹��� �·�� �湮�� ��ǥ�� ǥ���ϰ�
					 * �湮�� ��ǥ�� �� ��� ����� ���� ����Ѵ�.
					 */
					for(int i = 0; i < row; ++i)
					{
						System.out.print("    ");
						for(int j = 0; j < column; ++j)
						{
							if(!isVisited[i][j])
								System.out.print("�� ");
							else if(board[i][j] == 0)
								System.out.print("X ");
							else
								System.out.print(board[i][j] + " ");
						}
						System.out.println("");
					}
					
					/*
					 * �Է¹��� ��ǥ�� ���� ��÷�̸� while���� �������´�.
					 * �׷��� ������ chance���� �ϳ� ���ҽ�Ű�� while���� ��� ����.
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
			 * 3�� �Է��ϸ� ���α׷��� �����Ѵ�.
			 */
			else
			{
				System.out.println("Good-bye!");
				break;
			}
		}
	}
}
