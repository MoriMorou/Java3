package ru.morou.server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * @Setter -
 * @Getter -
 * @ApplicationScoped - is a bean annotation
 *
 */

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Package {
    private String id = UUID.randomUUID().toString();
    private PackageType type = PackageType.NONE;
}
