package com.mob.mcl;

import com.mob.mcl.b.b;
import com.mob.tools.network.HttpConnection;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Tmpc$1 implements HttpConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f27394a;

    public Tmpc$1(b bVar) {
        this.f27394a = bVar;
    }

    public InputStream getErrorStream() throws IOException {
        return this.f27394a.d();
    }

    public Map<String, List<String>> getHeaderFields() throws IOException {
        return this.f27394a.e();
    }

    public InputStream getInputStream() throws IOException {
        return this.f27394a.c();
    }

    public int getResponseCode() throws IOException {
        return this.f27394a.b();
    }
}
