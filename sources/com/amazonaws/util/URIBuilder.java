package com.amazonaws.util;

import com.amazonaws.Protocol;
import java.net.URI;
import java.net.URISyntaxException;

public class URIBuilder {

    /* renamed from: h  reason: collision with root package name */
    public static final String f15566h = Protocol.HTTPS.toString();

    /* renamed from: a  reason: collision with root package name */
    public String f15567a;

    /* renamed from: b  reason: collision with root package name */
    public String f15568b;

    /* renamed from: c  reason: collision with root package name */
    public String f15569c;

    /* renamed from: d  reason: collision with root package name */
    public int f15570d;

    /* renamed from: e  reason: collision with root package name */
    public String f15571e;

    /* renamed from: f  reason: collision with root package name */
    public String f15572f;

    /* renamed from: g  reason: collision with root package name */
    public String f15573g;

    public URIBuilder(URI uri) {
        this.f15567a = uri.getScheme();
        this.f15568b = uri.getUserInfo();
        this.f15569c = uri.getHost();
        this.f15570d = uri.getPort();
        this.f15571e = uri.getPath();
        this.f15572f = uri.getQuery();
        this.f15573g = uri.getFragment();
    }

    public static URIBuilder b(URI uri) {
        return new URIBuilder(uri);
    }

    public URI a() throws URISyntaxException {
        return new URI(this.f15567a, this.f15568b, this.f15569c, this.f15570d, this.f15571e, this.f15572f, this.f15573g);
    }

    public URIBuilder c(String str) {
        this.f15569c = str;
        return this;
    }
}
