/*
 * Created on 07-Sep-2004
 * @author bandara
 */
package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

import common.*;

/**
 * @author bandara
 *
 */
public class RMIServer extends UnicastRemoteObject implements RMIServerI {

	private int totalMessages = -1;
	private int[] receivedMessages;

	public RMIServer() throws RemoteException {
	}

	public void receiveMessage(MessageInfo msg) throws RemoteException {

		// TO-DO: On receipt of first message, initialise the receive buffer
		if(receivedMessages == null){
			totalMessage = 0;
			receivedMessages = new int(msg.totalMessages);
		}
		// TO-DO: Log receipt of the message
		totalMessages++;
		receivedMessages[msg.messageNum] = 1;
		// TO-DO: If this is the last expected message, then identify
		//        any missing messages
		if(totalMessages == msg.totalMessages){

			if(receivedMessage == null || totalMessage <= 0)
				return;
			
			String missingMessages = "";
			for(int i = 0; i <receivedMessages.length; i++)
				if(receivedMessages[i] == 0)
					missingMessages += i + ", ";
			System.out.println("******* SUMMARY *******");
			Systen.out.println("Number of messages received: " + totalMessages);
			if(totalMessages == receivedMessages.length)
				System.out.println("No missing messages!");
			else
				System.out.println("Lost Messages: " + missingMessages);
			receivedMessages = null;
			totalMessages = -1;
		}	
	}


	public static void main(String[] args) {

		RMIServer rmis = null;

		// TO-DO: Initialise Security Manager
		if (System.getSecurityManager() == null){
			System.setSecurityManager(new RMISecurityManager());
		}
		// TO-DO: Instantiate the server class
		try{
			rmis = new RMIServer();
		} catch(RemoteException e){
			System.out.println("Remote Exception: " + e);
		}
		// TO-DO: Bind to RMI registry
		rebindServer("localhost",rmis);

	}

	protected static void rebindServer(String serverURL, RMIServer server) {
		Registry reg;
		// TO-DO:
		// Start / find the registry (hint use LocateRegistry.createRegistry(...)
		// If we *know* the registry is running we could skip this (eg run rmiregistry in the start script)
		try{
		reg = LocateRegistry.createRegistry(1099);
		// TO-DO:
		// Now rebind the server to the registry (rebind replaces any existing servers bound to the serverURL)
		// Note - Registry.rebind (as returned by createRegistry / getRegistry) does something similar but
		// expects different things from the URL field.
		reg.rebind("RMIServer",server);
		} catch (RemoteException e){
			e.printStackTrace();
		}
	}
}
