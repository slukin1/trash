package com.facebook.stetho.server.http;

import java.util.ArrayList;

public class HandlerRegistry {
    private final ArrayList<HttpHandler> mHttpHandlers = new ArrayList<>();
    private final ArrayList<PathMatcher> mPathMatchers = new ArrayList<>();

    public synchronized HttpHandler lookup(String str) {
        int size = this.mPathMatchers.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.mPathMatchers.get(i11).match(str)) {
                return this.mHttpHandlers.get(i11);
            }
        }
        return null;
    }

    public synchronized void register(PathMatcher pathMatcher, HttpHandler httpHandler) {
        this.mPathMatchers.add(pathMatcher);
        this.mHttpHandlers.add(httpHandler);
    }

    public synchronized boolean unregister(PathMatcher pathMatcher, HttpHandler httpHandler) {
        int indexOf = this.mPathMatchers.indexOf(pathMatcher);
        if (indexOf < 0 || httpHandler != this.mHttpHandlers.get(indexOf)) {
            return false;
        }
        this.mPathMatchers.remove(indexOf);
        this.mHttpHandlers.remove(indexOf);
        return true;
    }
}
