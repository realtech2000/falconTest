package hu.pairg.falconTest.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pairg on 2016.04.23..
 */
public class Envelope<T> {

    @JsonProperty("isError")
    private final boolean isError;
    private final String message;
    private final T data;

    public Envelope(T data) {
        this.data = data;
        this.message = null;
        this.isError = false;
    }

    public Envelope(String errorMessage) {
        this.data = null;
        this.message = errorMessage;
        this.isError = true;
    }

    public boolean isError() {
        return isError;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

}
