package activerender;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.lang.reflect.Field;

import javax.swing.JFrame;

/**
 *
 * @author iggiotti2u
 */
public class FrameActiveRender
{
	private final static int hauteur = 600;
	private final static int largeur = 800;
    private static Graphics graphics;
    private static FrameActiveRender fenetre = null;
    
    /**
     * @param args the command line arguments
     */
    private FrameActiveRender()
    {
        try
        {
            JFrame fen = new JFrame("Dessin de formes geometriques");
            fen.setBounds(30, 30, largeur, hauteur);
            fen.setVisible(true);
            fen.setIgnoreRepaint(true);

            Canvas canvas = new Canvas();
            int numBuffers = 1;
            canvas.createBufferStrategy(numBuffers);
            fen.add(canvas);

            Thread.sleep(500);
            
            BufferStrategy strategie = canvas.getBufferStrategy();
            
            graphics = strategie.getDrawGraphics();
            
            //graphics.dispose();
        }
        catch(InterruptedException e)
        {
            
        }
    } //end construct

    public static FrameActiveRender getFenetre()
    {
    	if(fenetre == null)
    		fenetre = new FrameActiveRender();
    	
    	return fenetre;
    }
    
    private static Color creerCouleur(String s)
	{
		Field field;
		Color ma_color = null;
		try
		{
			field = Class.forName("java.awt.Color").getField( s );
			ma_color = (Color)field.get(null);
		} catch (Exception e)
		{
			ma_color = null;
		}
		
		return ma_color;
	}
    
    private static Graphics getGraphics()
    {
    	FrameActiveRender.getFenetre();
		return FrameActiveRender.graphics;
    }
    
    
    public static void changerCouleur(String couleur)
    {
    	getGraphics().setColor( creerCouleur(couleur) );
    }
    
    public static void dessinerLigne(int x1, int y1, int x2, int y2)
    {
    	getGraphics().drawLine(x1 + largeur/2, -y1 + hauteur/2,
    			x2 + largeur/2, -y2 + hauteur/2 );
    }
    
    public static void dessinerCercle(int x, int y, int rayon)
    {
    	getGraphics().drawOval(
				(x + largeur/2) - (rayon/2) ,
				(-y + hauteur/2) - (rayon/2),
				rayon,
				rayon
		);
    }
    
}
