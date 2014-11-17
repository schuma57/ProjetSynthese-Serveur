package handlers;

import activerender.FrameActiveRender;
import interfaces.DrawHandler;

public class SegmentDrawHandler implements DrawHandler
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
		if( !tabStrings[0].equals("Seg") )
		{
			System.out.println("ce n'est pas un segment");
			next.handleRequest(forme);
		}
		else
		{
			System.out.println("c'est un segment !");
			FrameActiveRender.getGraphics().drawLine(
					Integer.parseInt(tabStrings[1]),
					Integer.parseInt(tabStrings[2]),
					Integer.parseInt(tabStrings[3]),
					Integer.parseInt(tabStrings[4])
			);
		}
	}
}
