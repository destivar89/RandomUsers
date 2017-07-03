package com.destivar89.randomusers.infrastructure.di.detail;

import com.destivar89.randomusers.infrastructure.di.common.BaseModule;
import com.destivar89.randomusers.presentation.common.viewmodel.Viewmodel;
import com.destivar89.randomusers.presentation.detail.viewmodel.DetailViewmodel;

import dagger.Module;
import dagger.Provides;

@Module(includes = BaseModule.class)
public class DetailModule {

    @Provides
    Viewmodel providesTransportDetailViewmodel(DetailViewmodel viewmodel){
        return viewmodel;
    }

}
