package org.home.model;

public class Message {
    private String  key;
    private String body;

    public Message(String key, String body) {
        this.key = key;
        this.body = body;
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
