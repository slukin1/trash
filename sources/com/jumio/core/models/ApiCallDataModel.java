package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import java.io.Serializable;
import java.util.HashMap;

@PersistWith("ApiCallDataModel")
public final class ApiCallDataModel<T> implements StaticModel {

    /* renamed from: a  reason: collision with root package name */
    public final Class<T> f39241a;

    /* renamed from: b  reason: collision with root package name */
    public String f39242b = "";

    /* renamed from: c  reason: collision with root package name */
    public boolean f39243c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39244d;

    /* renamed from: e  reason: collision with root package name */
    public int f39245e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, Serializable> f39246f = new HashMap<>();

    public ApiCallDataModel(Class<T> cls) {
        this.f39241a = cls;
    }

    public final Class<T> getCall() {
        return this.f39241a;
    }

    public final HashMap<String, Serializable> getData() {
        return this.f39246f;
    }

    public final boolean getFireAndForget() {
        return this.f39243c;
    }

    public final boolean getIgnoreErrors() {
        return this.f39244d;
    }

    public final String getScanPartId() {
        return this.f39242b;
    }

    public final int getTimeout() {
        return this.f39245e;
    }

    public final void setFireAndForget(boolean z11) {
        this.f39243c = z11;
    }

    public final void setIgnoreErrors(boolean z11) {
        this.f39244d = z11;
    }

    public final void setScanPartId(String str) {
        this.f39242b = str;
    }

    public final void setTimeout(int i11) {
        this.f39245e = i11;
    }
}
