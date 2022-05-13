package org.home.model;

import java.io.Serializable;

public class FileMessage implements Serializable {
    private String  key;
    private String body;
    private boolean messageRead;

    public FileMessage(String key, String body) {
        this.key = key;
        this.body = body;
        this.messageRead = false;
    }

    public String getKey() {
        return key;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Message{" +
                "key='" + key + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
