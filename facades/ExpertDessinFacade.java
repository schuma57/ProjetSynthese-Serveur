package facades;

import activerender.FrameActiveRender;
import experts.ExpertDessin;
import experts.ExpertDessinCercle;
import experts.ExpertDessinPolygone;
import experts.ExpertDessinSegment;
import experts.ExpertDessinTriangle;
import experts.ExpertProcess;

/**
 * 
 * Design pattern fa�ade
 * <p>Cache la complexit� en instanciant un {@link ExpertProcess} et en l'initialisant de la sorte :</p>
 * <p>On traite une requ�te en testant si c'est un triangle, un segment, un cercle ou un polygone
 * </p>
 * @see ExpertDessinCercle
 * @see ExpertDessinPolygone
 * @see ExpertDessinSegment
 * @see ExpertDessinTriangle
 * @author Yacine
 */
public class ExpertDessinFacade
{
	/**
	 * ExpertProcess
	 * @see ExpertProcess
	 */
	private ExpertProcess processor;
	 
	/**
	 * Constructeur
	 */
	public ExpertDessinFacade()
	{
		createProcessor();
	}
	 
	/**
	 * Contruit la chaine de responsabilit�
	 * Les maillons sont li�s entre eux
	 */
	private void createProcessor()
	{
		processor = new ExpertProcess();
		processor.addExpert(new ExpertDessinTriangle());
		processor.addExpert(new ExpertDessinSegment());
		processor.addExpert(new ExpertDessinCercle());
		processor.addExpert(new ExpertDessinPolygone());
	}
	 
	/**
	 * 
	 * Ajoute un expert
	 * @param handler
	 * @see ExpertDessin
	 */
	public void addRule(ExpertDessin handler)
	{
		processor.addExpert(handler);
	}
	
	/**
	 * 
	 * @param forme : forme g�om�trique � dessiner
	 * @param fen : fen�tre dans laquelle dessiner la forme
	 */
	public void formeReceived(String forme, FrameActiveRender fen)
	{
		processor.expertAction(forme, fen);
	}
}
