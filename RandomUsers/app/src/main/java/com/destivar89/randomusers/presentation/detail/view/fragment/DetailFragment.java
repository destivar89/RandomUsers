package com.destivar89.randomusers.presentation.detail.view.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.destivar89.randomusers.R;
import com.destivar89.randomusers.databinding.FragmentDetailBinding;
import com.destivar89.randomusers.infrastructure.di.detail.DaggerDetailComponent;
import com.destivar89.randomusers.infrastructure.di.detail.DetailComponent;
import com.destivar89.randomusers.infrastructure.di.detail.DetailModule;
import com.destivar89.randomusers.presentation.common.view.fragment.BaseFragment;
import com.destivar89.randomusers.presentation.detail.model.DetailModel;
import com.destivar89.randomusers.presentation.detail.viewmodel.DetailViewmodel;

import javax.inject.Inject;

public class DetailFragment extends BaseFragment {

    private static final String EXTRA_DETAIL_MODEL = "extra_detail_model";

    private DetailComponent component;

    @Inject
    DetailViewmodel viewmodel;

    public static DetailFragment getInstance(DetailModel model) {
        DetailFragment fragment = new DetailFragment();

        Bundle arguments = new Bundle();
        arguments.putSerializable(EXTRA_DETAIL_MODEL, model);

        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewmodel.setModel((DetailModel) getArguments().getSerializable(EXTRA_DETAIL_MODEL));
    }

    @Override
    protected Integer getContentView() {
        return R.layout.fragment_detail;
    }

    @Override
    protected void injectComponent() {
        if(component == null){
            component = DaggerDetailComponent.builder()
                    .baseModule(getBaseModule())
                    .detailModule(new DetailModule())
                    .build();
        }
        component.inject(this);
    }

    @Override
    protected void bindData(View rootview) {
        FragmentDetailBinding binding =  DataBindingUtil.bind(rootview);
        binding.setViewmodel(viewmodel);
    }
}
