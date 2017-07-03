package com.destivar89.randomusers.domain.interactor.removedusers;


import com.destivar89.randomusers.presentation.randomusers.model.RandomUserItemModel;

import java.util.List;

public interface RemovedUsersInteractor {

    void removeUser(RandomUserItemModel userModel);
    List<RandomUserItemModel> applyRemovedUsers(List<RandomUserItemModel> users);

}
