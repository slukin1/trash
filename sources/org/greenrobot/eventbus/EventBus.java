package org.greenrobot.eventbus;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import k20.d;
import k20.e;
import k20.f;
import k20.i;
import k20.j;
import k20.k;
import k20.l;

public class EventBus {

    /* renamed from: q  reason: collision with root package name */
    public static String f68258q = "EventBus";

    /* renamed from: r  reason: collision with root package name */
    public static volatile EventBus f68259r;

    /* renamed from: s  reason: collision with root package name */
    public static final k20.c f68260s = new k20.c();

    /* renamed from: t  reason: collision with root package name */
    public static final Map<Class<?>, List<Class<?>>> f68261t = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, CopyOnWriteArrayList<l>> f68262a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Object, List<Class<?>>> f68263b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Class<?>, Object> f68264c;

    /* renamed from: d  reason: collision with root package name */
    public final ThreadLocal<c> f68265d;

    /* renamed from: e  reason: collision with root package name */
    public final d f68266e;

    /* renamed from: f  reason: collision with root package name */
    public final k20.b f68267f;

    /* renamed from: g  reason: collision with root package name */
    public final k20.a f68268g;

    /* renamed from: h  reason: collision with root package name */
    public final k f68269h;

    /* renamed from: i  reason: collision with root package name */
    public final ExecutorService f68270i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f68271j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f68272k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f68273l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f68274m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f68275n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f68276o;

    /* renamed from: p  reason: collision with root package name */
    public final int f68277p;

    public class a extends ThreadLocal<c> {
        public a() {
        }

        /* renamed from: a */
        public c initialValue() {
            return new c();
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f68279a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.greenrobot.eventbus.ThreadMode[] r0 = org.greenrobot.eventbus.ThreadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f68279a = r0
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.POSTING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f68279a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.MAIN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f68279a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.BACKGROUND     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f68279a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.ASYNC     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.EventBus.b.<clinit>():void");
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final List<Object> f68280a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public boolean f68281b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f68282c;

        /* renamed from: d  reason: collision with root package name */
        public l f68283d;

        /* renamed from: e  reason: collision with root package name */
        public Object f68284e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f68285f;
    }

    public EventBus() {
        this(f68260s);
    }

    public static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public static EventBus d() {
        if (f68259r == null) {
            synchronized (EventBus.class) {
                if (f68259r == null) {
                    f68259r = new EventBus();
                }
            }
        }
        return f68259r;
    }

    public static List<Class<?>> j(Class<?> cls) {
        List<Class<?>> list;
        Map<Class<?>, List<Class<?>>> map = f68261t;
        synchronized (map) {
            list = map.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, cls2.getInterfaces());
                }
                f68261t.put(cls, list);
            }
        }
        return list;
    }

    public void b(Object obj) {
        c cVar = this.f68265d.get();
        if (!cVar.f68281b) {
            throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
        } else if (obj == null) {
            throw new EventBusException("Event may not be null");
        } else if (cVar.f68284e != obj) {
            throw new EventBusException("Only the currently handled event may be aborted");
        } else if (cVar.f68283d.f68255b.f68236b == ThreadMode.POSTING) {
            cVar.f68285f = true;
        } else {
            throw new EventBusException(" event handlers may only abort the incoming event");
        }
    }

    public final void c(l lVar, Object obj) {
        if (obj != null) {
            o(lVar, obj, Looper.getMainLooper() == Looper.myLooper());
        }
    }

    public ExecutorService e() {
        return this.f68270i;
    }

    public final void f(l lVar, Object obj, Throwable th2) {
        if (obj instanceof i) {
            if (this.f68272k) {
                String str = f68258q;
                Log.e(str, "SubscriberExceptionEvent subscriber " + lVar.f68254a.getClass() + " threw an exception", th2);
                i iVar = (i) obj;
                String str2 = f68258q;
                Log.e(str2, "Initial event " + iVar.f68233c + " caused exception in " + iVar.f68234d, iVar.f68232b);
            }
        } else if (!this.f68271j) {
            if (this.f68272k) {
                String str3 = f68258q;
                Log.e(str3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + lVar.f68254a.getClass(), th2);
            }
            if (this.f68274m) {
                k(new i(this, th2, obj, lVar.f68254a));
            }
        } else {
            throw new EventBusException("Invoking subscriber failed", th2);
        }
    }

    public void g(f fVar) {
        Object obj = fVar.f68226a;
        l lVar = fVar.f68227b;
        f.b(fVar);
        if (lVar.f68256c) {
            h(lVar, obj);
        }
    }

    public void h(l lVar, Object obj) {
        try {
            lVar.f68255b.f68235a.invoke(lVar.f68254a, new Object[]{obj});
        } catch (InvocationTargetException e11) {
            f(lVar, obj, e11.getCause());
        } catch (IllegalAccessException e12) {
            throw new IllegalStateException("Unexpected exception", e12);
        }
    }

    public synchronized boolean i(Object obj) {
        return this.f68263b.containsKey(obj);
    }

    public void k(Object obj) {
        c cVar = this.f68265d.get();
        List<Object> list = cVar.f68280a;
        list.add(obj);
        if (!cVar.f68281b) {
            cVar.f68282c = Looper.getMainLooper() == Looper.myLooper();
            cVar.f68281b = true;
            if (!cVar.f68285f) {
                while (!list.isEmpty()) {
                    try {
                        l(list.remove(0), cVar);
                    } finally {
                        cVar.f68281b = false;
                        cVar.f68282c = false;
                    }
                }
                return;
            }
            throw new EventBusException("Internal error. Abort state was not reset");
        }
    }

    public final void l(Object obj, c cVar) throws Error {
        boolean z11;
        Class<?> cls = obj.getClass();
        if (this.f68276o) {
            List<Class<?>> j11 = j(cls);
            int size = j11.size();
            z11 = false;
            for (int i11 = 0; i11 < size; i11++) {
                z11 |= m(obj, cVar, j11.get(i11));
            }
        } else {
            z11 = m(obj, cVar, cls);
        }
        if (!z11) {
            if (this.f68273l) {
                Log.d(f68258q, "No subscribers registered for event " + cls);
            }
            if (this.f68275n && cls != e.class && cls != i.class) {
                k(new e(this, obj));
            }
        }
    }

    public final boolean m(Object obj, c cVar, Class<?> cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f68262a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = copyOnWriteArrayList.iterator();
        while (it2.hasNext()) {
            l lVar = (l) it2.next();
            cVar.f68284e = obj;
            cVar.f68283d = lVar;
            try {
                o(lVar, obj, cVar.f68282c);
                if (cVar.f68285f) {
                    return true;
                }
            } finally {
                cVar.f68284e = null;
                cVar.f68283d = null;
                cVar.f68285f = false;
            }
        }
        return true;
    }

    public void n(Object obj) {
        synchronized (this.f68264c) {
            this.f68264c.put(obj.getClass(), obj);
        }
        k(obj);
    }

    public final void o(l lVar, Object obj, boolean z11) {
        int i11 = b.f68279a[lVar.f68255b.f68236b.ordinal()];
        if (i11 == 1) {
            h(lVar, obj);
        } else if (i11 != 2) {
            if (i11 != 3) {
                if (i11 == 4) {
                    this.f68268g.a(lVar, obj);
                    return;
                }
                throw new IllegalStateException("Unknown thread mode: " + lVar.f68255b.f68236b);
            } else if (z11) {
                this.f68267f.a(lVar, obj);
            } else {
                h(lVar, obj);
            }
        } else if (z11) {
            h(lVar, obj);
        } else {
            this.f68266e.a(lVar, obj);
        }
    }

    public void p(Object obj) {
        List<j> a11 = this.f68269h.a(obj.getClass());
        synchronized (this) {
            for (j q11 : a11) {
                q(obj, q11);
            }
        }
    }

    public final void q(Object obj, j jVar) {
        Class<?> cls = jVar.f68237c;
        l lVar = new l(obj, jVar);
        CopyOnWriteArrayList copyOnWriteArrayList = this.f68262a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f68262a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(lVar)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        int i11 = 0;
        while (true) {
            if (i11 > size) {
                break;
            } else if (i11 == size || jVar.f68238d > ((l) copyOnWriteArrayList.get(i11)).f68255b.f68238d) {
                copyOnWriteArrayList.add(i11, lVar);
            } else {
                i11++;
            }
        }
        copyOnWriteArrayList.add(i11, lVar);
        List list = this.f68263b.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.f68263b.put(obj, list);
        }
        list.add(cls);
        if (!jVar.f68239e) {
            return;
        }
        if (this.f68276o) {
            for (Map.Entry next : this.f68264c.entrySet()) {
                if (cls.isAssignableFrom((Class) next.getKey())) {
                    c(lVar, next.getValue());
                }
            }
            return;
        }
        c(lVar, this.f68264c.get(cls));
    }

    public synchronized void r(Object obj) {
        List<Class> list = this.f68263b.get(obj);
        if (list != null) {
            for (Class s11 : list) {
                s(obj, s11);
            }
            this.f68263b.remove(obj);
        } else {
            String str = f68258q;
            Log.w(str, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public final void s(Object obj, Class<?> cls) {
        List list = this.f68262a.get(cls);
        if (list != null) {
            int size = list.size();
            int i11 = 0;
            while (i11 < size) {
                l lVar = (l) list.get(i11);
                if (lVar.f68254a == obj) {
                    lVar.f68256c = false;
                    list.remove(i11);
                    i11--;
                    size--;
                }
                i11++;
            }
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.f68277p + ", eventInheritance=" + this.f68276o + "]";
    }

    public EventBus(k20.c cVar) {
        this.f68265d = new a();
        this.f68262a = new HashMap();
        this.f68263b = new HashMap();
        this.f68264c = new ConcurrentHashMap();
        this.f68266e = new d(this, Looper.getMainLooper(), 10);
        this.f68267f = new k20.b(this);
        this.f68268g = new k20.a(this);
        List<l20.b> list = cVar.f68218j;
        this.f68277p = list != null ? list.size() : 0;
        this.f68269h = new k(cVar.f68218j, cVar.f68216h, cVar.f68215g);
        this.f68272k = cVar.f68209a;
        this.f68273l = cVar.f68210b;
        this.f68274m = cVar.f68211c;
        this.f68275n = cVar.f68212d;
        this.f68271j = cVar.f68213e;
        this.f68276o = cVar.f68214f;
        this.f68270i = cVar.f68217i;
    }
}
