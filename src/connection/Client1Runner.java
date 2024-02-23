package connection;

import connection.Clients.Client;

import java.io.IOException;

/**
 * This class runs a new instance of client on the given port and host name as arguments
 */
public class Client1Runner {
    public static void main(String[] args) {
        if(args.length!=2){
            System.err.println("Please enter the <port number> and <host name> as arguments");
            System.exit(1);
        }

        int PORT_NUMBER = Integer.parseInt(args[0]);
        String HOST_NAME = args[1];


        Client client = new Client(PORT_NUMBER,HOST_NAME);
        try {
            client.setupClient();
        } catch (IOException e) {
            System.err.println("Error Connecting to Server. Try again later.");
        }

    }
}
