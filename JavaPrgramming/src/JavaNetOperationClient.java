import java.net.*;
import java.io.*;

public class JavaNetOperationClient {

	public final static int port = 6335;
	public final static String serverName = "localhost";
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		// create client	
		Socket client = null;
	    try
	    {
	       System.out.println("Connecting to the host：" + serverName + " ，port：" + port);
	       client = new Socket(serverName, port);
	       System.out.println("Remote host address：" + client.getRemoteSocketAddress());
	       OutputStream outToServer = client.getOutputStream();
	       DataOutputStream out = new DataOutputStream(outToServer);
	 
	       out.writeUTF("Hello from " + client.getLocalSocketAddress());
	       InputStream inFromServer = client.getInputStream();
	       DataInputStream in = new DataInputStream(inFromServer);
	       System.out.println("Response from server： " + in.readUTF());
	       client.close();
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	      }
	}
}
