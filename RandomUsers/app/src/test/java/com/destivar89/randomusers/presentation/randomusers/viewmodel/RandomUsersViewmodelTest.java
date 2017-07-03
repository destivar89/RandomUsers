package com.destivar89.randomusers.presentation.randomusers.viewmodel;

import android.app.Activity;

import com.destivar89.randomusers.data.dto.randomusers.RandomUsersDTO;
import com.destivar89.randomusers.domain.interactor.InteractorCallback;
import com.destivar89.randomusers.domain.interactor.randomusers.RandomUsersInteractor;
import com.destivar89.randomusers.domain.interactor.randomusers.RandomUsersInteractorImpl;
import com.destivar89.randomusers.domain.mapper.RandomUsersMapper;
import com.destivar89.randomusers.presentation.common.navigator.NavigatorImpl;
import com.destivar89.randomusers.presentation.randomusers.adapter.RandomUsersAdapter;
import com.destivar89.randomusers.presentation.randomusers.model.RandomUserItemModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RandomUsersViewmodelTest {

    private RandomUsersViewmodel viewmodel;

    @Mock
    Activity activityContext;

    @Mock
    NavigatorImpl navigator;

    @Mock
    RandomUsersInteractorImpl interactor;

    @Mock
    RandomUsersAdapter adapter;

    @Before
    public void setUp(){

        viewmodel = new RandomUsersViewmodel(navigator, activityContext, interactor, adapter);

    }

    @Test
    public void loadUsers_shouldCallInteractorRetrieveUsers(){

        viewmodel.loadUsers();

        verify(interactor).retrieveRandomUsers(anyInt(), any(InteractorCallback.class));

    }

    @Test
    public void onClickRetry_shouldCallInteractorRetrieveUsers(){

        viewmodel.onClickRetry(null);

        verify(interactor).retrieveRandomUsers(anyInt(), any(InteractorCallback.class));

    }

    @Test
    public void onItemClick_shouldCallNavigatorGoToDetail(){

        RandomUserItemModel randomUserItemModel = new RandomUserItemModel();

        viewmodel.onItemClick(randomUserItemModel);

        verify(navigator).goToDetail();

    }

}