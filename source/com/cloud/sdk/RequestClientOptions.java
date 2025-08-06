package com.cloud.sdk;

import java.util.EnumMap;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public final class RequestClientOptions {

    /* renamed from: a  reason: collision with root package name */
    public final EnumMap<Marker, String> f64710a = new EnumMap<>(Marker.class);

    /* renamed from: b  reason: collision with root package name */
    public int f64711b = 131073;

    public enum Marker {
        USER_AGENT
    }
}
