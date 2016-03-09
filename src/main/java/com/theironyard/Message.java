package com.theironyard;

/**
 * Created by noellemachin on 3/8/16.
 */
public class Message {
    int id;
    String text;
    String user;

    public Message(String text, String user) {
        this.text = text;
        this.user = user;
    }

    public Message() {
    }
    public void setId(int id) {
        this.id = id;
    }
}
