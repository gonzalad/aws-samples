package org.gonzalad.aws.sample.mail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Adrian on 06/11/2016.
 */
@Configuration
public class MailConfig {

    @Bean
    public MailConfigProperties mailConfigProperties() {
        return new MailConfigProperties();
    }
}
