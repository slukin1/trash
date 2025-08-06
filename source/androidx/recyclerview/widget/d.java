package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.DiffUtil;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class d<T> {

    /* renamed from: h  reason: collision with root package name */
    public static final Executor f10823h = new c();

    /* renamed from: a  reason: collision with root package name */
    public final p f10824a;

    /* renamed from: b  reason: collision with root package name */
    public final c<T> f10825b;

    /* renamed from: c  reason: collision with root package name */
    public Executor f10826c;

    /* renamed from: d  reason: collision with root package name */
    public final List<b<T>> f10827d = new CopyOnWriteArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<T> f10828e;

    /* renamed from: f  reason: collision with root package name */
    public List<T> f10829f = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    public int f10830g;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f10831b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f10832c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f10833d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f10834e;

        /* renamed from: androidx.recyclerview.widget.d$a$a  reason: collision with other inner class name */
        public class C0055a extends DiffUtil.Callback {
            public C0055a() {
            }

            public boolean areContentsTheSame(int i11, int i12) {
                Object obj = a.this.f10831b.get(i11);
                Object obj2 = a.this.f10832c.get(i12);
                if (obj != null && obj2 != null) {
                    return d.this.f10825b.b().a(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            public boolean areItemsTheSame(int i11, int i12) {
                Object obj = a.this.f10831b.get(i11);
                Object obj2 = a.this.f10832c.get(i12);
                if (obj == null || obj2 == null) {
                    return obj == null && obj2 == null;
                }
                return d.this.f10825b.b().b(obj, obj2);
            }

            public Object getChangePayload(int i11, int i12) {
                Object obj = a.this.f10831b.get(i11);
                Object obj2 = a.this.f10832c.get(i12);
                if (obj != null && obj2 != null) {
                    return d.this.f10825b.b().c(obj, obj2);
                }
                throw new AssertionError();
            }

            public int getNewListSize() {
                return a.this.f10832c.size();
            }

            public int getOldListSize() {
                return a.this.f10831b.size();
            }
        }

        public class b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ DiffUtil.d f10837b;

            public b(DiffUtil.d dVar) {
                this.f10837b = dVar;
            }

            public void run() {
                a aVar = a.this;
                d dVar = d.this;
                if (dVar.f10830g == aVar.f10833d) {
                    dVar.c(aVar.f10832c, this.f10837b, aVar.f10834e);
                }
            }
        }

        public a(List list, List list2, int i11, Runnable runnable) {
            this.f10831b = list;
            this.f10832c = list2;
            this.f10833d = i11;
            this.f10834e = runnable;
        }

        public void run() {
            d.this.f10826c.execute(new b(DiffUtil.b(new C0055a())));
        }
    }

    public interface b<T> {
        void a(List<T> list, List<T> list2);
    }

    public static class c implements Executor {

        /* renamed from: b  reason: collision with root package name */
        public final Handler f10839b = new Handler(Looper.getMainLooper());

        public void execute(Runnable runnable) {
            this.f10839b.post(runnable);
        }
    }

    public d(p pVar, c<T> cVar) {
        this.f10824a = pVar;
        this.f10825b = cVar;
        if (cVar.c() != null) {
            this.f10826c = cVar.c();
        } else {
            this.f10826c = f10823h;
        }
    }

    public void a(b<T> bVar) {
        this.f10827d.add(bVar);
    }

    public List<T> b() {
        return this.f10829f;
    }

    public void c(List<T> list, DiffUtil.d dVar, Runnable runnable) {
        List<T> list2 = this.f10829f;
        this.f10828e = list;
        this.f10829f = Collections.unmodifiableList(list);
        dVar.b(this.f10824a);
        d(list2, runnable);
    }

    public final void d(List<T> list, Runnable runnable) {
        for (b<T> a11 : this.f10827d) {
            a11.a(list, this.f10829f);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void e(List<T> list) {
        f(list, (Runnable) null);
    }

    public void f(List<T> list, Runnable runnable) {
        int i11 = this.f10830g + 1;
        this.f10830g = i11;
        List<T> list2 = this.f10828e;
        if (list != list2) {
            List<T> list3 = this.f10829f;
            if (list == null) {
                int size = list2.size();
                this.f10828e = null;
                this.f10829f = Collections.emptyList();
                this.f10824a.onRemoved(0, size);
                d(list3, runnable);
            } else if (list2 == null) {
                this.f10828e = list;
                this.f10829f = Collections.unmodifiableList(list);
                this.f10824a.onInserted(0, list.size());
                d(list3, runnable);
            } else {
                this.f10825b.a().execute(new a(list2, list, i11, runnable));
            }
        } else if (runnable != null) {
            runnable.run();
        }
    }
}
