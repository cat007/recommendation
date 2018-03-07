package com.recommendation;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by naveen.kj on 07/03/18.
 */
public class RecoHealthCheck extends HealthCheck {

    public RecoHealthCheck(){
        super();
    }
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
