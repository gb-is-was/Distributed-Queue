package org.home.implementation;

import org.home.interfaces.MessageStorageInterface;
import org.home.model.Message;
import org.home.model.MessageQueue;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//@Component("primary")
public class SimpleMessageStorageImpl implements MessageStorageInterface {
   // MessageQueue messageQueue;
    Queue<Message> messages;
    public SimpleMessageStorageImpl(String qname)
    {
        messages = new LinkedList<>();
    }
    @Override
    public void storeMessage(Message message) {
        messages.add(message);
    }

    @Override
    public Message fetchMessage() {
        Message m = messages.peek();
        messages.remove();
        return m;
    }

    @Override
    public ArrayList<Message> getAllMessage() {
        ArrayList<Message>  returnMessages = new ArrayList<>();
        returnMessages.addAll(messages);
        return returnMessages;
    }

    @Override
    public void setAllMessage(ArrayList<Message> allMessage) {
        for(Message m : allMessage) {
            messages.add(m);
        }
    }
}
