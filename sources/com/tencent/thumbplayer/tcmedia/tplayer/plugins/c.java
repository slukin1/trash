package com.tencent.thumbplayer.tcmedia.tplayer.plugins;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private CopyOnWriteArrayList<a> f49622a = new CopyOnWriteArrayList<>();

    public void a() {
    }

    public void a(int i11, int i12, int i13, String str, Object obj) {
        CopyOnWriteArrayList<a> copyOnWriteArrayList = this.f49622a;
        if (copyOnWriteArrayList != null) {
            Iterator<a> it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                if (next != null) {
                    next.a(i11, i12, i13, str, obj);
                }
            }
        }
    }

    public void a(a aVar) {
        CopyOnWriteArrayList<a> copyOnWriteArrayList = this.f49622a;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(aVar)) {
            aVar.a();
            this.f49622a.add(aVar);
        }
    }

    public void b() {
    }

    public void c() {
        CopyOnWriteArrayList<a> copyOnWriteArrayList = this.f49622a;
        if (copyOnWriteArrayList != null) {
            Iterator<a> it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                if (next != null) {
                    next.b();
                }
            }
            this.f49622a.clear();
        }
        this.f49622a = null;
    }
}
