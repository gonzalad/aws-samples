package org.gonzalad.aws.sample.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * We disable aws auto-configuration by default (i.e. to test sending mails from a local non-aws environment)
 */
@SpringBootApplication
@EnableAutoConfiguration(
        exclude = { org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration.class,
                org.springframework.cloud.aws.autoconfigure.context.ContextCredentialsAutoConfiguration.class,
                org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration.class,
                org.springframework.cloud.aws.autoconfigure.context.ContextResourceLoaderAutoConfiguration.class,
                org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration.class,
                org.springframework.cloud.aws.autoconfigure.mail.MailSenderAutoConfiguration.class,
                org.springframework.cloud.aws.autoconfigure.cache.ElastiCacheAutoConfiguration.class,
                org.springframework.cloud.aws.autoconfigure.messaging.MessagingAutoConfiguration.class,
                org.springframework.cloud.aws.autoconfigure.jdbc.AmazonRdsDatabaseAutoConfiguration.class,
                org.springframework.cloud.aws.autoconfigure.actuate.CloudWatchMetricAutoConfiguration.class })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
