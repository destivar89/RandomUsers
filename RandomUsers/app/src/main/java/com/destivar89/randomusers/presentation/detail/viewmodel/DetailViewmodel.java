package com.destivar89.randomusers.presentation.detail.viewmodel;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

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

    @Bindable
    public String getEmail(){
        if (model == null) return "";
        return model.getEmail();
    }

    @Bindable
    public String getPhone(){
        if (model == null) return "";
        return model.getPhoneNumber();
    }

    @Bindable
    public String getGender(){
        if (model == null) return "";
        return model.getGender();
    }

    @Bindable
    public String getLocation(){
        if (model == null) return "";
        return model.getLocation();
    }

    @Bindable
    public String getRegisteredDate(){
        if (model == null) return "";
        return model.getRegisteredDate();
    }

    @Bindable
    public String getThumb(){
        if (model == null) return "";
        return model.getThumbnailUrl();
    }

}
