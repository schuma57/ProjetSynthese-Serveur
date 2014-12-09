package experts;

import activerender.FrameActiveRender;

/**
 * 
 * Cette classe renvoie au design pattern COR (Chain of responsibility)
 * <p>Cette classe permet de créer la liste chaînée d'experts de dessin pour traiter une requête venant du client</p>
 * @see ExpertDessin
 * @author Yacine
 */
public class ExpertProcess
{
	private ExpertDessin prevExpert;
	private ExpertDessin premier;
	
	/**
	 * 
	 * @param expert
	 */
	public void addExpert(ExpertDessin expert)
	{
		if(this.premier == null)
			this.premier = expert;
		else
			prevExpert.setNext(expert);
		
		prevExpert = expert;
	}
	
	/**
	 * 
	 * @param forme : forme géométrique à dessiner
	 * @param fen : fenêtre dans laquelle dessiner la forme géométrique
	 */
	public void expertAction(String forme, FrameActiveRender fen)
	{
		premier.expertAction(forme, fen);
	}
}
