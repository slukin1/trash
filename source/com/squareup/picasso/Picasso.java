package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import com.squareup.picasso.a;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

public class Picasso {

    /* renamed from: p  reason: collision with root package name */
    public static final Handler f29949p = new a(Looper.getMainLooper());
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: q  reason: collision with root package name */
    public static volatile Picasso f29950q = null;

    /* renamed from: a  reason: collision with root package name */
    public final d f29951a;

    /* renamed from: b  reason: collision with root package name */
    public final e f29952b;

    /* renamed from: c  reason: collision with root package name */
    public final c f29953c;

    /* renamed from: d  reason: collision with root package name */
    public final List<RequestHandler> f29954d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f29955e;

    /* renamed from: f  reason: collision with root package name */
    public final h f29956f;

    /* renamed from: g  reason: collision with root package name */
    public final d f29957g;

    /* renamed from: h  reason: collision with root package name */
    public final t f29958h;

    /* renamed from: i  reason: collision with root package name */
    public final Map<Object, a> f29959i;

    /* renamed from: j  reason: collision with root package name */
    public final Map<ImageView, g> f29960j;

    /* renamed from: k  reason: collision with root package name */
    public final ReferenceQueue<Object> f29961k;

    /* renamed from: l  reason: collision with root package name */
    public final Bitmap.Config f29962l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f29963m;

    /* renamed from: n  reason: collision with root package name */
    public volatile boolean f29964n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f29965o;

    public enum LoadedFrom {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);
        
        public final int debugColor;

        private LoadedFrom(int i11) {
            this.debugColor = i11;
        }
    }

    public enum Priority {
        LOW,
        NORMAL,
        HIGH
    }

    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i11 = message.what;
            if (i11 != 3) {
                int i12 = 0;
                if (i11 == 8) {
                    List list = (List) message.obj;
                    int size = list.size();
                    while (i12 < size) {
                        c cVar = (c) list.get(i12);
                        cVar.f30008c.d(cVar);
                        i12++;
                    }
                } else if (i11 == 13) {
                    List list2 = (List) message.obj;
                    int size2 = list2.size();
                    while (i12 < size2) {
                        a aVar = (a) list2.get(i12);
                        aVar.f29986a.n(aVar);
                        i12++;
                    }
                } else {
                    throw new AssertionError("Unknown handler message received: " + message.what);
                }
            } else {
                a aVar2 = (a) message.obj;
                if (aVar2.g().f29964n) {
                    y.t("Main", "canceled", aVar2.f29987b.d(), "target got garbage collected");
                }
                aVar2.f29986a.a(aVar2.k());
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Context f29966a;

        /* renamed from: b  reason: collision with root package name */
        public i f29967b;

        /* renamed from: c  reason: collision with root package name */
        public ExecutorService f29968c;

        /* renamed from: d  reason: collision with root package name */
        public d f29969d;

        /* renamed from: e  reason: collision with root package name */
        public d f29970e;

        /* renamed from: f  reason: collision with root package name */
        public e f29971f;

        /* renamed from: g  reason: collision with root package name */
        public List<RequestHandler> f29972g;

        /* renamed from: h  reason: collision with root package name */
        public Bitmap.Config f29973h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f29974i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f29975j;

        public b(Context context) {
            if (context != null) {
                this.f29966a = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public Picasso a() {
            Context context = this.f29966a;
            if (this.f29967b == null) {
                this.f29967b = new n(context);
            }
            if (this.f29969d == null) {
                this.f29969d = new l(context);
            }
            if (this.f29968c == null) {
                this.f29968c = new p();
            }
            if (this.f29971f == null) {
                this.f29971f = e.f29980a;
            }
            t tVar = new t(this.f29969d);
            Context context2 = context;
            return new Picasso(context2, new h(context2, this.f29968c, Picasso.f29949p, this.f29967b, this.f29969d, tVar), this.f29969d, this.f29970e, this.f29971f, this.f29972g, tVar, this.f29973h, this.f29974i, this.f29975j);
        }

        public b b(Bitmap.Config config) {
            if (config != null) {
                this.f29973h = config;
                return this;
            }
            throw new IllegalArgumentException("Bitmap config must not be null.");
        }

        public b c(i iVar) {
            if (iVar == null) {
                throw new IllegalArgumentException("Downloader must not be null.");
            } else if (this.f29967b == null) {
                this.f29967b = iVar;
                return this;
            } else {
                throw new IllegalStateException("Downloader already set.");
            }
        }

        public b d(ExecutorService executorService) {
            if (executorService == null) {
                throw new IllegalArgumentException("Executor service must not be null.");
            } else if (this.f29968c == null) {
                this.f29968c = executorService;
                return this;
            } else {
                throw new IllegalStateException("Executor service already set.");
            }
        }

        public b e(d dVar) {
            if (dVar == null) {
                throw new IllegalArgumentException("Listener must not be null.");
            } else if (this.f29970e == null) {
                this.f29970e = dVar;
                return this;
            } else {
                throw new IllegalStateException("Listener already set.");
            }
        }

        public b f(e eVar) {
            if (eVar == null) {
                throw new IllegalArgumentException("Transformer must not be null.");
            } else if (this.f29971f == null) {
                this.f29971f = eVar;
                return this;
            } else {
                throw new IllegalStateException("Transformer already set.");
            }
        }
    }

    public static class c extends Thread {

        /* renamed from: b  reason: collision with root package name */
        public final ReferenceQueue<Object> f29976b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f29977c;

        public class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Exception f29978b;

            public a(Exception exc) {
                this.f29978b = exc;
            }

            public void run() {
                throw new RuntimeException(this.f29978b);
            }
        }

        public c(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f29976b = referenceQueue;
            this.f29977c = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    a.C0264a aVar = (a.C0264a) this.f29976b.remove(1000);
                    Message obtainMessage = this.f29977c.obtainMessage();
                    if (aVar != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = aVar.f29998a;
                        this.f29977c.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e11) {
                    this.f29977c.post(new a(e11));
                    return;
                }
            }
        }
    }

    public interface d {
        void a(Picasso picasso, Uri uri, Exception exc);
    }

    public interface e {

        /* renamed from: a  reason: collision with root package name */
        public static final e f29980a = new a();

        public static class a implements e {
            public q a(q qVar) {
                return qVar;
            }
        }

        q a(q qVar);
    }

    public Picasso(Context context, h hVar, d dVar, d dVar2, e eVar, List<RequestHandler> list, t tVar, Bitmap.Config config, boolean z11, boolean z12) {
        this.f29955e = context;
        this.f29956f = hVar;
        this.f29957g = dVar;
        this.f29951a = dVar2;
        this.f29952b = eVar;
        this.f29962l = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new s(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new e(context));
        arrayList.add(new MediaStoreRequestHandler(context));
        arrayList.add(new f(context));
        arrayList.add(new b(context));
        arrayList.add(new j(context));
        arrayList.add(new NetworkRequestHandler(hVar.f30040d, tVar));
        this.f29954d = Collections.unmodifiableList(arrayList);
        this.f29958h = tVar;
        this.f29959i = new WeakHashMap();
        this.f29960j = new WeakHashMap();
        this.f29963m = z11;
        this.f29964n = z12;
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.f29961k = referenceQueue;
        c cVar = new c(referenceQueue, f29949p);
        this.f29953c = cVar;
        cVar.start();
    }

    public static Picasso h() {
        if (f29950q == null) {
            synchronized (Picasso.class) {
                if (f29950q == null) {
                    Context context = PicassoProvider.f29981b;
                    if (context != null) {
                        f29950q = new b(context).a();
                    } else {
                        throw new IllegalStateException("context == null");
                    }
                }
            }
        }
        return f29950q;
    }

    public void a(Object obj) {
        g remove;
        y.c();
        a remove2 = this.f29959i.remove(obj);
        if (remove2 != null) {
            remove2.a();
            this.f29956f.c(remove2);
        }
        if ((obj instanceof ImageView) && (remove = this.f29960j.remove((ImageView) obj)) != null) {
            remove.a();
        }
    }

    public void b(ImageView imageView) {
        if (imageView != null) {
            a(imageView);
            return;
        }
        throw new IllegalArgumentException("view cannot be null.");
    }

    public void c(v vVar) {
        if (vVar != null) {
            a(vVar);
            return;
        }
        throw new IllegalArgumentException("target cannot be null.");
    }

    public void d(c cVar) {
        a h11 = cVar.h();
        List<a> i11 = cVar.i();
        boolean z11 = true;
        boolean z12 = i11 != null && !i11.isEmpty();
        if (h11 == null && !z12) {
            z11 = false;
        }
        if (z11) {
            Uri uri = cVar.j().f30085d;
            Exception k11 = cVar.k();
            Bitmap s11 = cVar.s();
            LoadedFrom o11 = cVar.o();
            if (h11 != null) {
                f(s11, o11, h11, k11);
            }
            if (z12) {
                int size = i11.size();
                for (int i12 = 0; i12 < size; i12++) {
                    f(s11, o11, i11.get(i12), k11);
                }
            }
            d dVar = this.f29951a;
            if (dVar != null && k11 != null) {
                dVar.a(this, uri, k11);
            }
        }
    }

    public void e(ImageView imageView, g gVar) {
        if (this.f29960j.containsKey(imageView)) {
            a(imageView);
        }
        this.f29960j.put(imageView, gVar);
    }

    public final void f(Bitmap bitmap, LoadedFrom loadedFrom, a aVar, Exception exc) {
        if (!aVar.l()) {
            if (!aVar.m()) {
                this.f29959i.remove(aVar.k());
            }
            if (bitmap == null) {
                aVar.c(exc);
                if (this.f29964n) {
                    y.t("Main", "errored", aVar.f29987b.d(), exc.getMessage());
                }
            } else if (loadedFrom != null) {
                aVar.b(bitmap, loadedFrom);
                if (this.f29964n) {
                    String d11 = aVar.f29987b.d();
                    y.t("Main", "completed", d11, "from " + loadedFrom);
                }
            } else {
                throw new AssertionError("LoadedFrom cannot be null.");
            }
        }
    }

    public void g(a aVar) {
        Object k11 = aVar.k();
        if (!(k11 == null || this.f29959i.get(k11) == aVar)) {
            a(k11);
            this.f29959i.put(k11, aVar);
        }
        o(aVar);
    }

    public List<RequestHandler> i() {
        return this.f29954d;
    }

    public r j(Uri uri) {
        return new r(this, uri, 0);
    }

    public r k(File file) {
        if (file == null) {
            return new r(this, (Uri) null, 0);
        }
        return j(Uri.fromFile(file));
    }

    public r l(String str) {
        if (str == null) {
            return new r(this, (Uri) null, 0);
        }
        if (str.trim().length() != 0) {
            return j(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    public Bitmap m(String str) {
        Bitmap bitmap = this.f29957g.get(str);
        if (bitmap != null) {
            this.f29958h.d();
        } else {
            this.f29958h.e();
        }
        return bitmap;
    }

    public void n(a aVar) {
        Bitmap m11 = MemoryPolicy.shouldReadFromMemoryCache(aVar.f29990e) ? m(aVar.d()) : null;
        if (m11 != null) {
            LoadedFrom loadedFrom = LoadedFrom.MEMORY;
            f(m11, loadedFrom, aVar, (Exception) null);
            if (this.f29964n) {
                String d11 = aVar.f29987b.d();
                y.t("Main", "completed", d11, "from " + loadedFrom);
                return;
            }
            return;
        }
        g(aVar);
        if (this.f29964n) {
            y.s("Main", "resumed", aVar.f29987b.d());
        }
    }

    public void o(a aVar) {
        this.f29956f.h(aVar);
    }

    public q p(q qVar) {
        q a11 = this.f29952b.a(qVar);
        if (a11 != null) {
            return a11;
        }
        throw new IllegalStateException("Request transformer " + this.f29952b.getClass().getCanonicalName() + " returned null for " + qVar);
    }
}
