package com.destivar89.randomusers.domain.mapper;

import com.destivar89.randomusers.R;
import com.destivar89.randomusers.data.dto.randomusers.Name;
import com.destivar89.randomusers.data.dto.randomusers.Picture;
import com.destivar89.randomusers.data.dto.randomusers.RandomUsersDTO;
import com.destivar89.randomusers.data.dto.randomusers.Result;
import com.destivar89.randomusers.presentation.randomusers.model.RandomUserItemModel;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
        Picture picture = new Picture();
        picture.setThumbnail("thumb");
        result.setPicture(picture);

        results.add(result);

        data.setResults(results);

        return data;
    }

}