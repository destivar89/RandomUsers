package com.destivar89.randomusers.presentation.randomusers.view.fragment;


import com.destivar89.randomusers.R;
import com.destivar89.randomusers.infrastructure.di.randomusers.DaggerRandomUsersComponent;
import com.destivar89.randomusers.infrastructure.di.randomusers.RandomUsersComponent;
import com.destivar89.randomusers.infrastructure.di.randomusers.RandomUsersModule;
import com.destivar89.randomusers.presentation.common.view.fragment.BaseFragment;
import com.destivar89.randomusers.presentation.randomusers.viewmodel.RandomUsersViewmodel;

import javax.inject.Inject;

public class RandomUsersFragment extends BaseFragment{

    private RandomUsersComponent component;

    @Inject
    RandomUsersViewmodel viewmodel;

    @Override
    protected Integer getContentView() {
        return R.layout.fragment_randomusers;
    }

    @Override
    protected void loadInitialData() {
        viewmodel.loadUsers();
    }

    @Override
    protected void injectComponent() {
        if(component == null){
            component = DaggerRandomUsersComponent.builder()
                    .baseModule(getBaseModule())
                    .randomUsersModule(new RandomUsersModule())
                    .build();
        }
        component.inject(this);
    }

}
