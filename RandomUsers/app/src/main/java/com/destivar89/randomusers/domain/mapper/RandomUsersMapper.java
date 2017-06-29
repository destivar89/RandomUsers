package com.destivar89.randomusers.domain.mapper;


import com.destivar89.randomusers.data.dto.randomusers.RandomUsersDTO;
import com.destivar89.randomusers.data.dto.randomusers.Result;
import com.destivar89.randomusers.presentation.randomusers.model.RandomUserItemModel;

import java.util.ArrayList;
import java.util.List;

public class RandomUsersMapper {
    public static List<RandomUserItemModel> mapDtoToUserModelList(RandomUsersDTO data) {

        List<RandomUserItemModel> items = new ArrayList<>();

        for (Result result : data.getResults()){
            RandomUserItemModel item = new RandomUserItemModel.Builder()
                    .setEmail(result.getEmail())
                    .setFullname(result.getName().getFirst() + " " + result.getName().getLast())
                    .setPhoneNumber(result.getPhone())
                    .setThumbnailUrl(result.getPicture().getThumbnail())
                    .build();
            items.add(item);
        }

        return items;

    }
}
