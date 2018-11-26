package ru.morou.server.api;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;

@Getter
@Setter
@ApplicationScoped
public class ServerConfiguration {
    private Integer port = 4774;
    private String host = "localhost";
    private String login;
}
