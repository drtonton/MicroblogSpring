package com.theironyard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by noellemachin on 3/8/16.
 */
@Entity
public class Message {
    @Id
    @GeneratedValue
    int id;

    String text;
    String userName;

    public Message(String text, String userName) {
        this.text = text;
        this.userName = userName;
    }

    public Message() {
    }
    public void setId(int id) {
        this.id = id;
    }
}
