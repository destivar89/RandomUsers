package com.destivar89.randomusers.presentation.detail.model;


import java.io.Serializable;

public class DetailModel implements Serializable{

    private String fullname;
    private String email;
    private String thumbnailUrl;
    private String phoneNumber;
    private String gender;
    private String location;
    private String registeredDate;

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getLocation() {
        return location;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public static class Builder{

        private String fullname;
        private String email;
        private String thumbnailUrl;
        private String phoneNumber;
        private String gender;
        private String location;
        private String registeredDate;

        public Builder setFullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setThumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setRegisteredDate(String registeredDate) {
            this.registeredDate = registeredDate;
            return this;
        }

        public DetailModel build(){

            DetailModel model = new DetailModel();
            model.fullname = fullname;
            model.email = email;
            model.thumbnailUrl = thumbnailUrl;
            model.phoneNumber = phoneNumber;
            model.gender = gender;
            model.location = location;
            model.registeredDate = registeredDate;

            return model;

        }
    }
}
