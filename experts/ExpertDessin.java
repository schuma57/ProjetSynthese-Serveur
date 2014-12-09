package experts;

import activerender.FrameActiveRender;

/**
 * 
 * ExpertDessin est la classe mère qui va être héritée par toutes les classes de dessin de forme.
 * <p>Application du design pattern COR</p>
 * @author Florian
 */
public abstract class ExpertDessin
{
	protected ExpertDessin next = null;
	/**
	 * 
	 * @param forme : correspond à la requête envoyée par le client
	 * @param fen : fenêtre dans laquelle il faut dessiner la forme géométrique
	 */
	abstract void expertAction(String forme, FrameActiveRender fen);
	
	/**
	 * 
	 * @param expert
	 */
	public void setNext(ExpertDessin expert)
	{
		next = expert;
	}
}
