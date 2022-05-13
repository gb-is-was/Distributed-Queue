package org.home.implementation;

import org.home.interfaces.MessageStorageInterface;
import org.home.model.Message;
import org.home.model.MessageQueue;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Queue;

@Component("secondary")
public class FileMessageStorageImpl implements MessageStorageInterface {
    public FileMessageStorageImpl() {
    }

    @Override
    public void storeMessage(Message message) {

    }

    @Override
    public Message fetchMessage() {
        return null;
    }

    @Override
    public ArrayList<Message> getAllMessage() {
        return null;
    }

    @Override
    public void setAllMessage(ArrayList<Message> allMessage) {

    }
}
