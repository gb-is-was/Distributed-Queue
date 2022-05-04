package org.home;

import org.home.adapter.QueueAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QueueApplication {
    public static void main(String[] args) {
        SpringApplication.run(QueueApplication.class);
    }
}
