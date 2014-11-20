package handlers;

import activerender.FrameActiveRender;
import interfaces.DrawHandler;

public class PolygoneDrawHandler implements DrawHandler
{
	private DrawHandler next;
	
	@Override
	public void setNext(DrawHandler handler)
	{
		next = handler;
	}

	@Override
	public void handleRequest(String forme)
	{
		String[] tabStrings = forme.split(" ");
		if( !tabStrings[0].equals("Poly") )
		{
			System.out.println("ce n'est pas un polygone");
			next.handleRequest(forme);
		}
		else
		{
			for (int i = 1; i < tabStrings.length - 3; i = i+2) {
				FrameActiveRender.getGraphics().drawLine(
						Integer.parseInt(tabStrings[i]),
						Integer.parseInt(tabStrings[i+1]),
						Integer.parseInt(tabStrings[i+2]),
						Integer.parseInt(tabStrings[i+3])
				);
			}
			
			FrameActiveRender.getGraphics().drawLine(
					Integer.parseInt(tabStrings[1]),
					Integer.parseInt(tabStrings[2]),
					Integer.parseInt(tabStrings[tabStrings.length - 2]),
					Integer.parseInt(tabStrings[tabStrings.length - 1])
			);

			System.out.println("c'est un polygone !");
		}
	}

}
