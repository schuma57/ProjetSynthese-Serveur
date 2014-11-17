package model;

public class Segment extends FormeSimple
{
	private Point p1;
	private Point p2;
	
	public Segment(Point a, Point b )
	{
		p1 = a;
		p2 = b;
	}
	
	public Segment(int x1, int x2, int y1, int y2)
	{
		p1 = new Point(x1, x2);
		p2 = new Point(y1, y2);
	}

	public Point getP1()
	{
		return p1;
	}
	
	public Point getp2()
	{
		return p2;
	}

	@Override
	void afficher() {
		// TODO Auto-generated method stub
		
	}
}
