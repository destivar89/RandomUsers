package com.destivar89.randomusers.presentation.common.view.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.destivar89.randomusers.R;
import com.destivar89.randomusers.infrastructure.log.Logger;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {


    private Logger log;

    protected abstract Fragment getContentFragment();

    protected abstract String getToolbarTitle();

    protected void loadInitialData(){}

    protected String getTag(){return null;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        log = Logger.getLogger(getClass());
        setContentView(R.layout.activity_base);

        ButterKnife.bind(this);

        initToolbar();
        initFragmentContainer(R.id.fragment_container, getContentFragment());

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadInitialData();
    }

    protected void initFragmentContainer(int containerId, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (getTag() == null)
            transaction.replace(containerId, fragment);
        else
            transaction.replace(containerId, fragment, getTag());
        transaction.commit();
    }

    protected Logger getLog(){
        return log;
    }

    private void initToolbar() {
        getSupportActionBar().setTitle(getToolbarTitle());
    }


}
