package com.recommendation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by naveen.kj on 07/03/18.
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = false)
@EqualsAndHashCode(callSuper = false)
public class RecoConfiguration extends Configuration {
    @NotEmpty
    private String appName;

    @Valid
    @NotNull
    private DataSourceFactory databaseConfiguration = new DataSourceFactory();

    public DataSourceFactory getDatabaseConfiguration(){
        return databaseConfiguration;
    }
}
