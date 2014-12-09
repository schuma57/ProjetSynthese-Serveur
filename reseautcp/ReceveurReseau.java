package reseautcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import activerender.FrameActiveRender;
import facades.ExpertDessinFacade;


/**
 * Herite de la classe Thread
 * <p>On instancie cette classe pour chaque client.</p>
 */
public class ReceveurReseau extends Thread
{
    Socket socket;
    int noConnexion; 	// numero du client distant
    BufferedReader fluxEntrant;

    /**
    * Suppose socket deja  connecté vers le client n° noConnexion
     * @param noConnexion : n° du client
     * */
    public ReceveurReseau(Socket socket, ThreadGroup groupe, int noConnexion)
        throws IOException
    {
        super(groupe,"ReceveurReseau");
        this.socket = socket;
        this.noConnexion = noConnexion;

        fluxEntrant = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        /* à  présent fluxEntrant est pret pour lire du texte provenant du client */
    }

    @Override
	public void run()
    {
        String ligne;
        ExpertDessinFacade facade = new ExpertDessinFacade();
        FrameActiveRender fenetre = new FrameActiveRender(noConnexion);
        
        try
        {
            while (!isInterrupted())
            {		
                ligne = fluxEntrant.readLine(); // saisit le texte du client
                System.out.print(" le client n° "+this.noConnexion+" a envoyé : \n");
                
                facade.formeReceived(ligne, fenetre);
                sleep(4);
            }
        }
        catch(InterruptedException erreur)
        { /* le thread s'arrete */
        }
        catch(IOException erreur)
        {
            //System.err.print(" on ne peut pas lire sur le socket provenant du client\n");
        	System.out.println("le thread s'arrete");
        	interrupt();
        }
 
    }// run
}
