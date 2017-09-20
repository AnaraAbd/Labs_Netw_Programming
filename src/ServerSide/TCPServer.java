package ServerSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class TCPServer implements Runnable {
   Socket csocket;
   private static int PORT = 6000;
  
   TCPServer(Socket csocket) {
      this.csocket = csocket;
   }
   
   public static void main(String args[]) throws Exception { 
      ServerSocket ssock = new ServerSocket(PORT);
      System.out.println("Listening");
      
      while (true) {
         Socket sock = ssock.accept();
         System.out.println("Connected");
         new Thread(new TCPServer(sock)).start();
      }
   }
   
   
   public void run() {
      try {
    	 InputStream in = csocket.getInputStream(); 
    	 OutputStream out = csocket.getOutputStream();
         BufferedReader din = new BufferedReader(new InputStreamReader(in));
         PrintStream pstream = new PrintStream(csocket.getOutputStream());
         
         while(true) {
         String command = din.readLine();
         //for (int i = 100; i >= 0; i--) {
         //   pstream.println(i + " bottles of beer on the wall");
         //}
         	if(command.equals("quit"))
         	{
         		break;
         	}else {
         		 
                UnixCommander cli = new UnixCommander();
                String result = cli.runCommand(command);
                pstream.println(result);
         	}
         }
                 
         pstream.close();
         csocket.close();
      } catch (IOException e) {
         System.out.println(e);
      }
   }
}