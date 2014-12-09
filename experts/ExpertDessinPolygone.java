package experts;

import activerender.FrameActiveRender;

/**
 * 
 * Hérite de ExpertDessin
 * <p>Permet de traiter des requêtes demandant l'affichage d'un polygone</p>
 * @author Yacine
 */
public class ExpertDessinPolygone extends ExpertDessin
{	


	/**
	 * 
	 * @see ExpertDessin
	 * @see FrameActiveRender#dessinerLigne
	 * @see FrameActiveRender#changerCouleur
	 **/
	@Override
	public void expertAction(String forme, FrameActiveRender fen)
	{
		String[] tabStrings = forme.split(" ");
		if( !tabStrings[0].equals("Poly") )
		{
			//System.out.println("ce n'est pas un polygone");
			next.expertAction(forme, fen);
		}
		else
		{   
			fen.changerCouleur(tabStrings[1]);
			for (int i = 2; i < tabStrings.length - 3; i = i+2) {
				fen.dessinerLigne(
						(int)Double.parseDouble(tabStrings[i]),
						(int)Double.parseDouble(tabStrings[i+1]),
						(int)Double.parseDouble(tabStrings[i+2]),
						(int)Double.parseDouble(tabStrings[i+3])
				);
			}
			
			fen.dessinerLigne(
					(int)Double.parseDouble(tabStrings[2]),
					(int)Double.parseDouble(tabStrings[3]),
					(int)Double.parseDouble(tabStrings[tabStrings.length - 2]),
					(int)Double.parseDouble(tabStrings[tabStrings.length - 1])
			);

			System.out.println("c'est un polygone !");
		}
	}

}
