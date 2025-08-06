package com.tencent.thumbplayer.tcmedia.d;

import com.tencent.thumbplayer.tcmedia.d.b;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<a>> f49165a = new CopyOnWriteArrayList<>();

    public void a(a aVar) {
        CopyOnWriteArrayList<WeakReference<a>> copyOnWriteArrayList;
        if (aVar != null && (copyOnWriteArrayList = this.f49165a) != null && !copyOnWriteArrayList.contains(aVar)) {
            this.f49165a.add(new WeakReference(aVar));
        }
    }

    public void a(b.a aVar) {
        CopyOnWriteArrayList<WeakReference<a>> copyOnWriteArrayList = this.f49165a;
        if (copyOnWriteArrayList != null) {
            Iterator<WeakReference<a>> it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                a aVar2 = (a) it2.next().get();
                if (aVar2 != null) {
                    aVar2.a(aVar);
                }
            }
        }
    }
}
