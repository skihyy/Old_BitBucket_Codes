/**
 * 
 */
package com.yuyang.he.socket.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This is client java file.
 * 
 * @author Yuyang He
 * @date 10:59:25 PM, Sep 5, 2015
 * @version 1.0
 * @since
 */
public class ClientSocket
{

	/**
	 * the port number for communication
	 */
	private static final int PORT = 18888;

	/**
	 * default downloading path
	 */
	private static final File FILE_PATH = new File("Download");

	/**
	 * file to save
	 */
	private static File file;

	/**
	 * The main function used to start the server.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Socket clientSocket = null;
		String ipAddress = null;

		try
		{
			System.out.print("Enter the server IP: ");
			ipAddress = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("IO exception found. The IP is set to 127.0.0.1.");
			ipAddress = "127.0.0.1";
		}

		try
		{
			clientSocket = new Socket(ipAddress, PORT);

			// reading from the server
			BufferedReader br = null;
			// writing to the file
			BufferedWriter bw = null;

			String receviedMsg = null;
			long startSec = 0, endSec = 0;
			int count = 0;

			try
			{
				br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				startSec = System.currentTimeMillis();

				while (true)
				{
					// Received msg
					receviedMsg = br.readLine();

					if ("shut down".equalsIgnoreCase(receviedMsg))
					{
						System.out.println("The client server is shutting down.");
						break;
					}

					// 1st time to receive
					// the file name will be received
					if (0 == count)
					{
						// create the file
						file = new File(FILE_PATH.getAbsolutePath() + File.separator + receviedMsg);

						if (!file.exists())
						{
							file.mkdirs();
						}

						if (file.exists())
						{
							file.delete();
							file.createNewFile();
						}

						// create dos instance
						bw = new BufferedWriter(new FileWriter(file, true));

						++count;
					}
					// not the 1st time
					else if (null != file)
					{
						bw.write(receviedMsg);
					}
				}

				endSec = System.currentTimeMillis();
				System.out.println("This communication spends " + (endSec - startSec) + " millisecond(s).");

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
						System.out.println("IO exception is found.");
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
						System.out.println("IO exception is found.");
						e.printStackTrace();
					}
				}
			}
		}
		catch (UnknownHostException e)
		{
			System.out.println("Unknown host exception of client is found.");
			e.printStackTrace();
		}
		catch (IOException e)
		{
			System.out.println("IO exception of client is found.");
			e.printStackTrace();
		}
		finally
		{
			if (null != clientSocket)
			{
				try
				{
					clientSocket.close();
				}
				catch (IOException e)
				{
					System.out.println("IO exception of client is found.");
					e.printStackTrace();
				}
			}

		}
	}
}
