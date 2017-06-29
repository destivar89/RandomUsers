package com.destivar89.randomusers.infrastructure.di.randomusers;


import com.destivar89.randomusers.presentation.randomusers.view.fragment.RandomUsersFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = RandomUsersModule.class)
public interface RandomUsersComponent {
    void inject(RandomUsersFragment fragment);
}
