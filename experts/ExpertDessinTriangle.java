package experts;

import activerender.FrameActiveRender;

/**
 * 
 * Herite de ExpertDessin
 * <p>Permet de traiter des requêtes demandant l'affichage d'un triangle</p>
 * @author Yacine
 */
public class ExpertDessinTriangle extends ExpertDessin
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
		if( !tabStrings[0].equals("Tri") )
		{
			//System.out.println("ce n'est pas un triangle");
			next.expertAction(forme, fen);
		}
		else
		{   
			fen.changerCouleur(tabStrings[1]);
			System.out.println("c'est un triangle !");
			fen.dessinerLigne(
					(int)Double.parseDouble(tabStrings[2]),
					(int)Double.parseDouble(tabStrings[3]),
					(int)Double.parseDouble(tabStrings[4]),
					(int)Double.parseDouble(tabStrings[5])
			);
			fen.dessinerLigne(
					(int)Double.parseDouble(tabStrings[4]),
					(int)Double.parseDouble(tabStrings[5]),
					(int)Double.parseDouble(tabStrings[6]),
					(int)Double.parseDouble(tabStrings[7])
			);
			fen.dessinerLigne(
					(int)Double.parseDouble(tabStrings[2]),
					(int)Double.parseDouble(tabStrings[3]),
					(int)Double.parseDouble(tabStrings[6]),
					(int)Double.parseDouble(tabStrings[7])
			);
		}		
	}
}
