package com.destivar89.randomusers.presentation.detail.view.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.destivar89.randomusers.presentation.common.view.activity.BaseActivity;
import com.destivar89.randomusers.presentation.detail.model.DetailModel;
import com.destivar89.randomusers.presentation.detail.view.fragment.DetailFragment;

public class DetailActivity extends BaseActivity {

    private static final String EXTRA_DETAIL_MODEL = "extra_detail_model";

    private String title;

    public static Intent getLaunchIntent(Context context, DetailModel detailModel) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_DETAIL_MODEL, detailModel);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        title = ((DetailModel) getIntent().getSerializableExtra(EXTRA_DETAIL_MODEL)).getFullname();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Fragment getContentFragment() {
        return DetailFragment.getInstance((DetailModel) getIntent().getSerializableExtra(EXTRA_DETAIL_MODEL));
    }

    @Override
    protected String getToolbarTitle() {
        return title;
    }

    @Override
    protected boolean getToolbarShowBack() {
        return true;
    }

}
