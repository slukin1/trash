package com.tencent.thumbplayer.tcmedia.utils;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static CopyOnWriteArrayList<a> f49700a = new CopyOnWriteArrayList<>();

    public interface a {
        void a(int i11, int i12, int i13, Object obj);
    }

    public static synchronized void a(int i11, int i12, int i13, Object obj) {
        synchronized (f.class) {
            Iterator<a> it2 = f49700a.iterator();
            while (it2.hasNext()) {
                it2.next().a(i11, i12, i13, obj);
            }
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (f.class) {
            CopyOnWriteArrayList<a> copyOnWriteArrayList = f49700a;
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(aVar)) {
                f49700a.add(aVar);
                TPLogUtil.i("TPGlobalEventNofication", "add onNetStatus change listener: " + aVar + ", mListeners: " + f49700a.size());
            }
        }
    }

    public static synchronized void b(a aVar) {
        synchronized (f.class) {
            CopyOnWriteArrayList<a> copyOnWriteArrayList = f49700a;
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.remove(aVar);
                TPLogUtil.i("TPGlobalEventNofication", "remove netStatusChangeListener, listener: " + aVar + ", mListeners: " + f49700a.size());
            }
        }
    }
}
