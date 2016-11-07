package org.gonzalad.aws.sample.mail;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.apache.commons.codec.CharEncoding;
import org.gonzalad.aws.sample.mail.config.MailConfigProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Adrian on 06/11/2016.
 */
@RestController("/mail")
public class MailController {

    private final Logger log = LoggerFactory.getLogger(MailController.class);

    @Autowired
    private MailConfigProperties mailConfigProperties;

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping
    public void send(@Valid MailResource mail) {

        checkValidity(mail);
        log.debug("Send e-mail to '{}' from '{}' with subject '{}' and content={}", mailConfigProperties.getFrom(), mail.getTo(),
                mail.getSubject(), mail.getBody());

        // Prepare message using a Spring helper
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        String currentField = "";
        String currentAddress = "";
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, false, CharEncoding.UTF_8);
            message.setTo(mail.getTo());
            message.setReplyTo(mailConfigProperties.getFrom());
            message.setFrom(mailConfigProperties.getFrom());
            message.setSubject(mail.getSubject());
            String body = mail.getBody() != null ? mail.getBody() : "sample default body";
            message.setText(body, false);
            javaMailSender.send(mimeMessage);
            log.debug("Sent e-mail '{}' to User '{}'", mail.getSubject(), mail.getTo());
        } catch (Exception e) {
            String message = String.format("E-mail could not be sent to user '%s': %s", mail.getTo(), e);
            log.warn(message, e);
            throw new RuntimeException(e);
        }
    }

    private void checkValidity(MailResource mail) {
        if (!mailConfigProperties.getAllowedTo().contains(mail.getTo())) {
            throw new IllegalArgumentException(
                    String.format("Invalid to field, only %s are allowed : %s", mailConfigProperties.getAllowedTo(), mail));
        }
    }
}
