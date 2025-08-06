package com.huobi.woodpecker.kalle.cookie;

import android.text.TextUtils;
import java.io.Serializable;
import java.net.HttpCookie;

public class Cookie implements Serializable {
    private String comment;
    private String commentURL;
    private boolean discard;
    private String domain;
    private long expiry;

    /* renamed from: id  reason: collision with root package name */
    private long f21053id = -1;
    private String name;
    private String path;
    private String portList;
    private boolean secure;
    private String url;
    private String value;
    private int version = 1;

    public static boolean isExpired(Cookie cookie) {
        long j11 = cookie.expiry;
        return j11 != -1 && j11 < System.currentTimeMillis();
    }

    public static Cookie toCookie(String str, HttpCookie httpCookie) {
        Cookie cookie = new Cookie();
        cookie.setUrl(str);
        cookie.setName(httpCookie.getName());
        cookie.setValue(httpCookie.getValue());
        cookie.setComment(httpCookie.getComment());
        cookie.setCommentURL(httpCookie.getCommentURL());
        cookie.setDiscard(httpCookie.getDiscard());
        cookie.setDomain(httpCookie.getDomain());
        long maxAge = httpCookie.getMaxAge();
        int i11 = (maxAge > 0 ? 1 : (maxAge == 0 ? 0 : -1));
        if (i11 > 0) {
            long currentTimeMillis = (maxAge * 1000) + System.currentTimeMillis();
            if (currentTimeMillis < 0) {
                currentTimeMillis = System.currentTimeMillis() + 3153600000000L;
            }
            cookie.setExpiry(currentTimeMillis);
        } else if (i11 < 0) {
            cookie.setExpiry(-1);
        } else {
            cookie.setExpiry(0);
        }
        String path2 = httpCookie.getPath();
        if (!TextUtils.isEmpty(path2) && path2.length() > 1 && path2.endsWith("/")) {
            path2 = path2.substring(0, path2.length() - 1);
        }
        cookie.setPath(path2);
        cookie.setPortList(httpCookie.getPortlist());
        cookie.setSecure(httpCookie.getSecure());
        cookie.setVersion(httpCookie.getVersion());
        return cookie;
    }

    public static HttpCookie toHttpCookie(Cookie cookie) {
        HttpCookie httpCookie = new HttpCookie(cookie.name, cookie.value);
        httpCookie.setComment(cookie.comment);
        httpCookie.setCommentURL(cookie.commentURL);
        httpCookie.setDiscard(cookie.discard);
        httpCookie.setDomain(cookie.domain);
        long j11 = cookie.expiry;
        long j12 = 0;
        if (j11 == 0) {
            httpCookie.setMaxAge(0);
        } else if (j11 < 0) {
            httpCookie.setMaxAge(-1);
        } else {
            long currentTimeMillis = j11 - System.currentTimeMillis();
            if (currentTimeMillis > 0) {
                j12 = currentTimeMillis;
            }
            httpCookie.setMaxAge(j12 / 1000);
        }
        httpCookie.setPath(cookie.path);
        httpCookie.setPortlist(cookie.portList);
        httpCookie.setSecure(cookie.secure);
        httpCookie.setVersion(cookie.version);
        return httpCookie;
    }

    public String getComment() {
        return this.comment;
    }

    public String getCommentURL() {
        return this.commentURL;
    }

    public String getDomain() {
        return this.domain;
    }

    public long getExpiry() {
        return this.expiry;
    }

    public long getId() {
        return this.f21053id;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public String getPortList() {
        return this.portList;
    }

    public String getUrl() {
        return this.url;
    }

    public String getValue() {
        return this.value;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean isDiscard() {
        return this.discard;
    }

    public boolean isSecure() {
        return this.secure;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setCommentURL(String str) {
        this.commentURL = str;
    }

    public void setDiscard(boolean z11) {
        this.discard = z11;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setExpiry(long j11) {
        this.expiry = j11;
    }

    public void setId(long j11) {
        this.f21053id = j11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setPortList(String str) {
        this.portList = str;
    }

    public void setSecure(boolean z11) {
        this.secure = z11;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public void setVersion(int i11) {
        this.version = i11;
    }
}
