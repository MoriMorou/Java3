package ru.morou.server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Method for understanding, from whom received a message from the server
 * @Setter -
 * @Getter -
 * @ApplicationScoped - is a bean annotation
 *
 */



@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PackageMessage extends Package{
    {
        setType(PackageType.MESSAGE);
    }
    private String login;
    private String message;
}
