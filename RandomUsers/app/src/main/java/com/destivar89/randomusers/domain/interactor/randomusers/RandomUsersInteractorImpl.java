package com.destivar89.randomusers.domain.interactor.randomusers;


import com.destivar89.randomusers.data.dto.randomusers.RandomUsersDTO;
import com.destivar89.randomusers.data.repository.RepositoryCallback;
import com.destivar89.randomusers.data.repository.randomusers.RandomUsersRepository;
import com.destivar89.randomusers.domain.interactor.InteractorCallback;

import javax.inject.Inject;

public class RandomUsersInteractorImpl implements RandomUsersInteractor {

    public static final int PAGE_SIZE = 20;

    private RandomUsersRepository repository;

    @Inject
    public RandomUsersInteractorImpl(RandomUsersRepository repository){
        this.repository = repository;
    }

    @Override
    public void retrieveRandomUsers(int page, final InteractorCallback<RandomUsersDTO> callback) {

        repository.retrieveRandomUsers(page, PAGE_SIZE, new RepositoryCallback<RandomUsersDTO>() {
            @Override
            public void repositorySuccess(RandomUsersDTO data) {
                callback.success(data);
            }

            @Override
            public void repositoryFail(Throwable t) {
                callback.fail(t);
            }
        });

    }

}
