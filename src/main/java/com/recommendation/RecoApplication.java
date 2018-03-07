package com.recommendation;

import com.google.inject.Stage;

import com.hubspot.dropwizard.guice.GuiceBundle;
import com.recommendation.entity.UserData;
import com.recommendation.modules.HibernateModule;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by naveen.kj on 07/03/18.
 */

@Slf4j
public class RecoApplication extends Application<RecoConfiguration> {

    private final HibernateBundle<RecoConfiguration> hibernateBundle =
            new HibernateBundle<RecoConfiguration>(UserData.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(RecoConfiguration recoConfiguration) {
            return null;
        }

        @Override
        public void configure(Configuration configuration) {
            configuration.setNamingStrategy(new ImprovedNamingStrategy());
        }
    };

    @Override
    public void initialize(Bootstrap<RecoConfiguration> bootstrap) {
        log.info("Initialized");
        final GuiceBundle<RecoConfiguration> guiceBundle =
                new GuiceBundle.Builder<RecoConfiguration>()
                        .addModule(new HibernateModule(hibernateBundle))
                        .setConfigClass(RecoConfiguration.class)
                        .enableAutoConfig("com.recommendation.resource")
                        .build(Stage.DEVELOPMENT);

        bootstrap.addBundle(guiceBundle);
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(RecoConfiguration configuration, Environment environment) throws Exception {
        log.info("App Name : {}", configuration.getAppName());
        environment.jersey().register(RecoApplication.class);
        environment.healthChecks().register("Reco-App-Health", new RecoHealthCheck());
    }

    public static void main(String[] args) throws Exception {
        new RecoApplication().run(args);
    }
}
