package transport;

import bank.transactions.TransactionServer;
import lombok.Getter;
import lombok.NonNull;

@Getter @NonNull
public class Connection {
    private String host;
    private int port;
    private boolean isOpen;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
        this.isOpen = false;
    }

    public TransactionServer open(){
        isOpen = true;
        return new TransactionServer();
    }

    public void close(){
        isOpen = false;
    }

}
