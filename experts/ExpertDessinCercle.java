package experts;

import activerender.FrameActiveRender;

/**
 * 
 * Hérite de ExpertDessin
 * <p>Permet de traiter des requêtes demandant l'affichage d'un cercle</p>
 * @author Florian
 */
public class ExpertDessinCercle extends ExpertDessin
{	
	

	/**
	 * 
	 * @see ExpertDessin
	 * @see FrameActiveRender#dessinerCercle
	 * @see FrameActiveRender#changerCouleur
	 **/
	@Override
	public void expertAction(String forme, FrameActiveRender fen)
	{
		String[] tabStrings = forme.split(" ");
		if( !tabStrings[0].equals("Cer") )
		{
			//System.out.println("ce n'est pas un cercle");
			next.expertAction(forme, fen);
		}
		else
		{   
			fen.changerCouleur(tabStrings[1]) ;
			fen.dessinerCercle(
					(int)Double.parseDouble(tabStrings[2]),
					(int)Double.parseDouble(tabStrings[3]),
					(int)Double.parseDouble(tabStrings[4])
			);
			System.out.println("c'est un cercle !");
		}
	}
}
