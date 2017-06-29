package com.destivar89.randomusers.domain.interactor;

public interface InteractorCallback<T> {

    void success(T data);

    void fail(Throwable t);

}
