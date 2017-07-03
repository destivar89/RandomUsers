package com.destivar89.randomusers.domain.interactor.removedusers;


import com.destivar89.randomusers.data.dto.removedusers.RealmUser;
import com.destivar89.randomusers.presentation.randomusers.model.RandomUserItemModel;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;

public class RemovedUsersInteractorImpl implements RemovedUsersInteractor {

    private Realm realm;

    @Inject
    public RemovedUsersInteractorImpl(Realm realm){
        this.realm = realm;
    }


    @Override
    public void removeUser(RandomUserItemModel userModel) {

        realm.beginTransaction();
        RealmUser user = new RealmUser();
        realm.copyToRealm(user);
        realm.commitTransaction();

    }

    @Override
    public List<RandomUserItemModel> applyRemovedUsers(List<RandomUserItemModel> users) {

        for (int i = 0 ; i < realm.where(RealmUser.class).count() ; i++){
            removeUser(users, realm.where(RealmUser.class).findAll().get(i));
        }

        return users;

    }

    private List<RandomUserItemModel> removeUser(List<RandomUserItemModel> users, RealmUser user){

        Iterator<RandomUserItemModel> i = users.iterator();
        while (i.hasNext()) {
            RandomUserItemModel userItemModel = i.next(); // must be called before you can call i.remove()
            if (userItemModel.getEmail().equals(user.getEmail()))
                i.remove();
        }

        return users;

    }

}
