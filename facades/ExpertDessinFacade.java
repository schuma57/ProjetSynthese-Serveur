package facades;

import experts.*;

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
	 
	private void createProcessor()
	{
		processor = new ExpertProcess();
		processor.addExpert(new ExpertDessinTriangle());
		processor.addExpert(new ExpertDessinSegment());
		processor.addExpert(new ExpertDessinCercle());
		processor.addExpert(new ExpertDessinPolygone());
	}
	 
	/**
	 * Ajoute un expert
	 * @param handler
	 * @see ExpertDessin
	 */
	public void addRule(ExpertDessin handler)
	{
		processor.addExpert(handler);
	}
	
	public void formeReceived(String forme)
	{
		processor.expertAction(forme);
	}
}
