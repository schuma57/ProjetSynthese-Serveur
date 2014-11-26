package experts;

import activerender.FrameActiveRender;

public class ExpertDessinPolygone extends ExpertDessin
{	

	@Override
	public void expertAction(String forme)
	{
		String[] tabStrings = forme.split(" ");
		if( !tabStrings[0].equals("Poly") )
		{
			System.out.println("ce n'est pas un polygone");
			next.expertAction(forme);
		}
		else
		{   
			FrameActiveRender.changerCouleur(tabStrings[1]);
			for (int i = 2; i < tabStrings.length - 3; i = i+2) {
				FrameActiveRender.dessinerLigne(
						Integer.parseInt(tabStrings[i]),
						Integer.parseInt(tabStrings[i+1]),
						Integer.parseInt(tabStrings[i+2]),
						Integer.parseInt(tabStrings[i+3])
				);
			}
			
			FrameActiveRender.dessinerLigne(
					Integer.parseInt(tabStrings[2]),
					Integer.parseInt(tabStrings[3]),
					Integer.parseInt(tabStrings[tabStrings.length - 2]),
					Integer.parseInt(tabStrings[tabStrings.length - 1])
			);

			System.out.println("c'est un polygone !");
		}
	}

}
