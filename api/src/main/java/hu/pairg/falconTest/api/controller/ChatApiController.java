package hu.pairg.falconTest.api.controller;

/**
 * Created by pairg on 2016.04.23..
 */

import hu.pairg.falconTest.api.controller.exception.BadFormatException;
import hu.pairg.falconTest.api.domain.Message;
import hu.pairg.falconTest.api.dto.Envelope;
import hu.pairg.falconTest.api.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChatApiController {

    private final DbService dbService;

    @Autowired
    public ChatApiController(DbService dbService) {
        this.dbService = dbService;
    }

    @RequestMapping(path = "/message", method = RequestMethod.PUT)
    public @ResponseBody Envelope<Boolean> putMessage(@RequestBody Message message) throws BadFormatException {
        if(!dbService.createMessage(message))
            throw new BadFormatException("Invalid message!");
        return new Envelope<Boolean>(true);
    }

    @RequestMapping(path = "/messages", method = RequestMethod.GET)
    public Envelope<List<Message>> getMessages() {
        return new Envelope<>(
                dbService.getAllMessages()
        );
    }

    @RequestMapping(path = "/messages/{roomName}", method = RequestMethod.GET)
    public Envelope<List<Message>> getMessagesForRoom(@PathVariable("roomName") String roomName) {
        return new Envelope<>(
                dbService.getAllMessagesForRoom(roomName)
        );
    }

}
