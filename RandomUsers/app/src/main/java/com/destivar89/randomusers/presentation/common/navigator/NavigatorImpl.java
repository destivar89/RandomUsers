package com.destivar89.randomusers.presentation.common.navigator;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.destivar89.randomusers.presentation.detail.model.DetailModel;
import com.destivar89.randomusers.presentation.detail.view.activity.DetailActivity;
import com.destivar89.randomusers.presentation.randomusers.model.RandomUserItemModel;

import javax.inject.Inject;

public class NavigatorImpl implements Navigator {

    private Activity activityContext;

    @Inject
    public NavigatorImpl(Activity activityContext){
        this.activityContext = activityContext;
    }

    private FragmentManager getFragmentManager() {
        return ((FragmentActivity) activityContext).getSupportFragmentManager();
    }

    private int startActivity(Intent intent) {
        int randomIdRequest = 1;
        activityContext.startActivityForResult(intent, randomIdRequest);

        return randomIdRequest;
    }

    private FragmentTransaction showFragment(int containerId, Fragment fragment, boolean backEnabled) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(containerId, fragment);

        if (backEnabled) {
            transaction.addToBackStack(retrieveFragmentTag(fragment));
        }

        return transaction;
    }

    private FragmentTransaction showFragment(int containerId, Fragment fragment, String tag) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(containerId, fragment, tag);

        return transaction;
    }

    private String retrieveFragmentTag(Fragment fragment) {
        if (fragment == null) {
            return null;
        }
        return fragment.getClass().getSimpleName();
    }


    @Override
    public void goToDetail(DetailModel model) {

        Intent intent = DetailActivity.getLaunchIntent(activityContext, model);
        startActivity(intent);

    }
}
