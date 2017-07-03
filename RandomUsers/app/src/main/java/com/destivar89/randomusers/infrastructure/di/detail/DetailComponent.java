package com.destivar89.randomusers.infrastructure.di.detail;

import com.destivar89.randomusers.presentation.detail.view.fragment.DetailFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DetailModule.class)
public interface DetailComponent {
    void inject(DetailFragment fragment);
}
