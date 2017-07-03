package com.destivar89.randomusers.domain.mapper;


import com.destivar89.randomusers.data.dto.randomusers.RandomUsersDTO;
import com.destivar89.randomusers.data.dto.randomusers.Result;
import com.destivar89.randomusers.presentation.detail.model.DetailModel;
import com.destivar89.randomusers.presentation.randomusers.model.RandomUserItemModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RandomUsersMapper {

    public static List<RandomUserItemModel> mapDtoToUserModelList(RandomUsersDTO data) {

        List<RandomUserItemModel> items = new ArrayList<>();

        if (data == null || data.getResults() == null) return items;
        for (Result result : data.getResults()){

            String firstName = (result.getName() == null) ? "" : result.getName().getFirst();
            String lastName = (result.getName() == null) ? "" : result.getName().getLast();
            String thumbnail = (result.getPicture() == null) ? "" : result.getPicture().getThumbnail();
            String phone = (result.getPhone() == null) ? "" : result.getPhone();

            RandomUserItemModel item = new RandomUserItemModel.Builder()
                    .setEmail(result.getEmail())
                    .setFullname(firstName + " " + lastName)
                    .setPhoneNumber(phone)
                    .setThumbnailUrl(thumbnail)
                    .build();
            items.add(item);
        }

        return items;

    }

    public static DetailModel mapDtoToDetailModel(Result result) {

        if (result == null ) return new DetailModel();

        String firstName = (result.getName() == null) ? "" : result.getName().getFirst();
        String lastName = (result.getName() == null) ? "" : result.getName().getLast();
        String thumbnail = (result.getPicture() == null) ? "" : result.getPicture().getThumbnail();
        String phone = (result.getPhone() == null) ? "" : result.getPhone();
        String gender = (result.getGender() == null) ? "" : result.getGender();
        String street = (result.getLocation() == null) ? "" : result.getLocation().getStreet();
        String city = (result.getLocation() == null) ? "" : result.getLocation().getCity();
        String state = (result.getLocation() == null) ? "" : result.getLocation().getState();
        String registeredDate = (result.getRegistered() == null) ? "" : result.getRegistered();

        DetailModel model = new DetailModel.Builder()
                    .setEmail(result.getEmail())
                    .setFullname(firstName + " " + lastName)
                    .setPhoneNumber(phone)
                    .setThumbnailUrl(thumbnail)
                    .setGender(gender)
                    .setLocation(street + ", " + city + ", " + state)
                    .setRegisteredDate(formatDate(registeredDate))
                    .build();

        return model;

    }

    private static String formatDate(String date){

        DateFormat formatResult = new SimpleDateFormat("dd/MM/yyyy");

        return formatResult.format(new Date(Long.parseLong(date)*1000));

    }

}
