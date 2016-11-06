package org.gonzalad.aws.sample.mail;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Adrian on 06/11/2016.
 */
public class MailResource {

    @NotBlank
    private String to;

    @NotBlank
    private String subject;

    private String body;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "MailResource{" + "to='" + to + '\'' + ", subject='" + subject + '\'' + ", body='" + body + '\'' + '}';
    }
}
