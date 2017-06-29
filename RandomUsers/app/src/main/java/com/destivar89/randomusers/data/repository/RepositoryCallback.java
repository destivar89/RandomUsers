package com.destivar89.randomusers.data.repository;

public interface RepositoryCallback<T> {

    void repositorySuccess(T data);

    void repositoryFail(Throwable t);

}
