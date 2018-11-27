package ru.morou.server.api;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;

/**
 * @Setter -
 * @Getter -
 * @ApplicationScoped - is a bean annotation
 */

@Getter
@Setter
@ApplicationScoped
public class ServerConfiguration {
    private Integer port = 4774;
    private String host = "localhost";
    private String login;
}
