package handlers;

import interfaces.DrawHandler;

public class DrawProcessor
{
	private DrawHandler prevHandler;
	private DrawHandler first;
	
	public void addHandler(DrawHandler handler)
	{
		if(this.first == null)
			this.first = handler;
		else
			prevHandler.setNext(handler);
		
		prevHandler = handler;
	}
	
	public void handleRequest(String forme)
	{
		first.handleRequest(forme);
	}
}
