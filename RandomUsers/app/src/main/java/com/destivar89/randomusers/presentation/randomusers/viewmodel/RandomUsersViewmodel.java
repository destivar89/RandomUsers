package com.destivar89.randomusers.presentation.randomusers.viewmodel;


import android.app.Activity;
import android.databinding.BaseObservable;

import com.destivar89.randomusers.data.dto.randomusers.RandomUsersDTO;
import com.destivar89.randomusers.domain.interactor.InteractorCallback;
import com.destivar89.randomusers.domain.interactor.randomusers.RandomUsersInteractor;
import com.destivar89.randomusers.domain.mapper.RandomUsersMapper;
import com.destivar89.randomusers.presentation.common.navigator.Navigator;
import com.destivar89.randomusers.presentation.common.viewmodel.Viewmodel;
import com.destivar89.randomusers.presentation.randomusers.model.RandomUserItemModel;

import java.util.List;

import javax.inject.Inject;

public class RandomUsersViewmodel extends BaseObservable implements Viewmodel, InteractorCallback<RandomUsersDTO> {

    private Navigator navigator;
    private Activity activityContext;
    private RandomUsersInteractor interactor;

    @Inject
    public RandomUsersViewmodel(Navigator navigator, Activity activityContext, RandomUsersInteractor interactor){
        this.navigator = navigator;
        this.activityContext = activityContext;
        this.interactor = interactor;
    }

    public void loadUsers(){
        interactor.retrieveRandomUsers(this);
    }

    @Override
    public void success(RandomUsersDTO data) {
        List<RandomUserItemModel> items = RandomUsersMapper.mapDtoToUserModelList(data);
    }

    @Override
    public void fail(Throwable t) {

    }
}
