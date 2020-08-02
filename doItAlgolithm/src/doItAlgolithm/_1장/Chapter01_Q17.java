package doItAlgolithm._1장;

import java.util.Scanner;

public class Chapter01_Q17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이등변 삼각형 크기 => ");
		
		int n = sc.nextInt();

		spira(n);

		sc.close();
	}

	static void spira(int n) {

		for (int i = 1; i <= n; i++) {
			for (int j = i; j < n; j++) {
				System.out.print(" ");
			}

			for (int j = 0; j < (i - 1) * 2 + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
