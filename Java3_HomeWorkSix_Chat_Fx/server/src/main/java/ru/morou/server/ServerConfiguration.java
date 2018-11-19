package ru.morou.server;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServerConfiguration {
    private Integer port = 4774;
    private Integer threads = 4;
    private String host = "localhost";
}
