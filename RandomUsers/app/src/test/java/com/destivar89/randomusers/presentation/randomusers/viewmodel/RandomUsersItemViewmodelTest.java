package com.destivar89.randomusers.presentation.randomusers.viewmodel;

import com.destivar89.randomusers.presentation.randomusers.model.RandomUserItemModel;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RandomUsersItemViewmodelTest {

    private RandomUserItemModel model;
    private RandomUsersItemViewmodel viewmodel;

    @Test
    public void getFullname_withModel_shouldReturnModelInfo(){

        String expectedFullname =  "aFullname";

        model = new RandomUserItemModel.Builder()
                .setFullname(expectedFullname)
                .build();

        viewmodel = new RandomUsersItemViewmodel(model);

        assertEquals(expectedFullname, viewmodel.getFullname());

    }

    @Test
    public void getFullname_withNullModel_shouldReturnEmptyInfo(){

        String expectedFullname =  "";

        viewmodel = new RandomUsersItemViewmodel(null);

        assertEquals(expectedFullname, viewmodel.getFullname());

    }

    @Test
    public void getEmail_withModel_shouldReturnModelInfo(){

        String expectedEmail =  "aEmail";

        model = new RandomUserItemModel.Builder()
                .setEmail(expectedEmail)
                .build();

        viewmodel = new RandomUsersItemViewmodel(model);

        assertEquals(expectedEmail, viewmodel.getEmail());

    }

    @Test
    public void getEmail_withNullModel_shouldReturnEmptyInfo(){

        String expectedEmail =  "";

        viewmodel = new RandomUsersItemViewmodel(null);

        assertEquals(expectedEmail, viewmodel.getEmail());

    }

    @Test
    public void getPhone_withModel_shouldReturnModelInfo(){

        String expectedPhone =  "aPhone";

        model = new RandomUserItemModel.Builder()
                .setPhoneNumber(expectedPhone)
                .build();

        viewmodel = new RandomUsersItemViewmodel(model);

        assertEquals(expectedPhone, viewmodel.getPhone());

    }

    @Test
    public void getPhone_withNullModel_shouldReturnEmptyInfo(){

        String expectedPhone =  "";

        viewmodel = new RandomUsersItemViewmodel(null);

        assertEquals(expectedPhone, viewmodel.getPhone());

    }

    @Test
    public void getThumbUrl_withModel_shouldReturnModelInfo(){

        String expectedThumbUrl =  "aThumbUrl";

        model = new RandomUserItemModel.Builder()
                .setThumbnailUrl(expectedThumbUrl)
                .build();

        viewmodel = new RandomUsersItemViewmodel(model);

        assertEquals(expectedThumbUrl, viewmodel.getThumbUrl());

    }

    @Test
    public void getThumbUrl_withNullModel_shouldReturnEmptyInfo(){

        String expectedThumbUrl =  "";

        viewmodel = new RandomUsersItemViewmodel(null);

        assertEquals(expectedThumbUrl, viewmodel.getThumbUrl());

    }


}