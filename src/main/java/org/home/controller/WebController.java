package org.home.controller;

import org.apache.log4j.Logger;
import org.home.adapter.QueueAdapter;
import org.home.model.Message;
import org.home.model.MessageQueue;
import org.home.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class WebController {
    static final Logger myLogger = Logger.getLogger(WebController.class);
    @Autowired
    QueueAdapter queueAdapter;
    @PostMapping(path = "/queue/create/{name}")
    public void createQueue(@PathVariable("name") String qName, @RequestBody Owner owner)
    {
        myLogger.info(owner.getOwnerName()+" requests to create "+qName);
        try{
            queueAdapter.createQueue(qName, owner);
            queueAdapter.getAllQueueForConsole();
        }
        catch(Exception e)
        {
            myLogger.info("Error while creating "+qName+":"+e);
        }
    }

    @GetMapping(path="/queue/list")
    public List<String> listAllQueue()
    {
        myLogger.info("All queues - ");
        return queueAdapter.listAllQueue();
    }

    @PostMapping(path = "/message/add/{qname}")
    public void addMessageToQueue(@PathVariable("qname") String qName, @RequestBody Message message)
    {
        queueAdapter.addMessageToQueue(qName, message);
    }

    @GetMapping(path = "/message/next/{qname}")
    public String getNextMessage(@PathVariable("qname") String qName)
    {
        queueAdapter.getAllQueueForConsole();
       return queueAdapter.getNextMessage(qName);

    }
}
