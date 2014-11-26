package experts;


public class ExpertProcess
{
	private ExpertDessin prevExpert;
	private ExpertDessin premier;
	
	public void addExpert(ExpertDessin expert)
	{
		if(this.premier == null)
			this.premier = expert;
		else
			prevExpert.setNext(expert);
		
		prevExpert = expert;
	}
	
	public void expertAction(String forme)
	{
		premier.expertAction(forme);
	}
}