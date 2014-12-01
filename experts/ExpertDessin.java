package experts;

import activerender.FrameActiveRender;


public abstract class ExpertDessin
{
	protected ExpertDessin next = null;
	
	abstract void expertAction(String forme, FrameActiveRender fen);
	
	
	public void setNext(ExpertDessin expert)
	{
		next = expert;
	}
}
