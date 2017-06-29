package com.destivar89.randomusers.data.api;


import com.destivar89.randomusers.data.dto.randomusers.RandomUsersDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandomUsersService {

    @GET("/api/")
    Call<RandomUsersDTO> retrieveRandomUsers(@Query("page") int page, @Query("results") int results);

}
