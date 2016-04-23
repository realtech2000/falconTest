package hu.pairg.falconTest.process.config;

import hu.pairg.falconTest.commonDb.service.WriteService;
import hu.pairg.falconTest.process.service.CreateMessageService;
import hu.pairg.falconTest.process.service.CreateMessageServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by pairg on 2016.04.23..
 */
@Configuration
@Import(hu.pairg.falconTest.commonDb.CommonDbApplication.class)
public class ProcessAppConfig {

    @Bean
    public CreateMessageService createMessageService(WriteService dbWriteService) {
        return new CreateMessageServiceImpl(dbWriteService);
    }

}
