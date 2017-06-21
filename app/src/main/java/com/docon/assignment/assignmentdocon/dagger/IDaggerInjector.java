package com.docon.assignment.assignmentdocon.dagger;



import com.docon.assignment.assignmentdocon.network_connection.NetworkModule;
import com.docon.assignment.assignmentdocon.view.home.HomeActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Rahul on 20/01/17.
 */
@Singleton
@Component(modules = {NetworkModule.class,})
public interface IDaggerInjector {
    void inject(HomeActivity homeActivity);
}
