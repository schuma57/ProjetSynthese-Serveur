package activerender;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.lang.reflect.Field;

import javax.swing.JFrame;

/**
 * 
 * <p> FrameActiveRender est la classe qui gère la fenêtre servant à afficher des formes géométriques.
 * </p>
 *
 * @author Yacine
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
    private Graphics graphics;
    
    /**
     * 
     * Constructeur de la fenêtre.
     * @param nbConnexion : numero de connexion (present dans le titre de la fenetre)
     * Le repere prend son origine au milieu de la fenetre.
     */
    public FrameActiveRender(int nbConnexion)
    {
        try
        {
            JFrame fen = new JFrame("Dessin de formes geometriques, connexion nb " +nbConnexion);
            fen.setBounds(30, 30, largeur, hauteur);
            fen.setResizable(false);
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
     * Création d'une awt.Color à partir d'une string
     * 
     * @param couleur
     * @return une awt.Color .
     */
    private Color creerCouleur(String couleur)
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
     * @return l'instance du graphics.
     */
    private Graphics getGraphics()
    {
		return graphics;
    }
    
    /**
     * Changer la couleur des formes à dessiner
     * 
     * @param couleur
     * @see FrameActiveRender#creerCouleur(String)
     */
    public void changerCouleur(String couleur)
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
    public void dessinerLigne(int x1, int y1, int x2, int y2)
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
    public void dessinerCercle(int x, int y, int rayon)
    {
    	getGraphics().drawOval(
				(x + largeur/2) - (rayon/2) ,
				(-y + hauteur/2) - (rayon/2),
				rayon,
				rayon
		);
    }
    
}
