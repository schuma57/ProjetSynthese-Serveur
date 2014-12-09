package experts;

import activerender.FrameActiveRender;

/**
 * 
 * Hérite de ExpertDessin
 * <p>Permet de traiter des requêtes demandant l'affichage d'un segment</p>
 * @author Florian
 */
public class ExpertDessinSegment extends ExpertDessin
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
		if( !tabStrings[0].equals("Seg") )
		{
			//System.out.println("ce n'est pas un segment");
			next.expertAction(forme, fen);
		}
		else
		{
			fen.changerCouleur(tabStrings[1]);
			System.out.println("c'est un segment !");
			fen.dessinerLigne(
					Integer.parseInt(tabStrings[2]),
					Integer.parseInt(tabStrings[3]),
					Integer.parseInt(tabStrings[4]),
					Integer.parseInt(tabStrings[5])
			);
		}
	}
}
