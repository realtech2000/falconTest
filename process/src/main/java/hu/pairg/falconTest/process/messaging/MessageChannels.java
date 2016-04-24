package hu.pairg.falconTest.process.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by pairg on 2016.04.23..
 */
interface MessageChannels {

    String INPUT = "processMessages";

    @Input(MessageChannels.INPUT)
    SubscribableChannel input();

}
