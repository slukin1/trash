package androidx.navigation;

import androidx.navigation.NavOptions;
import d10.l;
import kotlin.Unit;

public final class NavOptionsBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final NavOptions.Builder f10358a = new NavOptions.Builder();

    /* renamed from: b  reason: collision with root package name */
    public boolean f10359b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10360c;

    /* renamed from: d  reason: collision with root package name */
    public int f10361d = -1;

    /* renamed from: e  reason: collision with root package name */
    public String f10362e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10363f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10364g;

    public static /* synthetic */ void d(NavOptionsBuilder navOptionsBuilder, int i11, l lVar, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            lVar = NavOptionsBuilder$popUpTo$1.INSTANCE;
        }
        navOptionsBuilder.c(i11, lVar);
    }

    public final void a(l<? super AnimBuilder, Unit> lVar) {
        AnimBuilder animBuilder = new AnimBuilder();
        lVar.invoke(animBuilder);
        this.f10358a.b(animBuilder.a()).c(animBuilder.b()).e(animBuilder.c()).f(animBuilder.d());
    }

    public final NavOptions b() {
        NavOptions.Builder builder = this.f10358a;
        builder.d(this.f10359b);
        builder.j(this.f10360c);
        String str = this.f10362e;
        if (str != null) {
            builder.h(str, this.f10363f, this.f10364g);
        } else {
            builder.g(this.f10361d, this.f10363f, this.f10364g);
        }
        return builder.a();
    }

    public final void c(int i11, l<? super PopUpToBuilder, Unit> lVar) {
        f(i11);
        g((String) null);
        PopUpToBuilder popUpToBuilder = new PopUpToBuilder();
        lVar.invoke(popUpToBuilder);
        this.f10363f = popUpToBuilder.a();
        this.f10364g = popUpToBuilder.b();
    }

    public final void e(boolean z11) {
        this.f10359b = z11;
    }

    public final void f(int i11) {
        this.f10361d = i11;
        this.f10363f = false;
    }

    public final void g(String str) {
        if (str == null) {
            return;
        }
        if (!StringsKt__StringsJVMKt.z(str)) {
            this.f10362e = str;
            this.f10363f = false;
            return;
        }
        throw new IllegalArgumentException("Cannot pop up to an empty route".toString());
    }

    public final void h(boolean z11) {
        this.f10360c = z11;
    }
}
