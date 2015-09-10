/**
 * 
 */
package com.yuyang.he.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This is the server java file.
 * 
 * @author Yuyang He
 * @date 11:34:49 PM, Sep 5, 2015
 * @version 1.0
 * @since
 */
public class Server
{
	/**
	 * the port number for communication
	 */
	private static final int PORT = 18888;
	
	/**
	 * Main function for the server.
	 * @param args
	 */
	public static void main(String [] args)
	{
		System.out.println("The server starts.");
		System.out.println();
		
		ServerSocket serverSocket = null;
		
		try
		{
			serverSocket = new ServerSocket(PORT);
			
			while(true)
			{
				Socket clientSocket = serverSocket.accept();
				new Thread(new MsgHandler(clientSocket)).start();
			}
		}
		catch (IOException e)
		{		
			e.printStackTrace();
		}		
		
	}
}
