package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.EnumSet;

public class LambdaConfiguration extends NotificationConfiguration implements Serializable {
    private final String functionARN;

    public LambdaConfiguration(String str, EnumSet<S3Event> enumSet) {
        super(enumSet);
        this.functionARN = str;
    }

    public String getFunctionARN() {
        return this.functionARN;
    }

    public LambdaConfiguration(String str, String... strArr) {
        super(strArr);
        this.functionARN = str;
    }
}
