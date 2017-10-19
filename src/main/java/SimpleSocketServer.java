import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleSocketServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(3000);
        ExecutorService service = Executors.newFixedThreadPool(3);
        while (true) {
            try {
                Socket client = serverSocket.accept();
                System.out.println("Client connected " + client.getPort());
                service.execute(new SocketThread(client));
            } catch (Exception e) {
                System.out.println("Socket connect exception:" + e.getMessage());
            }
        }
    }
}