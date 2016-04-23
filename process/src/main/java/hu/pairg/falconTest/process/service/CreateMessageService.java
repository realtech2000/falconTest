package hu.pairg.falconTest.process.service;

import hu.pairg.falconTest.process.domain.Message;
import org.springframework.stereotype.Service;

/**
 * Created by pairg on 2016.04.23..
 */
@Service
public interface CreateMessageService {

    void createMessage(Message message);

}
