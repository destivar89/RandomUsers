package com.destivar89.randomusers.data.repository.randomusers;


import com.destivar89.randomusers.data.api.ApiClientGenerator;
import com.destivar89.randomusers.data.api.RandomUsersService;
import com.destivar89.randomusers.data.dto.randomusers.RandomUsersDTO;
import com.destivar89.randomusers.data.repository.RepositoryCallback;
import com.destivar89.randomusers.domain.exception.RepositoryException;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomUsersSimpleRepository implements RandomUsersRepository {

    private ApiClientGenerator restApi;

    @Inject
    public RandomUsersSimpleRepository(ApiClientGenerator restApi){
        this.restApi = restApi;
    }

    @Override
    public void retrieveRandomUsers(int page, int results, final RepositoryCallback<RandomUsersDTO> repositoryCallback) {

        Call<RandomUsersDTO> call = restApi.generatedApi(RandomUsersService.class).retrieveRandomUsers(page, results);

        call.enqueue(new Callback<RandomUsersDTO>() {
            @Override
            public void onResponse(Call<RandomUsersDTO> call, Response<RandomUsersDTO> response) {
                if (response.code() == 200)
                    repositoryCallback.repositorySuccess(response.body());
                else
                    repositoryCallback.repositoryFail(new RepositoryException("some error"));
            }

            @Override
            public void onFailure(Call<RandomUsersDTO> call, Throwable t) {
                repositoryCallback.repositoryFail(t);
            }
        });

    }

}
