package org.home.model;

import org.home.implementation.FileMessageStorageImpl;
import org.home.implementation.SimpleFileMessageStorageImpl;
import org.home.implementation.SimpleMessageStorageImpl;
import org.home.interfaces.MessageStorageInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {
   // @Autowired
    //@Qualifier("primary")
    MessageStorageInterface messageStorageInterface;
    private Owner owner;
    private String name;

    public MessageQueue(Owner owner, String name) {
        this.messageStorageInterface = new SimpleFileMessageStorageImpl(name);
        this.owner = owner;
        this.name = name;
    }

    public MessageStorageInterface getMessageStorageInterface() {
        return messageStorageInterface;
    }

    public void setMessageStorageInterface(MessageStorageInterface messageStorageInterface) {
        this.messageStorageInterface = messageStorageInterface;
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
                ", owner=" + owner +
                ", name='" + name + '\'' +
                '}';
    }



}
