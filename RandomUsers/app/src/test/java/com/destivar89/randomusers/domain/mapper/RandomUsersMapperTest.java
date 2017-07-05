package com.destivar89.randomusers.domain.mapper;

import com.destivar89.randomusers.data.dto.randomusers.Name;
import com.destivar89.randomusers.data.dto.randomusers.Picture;
import com.destivar89.randomusers.data.dto.randomusers.RandomUsersDTO;
import com.destivar89.randomusers.data.dto.randomusers.Result;
import com.destivar89.randomusers.presentation.detail.model.DetailModel;
import com.destivar89.randomusers.presentation.randomusers.model.RandomUserItemModel;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class RandomUsersMapperTest {

    @Test
    public void mapDtoToUserModelList_withNullDTO_shouldReturnEmptyArray(){

        assertTrue(RandomUsersMapper.mapDtoToUserModelList(null).isEmpty());

    }

    @Test
    public void mapDtoToUserModelList_withNullResults_shouldReturnEmptyArray(){

        RandomUsersDTO data = new RandomUsersDTO();

        assertTrue(RandomUsersMapper.mapDtoToUserModelList(null).isEmpty());

    }

    @Test
    public void mapDtoToUserModelList_withResults_shouldReturnArray(){

        String expectedFullname = "first last";
        String expectedEmail = "email";
        String expectedPhone = "phone";
        String expectedThumbnail = "thumb";

        RandomUsersDTO data = buildDto();

        List<RandomUserItemModel> items = RandomUsersMapper.mapDtoToUserModelList(data);

        assertEquals(expectedFullname, items.get(0).getFullname());
        assertEquals(expectedEmail, items.get(0).getEmail());
        assertEquals(expectedPhone, items.get(0).getPhoneNumber());
        assertEquals(expectedThumbnail, items.get(0).getThumbnailUrl());

    }

    @Test
    public void mapDtoToDetailModel_withNullResult_shouldReturnNull(){

        assertNull(RandomUsersMapper.mapDtoToDetailModel(null));

    }

    @Test
    public void mapDtoToDetailModel_withResult_shouldReturnModel(){

        String expectedFullname = "first last";
        String expectedEmail = "email";
        String expectedPhone = "phone";
        String expectedThumbnail = "large";
        String expectedRegisteredDate = "08/08/2017";

        RandomUsersDTO data = buildDto();

        DetailModel model = RandomUsersMapper.mapDtoToDetailModel(data.getResults().get(0));

        assertEquals(expectedFullname, model.getFullname());
        assertEquals(expectedEmail, model.getEmail());
        assertEquals(expectedPhone, model.getPhoneNumber());
        assertEquals(expectedThumbnail, model.getThumbnailUrl());
        assertEquals(expectedRegisteredDate, model.getRegisteredDate());

    }

    private RandomUsersDTO buildDto(){
        RandomUsersDTO data = new RandomUsersDTO();

        List<Result> results = new ArrayList<>();
        Result result = new Result();
        Name name = new Name();
        name.setFirst("first");
        name.setLast("last");
        result.setName(name);
        result.setEmail("email");
        result.setPhone("phone");
        result.setRegistered("2017-08-08 00:00:00");
        Picture picture = new Picture();
        picture.setThumbnail("thumb");
        picture.setLarge("large");
        result.setPicture(picture);

        results.add(result);

        data.setResults(results);

        return data;
    }

}