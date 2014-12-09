package experts;

import activerender.FrameActiveRender;

/**
 * 
 * Cette classe renvoie au design pattern COR (Chain of responsibility)
 * <p>Cette classe permet de cr�er la liste cha�n�e d'experts de dessin pour traiter une requ�te venant du client</p>
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
	 * @param forme : forme g�om�trique � dessiner
	 * @param fen : fen�tre dans laquelle dessiner la forme g�om�trique
	 */
	public void expertAction(String forme, FrameActiveRender fen)
	{
		premier.expertAction(forme, fen);
	}
}
