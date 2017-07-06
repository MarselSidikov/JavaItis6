package ru.itis.vk.models;

import java.util.List;

public class Friends {
    private List<Friend> response;

    public Friends() {
    }

    public List<Friend> getResponse() {
        return response;
    }

    public void setResponse(List<Friend> response) {
        this.response = response;
    }
}
