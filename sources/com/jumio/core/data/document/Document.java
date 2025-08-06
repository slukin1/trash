package com.jumio.core.data.document;

import java.io.Serializable;
import kotlin.jvm.internal.x;
import org.json.JSONObject;

public final class Document implements Comparable<Document>, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f39103a;

    /* renamed from: b  reason: collision with root package name */
    public final String f39104b;

    /* renamed from: c  reason: collision with root package name */
    public final int f39105c;

    public Document(JSONObject jSONObject) {
        this.f39103a = jSONObject.getString("code");
        this.f39104b = jSONObject.getString("name");
        this.f39105c = jSONObject.optInt("maxPages", 30);
    }

    public boolean equals(Object obj) {
        return x.b(this.f39103a, obj);
    }

    public final String getCode() {
        return this.f39103a;
    }

    public final int getMaxPages() {
        return this.f39105c;
    }

    public final String getName() {
        return this.f39104b;
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    public int compareTo(Document document) {
        return this.f39103a.compareTo(document.f39103a);
    }
}
