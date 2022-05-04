package org.home.interfaces;

import org.home.model.Message;
import org.home.model.MessageQueue;

public interface MessageStorageInterface {
    public void storeMessage(MessageQueue messageQueue, Message message);
    public Message fetchMessage(MessageQueue messageQueue);
}
