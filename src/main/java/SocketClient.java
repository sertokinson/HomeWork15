import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by SBT-Pozdnyakov-AN on 12.10.2017.
 */
public class SocketClient {
    public void connect() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("localhost");
        try (Socket socket = new Socket(inetAddress, 3000)) {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите логин:");
            String login = r.readLine();
            ChatPacket chatPacket = new ChatPacket(ChatPacket.Command.REG, login);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(chatPacket);
            System.out.print(">> ");
            String msg;
            while (!(msg = r.readLine()).equals("exit")){
                System.out.println();
                System.out.print(">> ");
                objectOutputStream.writeObject(new ChatPacket(ChatPacket.Command.MSG, msg));
             }
                 objectOutputStream.writeObject(new ChatPacket(ChatPacket.Command.EXT, msg));

            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("Connect exception:" + e.getMessage());
        }
    }

}