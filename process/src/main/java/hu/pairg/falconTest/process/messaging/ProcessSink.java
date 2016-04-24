package hu.pairg.falconTest.process.messaging;

import hu.pairg.falconTest.process.domain.Message;
import hu.pairg.falconTest.process.service.CreateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.json.JsonObjectMapper;

/**
 * Created by pairg on 2016.04.24..
 */
@EnableBinding(MessageChannels.class)
class ProcessSink<N, P> {
    private CreateMessageService createMessageService;
    private JsonObjectMapper<N, P> jsonObjectMapper;

    @Autowired
    public void setReceiveMessageService(CreateMessageService createMessageService) {
        this.createMessageService = createMessageService;
    }

    @Autowired
    public void setJsonObjectMapper(JsonObjectMapper<N, P> jsonObjectMapper) {
        this.jsonObjectMapper = jsonObjectMapper;
    }

    @StreamListener(MessageChannels.INPUT)
    public void receive(String json) throws Exception {
        this.createMessageService.createMessage(
                this.jsonObjectMapper.fromJson(json, Message.class)
        );
    }

}
