package hu.pairg.falconTest.frontend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pairg on 2016.04.25..
 */
public class Services {

    private final int websocketServicePort;
    private final int restServicePort;

    public Services(
            @JsonProperty(value = "websocketServicePort", required = true) int websocketServicePort,
            @JsonProperty(value = "restServicePort", required = true) int restServicePort
    ) {
        this.websocketServicePort = websocketServicePort;
        this.restServicePort = restServicePort;
    }

    public int getWebsocketServicePort() {
        return websocketServicePort;
    }

    public int getRestServicePort() {
        return restServicePort;
    }

}
