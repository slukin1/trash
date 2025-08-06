package com.sumsub.sns.internal.core.domain;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.sumsub.sns.internal.core.domain.o;
import d10.l;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class b implements o {

    /* renamed from: a  reason: collision with root package name */
    public List<? extends o> f33508a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33509b = c.f33521a;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f33510c;

    public static final class a extends Lambda implements l<o.a, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f33511a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap f33512b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ RectF f33513c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ l<o.a, Unit> f33514d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f33515e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, Bitmap bitmap, RectF rectF, l<? super o.a, Unit> lVar, o oVar) {
            super(1);
            this.f33511a = bVar;
            this.f33512b = bitmap;
            this.f33513c = rectF;
            this.f33514d = lVar;
            this.f33515e = oVar;
        }

        public final void a(o.a aVar) {
            ExecutorService a11 = this.f33511a.f33510c;
            if (a11 != null) {
                a11.submit(new t(this.f33511a, this.f33512b, this.f33513c, this.f33514d, this.f33515e, aVar));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((o.a) obj);
            return Unit.f56620a;
        }

        public static final void a(b bVar, Bitmap bitmap, RectF rectF, l lVar, o oVar, o.a aVar) {
            bVar.a(bitmap, rectF, lVar, oVar, aVar);
        }
    }

    public b(List<? extends o> list) {
        this.f33508a = list;
        i iVar = i.f33611a;
        String name = getName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("init: ");
        List<? extends o> list2 = this.f33508a;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list2, 10));
        for (o name2 : list2) {
            arrayList.add(name2.getName());
        }
        sb2.append(arrayList);
        i.a(iVar, name, sb2.toString(), (Throwable) null, 4, (Object) null);
    }

    public final void b(Bitmap bitmap, RectF rectF, l<? super o.a, Unit> lVar) {
        o oVar = (o) CollectionsKt___CollectionsKt.c0(this.f33508a);
        if (oVar != null) {
            try {
                oVar.a(bitmap, rectF, new a(this, bitmap, rectF, lVar, oVar));
            } catch (Throwable th2) {
                lVar.invoke(new o.a.C0374a(bitmap, th2));
            }
        }
    }

    public String getName() {
        return this.f33509b;
    }

    public void start() {
        i iVar = i.f33611a;
        String name = getName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("start: d=");
        sb2.append(this.f33508a.size());
        sb2.append(", e=");
        sb2.append(this.f33510c != null);
        i.a(iVar, name, sb2.toString(), (Throwable) null, 4, (Object) null);
        if (this.f33510c == null) {
            this.f33510c = Executors.newSingleThreadExecutor(s.f33682b);
        }
        ((o) CollectionsKt___CollectionsKt.a0(this.f33508a)).start();
    }

    public void stop() {
        i iVar = i.f33611a;
        String name = getName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("stop: d=");
        sb2.append(this.f33508a.size());
        sb2.append(", e=");
        sb2.append(this.f33510c != null);
        i.a(iVar, name, sb2.toString(), (Throwable) null, 4, (Object) null);
        for (o stop : this.f33508a) {
            stop.stop();
        }
        ExecutorService executorService = this.f33510c;
        if (executorService != null) {
            executorService.shutdownNow();
        }
        this.f33510c = null;
    }

    public void a(Bitmap bitmap, RectF rectF, l<? super o.a, Unit> lVar) {
        ExecutorService executorService = this.f33510c;
        if (executorService != null) {
            executorService.submit(new r(this, bitmap, rectF, lVar));
        }
    }

    public static final void a(b bVar, Bitmap bitmap, RectF rectF, l lVar) {
        bVar.b(bitmap, rectF, lVar);
    }

    public final void a(Bitmap bitmap, RectF rectF, l<? super o.a, Unit> lVar, o oVar, o.a aVar) {
        if (!(aVar instanceof o.a.b) || this.f33508a.size() <= 1) {
            lVar.invoke(aVar);
            return;
        }
        i iVar = i.f33611a;
        String name = getName();
        iVar.a(name, "fatal error from -> " + oVar.getName(), ((o.a.b) aVar).b());
        try {
            a(oVar);
            b(bitmap, rectF, lVar);
        } catch (Throwable th2) {
            lVar.invoke(new o.a.c(bitmap, th2));
        }
    }

    public final void a(o oVar) {
        oVar.stop();
        List<? extends o> list = this.f33508a;
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (((o) next) != oVar) {
                arrayList.add(next);
            }
        }
        this.f33508a = arrayList;
        o oVar2 = (o) CollectionsKt___CollectionsKt.a0(arrayList);
        oVar2.start();
        i iVar = i.f33611a;
        String name = getName();
        i.a(iVar, name, "repeat image processing with " + oVar2.getName() + " ...", (Throwable) null, 4, (Object) null);
    }

    public static final Thread a(Runnable runnable) {
        return new Thread(runnable, "CompositeFaceDetector-Thread");
    }
}
