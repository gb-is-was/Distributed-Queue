package org.home.implementation;

import org.home.interfaces.MessageStorageInterface;
import org.home.model.Message;
import org.home.model.MessageQueue;
import org.springframework.stereotype.Component;

@Component("secondary")
public class FileMessageStorageImpl implements MessageStorageInterface {
    @Override
    public void storeMessage(MessageQueue messageQueue, Message message) {

    }

    @Override
    public Message fetchMessage(MessageQueue messageQueue) {
        return null;
    }
}
