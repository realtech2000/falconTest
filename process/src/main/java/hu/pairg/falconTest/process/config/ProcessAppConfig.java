package hu.pairg.falconTest.process.config;

import hu.pairg.falconTest.commonDb.service.WriteService;
import hu.pairg.falconTest.process.service.CreateMessageService;
import hu.pairg.falconTest.process.service.CreateMessageServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.integration.support.json.JsonObjectMapper;
import org.springframework.integration.support.json.JsonObjectMapperProvider;

/**
 * Created by pairg on 2016.04.23..
 */
@Configuration
@Import(hu.pairg.falconTest.commonDb.CommonDbApplication.class)
public class ProcessAppConfig {

    @Bean(name = "ProcessCreateMessageService")
    public CreateMessageService createMessageService(WriteService dbWriteService) {
        return new CreateMessageServiceImpl(dbWriteService);
    }

    @Bean(name = "ProcessJsonObjectMapper")
    public JsonObjectMapper<?, ?> jsonObjectMapper() {
        return JsonObjectMapperProvider.newInstance();
    }

}
