package com.destivar89.randomusers.presentation.common.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.destivar89.randomusers.domain.exception.ContentViewNotSettedException;
import com.destivar89.randomusers.infrastructure.di.common.BaseModule;
import com.destivar89.randomusers.infrastructure.di.common.DaggerBaseComponent;
import com.destivar89.randomusers.infrastructure.log.Logger;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    private Logger log;

    protected abstract Integer getContentView();

    protected void bindData(View rootview){};
    protected void loadInitialData(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        log = Logger.getLogger(getClass());

        if (getContentView() == null)
            throw new ContentViewNotSettedException("You must implement method getFragmentContentView and return a valid content view");

        View rootView = inflater.inflate(getContentView(), container, false);

        injectComponent();
        bindData(rootView);
        ButterKnife.bind(this, rootView);

        loadInitialData();

        return rootView;

    }

    protected Logger getLog(){
        return log;
    }

    protected void injectComponent(){
        DaggerBaseComponent.builder()
                .baseModule(getBaseModule())
                .build().inject(this);
    }

    protected BaseModule getBaseModule(){
        return new BaseModule(getActivity());
    }

}
