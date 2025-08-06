package com.mob.tools.network;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class StringPart extends HTTPPart {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f27953a = new StringBuilder();

    public InputStream a() throws Throwable {
        return new ByteArrayInputStream(this.f27953a.toString().getBytes("utf-8"));
    }

    public StringPart append(String str) {
        this.f27953a.append(str);
        return this;
    }

    public long b() throws Throwable {
        return (long) this.f27953a.toString().getBytes("utf-8").length;
    }

    public String toString() {
        return this.f27953a.toString();
    }
}
