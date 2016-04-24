package hu.pairg.falconTest.ws.controller;

import hu.pairg.falconTest.ws.domain.Message;
import hu.pairg.falconTest.ws.service.WsCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

/**
 * Created by pairg on 2016.04.24..
 */

@Controller
public class ChatWsController {

    private final WsCommandService wsCommandService;

    @Autowired
    public ChatWsController(WsCommandService wsCommandService){
        this.wsCommandService = wsCommandService;
    }

    @MessageMapping("/room/{chatRoomName}")
    public void createMessage(@DestinationVariable String chatRoomName, @Payload Message message) {
        wsCommandService.createMessage(chatRoomName, message);
    }

}
