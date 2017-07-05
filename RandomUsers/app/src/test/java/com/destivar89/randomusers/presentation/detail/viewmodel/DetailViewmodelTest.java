package com.destivar89.randomusers.presentation.detail.viewmodel;

import com.destivar89.randomusers.presentation.detail.model.DetailModel;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class DetailViewmodelTest {

    private DetailViewmodel viewmodel;

    @Test
    public void getEmail_withNullModel_shouldReturnEmptyString(){

        viewmodel = new DetailViewmodel();
        viewmodel.setModel(null);

        assertTrue(viewmodel.getEmail().isEmpty());

    }

    @Test
    public void getPhone_withNullModel_shouldReturnEmptyString(){

        viewmodel = new DetailViewmodel();
        viewmodel.setModel(null);

        assertTrue(viewmodel.getPhone().isEmpty());

    }

    @Test
    public void getGender_withNullModel_shouldReturnEmptyString(){

        viewmodel = new DetailViewmodel();
        viewmodel.setModel(null);

        assertTrue(viewmodel.getGender().isEmpty());

    }

    @Test
    public void getLocation_withNullModel_shouldReturnEmptyString(){

        viewmodel = new DetailViewmodel();
        viewmodel.setModel(null);

        assertTrue(viewmodel.getLocation().isEmpty());

    }

    @Test
    public void getRegisteredDate_withNullModel_shouldReturnEmptyString(){

        viewmodel = new DetailViewmodel();
        viewmodel.setModel(null);

        assertTrue(viewmodel.getRegisteredDate().isEmpty());

    }

    @Test
    public void getThumb_withNullModel_shouldReturnEmptyString(){

        viewmodel = new DetailViewmodel();
        viewmodel.setModel(null);

        assertTrue(viewmodel.getThumb().isEmpty());

    }

    @Test
    public void getEmail_withModel_shouldReturnSameString(){

        String expectedEmail= "expectedEmail";

        DetailModel model = new DetailModel.Builder().setEmail(expectedEmail).build();

        viewmodel = new DetailViewmodel();
        viewmodel.setModel(model);

        assertEquals(expectedEmail, viewmodel.getEmail());

    }

    @Test
    public void getPhone_withModel_shouldReturnSameString(){

        String expectedPhone= "expectedPhone";

        DetailModel model = new DetailModel.Builder().setPhoneNumber(expectedPhone).build();

        viewmodel = new DetailViewmodel();
        viewmodel.setModel(model);

        assertEquals(expectedPhone, viewmodel.getPhone());

    }

    @Test
    public void getGender_withModel_shouldReturnSameString(){

        String expectedGender= "expectedGender";

        DetailModel model = new DetailModel.Builder().setGender(expectedGender).build();

        viewmodel = new DetailViewmodel();
        viewmodel.setModel(model);

        assertEquals(expectedGender, viewmodel.getGender());

    }

    @Test
    public void getLocation_withModel_shouldReturnSameString(){

        String expectedLocation= "expectedLocation";

        DetailModel model = new DetailModel.Builder().setLocation(expectedLocation).build();

        viewmodel = new DetailViewmodel();
        viewmodel.setModel(model);

        assertEquals(expectedLocation, viewmodel.getLocation());

    }

    @Test
    public void getRegisteredDate_withModel_shouldReturnSameString(){

        String expectedDate= "expectedDate";

        DetailModel model = new DetailModel.Builder().setRegisteredDate(expectedDate).build();

        viewmodel = new DetailViewmodel();
        viewmodel.setModel(model);

        assertEquals(expectedDate, viewmodel.getRegisteredDate());

    }

    @Test
    public void getThumb_withModel_shouldReturnSameString(){

        String expectedThumb = "expectedThumb";

        DetailModel model = new DetailModel.Builder().setThumbnailUrl(expectedThumb).build();

        viewmodel = new DetailViewmodel();
        viewmodel.setModel(model);

        assertEquals(expectedThumb, viewmodel.getThumb());

    }

}