package com.destivar89.randomusers.presentation.randomusers.viewmodel;


import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.destivar89.randomusers.data.dto.randomusers.RandomUsersDTO;
import com.destivar89.randomusers.domain.interactor.InteractorCallback;
import com.destivar89.randomusers.domain.interactor.randomusers.RandomUsersInteractor;
import com.destivar89.randomusers.domain.mapper.RandomUsersMapper;
import com.destivar89.randomusers.presentation.common.navigator.Navigator;
import com.destivar89.randomusers.presentation.common.utils.EndlessScrollListener;
import com.destivar89.randomusers.presentation.common.viewmodel.Viewmodel;
import com.destivar89.randomusers.presentation.randomusers.adapter.RandomUsersAdapter;
import com.destivar89.randomusers.presentation.randomusers.model.RandomUserItemModel;

import java.util.List;

import javax.inject.Inject;

public class RandomUsersViewmodel extends BaseObservable implements Viewmodel, InteractorCallback<RandomUsersDTO>, RandomUsersAdapter.OnItemClickListener {

    private static final int FIRST_PAGE = 0;

    private Navigator navigator;
    private Activity activityContext;
    private RandomUsersInteractor interactor;
    private RandomUsersAdapter adapter;
    private LinearLayoutManager layoutManager;

    private ObservableBoolean loading = new ObservableBoolean(false);
    private ObservableBoolean error = new ObservableBoolean(false);

    @Inject
    public RandomUsersViewmodel(Navigator navigator, Activity activityContext, RandomUsersInteractor interactor, RandomUsersAdapter adapter){
        this.navigator = navigator;
        this.activityContext = activityContext;
        this.interactor = interactor;
        this.adapter = adapter;

        layoutManager = new LinearLayoutManager(activityContext);
        adapter.setOnItemClickListener(this);
    }

    public void loadUsers(){
        loading.set(true);
        interactor.retrieveRandomUsers(FIRST_PAGE, this);
    }

    @Override
    public void success(RandomUsersDTO data) {
        List<RandomUserItemModel> items = RandomUsersMapper.mapDtoToUserModelList(data);
        adapter.addItems(items);
        adapter.notifyDataSetChanged();
        loading.set(false);
    }

    @Override
    public void fail(Throwable t) {
        loading.set(false);
        error.set(true);
    }

    @Bindable
    public RecyclerView.LayoutManager getLayoutManager (){
        return layoutManager;
    }

    @Bindable
    public RandomUsersAdapter getAdapter(){
        return adapter;
    }

    @Bindable
    public ObservableBoolean getLoading(){
        return loading;
    }

    @Bindable
    public ObservableBoolean getError(){
        return error;
    }

    @Bindable
    public EndlessScrollListener getScrollListener(){
        return new EndlessScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                interactor.retrieveRandomUsers(page, RandomUsersViewmodel.this);
            }
        };
    }

    @Override
    public void onItemClick(RandomUserItemModel model) {
        navigator.goToDetail(model);
    }

    public void onClickRetry(View v){
        loading.set(true);
        interactor.retrieveRandomUsers(FIRST_PAGE, this);
    }
}
