package hu.pairg.falconTest.api.config;

import hu.pairg.falconTest.api.service.DbService;
import hu.pairg.falconTest.api.service.DbServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pairg on 2016.04.23..
 */
@Configuration
public class ApiAppConfig {

    @Bean
    public DbService dbService() {
        return new DbServiceImpl();
    }

}
