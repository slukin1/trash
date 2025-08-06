package com.zopim.android.sdk.api;

import com.zendesk.logger.Logger;
import com.zopim.android.sdk.api.ApiConfigBuilder;
import java.io.Serializable;

abstract class ApiConfigBuilder<T extends ApiConfigBuilder> implements Serializable {
    private static final String LOG_TAG = "ApiConfigBuilder";
    public String department;
    public String referrer;
    public String[] tags;
    public String title;

    public T department(String str) {
        if (str == null || str.isEmpty()) {
            Logger.l(LOG_TAG, "Minimum department validation failed. Can not be null or empty string", new Object[0]);
        } else {
            this.department = str;
        }
        return this;
    }

    public T tags(String... strArr) {
        if (strArr == null) {
            Logger.l(LOG_TAG, "Tags must not be null or empty string", new Object[0]);
        } else {
            this.tags = strArr;
        }
        return this;
    }

    public T visitorPathOne(String str) {
        if (str == null || str.isEmpty()) {
            Logger.l(LOG_TAG, "Visitor path must not be null or empty string", new Object[0]);
        } else {
            this.title = str;
        }
        return this;
    }

    public T visitorPathTwo(String str) {
        if (str == null || str.isEmpty()) {
            Logger.l(LOG_TAG, "Visitor path must not be null or empty string", new Object[0]);
        } else {
            this.referrer = str;
        }
        return this;
    }
}
