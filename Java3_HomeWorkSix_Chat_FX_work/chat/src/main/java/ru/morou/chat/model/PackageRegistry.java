package ru.morou.chat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PackageRegistry extends Package{
    {
        setType(PackageType.REGISTRY);
    }
    @Nullable
    private String login;

    @Nullable
    private String password;
}
