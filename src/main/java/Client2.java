import java.net.UnknownHostException;

public class Client2 {
    public static void main(String[] args) throws UnknownHostException {
        SocketClient socketClient =new SocketClient();
        socketClient.connect();
    }
}
