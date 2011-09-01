public class SolutionBPrime {

	private enum Letter {
		A, B, C, D, E, F, G, H, I
	};

	private static int N;
	private int numberOfSolutions = 0;

	public void generate(Letter[] pass, int size, int nbOfC) {
		if (size != 0) {
			for (Letter l : Letter.values()) {
				/* Hint 1: If it's the last letter, it's either E or D */
				if (size == 1) {
					if (l == Letter.D || l == Letter.E) {
						pass[N - size] = l;
						generate(pass, size - 1, nbOfC);
					}
					/*
					 * Hint 2 : If it is a C, it has to be I or F after it. As
					 * the last letter is E or D, C can't be at the penultimate
					 * position
					 * 
					 * Hint 3 :If there is already 3 C, we can't add more. 
					 */
				} else if (l == Letter.C) {
					if (size > 2) {
						if (nbOfC < 3) {	
							pass[N - size] = l;
							pass[N - (size - 1)] = Letter.I;
							generate(pass, size - 2, nbOfC+1);
							pass[N - (size - 1)] = Letter.F;
							generate(pass, size - 2, nbOfC+1);
						}
					}
				} else {
					pass[N - size] = l;
					generate(pass, size - 1, nbOfC);
				}

			}
		} else {
				numberOfSolutions++;
		}
	}

	public static void main(String[] args) {
		N = Integer.parseInt(args[0]); //Get N from command line arguments.
		SolutionBPrime sb = new SolutionBPrime();
		Letter[] l = new Letter[N];
		sb.generate(l, N, 0);
		System.out.println(sb.numberOfSolutions);
	}

}
