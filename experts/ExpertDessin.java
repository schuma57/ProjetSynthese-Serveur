package experts;


public abstract class ExpertDessin
{
	protected ExpertDessin next = null;
	
	abstract void expertAction(String forme);
	
	
	public void setNext(ExpertDessin expert)
	{
		next = expert;
	}
}
