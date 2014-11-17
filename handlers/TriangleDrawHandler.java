package handlers;

import activerender.FrameActiveRender;
import interfaces.DrawHandler;

public class TriangleDrawHandler implements DrawHandler
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
		if( !tabStrings[0].equals("Tri") )
		{
			System.out.println("ce n'est pas un triangle");
			next.handleRequest(forme);
		}
		else
		{
			System.out.println("c'est un triangle !");
			FrameActiveRender.getGraphics().drawLine(
					Integer.parseInt(tabStrings[1]),
					Integer.parseInt(tabStrings[2]),
					Integer.parseInt(tabStrings[3]),
					Integer.parseInt(tabStrings[4])
			);
			FrameActiveRender.getGraphics().drawLine(
					Integer.parseInt(tabStrings[3]),
					Integer.parseInt(tabStrings[4]),
					Integer.parseInt(tabStrings[5]),
					Integer.parseInt(tabStrings[6])
			);
			FrameActiveRender.getGraphics().drawLine(
					Integer.parseInt(tabStrings[1]),
					Integer.parseInt(tabStrings[2]),
					Integer.parseInt(tabStrings[5]),
					Integer.parseInt(tabStrings[4])
			);
		}
			
	}
}
