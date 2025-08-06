package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.EnumSet;

public class TopicConfiguration extends NotificationConfiguration implements Serializable {
    private String topicARN;

    public TopicConfiguration() {
    }

    public String getTopicARN() {
        return this.topicARN;
    }

    public void setTopicARN(String str) {
        this.topicARN = str;
    }

    public TopicConfiguration withTopicARN(String str) {
        setTopicARN(str);
        return this;
    }

    public TopicConfiguration(String str, EnumSet<S3Event> enumSet) {
        super(enumSet);
        this.topicARN = str;
    }

    public TopicConfiguration(String str, String... strArr) {
        super(strArr);
        this.topicARN = str;
    }
}
