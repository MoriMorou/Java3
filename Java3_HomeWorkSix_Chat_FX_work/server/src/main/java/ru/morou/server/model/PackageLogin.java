package ru.morou.server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class PackageLogin extends Package {
    {
        setType(PackageType.LOGIN);
    }
    @Nullable
    private String login;

    @Nullable
    private String password;
}
