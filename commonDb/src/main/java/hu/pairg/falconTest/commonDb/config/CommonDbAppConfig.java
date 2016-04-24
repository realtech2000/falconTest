package hu.pairg.falconTest.commonDb.config;

import hu.pairg.falconTest.commonDb.data.respository.MessageRepository;
import hu.pairg.falconTest.commonDb.service.ReadService;
import hu.pairg.falconTest.commonDb.service.ReadServiceImpl;
import hu.pairg.falconTest.commonDb.service.WriteService;
import hu.pairg.falconTest.commonDb.service.WriteServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pairg on 2016.04.23..
 */
@Configuration
public class CommonDbAppConfig {

    @Bean(name = "CommonDbReadService")
    public ReadService readService(MessageRepository messageRepository) {
        return new ReadServiceImpl(messageRepository);
    }

    @Bean(name = "CommonDbWriteService")
    public WriteService writeService(MessageRepository messageRepository) {
        return new WriteServiceImpl(messageRepository);
    }

}
