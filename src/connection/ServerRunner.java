package connection;

import connection.Server.MultiClientServer;

/**
 * This class runs a new instance of server on the given port number passed as arguments
 */
public class ServerRunner {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: Enter <port number> as argument");
            System.exit(1);
        }

        int PORT_NUMBER = Integer.parseInt(args[0]);

        MultiClientServer multiClientServer = new MultiClientServer(PORT_NUMBER);
        multiClientServer.setupServer();
    }
}
