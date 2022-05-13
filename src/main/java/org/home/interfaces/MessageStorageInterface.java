package org.home.interfaces;

import org.home.model.Message;
import org.home.model.MessageQueue;

import java.util.ArrayList;
import java.util.Queue;

public interface MessageStorageInterface {
    public void storeMessage(Message message);
    public Message fetchMessage();

    ArrayList<Message> getAllMessage();
    void setAllMessage(ArrayList<Message> allMessage);
}
