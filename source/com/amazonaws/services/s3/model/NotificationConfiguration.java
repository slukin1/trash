package com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class NotificationConfiguration {
    private Set<String> events = new HashSet();
    private Filter filter;
    @Deprecated
    private List<String> objectPrefixes = new ArrayList();

    public NotificationConfiguration() {
    }

    public void addEvent(String str) {
        this.events.add(str);
    }

    @Deprecated
    public void addObjectPrefix(String str) {
        this.objectPrefixes.add(str);
    }

    public Set<String> getEvents() {
        return this.events;
    }

    public Filter getFilter() {
        return this.filter;
    }

    @Deprecated
    public List<String> getObjectPrefixes() {
        return this.objectPrefixes;
    }

    public void setEvents(Set<String> set) {
        this.events = set;
    }

    public void setFilter(Filter filter2) {
        this.filter = filter2;
    }

    @Deprecated
    public void setObjectPrefixes(List<String> list) {
        this.objectPrefixes = list;
    }

    public NotificationConfiguration withEvents(Set<String> set) {
        this.events.clear();
        this.events.addAll(set);
        return this;
    }

    public NotificationConfiguration withFilter(Filter filter2) {
        setFilter(filter2);
        return this;
    }

    @Deprecated
    public NotificationConfiguration withObjectPrefixes(String... strArr) {
        this.objectPrefixes.clear();
        if (strArr != null && strArr.length > 0) {
            this.objectPrefixes.addAll(Arrays.asList(strArr));
        }
        return this;
    }

    public void addEvent(S3Event s3Event) {
        this.events.add(s3Event.toString());
    }

    public NotificationConfiguration(EnumSet<S3Event> enumSet) {
        if (enumSet != null) {
            Iterator it2 = enumSet.iterator();
            while (it2.hasNext()) {
                this.events.add(((S3Event) it2.next()).toString());
            }
        }
    }

    public NotificationConfiguration(String... strArr) {
        if (strArr != null) {
            for (String add : strArr) {
                this.events.add(add);
            }
        }
    }
}
