package com.destivar89.randomusers.domain.mapper;


import com.destivar89.randomusers.data.dto.randomusers.RandomUsersDTO;
import com.destivar89.randomusers.data.dto.randomusers.Result;
import com.destivar89.randomusers.presentation.randomusers.model.RandomUserItemModel;

import java.util.ArrayList;
import java.util.List;

public class RandomUsersMapper {
    public static List<RandomUserItemModel> mapDtoToUserModelList(RandomUsersDTO data) {

        List<RandomUserItemModel> items = new ArrayList<>();

        if (data == null || data.getResults() == null) return items;
        for (Result result : data.getResults()){

            String firstName = (result.getName() == null) ? "" : result.getName().getFirst();
            String lastName = (result.getName() == null) ? "" : result.getName().getLast();
            String thumbnail = (result.getPicture() == null) ? "" : result.getPicture().getThumbnail();

            RandomUserItemModel item = new RandomUserItemModel.Builder()
                    .setEmail(result.getEmail())
                    .setFullname(firstName + " " + lastName)
                    .setPhoneNumber(result.getPhone())
                    .setThumbnailUrl(thumbnail)
                    .build();
            items.add(item);
        }

        return items;

    }
}
