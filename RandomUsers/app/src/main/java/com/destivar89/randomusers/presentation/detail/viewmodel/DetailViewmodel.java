package com.destivar89.randomusers.presentation.detail.viewmodel;


import android.databinding.BaseObservable;

import com.android.databinding.library.baseAdapters.BR;
import com.destivar89.randomusers.presentation.common.viewmodel.Viewmodel;
import com.destivar89.randomusers.presentation.detail.model.DetailModel;

import javax.inject.Inject;

public class DetailViewmodel extends BaseObservable implements Viewmodel  {

    private DetailModel model;

    @Inject
    public DetailViewmodel(){
    }

    public void setModel(DetailModel model) {
        this.model = model;
        notifyPropertyChanged(BR._all);
    }

}
