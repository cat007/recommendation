package com.recommendation.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import com.recommendation.RecoConfiguration;

import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.HibernateBundle;

/**
 * Created by naveen.kj on 07/03/18.
 */
public class HibernateModule extends AbstractModule {

    private final HibernateBundle<RecoConfiguration> hibernateBundle;

    public HibernateModule(HibernateBundle<RecoConfiguration> hibernateBundle){
        this.hibernateBundle = hibernateBundle;
    }

    @Override
    protected void configure() {

    }

    @Provides
    @Singleton
    @Named("migration")
    public SessionFactory provideSessionFactory() {
        return hibernateBundle.getSessionFactory();
    }
}
