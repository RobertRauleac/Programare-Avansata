package server;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.Socket;
import java.io.IOException;

class ClientThread extends Thread 
{
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    
    public void run () 
    {
        try {
            while(true) 
            {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String raspuns = "Serverul  a primit un request " + request ;
                
                if(request.equals(new String("exit"))) 
                {
                    break;
                }
                if(request.equals(new String("stop"))) 
                {
                    raspuns = "Serverul s-a oprit";
                    out.println(raspuns);
                    out.flush();
                    System.exit(0);
                }
                //out.println(request);
                out.println(raspuns);
                out.flush();
            }
        } 
        catch (IOException e) 
        {
            System.err.println("Erori la comunicare... " + e);
        } 
        finally 
        {
            try 
            {
                socket.close();
            } 
            catch (IOException e) { System.err.println (e); }
        }
    }
}