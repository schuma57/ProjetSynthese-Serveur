package testreseau;

import facades.DrawHandlerFacade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.PrintStream;
import java.net.Socket;


/**
 *
 * @author iggiotti2u
 */
public class ReceveurReseau extends Thread
{
    Socket socket;
    int noConnexion; // numero du client distant

    BufferedReader fluxEntrant;
    //PrintStream fluxSortant;

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

        //fluxSortant = new PrintStream(this.socket.getOutputStream());
        /* à  present fluxSortant est pret pour renvoyer des reponses textuelles au client */
    }

    public void run()
    {
        String ligne;
        //String reponse;
        DrawHandlerFacade facade = new DrawHandlerFacade();

        try
        {
            while (!isInterrupted())
            {		
                ligne = fluxEntrant.readLine(); // saisit le texte du client
                System.out.print(" le client n° "+this.noConnexion+" a envoyé : \n");
                
                //ligne += '\n';
                facade.formeReceived(ligne);
                //System.out.print(ligne + '\n'); // echo de la question sur la console
                
                //ligne = ligne.trim();
                //reponse = ligne.toUpperCase(); // calcul de la reponse

                //fluxSortant.print(reponse +'\n'); // envoi de la reponse au client
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
