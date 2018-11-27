package ru.morou.server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

/**
 * @Setter -
 * @Getter -
 *
 *
 */

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class PackegeBroadcast extends Package {
    {
        setType(PackageType.BROADCAST);
    }
    @Nullable
    private String message = "";
}
