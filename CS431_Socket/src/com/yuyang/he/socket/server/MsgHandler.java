/**
 * 
 */
package com.yuyang.he.socket.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * The msg handler of the server.
 * 
 * @author Yuyang He
 * @date 11:43:16 PM, Sep 5, 2015
 * @version 1.0
 * @since
 */
public class MsgHandler implements Runnable
{
	private Socket clientSocket = null;

	/**
	 * reading from the file
	 */
	private BufferedReader br = null;

	/**
	 * sending to the client
	 */
	private BufferedWriter bw = null;

	private String sendingMsg = null;

	private static final File FILE = new File("David Copperfield.txt");

	/**
	 * Constructors of MsgHandler.
	 * 
	 * @param clientSocket
	 *            Client socket instance.
	 * @see Server
	 */
	public MsgHandler(Socket clientSocket)
	{
		this.clientSocket = clientSocket;
		System.out.println("Client received.");
		System.out.println("Client: " + clientSocket);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		try
		{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE)));
			bw = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

			// 1st time sending the file name then sending the data
			bw.write(FILE.getName());
			bw.newLine();
			bw.flush();

			while (true)
			{
				sendingMsg = br.readLine();
				
				if(null == sendingMsg)
				{
					break;
				}
						
				bw.write(sendingMsg);
				bw.newLine();
				bw.flush();
			}

			// finishing sending data
			// sending "shut down"
			bw.write("shut down");
			bw.newLine();
			bw.flush();
		}
		catch (IOException e)
		{
			System.out.println("IO exception is found.");
			e.printStackTrace();
		}
		finally
		{
			if (null != br)
			{
				try
				{
					br.close();
				}
				catch (IOException e)
				{
					System.out.println("IO exception is found in buffered reader.");
					e.printStackTrace();
				}
			}

			if (null != bw)
			{
				try
				{
					bw.close();
				}
				catch (IOException e)
				{
					System.out.println("IO exception is found in buffered writer.");
					e.printStackTrace();
				}
			}
		}
	}
}
