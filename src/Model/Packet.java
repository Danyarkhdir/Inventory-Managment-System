package Model;

import java.io.Serializable;
import java.util.LinkedList;

public class Packet <T> implements Serializable {
    LinkedList<T> items = new LinkedList<>();
    private int message;

    public Packet(int message) {
        this.message = message;
    }

    public LinkedList<T> getItems() {
        return items;
    }

    public void setItems(LinkedList<T> items) {
        this.items = items;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }
}
