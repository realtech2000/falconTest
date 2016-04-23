package hu.pairg.falconTest.process.service;

import hu.pairg.falconTest.commonDb.service.WriteService;
import hu.pairg.falconTest.process.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by pairg on 2016.04.23..
 */
public class CreateMessageServiceImpl implements CreateMessageService {

    private final WriteService dbWriteService;

    @Autowired
    public CreateMessageServiceImpl(WriteService dbWriteService){
        this.dbWriteService = dbWriteService;
    }

    @Override
    public void createMessage(Message message) {
        dbWriteService.createMessage(new hu.pairg.falconTest.commonDb.data.model.Message(
                message.getRoomName(), message.getSenderName(), message.getMessage()
        ));
    }

}
