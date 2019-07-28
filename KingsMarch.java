

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KingsMarch {
	Node topLeft;

	static class Node {
		Node bottom;
		Node Right; 
		Node botDia;
		int value;
		int x, y;

		Node(int value, int x, int y) {
			this.value = value;
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTCS = sc.nextInt();
		int b=noOfTCS;
		while (noOfTCS > 0) {
			int rows = Character.getNumericValue(sc.next().charAt(0));
			int columns = rows;
			char[][] ch = new char[rows][columns];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					ch[i][j] = sc.next().charAt(0);
				}
			}
			//System.out.println(ch[0][2]);
			/*for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					System.out.print(ch[i][j] + " ");
				}
				System.out.println();
			}*/

			KingsMarch km = new KingsMarch();
			km.topLeft = new Node(ch[0][0], 0, 0);
			ArrayList<Integer> al = new ArrayList<Integer>();
			assignNodes(km.topLeft, ch, rows, 0, al);
			//System.out.println(al);
			Collections.sort(al, Collections.reverseOrder());
			if(b==noOfTCS-1)
			{System.out.println();
			System.out.println();
			}
			if(al.isEmpty()){
				System.out.println("0 0");
			}
			else{
			int highest = al.get(0);
			int count = 0;
			for (int i = 0; i < al.size(); i++) {
				if (al.get(i) == highest)
					count++;
			}
			System.out.println(highest + " " + count);
			}
			noOfTCS--;

		}
	}

	public static void assignNodes(Node node, char[][] ch, int rows, int sum,
			ArrayList<Integer> al) {
		int X = node.x;
		int Y = node.y;
		// Right
		if (Y + 1 < rows) {
			char value = ch[X][Y + 1];
			if (value == 'x') {
			} else if (value == 's') {
				al.add(sum);
			} else {
				int rightsum = sum + Character.getNumericValue(value);
				node.Right = new Node(ch[X][Y + 1], X, Y + 1);
				assignNodes(node.Right, ch, rows, rightsum, al);
			}
		}

		// Bottom
		if (X + 1 < rows) {
			char value = ch[X + 1][Y];
			if (value == 'x') {
			} else if (value == 's') {
				al.add(sum);
			} else {
				int bottomsum = sum + Character.getNumericValue(value);
				node.bottom = new Node(ch[X + 1][Y], X + 1, Y);
				assignNodes(node.bottom, ch, rows, bottomsum, al);
			}
		}
		// BottomDiagonal
		if (X + 1 < rows && Y + 1 < rows) {
			char value = ch[X + 1][Y + 1];
			if (value == 'x') {
			} else if (value == 's') {
				al.add(sum);
			} else {
				int diagonalsum = sum + Character.getNumericValue(value);
				node.botDia = new Node(ch[X + 1][Y + 1], X + 1, Y + 1);
				assignNodes(node.botDia, ch, rows, diagonalsum, al);
			}

		}

	}

}