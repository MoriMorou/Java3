package ru.morou.server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Check the serves status
 */

@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PackageResult extends Package{
    {
        setType(PackageType.RESULT);
    }

    public PackageResult(Boolean success){
        this.success = success;
    }

    private Boolean success = true;
}
