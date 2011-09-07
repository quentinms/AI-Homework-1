public class SolutionA {

	private static enum Letter {
		A, B, C, D, E, F, G, H, I
	};

	private static final int N = 4;

	private static void generate(Letter[] pass, int size) {

		/*
		 * No need to test Hint 3 as we can't have more than 3 C in a 4-letters
		 * word knowing that the last one is E or D
		 */
		/* Hint 1: If it's the last letter, it's either E or D */
		if (size == 1) {
			pass[N - size] = Letter.D;
			generate(pass, size - 1);
			pass[N - size] = Letter.E;
			generate(pass, size - 1);
		} else if (size != 0) {

			/*
			 * Hint 2 : If it is a C, it has to be I or F after it. As the last
			 * letter is E or D, C can't be at the penultimate position
			 */

			pass[N - size] = Letter.A;
			generate(pass, size - 1);
			pass[N - size] = Letter.B;
			generate(pass, size - 1);

			if (size > 2) {
				pass[N - size] = Letter.C;
				pass[N - (size - 1)] = Letter.I;
				generate(pass, size - 2);
				pass[N - (size - 1)] = Letter.F;
				generate(pass, size - 2);
			}

			pass[N - size] = Letter.D;
			generate(pass, size - 1);
			pass[N - size] = Letter.E;
			generate(pass, size - 1);
			pass[N - size] = Letter.F;
			generate(pass, size - 1);
			pass[N - size] = Letter.G;
			generate(pass, size - 1);
			pass[N - size] = Letter.H;
			generate(pass, size - 1);
			pass[N - size] = Letter.I;
			generate(pass, size - 1);

		} else {
			for (Letter l : pass) {
				System.out.print(l);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		generate(new Letter[N], N);
	}

}
