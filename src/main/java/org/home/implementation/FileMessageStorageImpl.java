package org.home.implementation;

import org.home.interfaces.MessageStorageInterface;
import org.home.model.FileMessage;
import org.home.model.Message;
import org.home.model.MessageQueue;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Queue;

//@Component("secondary")
public class FileMessageStorageImpl implements MessageStorageInterface {
    String QFileName;
    ObjectOutputStream oo;
    ObjectInputStream io;
    public FileMessageStorageImpl(String qname) {
        QFileName = "Queue-"+qname+".txt";
    }

    @Override
    public void storeMessage(Message message) {
        try {
            oo = new ObjectOutputStream(new FileOutputStream(QFileName,true));
            oo.writeObject(new FileMessage(message.getKey(), message.getBody()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            if(oo!=null)
            {
                try {
                    oo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Message fetchMessage() {
        boolean message_read = false;
        ObjectOutputStream oos = null;
        FileMessage m=null;
        try {
            io = new ObjectInputStream(new FileInputStream(QFileName));

            if(io.readObject()!=null) {
                m = (FileMessage) io.readObject();
                message_read = true;
            }
            if(message_read)
            {
                oos = new ObjectOutputStream(new FileOutputStream("copy"+QFileName,true));
                int first = 1;
                while(io.readObject()!=null) {
                    m = (FileMessage) io.readObject();
                    if(first!=1)
                    {
                        oos.writeObject(m);
                    }
                    else
                    {
                        first = 0;
                    }


                }
            }
            return (m==null?null:new Message(m.getKey(),m.getBody()));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            if(io!=null)
            {
                try {
                    io.close();
                    if(message_read)
                    {
                        oos.close();
                        File oldName = new File("copy"+QFileName);
                        File newName = new File(QFileName);
                       Files.move(Paths.get("copy"+QFileName), Paths.get("copy"+QFileName).resolveSibling(QFileName));

                      // oldName.renameTo(newName);
                       oldName.delete();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
