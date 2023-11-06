package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Socket s = new Socket("localhost", 6789);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader inServ = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String stringaServer;
            int n = 0;
            do {
                n++;
                System.out.println("Inserisci nota");
                String st = in.readLine();
                out.writeBytes(st + '\n');
                stringaServer = inServ.readLine();
                if (stringaServer.equals("1"))
                {
                    System.out.println("Nota aggiunta numero" + " " + n);
                }
                if (stringaServer.equals("2"))
                {
                    System.out.println("Nota aggiunta numero" + " " + n);
                }
                if(stringaServer.equals("4"))
                {
                    System.out.println("Inserire nuovamente una nota");
                }
            } while (Integer.parseInt(stringaServer)!= 3);
            if(n == 1)
            {
                System.out.println("Nota aggiunta");
            }
            else{
                System.out.println();
            }
            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione!");
            System.exit(1);
        }
    }
}