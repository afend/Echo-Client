/*
 * Adam Fendler
 * Internet Technology
 * EchoClient
 */

//import java.lang.*;  (didn't use)
import java.net.*;
import java.io.*;

public class EchoClient {
	public static void main(String[] args) throws Exception {
		String ipaddress, input;
		int port;
		Socket s;
		PrintWriter message;
		BufferedReader in;
		BufferedReader response; 
		
		 //Get IP address and port from arg[0] and arg[1] respectively.
		ipaddress = args[0];
		port = Integer.parseInt(args[1]);

		//Initialize a new socket using previous command line input.
		s = new Socket(ipaddress, port);
		 
		//Initialize new I/O streams used to read from user, send to server, and read response from server respectively. 
		in = new BufferedReader(new InputStreamReader(System.in)); 
		message = new PrintWriter(s.getOutputStream(), true); //found a way to auto-flush using second boolean parameter from oracle docs.
		response = new BufferedReader(new InputStreamReader(s.getInputStream())); 

		//Read client input into buffer
		input = in.readLine(); 
		
		//Send client input to server
		message.println(input); 
		
		//Read back server response and print to command line.
		input = response.readLine();
		System.out.println(input.toUpperCase()); 		

		//Close all sockets and terminate connection/program w.o. using System.exit(0)
		s.close(); 
		in.close(); 
		response.close(); 
		message.close();
		
	}
}