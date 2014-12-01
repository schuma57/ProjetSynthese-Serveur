package experts;

import activerender.FrameActiveRender;

public class ExpertDessinTriangle extends ExpertDessin
{	

	@Override
	public void expertAction(String forme, FrameActiveRender fen)
	{
		String[] tabStrings = forme.split(" ");
		if( !tabStrings[0].equals("Tri") )
		{
			System.out.println("ce n'est pas un triangle");
			next.expertAction(forme, fen);
		}
		else
		{   
			fen.changerCouleur(tabStrings[1]);
			System.out.println("c'est un triangle !");
			fen.dessinerLigne(
					Integer.parseInt(tabStrings[2]),
					Integer.parseInt(tabStrings[3]),
					Integer.parseInt(tabStrings[4]),
					Integer.parseInt(tabStrings[5])
			);
			fen.dessinerLigne(
					Integer.parseInt(tabStrings[4]),
					Integer.parseInt(tabStrings[5]),
					Integer.parseInt(tabStrings[6]),
					Integer.parseInt(tabStrings[7])
			);
			fen.dessinerLigne(
					Integer.parseInt(tabStrings[2]),
					Integer.parseInt(tabStrings[3]),
					Integer.parseInt(tabStrings[6]),
					Integer.parseInt(tabStrings[7])
			);
		}
			
	}
}
