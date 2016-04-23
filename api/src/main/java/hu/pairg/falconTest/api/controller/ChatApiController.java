package hu.pairg.falconTest.api.controller;

/**
 * Created by pairg on 2016.04.23..
 */

import hu.pairg.falconTest.api.controller.exception.BadFormatException;
import hu.pairg.falconTest.api.domain.Message;
import hu.pairg.falconTest.api.dto.Envelope;
import hu.pairg.falconTest.api.service.CommandService;
import hu.pairg.falconTest.api.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChatApiController {

    private final CommandService commandService;

    private final QueryService queryService;

    @Autowired
    public ChatApiController(CommandService commandService, QueryService queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @RequestMapping(path = "/message", method = RequestMethod.PUT)
    public @ResponseBody Envelope<Boolean> putMessage(@RequestBody Message message) throws BadFormatException {
        if(!commandService.createMessage(message))
            throw new BadFormatException("Invalid message!");
        return new Envelope<Boolean>(true);
    }

    @RequestMapping(path = "/messages", method = RequestMethod.GET)
    public Envelope<List<Message>> getMessages() {
        return new Envelope<>(
                queryService.getAllMessages()
        );
    }

    @RequestMapping(path = "/messages/{roomName}", method = RequestMethod.GET)
    public Envelope<List<Message>> getMessagesForRoom(@PathVariable("roomName") String roomName) {
        return new Envelope<>(
                queryService.getAllMessagesForRoom(roomName)
        );
    }

}
