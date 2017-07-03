package com.destivar89.randomusers.domain.interactor.randomusers;

import com.destivar89.randomusers.data.dto.randomusers.RandomUsersDTO;
import com.destivar89.randomusers.data.repository.RepositoryCallback;
import com.destivar89.randomusers.data.repository.randomusers.RandomUsersSimpleRepository;
import com.destivar89.randomusers.domain.interactor.InteractorCallback;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RandomUsersInteractorImplTest {


    private RandomUsersInteractorImpl interactor;

    @Mock
    RandomUsersSimpleRepository repository;

    @Mock
    InteractorCallback<RandomUsersDTO> interactorCallback;

    @Before
    public void setUp() throws IOException {

        interactor = new RandomUsersInteractorImpl(repository);

    }

    @Test
    public void retrieveRandomUsers_shouldCallRepositoryMethod() throws Exception {

        interactor.retrieveRandomUsers(0, interactorCallback);

        verify(repository).retrieveRandomUsers(anyInt(), anyInt(), any(RepositoryCallback.class));

    }



}