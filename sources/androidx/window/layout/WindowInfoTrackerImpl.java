package androidx.window.layout;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.f;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0006B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Landroidx/window/layout/WindowInfoTrackerImpl;", "Landroidx/window/layout/p;", "Landroid/app/Activity;", "activity", "Lkotlinx/coroutines/flow/d;", "Landroidx/window/layout/s;", "a", "Landroidx/window/layout/u;", "b", "Landroidx/window/layout/u;", "windowMetricsCalculator", "Landroidx/window/layout/n;", "c", "Landroidx/window/layout/n;", "windowBackend", "<init>", "(Landroidx/window/layout/u;Landroidx/window/layout/n;)V", "d", "window_release"}, k = 1, mv = {1, 6, 0})
public final class WindowInfoTrackerImpl implements p {

    /* renamed from: d  reason: collision with root package name */
    public static final a f12102d = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final u f12103b;

    /* renamed from: c  reason: collision with root package name */
    public final n f12104c;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Landroidx/window/layout/WindowInfoTrackerImpl$a;", "", "", "BUFFER_CAPACITY", "I", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public WindowInfoTrackerImpl(u uVar, n nVar) {
        this.f12103b = uVar;
        this.f12104c = nVar;
    }

    public d<s> a(Activity activity) {
        return f.F(new WindowInfoTrackerImpl$windowLayoutInfo$1(this, activity, (c<? super WindowInfoTrackerImpl$windowLayoutInfo$1>) null));
    }
}
