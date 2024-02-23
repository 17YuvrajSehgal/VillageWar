package connection.Server;

import connection.Clients.RequestType;
import connection.protocols.InvalidProtocolRequestException;
import connection.protocols.Protocol;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread {

    private static int CLIENT_NUMBER = 0;
    private Socket clientSocket;
    ObjectOutputStream serverOutputStream;
    ObjectInputStream serverInputStream;
    ObjectInputStream dataObjectInputStream;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        CLIENT_NUMBER++;

        try{
                serverOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                serverInputStream = new ObjectInputStream((clientSocket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getClientNumber(){
        return CLIENT_NUMBER;
    }

    @Override
    public void run() {

        Protocol protocol = null;
        try {
            boolean condition=false;
            if (serverInputStream != null && serverOutputStream != null) {
                protocol = new Protocol(serverOutputStream, serverInputStream);
                condition=true;
            }

            while (condition) {
                RequestType requestType = (RequestType) serverInputStream.readObject();
                if (requestType == RequestType.TERMINATE_SERVER){
                    condition = false;
                break;
            }
                try{
                    protocol.processInput(requestType);
                }catch (InvalidProtocolRequestException e){
                    System.out.println("Invalid protocol request. Try again");
                }
            }
        } catch (IOException e) {
            System.err.println("IO exception caught");
        }
        catch (ClassNotFoundException e){
            System.err.println("Class Not found execution occurred");
        }
    }


}
