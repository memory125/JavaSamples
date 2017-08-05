import java.net.*;
import java.io.*;

public class JavaNetOperationServer extends Thread
{
   private ServerSocket serverSocket;
     
   public JavaNetOperationServer(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(10000);
   }
 
   public void run()
   {
      while(true)
      {
         try
         {
            System.out.println("Waitting the connection, port is: " + serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            System.out.println("Remote host address: " + server.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(server.getInputStream());
            System.out.println(in.readUTF());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("Thanks for connecting me: " + server.getLocalSocketAddress() + "\nGoodbye!");
            server.close();
         }catch(SocketTimeoutException s)
         {
            System.out.println("Socket timed out!");
            break;
         }catch(IOException e)
         {
            e.printStackTrace();
            break;
         }
      }
   }
   public static void main(String [] args)
   {
      int port = 6335;
      try
      {
         Thread t = new JavaNetOperationServer(port);
         t.run();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}