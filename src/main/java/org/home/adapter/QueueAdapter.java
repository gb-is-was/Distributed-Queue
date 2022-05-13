package org.home.adapter;

import org.apache.log4j.Logger;
import org.home.controller.MessageQueueController;
import org.home.model.Message;
import org.home.model.MessageQueue;
import org.home.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueueAdapter {
    @Autowired
    MessageQueueController messageQueueController;
    static final Logger logger = Logger.getLogger(QueueAdapter.class);
    public void createQueue(String qName, Owner owner) {
        messageQueueController.addNewQueue(qName, owner);
    }

    public void getAllQueueForConsole()
    {
        List<MessageQueue> queues = messageQueueController.getAllQueue();
        for(MessageQueue m:queues)
        {
            logger.info(m);
        }
    }

    public List<String> listAllQueue() {
        return messageQueueController.listAllQueueName();
    }

    public void addMessageToQueue(String qname, Message m)
    {
        messageQueueController.addMessageToQueue(qname, m);
    }

    public String getNextMessage(String qname)
    {
        return messageQueueController.getNextMessage(qname).getBody();
    }
}
