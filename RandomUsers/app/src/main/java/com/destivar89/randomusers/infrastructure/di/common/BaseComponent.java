package com.destivar89.randomusers.infrastructure.di.common;

import com.destivar89.randomusers.presentation.common.view.fragment.BaseFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = BaseModule.class)
public interface BaseComponent {
    void inject(BaseFragment fragment);
}
