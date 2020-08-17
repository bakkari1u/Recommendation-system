
import java.io.*;
import java.util.*;

public class MUT {
	
	
	public void tester(String user,String theme,int nbr){
		/*faur le nombre d'un user dans link égal le nombre se users dans le fichier log */
		
	}
	
	
	public static void main (String args[]) throws IOException {
		
		Vector<String> Users = new Vector<String>();
		Vector<String> Themes = new Vector<String>();
		HashMap<String, Integer> link= new HashMap<String,Integer>();
		
		
		// l'ouverture ,lecture de fichier.
		InputStream flux=new FileInputStream("log_clients_themes.txt"); 
		InputStreamReader lecture=new InputStreamReader(flux);
		BufferedReader buff=new BufferedReader(lecture);
		String ligne;
		
		
		/* lire le fichier ,déposer son contenus dans deux vector : un contient les users ,l'autre contient les themes */
		while ((ligne=buff.readLine())!=null){
			String[] contenus = ligne.split(";");
			if(contenus.length == 3){
				if(!Users.contains(contenus[1])){
					Users.add(contenus[1]);
				}
					
					
				if(!Themes.contains(contenus[2])){
					Themes.add(contenus[2]);
				}
					
			}
		}
		/**/
		
		
		
		/* créer un fichier qui contient le link combien fois un users utilise un thémes*/
		FileWriter FileLink = new FileWriter(new File("link.txt"));
		for(String u : Users){
			for(String t : Themes){
				String them;
				int nbr=0;
				
				InputStream fluxs=new FileInputStream("log_clients_themes.txt"); 
				InputStreamReader lectures=new InputStreamReader(fluxs);
				BufferedReader buffs=new BufferedReader(lectures);
				String h;
				while ((h=buffs.readLine())!=null){
						String[] linkTest = h.split(";");
						if(linkTest.length == 3){
							if(linkTest[1].equals(u) && linkTest[2].equals(t)){
								nbr++;
								
							}
						}
					}
				
				FileLink.write(""+nbr+" ");
			}
			FileLink.write("\n");
		}
		FileLink.close();
		
			
		/* ecrire dans les fichiers , un contient les users , autre contient les themes */
		FileWriter FileUsers = new FileWriter(new File("Users.txt"));
		FileWriter FileThemes = new FileWriter(new File("Themes.txt"));
		
		for(String us : Users){
			FileUsers.write(us);
			FileUsers.write("\n");
		}
		for(String th : Themes){
			FileThemes.write(th);
			FileThemes.write("\n");
		}
		FileUsers.close();
		FileThemes.close();
		
		
		
	}
}