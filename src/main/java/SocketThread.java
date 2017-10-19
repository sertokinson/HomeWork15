import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketThread implements Runnable {

    private Socket client;

    public SocketThread(Socket client) {
        this.client = client;
    }

    public void run() {
        String name=null;

        try {
            ObjectInputStream inputStream = new ObjectInputStream(client.getInputStream());
            ChatPacket object;
            while ((object= (ChatPacket) inputStream.readObject())!=null) {
                switch (object.getCommand()){
                    case REG:
                        name= object.getData();
                        System.out.println("Welcome " +name);
                        break;
                    case MSG:
                        if(name!=null)
                            System.out.println(name + ">> " + object.getData());
                        break;
                    case EXT:
                        System.out.println(name+" вышел из чата");
                }
            }
            inputStream.close();
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}