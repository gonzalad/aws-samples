package org.gonzalad.aws.sample.mail.config;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Adrian on 06/11/2016.
 */
@ConfigurationProperties(prefix = "mail")
public class MailConfigProperties {

    private final Logger log = LoggerFactory.getLogger(MailConfigProperties.class);

    @NotNull
    private List<String> allowedTo;

    @NotBlank
    private String from;

    public List<String> getAllowedTo() {
        return allowedTo;
    }

    public void setAllowedTo(List<String> allowedTo) {
        this.allowedTo = allowedTo;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @PostConstruct
    public void initialize() {
        log.debug("{}", this);
    }

    @Override
    public String toString() {
        return "MailConfigProperties{" + "allowedTo=" + allowedTo + ", from='" + from + '\'' + '}';
    }
}
