package hu.pairg.falconTest.api.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * Empty class to initialize the stream bindings
 */
@EnableBinding(MessageChannels.class)
class Messenger {

}
