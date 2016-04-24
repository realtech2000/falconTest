package hu.pairg.falconTest.ws.messaging;

import hu.pairg.falconTest.ws.messaging.dto.ChannelMessage;
import hu.pairg.falconTest.ws.domain.Message;
import hu.pairg.falconTest.ws.service.ReceiveMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.json.JsonObjectMapper;

/**
 * Created by pairg on 2016.04.24..
 */
@EnableBinding(MessageChannels.class)
class Sink<N, P> {

    private ReceiveMessageService receiveMessageService;

    private JsonObjectMapper<N, P> jsonObjectMapper;

    @Autowired
    public void setReceiveMessageService(ReceiveMessageService receiveMessageService) {
        this.receiveMessageService = receiveMessageService;
    }

    @Autowired
    public void setJsonObjectMapper(
            @Qualifier("WsJsonObjectMapper") JsonObjectMapper<N, P> jsonObjectMapper
    ) {
        this.jsonObjectMapper = jsonObjectMapper;
    }

    @ServiceActivator(inputChannel = MessageChannels.INPUT)
    public void receive(String json) throws Exception {
        ChannelMessage message = this.convertJsonToChannelMessage(json);
        Message msg = new Message(message.getSenderName(), message.getMessage());
        this.receiveMessageService.receiveMessage(message.getRoomName(), msg);
    }

    private ChannelMessage convertJsonToChannelMessage(String jsonMessage) throws Exception {
        return this.jsonObjectMapper.fromJson(jsonMessage, ChannelMessage.class);
    }

}
