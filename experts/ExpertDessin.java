package experts;

import activerender.FrameActiveRender;

/**
 * 
 * ExpertDessin est la classe m�re qui va �tre h�rit�e par toutes les classes de dessin de forme.
 * <p>Application du design pattern COR</p>
 * @author Florian
 */
public abstract class ExpertDessin
{
	protected ExpertDessin next = null;
	/**
	 * 
	 * @param forme : correspond � la requ�te envoy�e par le client
	 * @param fen : fen�tre dans laquelle il faut dessiner la forme g�om�trique
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
