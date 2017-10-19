import java.net.UnknownHostException;

public class Client1 {
    public static void main(String[] args) throws UnknownHostException {
        SocketClient socketClient =new SocketClient();
        socketClient.connect();
    }
}
