import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 *
 */

/**
 * @author bakkari
 *
 */
public class Recomm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String filePath = "mut.txt";

		int[][] mut;
		mut = new int[9][5];

		// lire le fichier Mut
		try {
			BufferedReader buff = new BufferedReader(new FileReader(filePath));


			//extraire les lignes et les mettre dans une liste
			String str;
			int i=0;

			try {
				while ((str = buff.readLine()) != null) {

					String[] str_tab = str.split(";");
					for (int j = 0; j < str_tab.length; j++) {
						mut[i][j] = Integer.parseInt(str_tab[j]);
					}
					i++;
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//affichage de la matrice mut
		System.out.println("################################### Matrice mut ####################################");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(mut[i][j]+";");
			}
			System.out.println("");

		}

		System.out.println("############################################################################################");
		System.out.println("");
		System.out.println("");

		System.out.println("################################### Matrice mut_binaire ####################################");
		int[][] mut_binaire;
		mut_binaire = new int[9][5];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 5; j++) {
				if(mut[i][j] == 0)
					mut_binaire[i][j] = 0;
				else
					mut_binaire[i][j] = 1;

			}
		}
		//affichage de la matrice mut_Binaire
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(mut_binaire[i][j]+";");
			}
			System.out.println("");

		}

		System.out.println("############################################################################################");
		System.out.println("");
		System.out.println("");

		System.out.println("################################### Matrice Mtt ####################################");
		double mtt[][];
		mtt = new double[5][5];
		double inter = 0;
		double union = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = i ; j < 5; j++) {
				if(i != j) {
					for (int k = 0; k < 9; k++) {
						if (mut_binaire[k][i] == mut_binaire[k][j] && mut_binaire[k][i]  == 1) {
							inter++;
						}
						if (mut_binaire[k][i] == 1 || mut_binaire[k][j]  == 1) {
							union++;
						}
					}

					mtt [i][j] = 1 - (inter/union);
					inter =0 ;
					union =0 ;
				}
			}
		}
		DecimalFormat df = new DecimalFormat ( ) ;
		df.setMaximumFractionDigits ( 2 ) ; //arrondi à 2 chiffres apres la virgules
		df.setMinimumFractionDigits ( 2 ) ;
		System.out.println("");

		//affichage de la matrice mtt
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(df.format(mtt[i][j])+"\t;\t");
			}
			System.out.println("");

		}
		System.out.println("############################################################################################");
		System.out.println("");
		System.out.println("");

		System.out.println("################################### Matrice Mtt_binaire ####################################");

		int[][] mtt_binaire;
		mtt_binaire = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = i; j < 5; j++) {
				if(mtt[i][j] < 0.5)
					mtt_binaire[i][j] = 1;
				else
					mtt_binaire[i][j] = 0;

			}
		}

		//affichagede la matrice mtt_binaire
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(mtt_binaire[i][j]+";");
			}
			System.out.println("");
		}
		System.out.println("############################################################################################");
		System.out.println("");
		System.out.println("");

		System.out.println("################################### Matrice MutR ###########################################");

		int[][] mutR;
		mutR = new int[9][5];

		for (int i = 0; i < 5; i++) {
			for (int j = i; j < 5; j++) {
				if(mtt_binaire[i][j] == 1 && i != j) {
					for (int k = 0; k < 9; k++) {
						if(mut_binaire[k][i] == 1 && mut_binaire[k][j] != 1) {
							mutR[k][j]=1;
						}
						if(mut_binaire[k][i] != 1 && mut_binaire[k][j] == 1) {
							mutR[k][i]=1;
						}
					}


				}


			}
		}

		//affichagede la matrice mutR
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(mutR[i][j]+";");
			}
			System.out.println("");
		}
		System.out.println("############################################################################################");
		System.out.println("");
		System.out.println("");



	}
}