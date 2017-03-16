package test23;

import java.util.*;
import java.io.*;


public class UEFA16 {
        // ����һ����ΪClub���࣬
        // ��¼ĳ����ӵ���Ϣ
        // �������ơ����ҡ�����С�鼰С������
	public class Club {
		String name;
		String country;
		char group;
		int rank;
		
		public Club(String n, String c, char g, int r) {
			name = n;
			country = c;
			group = g;
			rank = r;
		}
		
		public String toString() {
			return name + "(" + group + rank + ")";
		}
	}
	
	public LinkedList<Club> pool1; // ���л��С���һ�����
	public LinkedList<Club> pool2; // ���л��С��ڶ������
	public int sum;
	
	public UEFA16() {
		pool1 = new LinkedList<Club>();
		pool2 = new LinkedList<Club>();
		sum = 0;
	}

        // ���ʮ��֧��ӵ���Ϣ��	
	public void loadClubs() {
		pool1.add(new Club("Arsenal", "England", 'A', 1));
		pool1.add(new Club("Napoli", "Italy", 'B', 1));
//		pool1.add(new Club("Barcelona", "Spain", 'C', 1));
//		pool1.add(new Club("Atletico", "Spain", 'D', 1));
//		pool1.add(new Club("Monaco", "France", 'E', 1));
//		pool1.add(new Club("Dortmund", "Germany", 'F', 1));
//		pool1.add(new Club("Leiceter", "England", 'G', 1));
//		pool1.add(new Club("Juventus", "Italy", 'H', 1));
		
//		pool2.add(new Club("Paris", "France", 'A', 2));
//		pool2.add(new Club("Benfica", "Portugal", 'B', 2));
//		pool2.add(new Club("ManCity", "England", 'C', 2));
//		pool2.add(new Club("Bayern", "Germany", 'D', 2));
//		pool2.add(new Club("Leverkusen", "Germany", 'E', 2));
//		pool2.add(new Club("RealMadrid", "Spain", 'F', 2));
		pool2.add(new Club("Porto", "Portugal", 'G', 2));
		pool2.add(new Club("Sevilla", "Spain", 'H', 2));
	}

        // ���г����п��ܵĳ�ǩ��ϣ�������Щ�����ӡ��ָ���ļ���
	public void draw(String filename) throws FileNotFoundException {
		PrintStream output = new PrintStream(new File(filename));
		drawHelper(pool1, pool2, new LinkedList<Club>(), output);
	}

        // ������ǩ	
	private void drawHelper(LinkedList<Club> pool1,
			                LinkedList<Club> pool2,
					        LinkedList<Club> chosen,
					        PrintStream output) {
		if (pool1.isEmpty()) {
			printHelper(output, chosen);
			output.println();
			sum++;
		} else {
			Club c1 = pool1.removeFirst();
			chosen.add(c1);
			for (int i = 0; i < pool2.size(); i++) {
				Club c2 = pool2.remove(i);
				if (c1.group != c2.group && !c1.country.equals(c2.country)) { // ͬ���ܡ�ͬ�����
					chosen.add(c2);
					drawHelper(pool1, pool2, chosen, output);
					chosen.removeLast();
				}
				pool2.add(i, c2);
			}
			chosen.removeLast();
			pool1.addFirst(c1);
		}
	}
        
        // ������ӡ��ǩ�����	
	private void printHelper(PrintStream output, LinkedList<Club> chosen) {
		for (int i = 0; i < chosen.size() / 2; i++) {
			output.println(chosen.get(i * 2) + " vs " + chosen.get(i * 2 + 1));
		}
	}

        // ��ȡ��ͳ�Ƴ�ǩ�����������ʣ���ӡ��
	public void getProbs(String filename1, String filename2) throws FileNotFoundException {
		Scanner input = new Scanner(new File(filename1));
		double[][] stats = new double[pool1.size()][pool2.size()];
		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (!line.isEmpty()) {
				String[] oneMatch = line.split(" ");
				int i = oneMatch[0].charAt(oneMatch[0].length() - 3) - 'A';
				int j = oneMatch[2].charAt(oneMatch[2].length() - 3) - 'A';
				stats[i][j]++;
			}
		}
		for (int i = 0; i < pool1.size(); i++) {
			for (int j = 0; j < pool2.size(); j++) {
				stats[i][j] /= sum;
			}
		}
		PrintStream output = new PrintStream(new File(filename2));
		output.print("                ");
		for (int i = 0; i < pool2.size(); i++) {
			output.printf("%-16s", pool2.get(i));
		}
		
		for (int i = 0; i < pool1.size(); i++) {
			output.println();
			output.printf("%-16s", pool1.get(i));
			for (int j = 0; j < pool2.size(); j++) {
				output.printf("%-16.6f", stats[i][j]);
			}
		}
	}
	
        // ȫ��������һ��ɣ�	
	public static void main(String[] args) throws FileNotFoundException {
		UEFA16 uefa = new UEFA16();
		uefa.loadClubs();
		uefa.draw("draw.txt"); // ����ǩ�����ӡ��draw.txt
		//uefa.getProbs("draw.txt", "prob.txt"); // ��ȡdraw.txt�� ���������prob.txt�� 
	}
}