package reseautcp;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * Contient le main
 * Initialise les connexions des clients
 * @see ReceveurReseau
 */
public class ServeurDessin
{
    @SuppressWarnings("resource")
	public static void main(String[] args)throws Exception
    {
        ServerSocket serveur;
        serveur = new ServerSocket(9111); // place un serveur a  l'ecoute sur le port 9111
                             //si le parametre = 0 alors la JVM choisit un port libre

        System.out.print("serveur de dessin démarré : "+serveur +'\n');

        InetAddress cetteMachine;
        int portLocal;
        ThreadGroup groupe;

        portLocal = serveur.getLocalPort();

        cetteMachine = InetAddress.getLocalHost();

        System.out.print("adresse IP du serveur de dessin : "+cetteMachine.getHostAddress() +'\n');
        System.out.print("port du serveur : "+portLocal +'\n');

        groupe = new ThreadGroup("socketsClients");
        int noConnexion = 0;
        while(true) //attente infinie du serveur sur le port
        {
            Socket nouveauClientSocket;
            ReceveurReseau nouveauClientThread;
    
            nouveauClientSocket = serveur.accept(); // attente de connexion de la part d'un nouveau client
            ++noConnexion; // la connexion a eu lieu et un socket a été créé : nouveauClientSocket
            System.out.print("Connexion réussie n° : "+noConnexion +'\n');

            /* à  present creation d'un thread pour gerer les transactions avec le nouvau client en parallÃ¨le 
             * avec les autres clients deja  connectés et avec l'attente perpetuelle du servur*/

            nouveauClientThread = new ReceveurReseau(nouveauClientSocket, groupe, noConnexion); 
            nouveauClientThread.start();
        }
    }
    
}
