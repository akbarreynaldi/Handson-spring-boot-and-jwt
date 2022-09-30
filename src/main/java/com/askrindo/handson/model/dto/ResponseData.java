package com.askrindo.handson.model.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseData<T> {
    private List<String> messages = new ArrayList<>();
    private T data;

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
