package activerender;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author iggiotti2u
 */
public class FrameActiveRender
{
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
            fen.setBounds(30, 60, 400, 400);
            fen.setVisible(true);
            fen.setIgnoreRepaint(true);

            Canvas canvas = new Canvas();
            int numBuffers = 1;
            canvas.createBufferStrategy(numBuffers);
            fen.add(canvas);

            Thread.sleep(500);
            
            BufferStrategy strategie = canvas.getBufferStrategy();
            
            graphics = strategie.getDrawGraphics();
            
            //graphics.drawLine(1, 1, 100, 1);
            //graphics.drawLine(30, 100, 100, 30);
            
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
    
    public static Graphics getGraphics()
    {
    	FrameActiveRender.getFenetre();
		return FrameActiveRender.graphics;
    }
    
    public void dessinerLigne(int x1, int y1, int x2, int y2)
    {
    	graphics.drawLine(x1, y1, x2, y2);
    	graphics.dispose();
    }
}
