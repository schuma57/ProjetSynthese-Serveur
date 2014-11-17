package handlers;

import activerender.FrameActiveRender;
import interfaces.DrawHandler;

public class CircleDrawHandler implements DrawHandler
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
		if( !tabStrings[0].equals("Cer") )
		{
			System.out.println("ce n'est pas un cercle");
			next.handleRequest(forme);
		}
		else
		{
			FrameActiveRender.getGraphics().drawOval(
					Integer.parseInt(tabStrings[1]) - Integer.parseInt(tabStrings[3]),
					//Integer.parseInt(tabStrings[2]) - Integer.parseInt(tabStrings[3]),
					Integer.parseInt(tabStrings[2]) - (Integer.parseInt(tabStrings[3])/2), 	//remplace celle du dessus
					Integer.parseInt(tabStrings[3]),
					Integer.parseInt(tabStrings[3])
			);
			System.out.println("c'est un cercle !");
		}
	}
}
