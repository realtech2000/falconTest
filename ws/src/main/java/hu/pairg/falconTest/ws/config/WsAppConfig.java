package hu.pairg.falconTest.ws.config;

import hu.pairg.falconTest.ws.messaging.Producer;
import hu.pairg.falconTest.ws.service.ReceiveMessageService;
import hu.pairg.falconTest.ws.service.ReceiveMessageServiceImpl;
import hu.pairg.falconTest.ws.service.WsCommandService;
import hu.pairg.falconTest.ws.service.WsCommandServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.json.JsonObjectMapper;
import org.springframework.integration.support.json.JsonObjectMapperProvider;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * Created by pairg on 2016.04.24..
 */
@Configuration()
public class WsAppConfig {

    @Bean(name = "WsCommandService")
    public WsCommandService commandService(Producer producer) {
        return new WsCommandServiceImpl(producer);
    }

    @Bean(name = "WsReceiveMessageService")
    public ReceiveMessageService receiveMessageService(SimpMessagingTemplate simpMessagingTemplate) {
        return new ReceiveMessageServiceImpl(simpMessagingTemplate);
    }

    @Bean(name = "WsJsonObjectMapper")
    public JsonObjectMapper<?, ?> jsonObjectMapper() {
        return JsonObjectMapperProvider.newInstance();
    }

}
