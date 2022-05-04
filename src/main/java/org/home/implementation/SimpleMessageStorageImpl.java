package org.home.implementation;

import org.home.interfaces.MessageStorageInterface;
import org.home.model.Message;
import org.home.model.MessageQueue;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Component("primary")
public class SimpleMessageStorageImpl implements MessageStorageInterface {
   // MessageQueue messageQueue;
    List<Message> messages;
    public SimpleMessageStorageImpl()
    {
        messages = new ArrayList<>();
    }
    @Override
    public void storeMessage(MessageQueue messageQueue, Message message) {
        //this.messageQueue = messageQueue;
       // messages.addAll(messageQueue.getAllMessage());
      //  messages.add(message);
        Queue<Message> messages = messageQueue.getAllMessage();
        messages.add(message);
        messageQueue.setAllMessage(messages);

    }

    @Override
    public Message fetchMessage(MessageQueue messageQueue) {
       // this.messageQueue = messageQueue;
        //messages.addAll(messageQueue.getAllMessage());
        Message m = messageQueue.getAllMessage().peek();
       // Queue<Message> mq = messageQueue.getAllMessage();
       // mq.poll();
      //  messageQueue.setAllMessage(mq);
        return m;
    }
}
