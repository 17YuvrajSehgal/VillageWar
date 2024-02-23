package connection;

import connection.Clients.Client;

import java.io.IOException;

/**
 * This class runs a new instance of client on the given port and host name as arguments
 */
public class Client2Runner {
    public static void main(String[] args) {
        Client client = new Client(8080,"localhost");
        try {
            client.setupClient();
        } catch (IOException e) {
            System.out.println("Error Connecting to Server. Try again later.");
        }    }
}
