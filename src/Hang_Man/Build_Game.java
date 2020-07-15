package Hang_Man;

import java.util.Random;
import java.util.Scanner;

public class Build_Game {
	private static final String[] str = {"TRANQUOCTUAN","LYTHUONGKIET","LELOI","DINHBOLINH"};
	private static final String[] str1 = {"TRAN QUOC TUAN","LY THUONG KIET","LE LOI","DINH BO LINH"};
	private String[] a;
	private int l;
	private int mark = 5;
	Scanner scanner = new Scanner(System.in);
	/*
	 * Step 1: Tao man choi
	 */
	public void creat_Game() {
		Random random = new Random();
		l = random.nextInt(4);
		a = new String[str[l].length()];
		for (int k = 0;k<str[l].length();k++) {
			a[k]="  ";
		}
		for (int k = 0;k<a.length;k++) {
			System.out.print(a[k]+"  |");
		}
	}
	public void output() {
		for (int i = 0;i<a.length;i++) {
			System.out.print(a[i]+"  |");
		}
		System.out.println("\nSo diem cua ban la: "+mark);
	}
	public boolean check() {
		for (int i = 0;i<a.length;i++) {
			if (a[i].equals("  ")) return false;
		}
		return true;
	}
	/*
	 * Step 2: Choi
	 */
	public void play_Game() {
		while(mark>0) {
		System.out.println("\nMoi nhap chu cai: ");
		String p = scanner.next();
		if (str[l].contains(p)||str[l].contains(p.toUpperCase())) {
			for (int i = 0;i<a.length;i++) {
				if (str[l].charAt(i)==p.charAt(0)||str[l].charAt(i)==p.toUpperCase().charAt(0)) {
					 a[i] = p.toUpperCase();
					 mark++;
				}
			 }
			this.output();
			if (check()) {
				System.out.println("You win!!");
				System.out.println("Ket qua la: "+str1[l]);
				return;
			}
		}
		else {
			System.out.println("Khong co chu cai nay!!\nBan bi tru 1 diem");
			mark--;
			this.output();
		}
	}
		System.out.println("Ban khong con diem nao ca!!!\nYou lose!!");
} 
	public static void main(String args[]) {
		Build_Game b = new Build_Game();
		System.out.println("Day la 1 trong nhung tuong linh cua Viet Nam\n\n");
		b.creat_Game();
		b.play_Game();
	}
}
