package com.amazonaws.services.s3.model;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class BucketNotificationConfiguration implements Serializable {
    private Map<String, NotificationConfiguration> configurations;

    @Deprecated
    public static class TopicConfiguration extends TopicConfiguration {
        public TopicConfiguration(String str, String str2) {
            super(str, str2);
        }

        @Deprecated
        public String getEvent() {
            Set<String> events = getEvents();
            return ((String[]) events.toArray(new String[events.size()]))[0];
        }

        public String getTopic() {
            return getTopicARN();
        }

        public String toString() {
            return new Gson().toJson((Object) this);
        }
    }

    public BucketNotificationConfiguration() {
        this.configurations = null;
        this.configurations = new HashMap();
    }

    public BucketNotificationConfiguration addConfiguration(String str, NotificationConfiguration notificationConfiguration) {
        this.configurations.put(str, notificationConfiguration);
        return this;
    }

    public NotificationConfiguration getConfigurationByName(String str) {
        return this.configurations.get(str);
    }

    public Map<String, NotificationConfiguration> getConfigurations() {
        return this.configurations;
    }

    @Deprecated
    public List<TopicConfiguration> getTopicConfigurations() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.configurations.entrySet()) {
            if (next.getValue() instanceof TopicConfiguration) {
                arrayList.add((TopicConfiguration) next.getValue());
            }
        }
        return arrayList;
    }

    public NotificationConfiguration removeConfiguration(String str) {
        return this.configurations.remove(str);
    }

    public void setConfigurations(Map<String, NotificationConfiguration> map) {
        this.configurations = map;
    }

    @Deprecated
    public void setTopicConfigurations(Collection<TopicConfiguration> collection) {
        this.configurations.clear();
        if (collection != null) {
            for (TopicConfiguration addConfiguration : collection) {
                addConfiguration(UUID.randomUUID().toString(), addConfiguration);
            }
        }
    }

    public String toString() {
        return new Gson().toJson((Object) getConfigurations());
    }

    public BucketNotificationConfiguration withNotificationConfiguration(Map<String, NotificationConfiguration> map) {
        this.configurations.clear();
        this.configurations.putAll(map);
        return this;
    }

    @Deprecated
    public BucketNotificationConfiguration withTopicConfigurations(TopicConfiguration... topicConfigurationArr) {
        setTopicConfigurations(Arrays.asList(topicConfigurationArr));
        return this;
    }

    public BucketNotificationConfiguration(String str, NotificationConfiguration notificationConfiguration) {
        this.configurations = null;
        this.configurations = new HashMap();
        addConfiguration(str, notificationConfiguration);
    }

    @Deprecated
    public BucketNotificationConfiguration(Collection<TopicConfiguration> collection) {
        this.configurations = null;
        this.configurations = new HashMap();
        if (collection != null) {
            for (TopicConfiguration addConfiguration : collection) {
                addConfiguration(UUID.randomUUID().toString(), addConfiguration);
            }
        }
    }
}
