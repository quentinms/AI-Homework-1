public class SolutionB {

	/*Naive Algorithm, generates all possible possibilities and then checks which ones are correct*/

	
	private enum Letter {
		A, B, C, D, E, F, G, H, I
	};

	private static int N;
	private int numberOfSolutions = 0;

	public boolean check(Letter[] pass) {
		return checkLastLetter(pass) && checkNumberOfC(pass)
				&& check2ndCondition(pass);
	}

	public boolean checkLastLetter(Letter[] pass) {
		if (pass[N - 1] == Letter.E || pass[N - 1] == Letter.D) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkNumberOfC(Letter[] pass) {
		int numberOfC = 0;
		for (Letter l : pass) {
			if (l == Letter.C)
				numberOfC++;
			if (numberOfC == 4)
				return false;
		}
		return true;
	}

	public boolean check2ndCondition(Letter[] pass) {

		for (int i = 0; i < pass.length - 1; i++) {
			if (pass[i] == Letter.C && pass[i + 1] != Letter.I
					&& pass[i + 1] != Letter.F) {
				return false;
			}
		}

		return true;
	}

	public void generate(Letter[] pass, int size) {
		if (size != 0)
			for (Letter l : Letter.values()) {
				pass[N - size] = l;
				generate(pass, size - 1);
			}
		else {
			if (check(pass)) {
				numberOfSolutions++;
			}
		}
	}

	public static void main(String[] args) {
		N = Integer.parseInt(args[0]);
		SolutionB sb = new SolutionB();
		Letter[] l = new Letter[N];
		sb.generate(l, N);
		System.out.println(sb.numberOfSolutions);
	}

}