package hu.pairg.falconTest.api.config;

import hu.pairg.falconTest.api.messaging.Producer;
import hu.pairg.falconTest.api.service.CommandService;
import hu.pairg.falconTest.api.service.CommandServiceImpl;
import hu.pairg.falconTest.api.service.QueryService;
import hu.pairg.falconTest.api.service.QueryServiceImpl;
import hu.pairg.falconTest.commonDb.service.ReadService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by pairg on 2016.04.23..
 */
@Configuration
@Import(hu.pairg.falconTest.commonDb.CommonDbApplication.class)
public class ApiAppConfig {

    @Bean(name = "ApiCommandService")
    public CommandService commandService(Producer producer) {
        return new CommandServiceImpl(producer);
    }

    @Bean(name = "ApiQueryService")
    public QueryService queryService(ReadService dbReadService) {
        return new QueryServiceImpl(dbReadService);
    }

}
