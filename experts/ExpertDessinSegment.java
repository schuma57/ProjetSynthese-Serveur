package experts;

import activerender.FrameActiveRender;

public class ExpertDessinSegment extends ExpertDessin
{	

	@Override
	public void expertAction(String forme)
	{
		String[] tabStrings = forme.split(" ");
		if( !tabStrings[0].equals("Seg") )
		{
			System.out.println("ce n'est pas un segment");
			next.expertAction(forme);
		}
		else
		{
			FrameActiveRender.changerCouleur(tabStrings[1]);
			System.out.println("c'est un segment !");
			FrameActiveRender.dessinerLigne(
					Integer.parseInt(tabStrings[2]),
					Integer.parseInt(tabStrings[3]),
					Integer.parseInt(tabStrings[4]),
					Integer.parseInt(tabStrings[5])
			);
		}
	}
}
