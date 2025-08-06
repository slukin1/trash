package androidx.camera.extensions.internal.compat.workaround;

import androidx.camera.extensions.internal.compat.quirk.CrashWhenOnDisableTooSoon;
import v.a;

public class OnEnableDisableSessionDurationCheck {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5766a;

    /* renamed from: b  reason: collision with root package name */
    public long f5767b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OnEnableDisableSessionDurationCheck() {
        this(a.a(CrashWhenOnDisableTooSoon.class) != null);
    }

    public OnEnableDisableSessionDurationCheck(boolean z11) {
        this.f5767b = 0;
        this.f5766a = z11;
    }
}
