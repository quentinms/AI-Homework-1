public class SolutionB {

	private static enum Letter {
		A, B, C, D, E, F, G, H, I
	};

	private static int N;
	private static long numberOfSolutions = 0;

	private static void generate(Letter[] pass, int size, int nbOfC) {

		/* Hint 1: If it's the last letter, it's either E or D */
		if (size == 1) {
			pass[N - size] = Letter.D;
			generate(pass, size - 1, nbOfC);
			pass[N - size] = Letter.E;
			generate(pass, size - 1, nbOfC);
		} else if (size != 0) {

			/*
			 * Hint 2 : If it is a C, it has to be I or F after it. As the last
			 * letter is E or D, C can't be at the penultimate position
			 * 
			 * Hint 3 :If there is already 3 C, we can't add more.
			 */

			pass[N - size] = Letter.A;
			generate(pass, size - 1, nbOfC);
			pass[N - size] = Letter.B;
			generate(pass, size - 1, nbOfC);

			if (size > 2) {
				if (nbOfC < 3) {
					pass[N - size] = Letter.C;
					pass[N - (size - 1)] = Letter.I;
					generate(pass, size - 2, nbOfC + 1);
					pass[N - (size - 1)] = Letter.F;
					generate(pass, size - 2, nbOfC + 1);
				}
			}

			pass[N - size] = Letter.D;
			generate(pass, size - 1, nbOfC);
			pass[N - size] = Letter.E;
			generate(pass, size - 1, nbOfC);
			pass[N - size] = Letter.F;
			generate(pass, size - 1, nbOfC);
			pass[N - size] = Letter.G;
			generate(pass, size - 1, nbOfC);
			pass[N - size] = Letter.H;
			generate(pass, size - 1, nbOfC);
			pass[N - size] = Letter.I;
			generate(pass, size - 1, nbOfC);

		} else {
			numberOfSolutions++;
		}
	}

	public static void main(String[] args) {
		N = Integer.parseInt(args[0]); // Get N from command line arguments.
		generate(new Letter[N], N, 0);
		System.out.println(numberOfSolutions);
	}

}
