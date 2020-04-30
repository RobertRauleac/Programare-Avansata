package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

public class GameClient 
{
    public GameClient() throws Exception 
    {
    	int port = 8100;
        String address = "127.0.0.1";
        
        try (
                Socket socket = new Socket(address, port);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) 
        {
            Scanner input = new Scanner(System.in);
            
            while(true) 
            {
                System.out.print("Introduceti o comanda : ");
                String request = input.nextLine();
                
                if(request.equals(new String("exit"))) 
                {
                    out.println(request);
                    break;
                }
                out.println(request);
                String raspuns = in.readLine();
                System.out.println(raspuns);
                if(raspuns.equals(new String("Serverul s-a oprit")))
                    break;
            }
        } 
        catch (Exception e) 
        {
            System.err.println("Nici un server disponibil" + e);
        }
    }

}
