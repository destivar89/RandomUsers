package com.destivar89.randomusers.data.api;

public interface ApiClientGenerator {
    <T> T generatedApi(Class<T> service);
}