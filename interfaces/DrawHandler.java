package interfaces;

public interface DrawHandler
{
	public void setNext(DrawHandler handler);
	public void handleRequest(String forme);
}
