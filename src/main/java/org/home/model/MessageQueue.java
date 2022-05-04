package org.home.model;

import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {
    private Queue<Message> allMessage;
    private Owner owner;
    private String name;

    public MessageQueue(Owner owner, String name) {
        this.allMessage = new LinkedList<>();
        this.owner = owner;
        this.name = name;
    }

    public Queue<Message> getAllMessage() {
        return allMessage;
    }

    public void setAllMessage(Queue<Message> allMessage) {
        this.allMessage = allMessage;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MessageQueue{" +
                "allMessage=" + allMessage +
                ", owner=" + owner +
                ", name='" + name + '\'' +
                '}';
    }



}
