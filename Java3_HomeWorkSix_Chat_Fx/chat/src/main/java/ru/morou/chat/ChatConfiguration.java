package ru.morou.chat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChatConfiguration {
    private Integer port = 4774;
    private Integer threads = 4;
    private String host = "localhost";
}
