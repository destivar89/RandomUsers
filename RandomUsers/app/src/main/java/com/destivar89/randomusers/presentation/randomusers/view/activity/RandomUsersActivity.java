package com.destivar89.randomusers.presentation.randomusers.view.activity;


import android.support.v4.app.Fragment;

import com.destivar89.randomusers.R;
import com.destivar89.randomusers.presentation.common.view.activity.BaseActivity;
import com.destivar89.randomusers.presentation.randomusers.view.fragment.RandomUsersFragment;

public class RandomUsersActivity extends BaseActivity {

    @Override
    protected Fragment getContentFragment() {
        return new RandomUsersFragment();
    }

    @Override
    protected String getToolbarTitle() {
        return getString(R.string.app_name);
    }
}
