package connection.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiClientServer {
    private final int PORT_NUMBER;
    private final List<ClientHandler> clients;
    private final ExecutorService executor;
    public MultiClientServer(int PORT_NUMBER){
        this.clients = new ArrayList<>();
        this.executor = Executors.newCachedThreadPool();
        this.PORT_NUMBER=PORT_NUMBER;
    }

    public void setupServer(){
        try (
                ServerSocket server = new ServerSocket(PORT_NUMBER);
        ) {
            System.out.println("Server Is Running...");
            while (true){
                Socket clientSocket = server.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                executor.execute(clientHandler);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
