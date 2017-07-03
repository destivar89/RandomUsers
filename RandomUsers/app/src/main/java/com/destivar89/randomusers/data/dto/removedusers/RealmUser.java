package com.destivar89.randomusers.data.dto.removedusers;


import io.realm.RealmObject;

public class RealmUser extends RealmObject{

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
