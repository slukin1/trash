package androidx.profileinstaller;

import androidx.profileinstaller.h;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h.c f10498b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f10499c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f10500d;

    public /* synthetic */ g(h.c cVar, int i11, Object obj) {
        this.f10498b = cVar;
        this.f10499c = i11;
        this.f10500d = obj;
    }

    public final void run() {
        this.f10498b.a(this.f10499c, this.f10500d);
    }
}
