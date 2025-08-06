package com.sumsub.sns.core;

import androidx.annotation.Keep;
import kotlin.Metadata;

@a
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/core/SNSModule;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "toString", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public abstract class SNSModule {
    private final String name;

    public SNSModule(String str) {
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }
}
