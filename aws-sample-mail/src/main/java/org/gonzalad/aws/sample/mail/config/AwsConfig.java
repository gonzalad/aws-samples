package org.gonzalad.aws.sample.mail.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

/**
 * Created by Adrian on 06/11/2016.
 */
@Configuration
@Profile("aws")
// @ImportResource("classpath:aws-config.xml")
@Import({ org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration.class,
        org.springframework.cloud.aws.autoconfigure.context.ContextCredentialsAutoConfiguration.class,
        org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration.class,
        org.springframework.cloud.aws.autoconfigure.context.ContextResourceLoaderAutoConfiguration.class,
        org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration.class,
        org.springframework.cloud.aws.autoconfigure.mail.MailSenderAutoConfiguration.class,
        org.springframework.cloud.aws.autoconfigure.cache.ElastiCacheAutoConfiguration.class,
        org.springframework.cloud.aws.autoconfigure.messaging.MessagingAutoConfiguration.class,
        org.springframework.cloud.aws.autoconfigure.jdbc.AmazonRdsDatabaseAutoConfiguration.class,
        org.springframework.cloud.aws.autoconfigure.actuate.CloudWatchMetricAutoConfiguration.class })
public class AwsConfig {
}
