import java.io.Serializable;

/**
 * Created by SBT-Pozdnyakov-AN on 12.10.2017.
 */
public class ChatPacket implements Serializable{
    private Command command;
    private String data;

    public ChatPacket(Command command, String data) {
        this.command = command;
        this.data = data;
    }

    public Command getCommand() {
        return command;
    }

    public String getData() {
        return data;
    }

    public enum Command{
        MSG,
        REG,
        EXT
    }
}
