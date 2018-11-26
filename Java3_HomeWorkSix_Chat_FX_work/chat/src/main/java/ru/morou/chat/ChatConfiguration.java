package ru.morou.chat;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;

@Setter
@Getter
@ApplicationScoped
public class ChatConfiguration {
    private Integer port = 4774;
    private String host = "localhost";
    private String login;
}
