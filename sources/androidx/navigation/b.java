package androidx.navigation;

import android.os.Bundle;
import kotlin.jvm.internal.r;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f10379a;

    /* renamed from: b  reason: collision with root package name */
    public NavOptions f10380b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f10381c;

    public b(int i11, NavOptions navOptions, Bundle bundle) {
        this.f10379a = i11;
        this.f10380b = navOptions;
        this.f10381c = bundle;
    }

    public final Bundle a() {
        return this.f10381c;
    }

    public final int b() {
        return this.f10379a;
    }

    public final NavOptions c() {
        return this.f10380b;
    }

    public final void d(Bundle bundle) {
        this.f10381c = bundle;
    }

    public final void e(NavOptions navOptions) {
        this.f10380b = navOptions;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i11, NavOptions navOptions, Bundle bundle, int i12, r rVar) {
        this(i11, (i12 & 2) != 0 ? null : navOptions, (i12 & 4) != 0 ? null : bundle);
    }
}
