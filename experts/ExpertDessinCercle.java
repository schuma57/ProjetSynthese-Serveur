package experts;

import activerender.FrameActiveRender;

public class ExpertDessinCercle extends ExpertDessin
{	
	
	@Override
	public void expertAction(String forme)
	{
		String[] tabStrings = forme.split(" ");
		if( !tabStrings[0].equals("Cer") )
		{
			System.out.println("ce n'est pas un cercle");
			next.expertAction(forme);
		}
		else
		{   
			FrameActiveRender.changerCouleur(tabStrings[1]) ;
			FrameActiveRender.dessinerCercle(
					Integer.parseInt(tabStrings[2]),
					Integer.parseInt(tabStrings[3]),
					Integer.parseInt(tabStrings[4])
			);
			System.out.println("c'est un cercle !");
		}
	}
}
