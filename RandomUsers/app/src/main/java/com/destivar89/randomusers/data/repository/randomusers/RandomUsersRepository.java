package com.destivar89.randomusers.data.repository.randomusers;


import com.destivar89.randomusers.data.dto.randomusers.RandomUsersDTO;
import com.destivar89.randomusers.data.repository.RepositoryCallback;

public interface RandomUsersRepository {

    void retrieveRandomUsers(int page, int results, RepositoryCallback<RandomUsersDTO> callback);

}
