/*
 * Created on 07-Sep-2004
 * @author bandara
 */
package rmi;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import common.MessageInfo;

/**
 * @author bandara
 *
 */
public class RMIClient {

	public static void main(String[] args) {

		RMIServerI iRMIServer = null;

		// Pass server IPAdress and number of messages to send in the command line
		// Check arguments for Server host and number of messages
		if (args.length < 2){
			System.out.println("Needs 2 arguments: ServerHostName/IPAddress, TotalMessageCount");
			System.exit(-1);
		}

		String urlServer = new String("rmi://" + args[0] + "/RMIServer");
		int numMessages = Integer.parseInt(args[1]);
 
		// TO-DO: Initialise Security Manager
		System.setSecurityManager(new RMISecurityManager());

		// TO-DO: Bind to RMIServer

		// TO-DO: Attempt to send messages the specified number of times
		// for int in range numMessages
		// 	   create instance of MessageInfo
		
		//     send MessageInfo to the server

	}
}
