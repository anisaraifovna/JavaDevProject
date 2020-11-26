package transport;

import lombok.Getter;

public class Connection {
    private String host;
    private int port;
    @Getter
    private boolean isOpen;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
        this.isOpen = false;
    }

    public void open(){
        isOpen = true;
    }

    public void close(){
        isOpen = false;
    }

}
