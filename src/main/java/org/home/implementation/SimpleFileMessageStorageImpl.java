package org.home.implementation;

import org.home.interfaces.MessageStorageInterface;
import org.home.model.FileMessage;
import org.home.model.Message;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

//@Component("secondary")
public class SimpleFileMessageStorageImpl implements MessageStorageInterface {
    String QFileName;
    BufferedWriter oo;
    BufferedReader io;
    public SimpleFileMessageStorageImpl(String qname) {
        QFileName = "Queue-"+qname+".txt";
        try {
            oo = new BufferedWriter(new FileWriter(QFileName));
            //oo.write("");
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
    public void storeMessage(Message message) {
        try {
            oo = new BufferedWriter(new FileWriter(QFileName,true));
            String msg = message.getKey()+ "," + message.getBody();
            oo.write(msg);
            oo.write("\n");
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
        BufferedWriter oos = null;
        Message m=null;
        try {
            io = new BufferedReader(new FileReader(QFileName));
            String fileLine = null;
            if((fileLine = io.readLine()) != null) {
                m = new Message(fileLine.split(",")[0],fileLine.split(",")[1]);
                message_read = true;
            }
            if(message_read)
            {
                oos = new BufferedWriter(new FileWriter("copy"+QFileName, true));
                String nextLine = null;
                while((nextLine = io.readLine()) != null) {
                        oos.write(nextLine);
                        oos.write("\n");
                }
            }
            return m;
        } catch (IOException e) {
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
                        newName.delete();
                        Files.move(Paths.get("copy"+QFileName), Paths.get("copy"+QFileName).resolveSibling(QFileName));

                        //oldName.renameTo(newName);
                      // oldName.delete();
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
