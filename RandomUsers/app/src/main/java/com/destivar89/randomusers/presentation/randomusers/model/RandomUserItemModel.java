package com.destivar89.randomusers.presentation.randomusers.model;


public class RandomUserItemModel {

    private String fullname;
    private String email;
    private String thumbnailUrl;
    private String phoneNumber;

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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static class Builder{

        private String fullname;
        private String email;
        private String thumbnailUrl;
        private String phoneNumber;

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

        public RandomUserItemModel build(){

            RandomUserItemModel model = new RandomUserItemModel();
            model.fullname = fullname;
            model.email = email;
            model.thumbnailUrl = thumbnailUrl;
            model.phoneNumber = phoneNumber;

            return model;

        }
    }
}
