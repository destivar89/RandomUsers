package com.destivar89.randomusers.presentation.randomusers.viewmodel;


import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.destivar89.randomusers.data.dto.randomusers.RandomUsersDTO;
import com.destivar89.randomusers.domain.interactor.InteractorCallback;
import com.destivar89.randomusers.domain.interactor.randomusers.RandomUsersInteractor;
import com.destivar89.randomusers.domain.interactor.removedusers.RemovedUsersInteractor;
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
    private RandomUsersInteractor interactor;
    private RandomUsersAdapter adapter;
    private RemovedUsersInteractor removedUsersInteractor;

    private LinearLayoutManager layoutManager;

    private ObservableBoolean loading = new ObservableBoolean(false);
    private ObservableBoolean error = new ObservableBoolean(false);

    @Inject
    public RandomUsersViewmodel(Navigator navigator, Activity activityContext, RandomUsersInteractor interactor,
                                RandomUsersAdapter adapter, RemovedUsersInteractor removedUsersInteractor){

        this.navigator = navigator;
        this.interactor = interactor;
        this.adapter = adapter;
        this.removedUsersInteractor = removedUsersInteractor;

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
        items = removedUsersInteractor.applyRemovedUsers(items);
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

    @Bindable
    public ItemTouchHelper getItemTouchHelper(){

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                removedUsersInteractor.removeUser(adapter.getItem(viewHolder.getAdapterPosition()));
                adapter.removeItem(viewHolder.getAdapterPosition());
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        };

        return new ItemTouchHelper(simpleItemTouchCallback);

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
