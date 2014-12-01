package activerender;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.lang.reflect.Field;

import javax.swing.JFrame;

/**
 * <p> FrameActiveRender est la classe qui gère la fenêtre servant à afficher des formes géométriques.
 * Cette classe est en singleton. </p>
 *
 * @author iggiotti2u
 */

public class FrameActiveRender
{
	/**
	 * Hauteur de la fenêtre en pixels
	 */
	private final static int hauteur = 600;
	
	/**
	 * Largeur de la fenêtre en pixels
	 */
	private final static int largeur = 800;
    
	/**
     * Le graphics est nécessaire pour dessiner dans le fenêtre
     */
    private static Graphics graphics;
    
    /**
     * L'instance unique de la fenêtre
     */
    private static FrameActiveRender fenetre = null;
    
    /**
     * Constructeur de la fenêtre.
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
            graphics.drawLine(largeur / 2 - 5 , hauteur / 2, largeur / 2 + 5 , hauteur / 2);
            graphics.drawLine(largeur / 2 , hauteur / 2  - 5, largeur / 2  , hauteur / 2 + 5);
            graphics.drawString("O", largeur / 2 - 10, hauteur / 2 - 5);
            //graphics.dispose();
        }
        catch(InterruptedException e)
        {
            
        }
    } //end construct

    /**
     * 
     * @return l'instance unique de fenêtre.
     */
    public static FrameActiveRender getFenetre()
    {
    	if(fenetre == null)
    		fenetre = new FrameActiveRender();
    	
    	return fenetre;
    }
    
    /**
     * Création d'une awt.Color à partir d'une string
     * 
     * @param couleur
     * @return une awt.Color .
     */
    private static Color creerCouleur(String couleur)
	{
		Field field;
		Color ma_color = null;
		try
		{
			field = Class.forName("java.awt.Color").getField( couleur );
			ma_color = (Color)field.get(null);
		} catch (Exception e)
		{
			ma_color = null;
		}
		
		return ma_color;
	}
    
    /**
     * 
     * @return l'instance unique du graphics.
     */
    private static Graphics getGraphics()
    {
    	FrameActiveRender.getFenetre();
		return FrameActiveRender.graphics;
    }
    
    /**
     * Changer la couleur des formes à dessiner
     * 
     * @param couleur
     * @see FrameActiveRender#creerCouleur(String)
     */
    public static void changerCouleur(String couleur)
    {
    	getGraphics().setColor( creerCouleur(couleur) );
    }
    
    /**
     * Dessiner un segment dans la fenêtre
     * 
     * @param x1 : point 1
     * @param y1 : point 1
     * @param x2 : point 2
     * @param y2 : point 2
     */
    public static void dessinerLigne(int x1, int y1, int x2, int y2)
    {
    	getGraphics().drawLine(x1 + largeur/2, -y1 + hauteur/2,
    			x2 + largeur/2, -y2 + hauteur/2 );
    }
    
    /**
     * Dessiner un cercle dans la fenêtre
     * 
     * @param x : centre du cercle
     * @param y : centre du cercle
     * @param rayon
     */
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
