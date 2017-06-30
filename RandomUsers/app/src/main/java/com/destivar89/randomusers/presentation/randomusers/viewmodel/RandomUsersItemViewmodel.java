package com.destivar89.randomusers.presentation.randomusers.viewmodel;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.destivar89.randomusers.presentation.common.viewmodel.Viewmodel;
import com.destivar89.randomusers.presentation.randomusers.model.RandomUserItemModel;

public class RandomUsersItemViewmodel extends BaseObservable implements Viewmodel {

    private RandomUserItemModel model;

    public RandomUsersItemViewmodel(RandomUserItemModel model){
        this.model = model;
    }

    @Bindable
    public String getFullname(){
        if(model == null) return "";
        return model.getFullname();
    }

    @Bindable
    public String getEmail(){
        if(model == null) return "";
        return model.getEmail();
    }
    @Bindable
    public String getPhone(){
        if(model == null) return "";
        return model.getPhoneNumber();
    }

    @Bindable
    public String getThumbUrl(){
        if(model == null) return "";
        return model.getThumbnailUrl();
    }


}
