package com.destivar89.randomusers.domain.interactor.randomusers;


import com.destivar89.randomusers.data.dto.randomusers.RandomUsersDTO;
import com.destivar89.randomusers.domain.interactor.InteractorCallback;

public interface RandomUsersInteractor {

    void retrieveRandomUsers(int page, InteractorCallback<RandomUsersDTO> callback);

}
