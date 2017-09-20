package clientGUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Model {
	
	Socket clientSocket = null;
	
	
	public String connectServer(String IP, int port){
		
		try {
			clientSocket = new Socket(IP, port);
		} catch (UnknownHostException e) {
			return "Unknown Host";
		} catch (IOException e) {
			return "I/O Error";
		}
		return "Connection is OK";
	}
	
	public String execute(String command) throws IOException{
		
		if (clientSocket != null){	
			
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
			     clientSocket.getInputStream()));
			  
			outToServer.writeBytes(command + "\n");						   
			String result;
			String response="";
		    while ((result=inFromServer.readLine()) != null)
		         {
		    	if (result.isEmpty())
		    		break;
		    	response += result;
		    	response +="\n";
		         }
		    return response;
		}
		else
		{	
			return "Not Connected";
		}
		
		
	}
	


}


