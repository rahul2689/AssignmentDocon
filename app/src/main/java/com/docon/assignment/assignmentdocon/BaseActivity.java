package com.docon.assignment.assignmentdocon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.docon.assignment.assignmentdocon.dagger.DaggerIDaggerInjector;
import com.docon.assignment.assignmentdocon.dagger.IDaggerInjector;
import com.docon.assignment.assignmentdocon.network_connection.NetworkModule;

import java.io.File;

/**
 * Created by Rahul on 20/6/17.
 */

public class BaseActivity extends AppCompatActivity {

    private IDaggerInjector daggerInjector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        daggerInjector = DaggerIDaggerInjector.builder().networkModule(new NetworkModule(cacheFile)).build();

    }

    public IDaggerInjector getDaggerInjector() {
        return daggerInjector;
    }

}
