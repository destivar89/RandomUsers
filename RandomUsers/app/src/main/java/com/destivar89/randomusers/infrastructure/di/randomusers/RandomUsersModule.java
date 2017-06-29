package com.destivar89.randomusers.infrastructure.di.randomusers;

import com.destivar89.randomusers.data.api.ApiClientGenerator;
import com.destivar89.randomusers.data.api.RestApi;
import com.destivar89.randomusers.data.repository.randomusers.RandomUsersRepository;
import com.destivar89.randomusers.data.repository.randomusers.RandomUsersSimpleRepository;
import com.destivar89.randomusers.domain.interactor.randomusers.RandomUsersInteractor;
import com.destivar89.randomusers.domain.interactor.randomusers.RandomUsersInteractorImpl;
import com.destivar89.randomusers.infrastructure.di.common.BaseModule;
import com.destivar89.randomusers.presentation.common.viewmodel.Viewmodel;
import com.destivar89.randomusers.presentation.randomusers.viewmodel.RandomUsersViewmodel;

import dagger.Module;
import dagger.Provides;

@Module(includes = BaseModule.class)
public class RandomUsersModule {

    @Provides
    Viewmodel providesLoginViewModel(RandomUsersViewmodel viewModel){
        return viewModel;
    }

    @Provides
    RandomUsersInteractor providesLoginInteractor(RandomUsersInteractorImpl interactor){
        return interactor;
    }

    @Provides
    RandomUsersRepository providesRandomUsersRepository(RandomUsersSimpleRepository repository){
        return repository;
    }

    @Provides
    ApiClientGenerator providesApiClientGenerator(RestApi restApi){
        return restApi;
    }

}