package facades;

import interfaces.DrawHandler;
import handlers.*;

public class DrawHandlerFacade
{
	private DrawProcessor processor;
	 
	public DrawHandlerFacade()
	{
		createProcessor();
	}
	 
	private void createProcessor()
	{
		processor = new DrawProcessor();
		processor.addHandler(new TriangleDrawHandler());
		processor.addHandler(new SegmentDrawHandler());
		processor.addHandler(new CircleDrawHandler());
		processor.addHandler(new PolygoneDrawHandler());
	}
	 
	public void addRule(DrawHandler handler)
	{
		processor.addHandler(handler);
	}
	
	public void formeReceived(String forme)
	{
		processor.handleRequest(forme);
	}
}
