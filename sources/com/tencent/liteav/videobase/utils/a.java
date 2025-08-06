package com.tencent.liteav.videobase.utils;

import java.util.LinkedList;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<Runnable> f22241a = new LinkedList<>();

    public final void a() {
        LinkedList linkedList;
        synchronized (this.f22241a) {
            if (!this.f22241a.isEmpty()) {
                linkedList = new LinkedList(this.f22241a);
                this.f22241a.clear();
            } else {
                linkedList = null;
            }
        }
        while (linkedList != null && !linkedList.isEmpty()) {
            ((Runnable) linkedList.removeFirst()).run();
        }
    }
}
