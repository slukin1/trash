package com.mob.tools.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public class HttpConnectionImpl23 implements HttpConnection {

    /* renamed from: a  reason: collision with root package name */
    private HttpURLConnection f27914a;

    public HttpConnectionImpl23(HttpURLConnection httpURLConnection) {
        this.f27914a = httpURLConnection;
    }

    public InputStream getErrorStream() throws IOException {
        return this.f27914a.getErrorStream();
    }

    public Map<String, List<String>> getHeaderFields() throws IOException {
        return this.f27914a.getHeaderFields();
    }

    public InputStream getInputStream() throws IOException {
        return this.f27914a.getInputStream();
    }

    public int getResponseCode() throws IOException {
        return this.f27914a.getResponseCode();
    }
}
