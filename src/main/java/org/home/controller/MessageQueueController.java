package org.home.controller;

import org.apache.log4j.Logger;
import org.home.interfaces.MessageStorageInterface;
import org.home.model.Message;
import org.home.model.MessageQueue;
import org.home.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Component
public class MessageQueueController {
    List<MessageQueue> allQueue;
    static final Logger logger = Logger.getLogger(MessageQueueController.class);
    public MessageQueueController()
    {
        allQueue = new ArrayList<>();
    }

    public void addNewQueue(String qName, Owner owner) {
        if(this.queueExists(qName)!=null)
        {
            logger.info(qName +" already exists");
        }
        else {
            MessageQueue messageQueue = new MessageQueue(owner, qName);
            allQueue.add(messageQueue);
            logger.info(qName+" created");
        }
    }

    public MessageQueue queueExists(String qName)
    {
        for(MessageQueue m:allQueue)
        {
            if(m.getName().equals(qName))
            {
                return m;
            }
        }
        return null;
    }

    public List<MessageQueue> getAllQueue()
    {
        return allQueue;
    }

    public List<String> listAllQueueName() {
        List<String> qnames = new ArrayList<>();
        for(MessageQueue m : this.getAllQueue())
        {
            qnames.add(m.getName());
        }
        return qnames;
    }

    public void addMessageToQueue(String qname, Message m) {
        if (this.queueExists(qname) != null) {
            this.queueExists(qname).getMessageStorageInterface().storeMessage(m);
        }
    }
    public Message getNextMessage(String qname)
    {
        MessageQueue mq = this.queueExists(qname);
        Message m = mq.getMessageStorageInterface().fetchMessage();
        return m;

    }
}
