package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer 
{
    public static final int PORT = 8100;
    public GameServer() throws IOException 
    {
        ServerSocket serverSocket = null ;
        try 
        {
            serverSocket = new ServerSocket(PORT);
            
            while (true) 
            {
                System.out.println ("Asteptam ca un client sa se conecteze");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        } 
        catch (IOException e) 
        {
            System.err. println ("Eroare detectata : " + e);
        } 
        finally 
        {
            serverSocket.close();
        }
    }
}
